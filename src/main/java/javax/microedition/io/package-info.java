/**
 * MID Profile includes networking support based on the
 * {@code Generic Connection} framework from the <i>Connected, Limited Device
 * Configuration</i>.
 * 
 * <h2>HTTP Networking</h2>
 * 
 * <p>
 * In addition to the {@code javax.microedition.io} classes specified in the
 * <i>Connected Limited Device Configuration</i> the <i>Mobile Information
 * Device Profile</i> includes the following interface for the HTTP access. An
 * {@code HttpConnection} is returned from {@code Connector.open()} when an
 * {@code "http://"} connection string is accessed.
 * 
 * <ul>
 * <li>{@code javax.microedition.io.HttpConnection}
 * </ul>
 * 
 * <p>
 * The MIDP extends the connectivity support provided by the Connected, Limited
 * Device Configuration (CLDC) with specific functionality for the
 * <i>GenericConnection</i> framework. The MIDP supports a subset of the HTTP
 * protocol, which can be implemented using both IP protocols such as TCP/IP and
 * non-IP protocols such as WAP and i-Mode, utilizing a gateway to provide
 * access to HTTP servers on the Internet.
 * 
 * <p>
 * The <i>GenericConnection</i> framework is used to support client-server and
 * datagram networks. Using only the protocols specified by the MIDP will allow
 * the application to be portable to all MIDs. MIDP implementations MUST provide
 * support for accessing HTTP 1.1 servers and services.
 * 
 * <p>
 * There are wide variations in wireless networks. It is the joint
 * responsibility of the device and the wireless network to provide the
 * application service. It may require a <i>gateway</i> that can bridge between
 * the wireless transports specific to the network and the wired Internet. The
 * client application and the Internet server MUST NOT need to be required to
 * know either that non-IP networks are being used or the characteristics of
 * those networks. While the client and server MAY both take advantage of such
 * knowledge to optimize their transmissions, they MUST NOT be required to do
 * so.
 * 
 * <p>
 * For example, a MID MAY have no in-device support for the Internet Protocol
 * (IP). In this case, it would utilize a gateway to access the Internet, and
 * the gateway would be responsible for some services, such as DNS name
 * resolution for Internet URLs. The device and network may define and implement
 * security and network access policies that restrict access.
 * 
 * <h2>HTTP Network Connection</h2>
 * 
 * <img src="./MIDP_Networking-4.gif"/>
 * 
 * <p>
 * The <i>GenericConnection</i> framework from the CLDC provides the base stream
 * and content interfaces. The interface <i>HttpConnection</i> provides the
 * additional functionality needed to set request headers, parse response
 * headers, and perform other HTTP specific functions.
 * 
 * <p>
 * The interface MUST support:
 * 
 * <ul>
 * <li>HTTP 1.1
 * </ul>
 * 
 * <p>
 * Each device implementing the MIDP MUST support opening connections using the
 * following URL schemes (RFC2396 Uniform Resource Identifiers (URI): Generic
 * Syntax)
 * 
 * <ul>
 * <li>"http" as defined by RFC2616 <i>Hypertext Transfer Protocol -
 * HTTP/1.1</i>
 * </ul>
 * 
 * <p>
 * Each device implementing the MIDP MUST support the full specification of
 * RFC2616 HEAD, GET and POST requests. The implementation MUST also support the
 * absolute forms of URIs.
 * 
 * <p>
 * The implementation MUST pass all request headers supplied by the application
 * and response headers as supplied by the network server. The ordering of
 * request and response headers MAY be changed. While the headers may be
 * transformed in transit, they MUST be reconstructed as equivalent headers on
 * the device and server. Any transformations MUST be transparent to the
 * application and origin server. The HTTP implementations does not
 * automatically include any headers. The application itself is responsible for
 * setting any request headers that it needs.
 * 
 * <p>
 * Connections may be implemented with any suitable protocol providing the
 * ability to reliably transport the HTTP headers and data. (RFC takes great
 * care to not to mandate TCP streams as the only required transport mechanism.)
 * 
 * <h2>HTTP Request Headers</h2>
 * 
 * <p>
 * The HTTP 1.1 specification provides a rich set of request and response
 * headers that allow the application to negotiate the form, format, language,
 * and other attributes of the content retrieved. In the MIDP, the application
 * is responsible for selection and processing of request and response headers.
 * Only the <i>User-Agent</i> header is described in detail. Any other header
 * that is mutually agreed upon with the server may be used.
 * 
 * <h2>User-Agent and Accept-Language Request Headers</h2>
 * 
 * <p>
 * For the MIDP, a simple <i>User-Agent</i> field may be used to identify the
 * current device. As specified by RFC2616, the field contains blank separated
 * features where feature contains a name and optional version number.
 * 
 * <p>
 * The application is responsible for formatting and requesting that the
 * <i>User-Agent</i> field be included in HTTP requests via the
 * {@code setRequestProperty} method in the interface
 * {@code javax.microedition.io.HttpConnection}. It can supply any
 * application-specific features that are appropriate, in addition to any of the
 * profile-specific request header values listed below.
 * 
 * <p>
 * Applications are not required to be loaded onto the device using HTTP. But if
 * they are, then the <i>User-Agent</i> request header should be included in
 * requests to load an application descriptor or application JAR file onto the
 * device. This will allow the server to provide the most appropriate
 * application for the device.
 * 
 * <p>
 * The user-agent and accept-language fields SHOULD contain the following
 * features as defined by system properties using
 * {@code java.lang.System.getProperty}. If multiple values are present they
 * will need to be reformatted into individual fields in the request header.
 * 
 * <h2>System Properties Used for User-Agent and Accept-Language Request
 * Headers</h2>
 * 
 * <table>
 * <thead>
 * <tr>
 * <th>System Property</th>
 * <th>Description</th>
 * </tr>
 * </thead> <tbody>
 * <tr>
 * <td>microedition.profiles</td>
 * <td>A blank (Unicode U+0020) separated list of the J2ME profiles that this
 * device supports. For MIDP 2.0 devices, this property MUST contain at least
 * "MIDP-2.0".</td>
 * </tr>
 * <tr>
 * <td>microedition.configuration</td>
 * <td>The J2ME configuration supported by this device. For example,
 * "CLDC-1.0".</td>
 * </tr>
 * <tr>
 * <td>microedition.locale</td>
 * <td>The name of the current locale on this device. For example, "en-US".</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * <h2>HTTP Request Header Example</h2>
 * 
 * <pre>
 * User-Agent: Profile/MIDP/MIDP-2.0 Configuration/CLDC-1.0
 * Accept-Language: en-US
 * </pre>
 * 
 * <h2>StreamConnection Behavior</h2>
 * 
 * <p>
 * All MIDP {@code StreamConnection}s have one underlying {@code InputStream}
 * and one {@code OutputStream}. Opening a {@code DataInputStream} counts as
 * opening an {@code InputStream} and opening a {@code DataOutputStream} counts
 * as opening an {@code OutputStream}. Trying to open another
 * {@code InputStream} or another {@code OutputStream} from a
 * {@code StreamConnection} causes an {@code IOException}. Trying to open
 * {@code InputStream} or {@code OutputStream} after they have been closed
 * causes an {@code IOException}.
 * 
 * <p>
 * After calling the {@code close} method, regradless of open streams, further
 * method calls to connection will result in {@code IOException} for those
 * methods that are declared to throw {@code IOException}. For the methods that
 * do not throw exceptions, unknown results may be returned.
 * 
 * <p>
 * The methods of {@code StreamConnection} are not synchronized. The only stream
 * method that can be called safely in anthor thread is {@code close}. When
 * {@code close} is invoked on a stream that is excuting in another thread, any
 * pending I/O method MUST throw an {@code InterruptedIOException}. In the above
 * case implementation SHOULD try to throw the exception in a timely manner.
 * When all open streams have been closed, and the {@code StreamConnection} is
 * closed, any pending I/O operations MUST be interrupted in a timely manner.
 * 
 * <h2>Secure Networking</h2>
 * 
 * <p>
 * Since the MIDP 2.0 release additional interfaces are available for secure
 * communication with WWW network services. Secure interfaces are provided by
 * HTTPS and SSL/TLS protocol access over the IP network. Refer to the package
 * documentation of {@code javax.microedition.pki} for the details of
 * certificate profile that applies to secure connections. A
 * {@code HttpsConnection} is returned from {@code Connector.open()} when a
 * {@code "https://"} connection string is accessed. A {@code SecureConnection}
 * is returned from {@code Connector.open()} when a {@code "ssl://"} connection
 * string is accessed.
 * 
 * <ul>
 * <li>{@code javax.microedition.io.HttpsConnection}
 * <li>{@code javax.microedition.io.SecureConnection}
 * <li>{@code javax.microedition.io.SecurityInfo}
 * <li>{@code javax.microedition.pki.Certificate}
 * <li>{@code javax.microedition.pki.CertificateException}
 * </ul>
 * 
 * <h2>Low Level IP Networking</h2>
 * 
 * <p>
 * Since the MIDP 2.0 release, the MIDP specification also includes optional
 * networking support for TCP/IP sockets and UDP/IP datagrams. For each of the
 * following schemes, a host is specified for an outbound connection and the
 * host is omitted for an inbound connection. The host can be a host name, a
 * literal IPv4 address or a literal IPv6 address (according to RFC2732 square
 * bracket character '[' ']' may be used to designate an IPv6 address in URL
 * strings). Implementation MUST be able to parse the URL string and recognize
 * the address format used, but are not required to support all address formats
 * and associated protocols.
 * 
 * <p>
 * When the host and port number are both ommitted from th {@code socket} or
 * {@code datagram} connection, the system will allocate an available port. The
 * host and port numbers allocated in this fashion can be discovered using the
 * {@code getLocalAddress} and {@code getLocalPort} methods. The colon
 * ({@code :}) may be omitted when the connection string does not include the
 * port parameter.
 * 
 * <p>
 * A {@code SocketConnection} is returned from {@code Connector.open()} when a
 * {@code "socket://host:port"} connection string is accessed. A
 * {@code ServerSocketConnection} is returned from {@code Connector.open()} when
 * a {@code "socket://:port"} connection string is accessed. A
 * {@code UDPDatagramConnection} is returned from {@code Connector.open()} when
 * a {@code "datagram://host:port"} connection string is accessed.
 * 
 * <ul>
 * <li>{@code javax.microedition.io.SocketConnection}
 * <li>{@code javax.microedition.io.ServerSocketConnection}
 * <li>{@code javax.microedition.io.DatagramConnection}
 * <li>{@code javax.microedition.io.Datagram}
 * <li>{@code javax.microedition.UDPDatagramConnection}
 * </ul>
 * 
 * <h2>Push Applications</h2>
 * 
 * <p>
 * A {@code PushRegistry} is available in the MIDP 2.0 release which provides a
 * MIDlet with a means of registering for network connection events, which may
 * be delivered when the application is not currently running.
 * 
 * <ul>
 * <li>{@code javax.microedition.io.PushRegistry}
 * </ul>
 * 
 * <h2>Serial Port Communications</h2>
 * 
 * <p>
 * A {@code CommConnection} is available in the MIDP 2.0 release which provides
 * a MIDlet with a means of registering for network accessing a local serial
 * port as a stream connection.
 * 
 * <ul>
 * <li>{@code javax.microedition.io.CommConnection}
 * </ul>
 * 
 * <h2>Security of Networking Functions</h2>
 * 
 * <p>
 * The security model is found in the package {@code javax.microedition.midlet}
 * and provides a framework that allows APIs and functions to be restricted to
 * MIDlet suites that have been granted permissions either by signing or
 * explicitly by the user. (See Security for MIDlet suites for details about
 * granting specific permissions to a {@code MIDlet} suite.)
 * 
 * <p>
 * The risks associated with a MIDlet suite's use of the network are related the
 * potential for network abuse and to costs to the device owner since network
 * use may result in charges. MIDP 2.0 provides a security framework in which
 * network functions can be protected and allowed only to those applications
 * that have requested and been granted appropriate permissions.
 * 
 * <p>
 * Each protocol is accessed by invoking
 * {@code javax.microedition.io.Connector.open} with a URI including the
 * protocol and arguments. The permissions below allow access to be granted
 * individually protocols. The functionality of the protocols is specified by
 * subclasses of {@code Connection} interface that defines the syntax of the URI
 * and any protocol specific methods. Devices are NOT REQUIRED to implement
 * every protocol. If a protocol is implemented, the security framework
 * specifies the naming of permissions according to the package and class name
 * of the APIs used to access the protocol extended with the protocol name. The
 * API providing access is {@code javax.microedition.io.Connector.open}. The
 * table below defines the corresponding permissions for the protocols defined
 * within this specification.
 * 
 * <table>
 * <thead>
 * <th>Permission</th>
 * <th>Protocol</th> </thead> <tbody>
 * <tr>
 * <td>{@code javax.microedition.io.Connector.http}</td>
 * <td>{@code http}</td>
 * </tr>
 * <tr>
 * <td>{@code javax.microedition.io.Connector.https}</td>
 * <td>{@code https}</td>
 * </tr>
 * <tr>
 * <td>{@code javax.microedition.io.Connector.datagram}</td>
 * <td>{@code datagram}</td>
 * </tr>
 * <tr>
 * <td>{@code javax.microedition.io.Connector.datagramreceive}</td>
 * <td>{@code datagram server (without host)}</td>
 * </tr>
 * <tr>
 * <td>{@code javax.microedition.io.Connector.socket}</td>
 * <td>{@code socket}</td>
 * </tr>
 * <tr>
 * <td>{@code javax.microedition.io.Connector.serversocket}</td>
 * <td>{@code server socket (without host)}</td>
 * </tr>
 * <tr>
 * <td>{@code javax.microedition.io.Connector.ssl}</td>
 * <td>{@code ssl}</td>
 * </tr>
 * <tr>
 * <td>{@code javax.microedition.io.Connector.comm}</td>
 * <td>{@code comm}</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * <h2>Security of PushRegistry</h2>
 * 
 * <p>
 * The {@code PushRegistry} is protected using the security framework and
 * permissions. The MIDlet suite must have the
 * {@code javax.microedition.io.PushRegistry} permission to register and alarm
 * based launch, to register dynamically using the {@code PushRegistry}, to make
 * a static registration in the application descriptor and to determine if the
 * user needs to be prompted prior to invoking MIDlet suite in response to a
 * Push connection event or alarm. The protection domain defines the general
 * behavior for user permissions with the interaction modes of "oneshot",
 * "session", and "blanket". For the {@code PushRegistry} and the AMS, launching
 * behavior is specialized:
 * 
 * <ul>
 * <li>Oneshot: The user is prompted before the MIDlet suite is invoked to
 * handle a push event or alarm and for each {@code PushRegistry} request; for
 * example to register an alarm or a connection.
 * <li>Session: The user is prompted before the MIDlet suite is invoked to
 * handle a push event or alarm, or before the first {@code PushRegistry}
 * request; for example to register an alarm or a connection. Subsequently, when
 * a MIDlet uses the {@code PushRegistry} the user is not prompted.
 * <li>Blanket: The user is prompted only once during installation, before the
 * first time the MIDlet suite is invoked to handle a push event or alarm, or
 * uses the {@code PushRegistry}
 * </ul>
 * 
 * <p>
 * The push mechanism uses protocols in which the device is acting as the server
 * and connections can be accepted from other elements of the network. To use
 * the push mechanisms the MIDlet suite will need the permission to use the
 * server connection. For example, to register a chat program that can be
 * started via push might use the following attributes in the manifest:
 * 
 * <pre>
 * MIDlet-Push-1: socket://:79, com.sum.example.SampleChat, *
 * MIDlet-Permissions: javax.microedition.io.PushRegistry, javax.microedition.io.Connector.servers
 * </pre>
 * 
 * @since CLDC 1.0
 */
package javax.microedition.io;