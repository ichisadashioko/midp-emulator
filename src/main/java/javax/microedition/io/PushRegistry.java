package javax.microedition.io;

/**
 * The {@code PushRegistry} maintains a list of inbound connections. An
 * application can register the inbound connections with an entry in the
 * application descriptor file or dynamically by calling the
 * {@code registerConnection} method.
 * 
 * <p>
 * While an application is running, it is responsible for all I/O operations
 * associated with the inbound connection. When the application is not running,
 * the application management software (AMS) listens for inbound notification
 * requests. When a notification arrives for a registered {@code MIDlet}, the
 * AMS will start the {@code MIDlet} via the normal invocation of
 * {@code MIDlet.startApp} method.
 * 
 * <h2>Installation Handling of Declared Connections</h2>
 * 
 * <p>
 * To avoid collisions on inbound generic connections, the application
 * descriptor file MUST include information about static connections that are
 * needed by the {@code MIDlet} suite. If all the static Push declarations in
 * the application descriptor can not be fullied during installation, the user
 * MUST be notified that there are conflicts and the MIDlet suite MUST NOT be
 * installed (see <i>Over The Air Initiated Provisioning Specification</i>
 * section for errors reported in the event of conflicts). Conditions when the
 * declarations can not be fufilled include: syntax errors in the Push
 * attributes, declaration for a connection end point (e.g. port number) that is
 * already reserved in the device, declaration for a protocol that is not
 * supported for Push in the device, and declaration referencing a
 * {@code MIDlet} class that is not listed in the <code>MIDlet-&lt;n&gt;</code>
 * attributes of the same application descriptor. If the {@code MIDlet} suite
 * can function meaningfully even if a Push registration can't be fulfilled, it
 * MUST register the Push connections using the dynamic registration methods in
 * the {@code PushRegistry}.
 * 
 * <p>
 * A conflict-free installation reserves each requested connection for the
 * exclusive use of the {@code MIDlets} in the suite. While the suite is
 * installed, any attempt by other applications to open one of the reserved
 * connections will fail with an {@code IOException}. A call from a
 * {@code MIDlet} to {@code Connector.open()} on a reserved for its suite will
 * always succeed, assuming the suite does not already have the connection open.
 * 
 * <p>
 * If two {@code MIDlet} suites have a static push connection in common, they
 * cannot be installed together and both function correctly. The end user would
 * typically have to uninstall one before being able to successfully install the
 * other.
 * 
 * <h2>Push Registration Attribute</h2>
 * 
 * <p>
 * Each push registration entry contains the following information:
 * 
 * <pre>
 * MIDlet-Push-&lt;n&gt;: &lt;ConnectionURL&gt;, &lt;MIDletClassName&gt;, &lt;AllowedSender&gt;
 * </pre>
 * 
 * <p>
 * where:
 * 
 * <ul>
 * <li><code>MIDlet-Push-&lt;n&gt;</code> = the Push registration attribute
 * name. Multiple push registrations can be provided in a {@code MIDlet} suite.
 * The numeric value for &lt;n&gt; starts from 1 and MUST use consecutive
 * ordinal numbers for additional entries. The first missing entry terminates
 * the list. Any additional entries are ignored.
 * <li><code>ConnectionURL</code> = the connection string used in
 * {@code Connector.open()}
 * <li><code>MIDletClassName</code> = the {@code MIDlet} that is responsible for
 * the connection. The named {@code MIDlet} MUST be registered in the descriptor
 * file or the jar file manifest with a <code>MIDlet-&lt;n&gt;</code> record
 * (This information is needed when displaying messages to the user about the
 * application when push connections are detected, or when the user
 * grants/revokes priveleges for the application). If the named {@code MIDlet}
 * appears more than once in the suite, the first matching entry is used.
 * <li><code>AllowedSender</code> = a designated filter that restricts which
 * senders are valid for launching the requested {@code MIDlet}. The syntax and
 * semantics of the {@code AllowedSender} field depend on the addressing format
 * used for the protocol. However, every syntax for this field depend on the
 * addressing format used for the protocol. However, every syntax for this field
 * MUST support using the wildcard characters "*" and "?". The semantics of
 * those wildcard are:
 * <ul>
 * <li>"*" matches any string, including an empty string
 * <li>"?" matches any single character
 * </ul>
 * When the value of this field is just wildcard character "*", connections will
 * be accepted from any originating source. For Push attributes using the
 * {@code datagram} and {@code socket} URLs (if supported by the platform), this
 * field contains a numeric IP address in the same format for IPv4 and IPv6 as
 * used in the respective URLs (IPv6 address including the square brackets as in
 * the URL). It is possible to use the wildcards also in these IP addresses,
 * e.g. "129.70.40.*" would allow subnet resolution. Note that the port number
 * not part of the filter for {@code datagram} and {@code socket} connections.
 * </li>
 * </ul>
 * 
 * <p>
 * The MIDP 2.0 specification defines the syntax for {@code datagram} and
 * {@code socket} inbound connections. When other specifications define push
 * semantics for additional connection types, they must define the expected
 * syntax for the filter field, as well as the expected format for the
 * connection URL string.
 * 
 * <h2>Example Descriptor File Declarative Notation</h2>
 * 
 * <p>
 * The following is a sample descriptor file entry that would reserve a stream
 * socket at port 79 and a datagram connection at port 50000 (port numbers are
 * maintained by IANA and cover well-known, user-registered and dynamic port
 * numbers) [See <a href=
 * "https://www.iana.org/assignments/service-names-port-numbers/service-names-port-numbers.xhtml">IANA
 * Port Number Registry</a>]
 * 
 * <pre>
 * MIDlet-Push-1: socket://:79, com.sun.example.SampleChat, *
 * MIDlet-Push-2: datagram://:50000, com.sun.example.SampleChat, *
 * </pre>
 * 
 * <h2>Buffered Messages</h2>
 * 
 * <p>
 * The requirements for buffering of messages are specific to each protocol used
 * for Push and are defined separately for each protocol. There is no general
 * requirement related to buffering that would apply to all protocols. If the
 * implementation buffers messages, these messages MUST be provided to the
 * {@code MIDlet} when the {@code MIDlet} is started and it opens the related
 * {@code Connection} that it has registered for Push.
 * 
 * <p>
 * When datagram connections are supported with Push, the implementation MUST
 * guarantee that when a {@code MIDlet} registered for datagram Push is started
 * in response to an incoming datagram, at least the datagram that caused the
 * startup of the {@code MIDlet} is buffered by the implementation and will be
 * available to the {@code MIDlet} when the {@code MIDlet} opens the
 * {@code UDPDatagramConnection} after startup.
 * 
 * <p>
 * When socket connections are supported with Push, the implementation MUST
 * guarantee that when a {@code MIDlet} registered for socket Push is started in
 * response to an incoming socket connection, this connection can be accepted by
 * the {@code MIDlet} by opening the {@code ServerSocketConnection} after
 * startup, provided that the connection hasn't timed out meanwhile.
 * 
 * <h2>Connection vs Push Registration Support</h2>
 * 
 * <p>
 * Not all generic connections will be appropriate for use as push application
 * transport. Even if a protocol is supported on the device as an inbound
 * connection type, it is not required to be enabled as a valid push mechanism.
 * e.g. a platform might support server socket connections in a {@code MIDlet},
 * but might not support inbound socket connections for push launch capability.
 * A {@code ConnectionNotFoundException} is thrown from the
 * {@code registerConnection} and from the {@code registerAlarm} methods, when
 * the platform does not support that optional capability.
 * 
 * <h2>AMS Connection Handoff</h2>
 * 
 * <p>
 * Responsibility for registered push connections is shared between the AMS and
 * the {@code MIDlet} that handles the I/O operations on the inbound
 * connections. To prevent any data from being lost, an application is
 * responsible for all I/O operations on the connection from the time it calls
 * {@code Connector.open()} until it calls {@code Connection.close()}.
 * 
 * <p>
 * The AMS listens for inbound connection notifications. This MAY be handled via
 * a native callback or polling machanism looking for new inbound data. The AMS
 * is responsible for enforcing the Security of {@code PushRegistry} and
 * presenting notifications (if any) to the user before invoking the MIDlet
 * suite.
 * 
 * <p>
 * The AMS is responsible for the shutdown of any running applications (if
 * necessary) prior to the invocation of the push {@code MIDlet} method.
 * 
 * <p>
 * After the AMS has started the push application, the {@code MIDlet} is
 * responsible for opening the connections for all subsequent I/O operations. An
 * application that needs to perform blocking I/O operations SHOULD use a
 * separate thread to allow for interactive user operations. Once the
 * application has been started and the connection has been opened, the AMS is
 * no longer responsible for listening for push notifications for that
 * connection. The application is responsible for reading all inbound data.
 * 
 * <p>
 * If an application has finished with all inbound data it MAY {@code close} the
 * connection. If the connection is closed, then neither the AMS nor the
 * application will be listening for push notifications. Inbound data could be
 * lost, if the application closes the connection before all data has been
 * received.
 * 
 * <p>
 * When the application is destroyed, the AMS resumes its responsibility to
 * watch for inbound connections.
 * 
 * <p>
 * A push application SHOULD behave in a predictable manner when handling
 * asynchronous data via the push mechanism. A well behaved application SHOULD
 * inform the user that data has been processed (while it is possible to write
 * applications that do not use any user visible interfaces, this could lead to
 * a confused end user experience to launch an application that only performs a
 * background function).
 * 
 * <h2>Dynamic Connections Registered from a Running MIDlet
 * 
 * <p>
 * There are cases when defining a well known port registered with IANA is not
 * necessary. Simple applications may just wish to exchange data using a private
 * protocol between a {@code MIDlet} and server application.
 * 
 * <p>
 * To accomodate this type of application, a mechanism is provided to
 * dynamically allocate a connection and to register that information, as if it
 * was known, when the application was installed. This information can then be
 * sent to an agent on the network to use as the mechanism to communicate with
 * the registered {@code MIDlet}.
 * 
 * <p>
 * For instance, if a {@code UDPDatagramConnection} is opened and a port number
 * was not specified, then the application is requesting a dynamic port to be
 * allocated from the ports that are currently available. By calling
 * {@code PushRegistry.registerConnection()} the {@code MIDlet} informs the AMS
 * that it is the target for inbound communication, even after the
 * {@code MIDlet} has been destroyed (See {@code MIDlet} life cycle for
 * definition of "destroyed" state). If the application is deleted from the
 * phone, then its dynamic communication connections are unregistered
 * automatically.
 * 
 * <h2>AMS Runtime Handling - Implementation Notes
 * 
 * <p>
 * During installation each {@code MIDlet} that is expecting inbound
 * communication on a well known address has the information recorded with the
 * AMS from the push registration attribute in the manifest or application
 * descriptor file. Once the installation has been successfully completed (e.g.
 * for the OTA recommended practices - when the <i>Installation notification
 * message</i> has been successfully transmitted, the application is officially
 * installed), the {@code MIDlet} MAY then receive inbound communication. e.g.
 * the push notification event.
 * 
 * <p>
 * When the AMS is started, it checks the list of registered connections and
 * begins listening for inbound communication. When a notification arrives the
 * AMS starts the registered {@code MIDlet}. The {@code MIDlet} then opens the
 * connection with {@code Connector.open()} method to perform whatever I/O
 * operations are needed for the particular connection type. e.g. for a server
 * socket the application uses {@code acceptAndOpen()} to get the socket
 * connected and for a datagram connection the application uses
 * {@code receive()} to read the delivered message.
 * 
 * <p>
 * For message oriented transports the inbound message MAY be read by the AMS
 * and saved for delivery to the {@code MIDlet} when it requests to read the
 * data. For stream oriented transports the connection MAY be lost if the
 * connection is not accepted before the server end of connection request
 * timeouts.
 * 
 * <p>
 * When a {@code MIDlet} is started in response to a registered push connection
 * notification, it is platform dependent what happens to the current running
 * application. The {@code MIDlet} life cycle defines the expected behaviors
 * that an interrupted {@code MIDlet} could see from a call to
 * {@code pauseApp()} or from {@code destroyApp()}.
 * 
 * <h2>Sample Usage Scenarios
 * 
 * <p>
 * <b>Usage scenario 1:</b> The suite includes a {@code MIDlet} with a well
 * known port for communication. During the {@code startApp} processing a thread
 * is launched to handle the incoming data. Using a separate thread is the
 * recommended practice for avoiding conflicts between blocking I/O operations
 * and the normal user interaction events. The thread continues to receive
 * messages until the {@code MIDlet} is destroyed.
 * 
 * <h3>Sample Chat Descriptor File
 * 
 * <p>
 * In this sample, the descriptor file includes a static push connection
 * registration. It also includes an indication that this {@code MIDlet}
 * requires permission to use a datagram connection for inbound push messages
 * (see Security of PushRegistry in the package overview for details about
 * {@code MIDlet} permissions). <b>Note:</b> this sample is appropriate for
 * bursts of datagrams. It is written to loop on the connection, processing
 * received messages.
 * 
 * <pre>
 * MIDlet-Name: SunNetwork - Chat Demo
 * MIDlet-Version: 1.0
 * MIDlet-Vendor: Sun Microsystems, Inc.
 * MIDlet-Description: Network demonstration programs for MIDP
 * MicroEdition-Profile: MIDP-2.0
 * MicroEdition-Configuration: CLDC-1.0
 * MIDlet-1: InstantMessage, /icons/Chat.png, example.chat.SampleChat, *
 * MIDlet-Push-1: datagram://:79, example.chat.SampleChat, *
 * MIDlet-Permissions: javax.microedition.io.PushRegistry, \\
 *                     javax.microedition.io.Connector.datagramreceiver
 * </pre>
 * 
 * <h3>Sample Chat MIDlet Processing
 * 
 * <pre>
 * public class SampleChat extends MIDlet {
 *     // Current inbound message connection.
 *     DatagramConnection conn;
 *     // Flag to terminate the message reading thread.
 *     boolean done_reading;
 * 
 *     public void startApp() {
 *         // List of active connections.
 *         String connections[];
 * 
 *         // Check to see if this session was started due to
 *         // inbound connection notification.
 *         connections = PushRegistry.listConnections(true);
 * 
 *         // Start an inbound message thread for available
 *         // inbound messages for the statically configured
 *         // connection in the descriptor file.
 *         for (int i = 0; i < connections.length; i++) {
 *             Thread t = new Thread(new MessageHandler(connections[i]));
 * 
 *             t.start();
 *         }
 * 
 *         // ...
 *     }
 * 
 *     // Stop reading inbound messages and release the push
 *     // connection to the AMS listener.
 *     public void destroyApp(boolean conditional) {
 *         done_reading = true;
 *         if (conn != null) {
 *             conn.close();
 *         }
 *         // Optionally, notify network service that we're
 *         // done with the current session.
 *         // ...
 *     }
 * 
 *     // Optionally, notify network service.
 *     public void pauseApp() {
 *         // ...
 *     }
 * }
 * </pre>
 */
public class PushRegistry {

}
