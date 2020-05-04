package javax.microedition.io;

import java.io.IOException;

/**
 * <p>
 * This interface defines a datagram connection which knows it's local end point
 * address. The protocol is transaction oriented, and delivery and duplicate
 * protection are not guaranteed. Applications requiring ordered reliable
 * delivery of streams of data should use the {@code SocketConnection}.
 * 
 * <p>
 * A {@code UDPDatagramConnection} is returned from {@code Connector.open()} in
 * response to a request to open a {@code datagram://} URL connection string. If
 * the connection string omits both the {@code host} and {@code port} fields in
 * the URL string, then the system will allocate an available port. The local
 * address and the local port can be discovered using the accessor methods
 * within this interface.
 * 
 * <p>
 * The syntax described here for the datagram URL connection string is also
 * valid for the {@code Datagram.setAddress()} method used to assign a
 * destination address to a {@code Datagram} to be sent. e.g.,
 * {@code datagram://host:port}
 * 
 * <h2>BNF Format for Connector.open() string</h2>
 * 
 * <p>
 * The URI must conform to the BNF syntax specified below. If the URI does not
 * conform to this syntax, an {@code IllegalArgumentException} is thrown.
 * 
 * <pre>
 * ┌──────────────────────────────┬───────────────────────────────────────────────────────────────┐
 * | <datagram_connection_string> | ::= "datagram://" | "datagram://"<hostport>                   |
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────┤
 * | <hostport>                   | ::= host ":" port                                             |
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────┤
 * | <host>                       | ::= host name or IP address (omitted for inbound connections) |
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────┤
 * | <port>                       | ::= numeric port number (omitted for system assigned port)    |
 * └──────────────────────────────┴───────────────────────────────────────────────────────────────┘
 * </pre>
 * 
 * @since MIDP 2.0
 */
public interface UDPDatagramConnection extends DatagramConnection {

    /**
     * <p>
     * Gets the local address to which the datagram connection is bound.
     * 
     * <p>
     * The host address (IP number) that can be used to connect to this end of the
     * datagram connection from an external system. Since IP addresses may be
     * dynamically assigned, a remote application will need to be robust in the face
     * of IP number reassignment.
     * 
     * <p>
     * The local hostname (if available) can be accessed from
     * {@code System.getProperty("microedition.hostname")}
     * 
     * @return the local address to which the datagram connection is bound.
     * @throws IOException if the connection was closed.
     * @see ServerSocketConnection
     */
    public String getLocalAddress() throws IOException;

    /**
     * Returns the local port to which this datagram connection is bound.
     * 
     * @return the local port number to which this datagram connection is connected.
     * @throws IOException if the connection was closed.
     * @see ServerSocketConnection
     */
    public int getLocalPort() throws IOException;
}