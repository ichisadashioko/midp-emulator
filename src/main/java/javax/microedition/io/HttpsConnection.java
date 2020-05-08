package javax.microedition.io;

import java.io.IOException;

import javax.microedition.pki.CertificateException;

/**
 * This interface defines the necessary methods and constants to establish a
 * secure network connection. The URI format with scheme {@code https} when
 * passed to {@code Connector.open} will return a {@code HttpsConnection}.
 * <a href="https://www.ietf.org/rfc/rfc2818.txt">RFC 2818</a> defines the
 * scheme.
 * 
 * <p>
 * A secure connection MUST be implemented by one or more of the following
 * specifications:
 * 
 * <ul>
 * <li>HTTP over TLS as documented in
 * <a href="https://www.ietf.org/rfc/rfc2818.txt">RFC 2818</a> and TLS Protocol
 * Version 1.0 as specified in <a href="http://www.ietf.org/rfc/rfc2246.txt">RFC
 * 2246</a>.
 * <li>SSL V3 as specified in
 * <a href="https://tools.ietf.org/html/draft-ietf-tls-ssl-version3-00">The SSL
 * Protocol Version 3.0</a>
 * <li>WTLS as specified in
 * <a href="http://www.wapforum.org/what/technical_1_2_1.htm">WAP Forum
 * Specifications June 2000 (WAP 1.2.1) conformance release</a> - Wireless
 * Transport Layer Security document WAP-199.
 * <li>WAP(TM) TLS Profile and Tunneling Specification as specified in <a href=
 * "http://www.wapforum.com/what/technical.htm">WAP-219-TLS-20010411-a</a>
 * </ul>
 * 
 * HTTPS is the secure version of HTTP (IETF RFC2616), a request-response
 * protocol in which the parameters of the request must be set before the
 * request is sent.
 * 
 * <p>
 * In addition to the normal {@code IOExceptions} that may occur during
 * invocation of the various methods that cause a transition to the Connected
 * state, {@code CertificateException} (a subtype of {@code IOException}) may be
 * thrown to indicate various failures related to establishing the secure link.
 * The secure link is necessary in the {@code Connected} state to the headers
 * can be sent securely. The secure link may be established as early as the
 * invocation of {@code Connector.open()} and related methods for opening input
 * and output streams and failure related to certificate exceptions may be
 * reported.
 * 
 * <p>
 * <b>Example</b>
 * 
 * <p>
 * Open a HTTPS connection, set its parameters, then read the HTTP response.
 * 
 * <p>
 * {@code Connector.open} is used to open the URL and an {@code HttpsConnection}
 * is returned. The HTTP headers are read and processed. If the length is
 * available, it is used to read the data in bulk. From the
 * {@code HttpsConnection} the {@code InputStream} is opened. It is used to read
 * every character until the end of file (-1). If and exception is thrown the
 * connection and stream are closed.
 * 
 * <pre>
 * void getViaHttpsConnection(String url) throws CertificateException, IOException {
 *     HttpsConnection c = null;
 *     InputStream is = null;
 *     try {
 *         c = (HttpsConnection) Connector.open(url);
 *         // Getting the InputStream ensures that the connection
 *         // is opened (if it was not already handled by
 *         // Connector.open()) and the SSL handshake is exchanged,
 *         // and the HTTP response headers are read.
 *         // These are stored until requested.
 *         is = c.openDataInputStream();
 * 
 *         if (c.getResponseCode() == HttpConnection.HTTP_OK) {
 *             // Get the length and process the data
 *             int len = (int) c.getLength();
 *             if (len > 0) {
 *                 byte[] data = new byte[len];
 *                 int actual = is.readFully(data);
 *                 // ...
 *             } else {
 *                 int ch;
 *                 while ((ch = is.read()) != -1) {
 *                     // ...
 *                 }
 *             }
 *         } else {
 *             // ...
 *         }
 *     } finally {
 *         if (is != null) {
 *             is.close();
 *         }
 *         if (c != null) {
 *             c.close();
 *         }
 *     }
 * }
 * </pre>
 * 
 * @since MIDP 2.0
 * @see CertificateException
 */
public interface HttpsConnection extends HttpConnection {

    /**
     * Return the security information associated with this successfully opened
     * connection. If the connection is still in {@code Setup} state then the
     * connection is initiated to established the secure connection to the server.
     * The method returns when the connection is established and the
     * {@code Certificate} supplied by the server has been validated. The
     * {@code SecurityInfo} is only returned if the connection has been successfully
     * made to the server.
     * 
     * @return the security information associated with this open connection.
     * @throws IOException if an arbitrary connection failure occurs
     */
    public SecurityInfo getSecurityInfo() throws IOException;

    /**
     * Returns the network port number of the URL for this {@code HttpsConnection}.
     * 
     * @return the network port number of the URL for this {@code HttpsConnection}.
     *         The default HTTPS port number (443) is returned if these was no port
     *         number in the string passed to {@code Connector.open}.
     */
    public int getPort();
}
