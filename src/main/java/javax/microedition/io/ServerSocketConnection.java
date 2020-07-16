package javax.microedition.io;

import java.io.IOException;

/**
 * This interface defines the server socket stream connection.
 * 
 * <p>
 * A server socket is accessed using a generic connection string with the host
 * omitted. For example, {@code socket://:79} defines an inbound server socket
 * on port {@code 79}. The host can be discovered using the
 * {@code getLocalAddress} method.
 * 
 * <p>
 * The {@code acceptAndOpen()} method returns a {@code SocketConnection}
 * instance. In addition to the normal {@code StreamConnection} behavior, the
 * {@code SocketConnection} supports accessing the IP end point addresses of the
 * live connection and access to socket options that control the buffering and
 * timing delays associated with specific application usage of the connection.
 * 
 * <p>
 * Access to server socket connections may be restricted by the security policy
 * of the device. {@code Connector.open} MUST check access for the initial
 * server socket connection and {@code acceptAndOpen} MUST check before
 * returning each new {@code SocketConnection}.
 * 
 * <p>
 * A server socket can be used to dynamically select an available port by
 * omitting both the host parameters in the connection URL string. For example,
 * {@code socket://} defines an inbound server socket on a port which is
 * allocated by the system. To discover the assigned port number use the
 * {@code getLocalPort} method.
 * 
 * <h2>BNF Format for Connector.open() string</h2>
 * 
 * <p>
 * The URI must conform to the BNF syntax specified below. If the URI does not
 * conform to this syntax, an {@code IllegalArgumentException} is thrown.
 * 
 * <pre>
 * ┌────────────────────────────┬────────────────────────────────────────────────────────────┐
 * | <socket_connection_string> | ::= "socket://" | "socket://"<hostport>                    |
 * ├────────────────────────────┼────────────────────────────────────────────────────────────┤
 * | <hostport>                 | ::= host ":" port                                          |
 * ├────────────────────────────┼────────────────────────────────────────────────────────────┤
 * | <host>                     | ::= omitted for inbound connections. See SocketConnection  |
 * ├────────────────────────────┼────────────────────────────────────────────────────────────┤
 * | <port>                     | ::= numeric port number (omitted for system assigned port) |
 * └────────────────────────────┴────────────────────────────────────────────────────────────┘
 * </pre>
 * 
 * <h2>Examples</h2>
 * 
 * <p>
 * The following examples show how a {@code ServerSocketConnection} would be
 * used to access a sample loopback program.
 * 
 * <pre>
 * // Create the server listening socket for port 1234
 * ServerSocketConnection scn = (ServerSocketConnection) Connector.open("socket://:1234");
 * 
 * // Wait for a connection.
 * SocketConnection sc = (SocketConnection) scn.acceptAndOpen();
 * 
 * // Set application specific hints on the socket.
 * sc.setSocketOption(DELAY, 0);
 * sc.setSocketOption(LINGER, 0);
 * sc.setSocketOption(KEEPALIVE, 0);
 * sc.setSocketOption(RCVBUF, 128);
 * sc.setSocketOption(SNDBUF, 128);
 * 
 * // Get the input stream of the connection.
 * DataInputStream is = sc.openDataInputStream();
 * 
 * // Get the output stream of the connection.
 * DataOutputStream os = sc.openDataOutputStream();
 * 
 * // Read the input data.
 * String result = is.readUTF();
 * 
 * // Echo the data back to the sender.
 * os.writeUTF(result);
 * 
 * // Close everything.
 * is.close();
 * os.close();
 * sc.close();
 * scn.close();
 * </pre>
 * 
 * @since MIDP 2.0
 */
public interface ServerSocketConnection extends StreamConnectionNotifier {

    /**
     * <p>
     * Gets the local address to which the socket is bound.
     * 
     * <p>
     * The host address (IP number) that can be used to connect to this end of
     * socket connection from an external system. Since IP addresses may be
     * dynamically assigned, a remote application will need to be robust in the face
     * of IP number reassignment.
     * 
     * <p>
     * The local hostname (if available) can be accessed from
     * {@code System.getProperty("microedition.hostname")}
     * 
     * @return the local address to which the socket is bound.
     * @throws IOException if the connection was closed
     * @see SocketConnection
     */
    public String getLocalAddress() throws IOException;

    /**
     * Returns the local port to which this socket is bound.
     * 
     * @return the local port number to which this socket is connected.
     * @throws IOException if the connection was closed
     * @see SocketConnection
     */
    public int getLocalPort() throws IOException;
}
