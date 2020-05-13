package javax.microedition.io;

import java.io.IOException;

/**
 * This interface defines the socket stream connection.
 * 
 * <p>
 * A socket is accessed using a generic connection string with an explicit host
 * and port number. The host may be specified as a fully qualified host name or
 * IPv4 number. e.g. {@code socket://host.com:79} defines a target socket on the
 * {@code host.com} system at port {@code 79}.
 * 
 * <p>
 * Note that RFC1900 recommends the use of names rather than IP numbers for best
 * results in the event of IP number reassignment.
 * 
 * <h2>Closing Streams</h2>
 * 
 * <p>
 * Every {@code StreamConnection} provides a {@code Connection} object as well
 * as an {@code InputStream} and {@code OutputStream} to handle the I/O
 * associated with the connection. Each of these interfaces has its own
 * {@code close()} method. For systems that support duplex communication over
 * the socket connection, closing of the input or output stream SHOULD shutdown
 * just that side of the connection. e.g. closing the {@code InputStream} will
 * permit the {@code OutputStream} to continue sending data.
 * 
 * <p>
 * Once the input or output stream has been closed, it can only be reopened with
 * a call to {@code Connector.open()}. The application will receive an
 * {@code IOException} if an attempt is made to reopen the stream.
 * 
 * <h2>BNF Format for Connector.open() string</h2>
 * 
 * <p>
 * The URI must conform to the BNF syntax specified below. If the URI does not
 * conform to this syntax, an {@code IllegalArgumentException} is thrown.
 * 
 * <pre>
 * ┌────────────────────────────┬───────────────────────────────────┐
 * | <socket_connection_string> | ::= "socket://"<hostport>         |
 * ├────────────────────────────┼───────────────────────────────────┤
 * | <hostport>                 | ::= host ":" port                 |
 * ├────────────────────────────┼───────────────────────────────────┤
 * | <host>                     | ::= host name or IP address       |
 * |                            | (omitted for inbound connections, |
 * |                            | see ServerSocketConnection)       |
 * ├────────────────────────────┼───────────────────────────────────┤
 * | <port>                     | ::= numeric port number           |
 * └────────────────────────────┴───────────────────────────────────┘
 * </pre>
 * 
 * <h2>Examples</h2>
 * 
 * <p>
 * The following examples show how a {@code SocketConnection} would be used to
 * access a sample loopback program.
 * 
 * <pre>
 * SocketConnection sc = (SocketConnection) Connector.open("socket://host.com:79");
 * sc.setSocketConnection(SocketConnection.LINGER, 5);
 * 
 * InputStream is = sc.openInputStream();
 * OutputStream os = sc.openOutputStream();
 * 
 * os.write("\r\n".getBytes());
 * int ch = 0;
 * while (ch != -1) {
 *     ch = is.read();
 * }
 * 
 * is.close();
 * os.close();
 * sc.close();
 * </pre>
 * 
 * @since MIDP 2.0
 */
public interface SocketConnection extends StreamConnection {

    /**
     * Socket option for the small buffer <i>writing delay</i> (0). Set to zero to
     * disable Nagle algorithm for small buffer operations. Set to a non-zero value
     * to enable.
     */
    public static final byte DELAY = 0;

    /**
     * Socket option for the <i>linger time</i> to wait in seconds before closing a
     * connection with pending data output (1). Setting the linger time to zero
     * disables the linger wait interval.
     */
    public static final byte LINGER = 1;

    /**
     * Socket option for the <i>keep alive</i> feature (2). Setting KEEPALIVE to
     * zero will disable the feature. Setting KEEPALIVE to a non-zero value will
     * enable the feature.
     */
    public static final byte KEEPALIVE = 2;

    /**
     * Socket option for the size of the <i>receiving buffer</i> (3).
     */
    public static final byte RCVBUF = 3;

    /**
     * Socket option for the size of the <i>sending buffer</i> (4).
     */
    public static final byte SNDBUF = 4;

    /**
     * Set a socket option for the connection.
     * 
     * <p>
     * Options inform low level networking code about intended usage patterns that
     * the application will use in dealing with the socket connection.
     * 
     * <p>
     * Calling {@code setSocketOption} to assign buffer sizes is a hint to the
     * platform of the sizes to set the underlying network I/O buffers. Calling
     * {@code getSocketOption} can be used to see what sizes the system is using.
     * The system MAY adjust the buffer sizes to account for better throughput
     * available from Maximum Transmission Unit (MTU) and Maximum Segment Size (MSS)
     * data available from current network information.
     * 
     * @param option socket option identifier (KEEPALIVE, LINGER, SNDBUF, RCVBUF, or
     *               DELAY)
     * @param value  numeric value for specified option
     * @throws IllegalArgumentException if the value is not valid (e.g. negative
     *                                  value) or if the option identifier is not
     *                                  valid
     * @throws IOException              if the connection was closed
     * @see #getSocketOption(byte)
     */
    public void setSocketOption(byte option, int value) throws IllegalArgumentException, IOException;

    /**
     * Get a socket option for the connection.
     * 
     * @param option socket option identifier (KEEPALIVE, LINGER, SNDBUF, RCVBUF, or
     *               DELAY)
     * @return numeric value for specified or -1 if the value is not available.
     * @throws IllegalArgumentException if the option identifier is not valid
     * @throws IOException              if the connection was closed
     * @see #setSocketOption(byte, int)
     */
    public int getSocketOption(byte option) throws IllegalArgumentException, IOException;

    /**
     * Gets the local address to which the socket is bound.
     * 
     * <p>
     * The host address (IP number) that can be used to connect to this end of the
     * socket connection from an external system. Since IP addresses may be
     * dynamically assigned, a remote application will need to be robust in the face
     * of IP number reassignment.
     * 
     * <p>
     * The local hostname (if available) can be accessed from
     * {@code System.getProperty("microedition.hostname")}
     * 
     * @return the local address to which the socket is bound.
     * @throws IOException if the connection was closed.
     * @see ServerSocketConnection
     */
    public String getLocalAddress() throws IOException;

    /**
     * Returns the local port to which this socket is bound.
     * 
     * @return the local port number to which this socket is connected.
     * @throws IOException if the connection was closed.
     * @see ServerSocketConnection
     */
    public int getLocalPort() throws IOException;

    /**
     * Gets the remote address to which the socket is bound. The address can be
     * either the remote host name or the IP address (if available).
     * 
     * @return the remote address to which the socket is bound.
     * @throws IOException if the connection was closed.
     */
    public String getAddress() throws IOException;

    /**
     * Returns the remote port to which this socket is bound.
     * 
     * @return the remote port number to which this socket is connected.
     * @throws IOException if the connection was closed.
     */
    public int getPort() throws IOException;
}