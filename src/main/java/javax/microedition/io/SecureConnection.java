package javax.microedition.io;

import java.io.IOException;

/**
 * This interface defines the secure socket stream connection. A secure
 * connection is established using {@code Connector.open} with the scheme "ssl"
 * and the secure connection is established before {@code open} returns. If the
 * secure connection cannot be established due to errors related to certificates
 * a {@code CertificateException} is thrown.
 * 
 * <p>
 * A secure socket is accessed using a generic connection string with an
 * explicit host and port number. The host may be specified as a fully qualified
 * host name or IPv4 number. e.g. {@code ssl://host.com:79} defines a target
 * socket on the {@code host.com} system at port {@code 79}.
 * 
 * <p>
 * Note that RFC1900 recommends the use of names rather than IP numbers for best
 * results in the event of IP reassignment.
 * 
 * <p>
 * A secure connection MUST be implemented by one or more of the following
 * specifications:
 * 
 * <ul>
 * <li>TLS Protocol Version 1.0 as specified in
 * <a href="https://www.ietf.org/rfc/rfc2246.txt">RFC 2246</a>.
 * <li>SSL V3 as specified in
 * <a href="https://tools.ietf.org/html/draft-ietf-tls-ssl-version3-00">The SSL
 * Protocol Version 3.0</a>
 * <li>WAP(TM) TLS Profile and Tunneling Specification as specified in <a href=
 * "http://www.wapforum.com/what/technical.htm">WAP-219-TLS-20010411-a</a>
 * </ul>
 * 
 * <h2>BNF Format for Connector.open() string</h2>
 * 
 * <p>
 * The URI must conform to the BNF syntax specified below. If the URI does not
 * conform to this syntax, an {@code IllegalArgumentException} is thrown.
 * 
 * <pre>
 * ┌────────────────────────────┬─────────────────────────────┐
 * | <socket_connection_string> | ::= "ssl://"<hostport>      |
 * ├────────────────────────────┼─────────────────────────────┤
 * | <hostport>                 | ::= host ":" port           |
 * ├────────────────────────────┼─────────────────────────────┤
 * | <host>                     | ::= host name or IP address |
 * ├────────────────────────────┼─────────────────────────────┤
 * | <port>                     | ::= numeric port number     |
 * └────────────────────────────┴─────────────────────────────┘
 * </pre>
 * 
 * <h2>Examples</h2>
 * 
 * <p>
 * The following examples show how a {@code SecureConnection} would be used to
 * access a sample loopback program.
 * 
 * <pre>
 * SecureConnection sc = (SecureConnection)Connector.open("ssl://host.com:79");
 * SecurityInfo info = sc.getSecurityInfo();
 * boolean is TLS = (info.getProtocolName().equals("TLS"));
 * 
 * sc.setSocketOption(SocketConnection.LINGER, 5);
 * 
 * InputStream is = sc.openInputStream();
 * OutputStream os = sc.openOutputStream();
 * 
 * os.write("\r\n".getBytes());
 * int ch = 0;
 * while(ch != -1) {
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
public interface SecureConnection extends SocketConnection {

    /**
     * Return the security information associated with this connection when it was
     * opened.
     * 
     * @return the security information associated with this open connection.
     * @throws IOException if an arbitrary connection failure occurs
     */
    public SecurityInfo getSecurityInfo() throws IOException;
}
