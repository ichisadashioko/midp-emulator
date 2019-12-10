package javax.microedition.io;

import java.io.IOException;

/**
 * <p>
 * This interface defines the necessary methods and constants for an HTTP
 * connection.
 * 
 * <p>
 * HTTP is a request-response protocol in which the parameters of request must
 * be set before the request is sent. The connection exists in one of three
 * states:
 * 
 * <ul>
 * <li>Setup, in which the request parameters can be set
 * <li>Connected, in which request parameters have been sent and the response is
 * expected
 * <li>Closed, the final state, in which the HTTP connection as been terminated
 * </ul>
 * 
 * <p>
 * The following methods may be invoked only in the Setup state:
 * 
 * <ul>
 * <li>{@code setRequestMethod}
 * <li>{@code setRequestProperty}
 * </ul>
 * 
 * <p>
 * The transition from Setup to Connected is caused by any method that requires
 * data to be sent to or received from the server.
 * 
 * <p>
 * The following methods cause the transition to the Conntected state when the
 * connection is in Setup state.
 * 
 * <ul>
 * <li>{@code openInputStream}
 * <li>{@code openDataInputStream}
 * <li>{@code getLength}
 * <li>{@code getType}
 * <li>{@code getEncoding}
 * <li>{@code getHeaderField}
 * <li>{@code getResponseCode}
 * <li>{@code getResponseMessage}
 * <li>{@code getHeaderFieldInt}
 * <li>{@code getHeaderFieldDate}
 * <li>{@code getExpiration}
 * <li>{@code getDate}
 * <li>{@code getLastModified}
 * <li>{@code getHeaderField}
 * <li>{@code getHeaderFieldKey}
 * </ul>
 * 
 * <p>
 * The following methods may be invoked while the connection is in Setup or
 * Connected state.
 * 
 * <ul>
 * <li>{@code close}
 * <li>{@code getRequestMethod}
 * <li>{@code getRequestProperty}
 * <li>{@code getURL}
 * <li>{@code getProtocol}
 * <li>{@code getHost}
 * <li>{@code getHost}
 * <li>{@code getFile}
 * <li>{@code getRef}
 * <li>{@code getPort}
 * <li>{@code getQuery}
 * </ul>
 * 
 * <p>
 * After an output stream has been opened by the {@code openOutputStream} or
 * {@code openDataOutputStream} methods, attempts to change the request
 * parameters via {@code setRequestMethod} or the {@code setRequestProperty} are
 * ignored. Once the request parameters have been sent, these methods will throw
 * an {@code IOException}. When an output stream is closed via the
 * {@code OutputStream.close} or {@code DataOutputStream.close} methods, the
 * connection enters the Connected state. When the output stream is flushed via
 * the {@code OutputStream.flush} or {@code DataOutputStream.flush} methods, the
 * request parameters MUST be sent along with any data written to the stream.
 * 
 * <p>
 * The transition to Closed state from any other state is caused by the
 * {@code close} method and the closing all of the streams that were opened from
 * the connection.
 * 
 * <h3>Example using StreamConnection</h3>
 * 
 * <p>
 * Simple read of a URL using {@code StreamConnection}. No HTTP specific
 * behavior is needed or used. (Note: this example ignores all HTTP response
 * headers and the HTTP response code. Since a proxy or server may have sent an
 * error response page, an application can not distinquish which data is
 * retreived in the {@code InputStream}.)
 * 
 * <p>
 * {@code Connector.open} is used to open URL and a {@code StreamConnection} is
 * returned. From the {@code StreamConnection} the {@code InputStream} is
 * opened. It is used to read every character until end of file (-1). If an
 * exception is thrown the connection and stream are closed.
 * 
 * <blockquote>
 * 
 * <pre>
 * void getViaStreamConnection(String url) throws IOException {
 *     StreamConnection c = null;
 *     InputStream s = null;
 *     try {
 *         c = (StreamConnection) Connector.open(url);
 *         s = c.openInputStream();
 *         int ch;
 *         while ((ch = s.read()) != -1) {
 *             // ...
 *         }
 *     } finally {
 *         if (s != null)
 *             s.close();
 *         if (c != null)
 *             c.close();
 *     }
 * }
 * </pre>
 * 
 * </blockquote>
 * 
 * <h3>Example using ContentConnection</h2>
 * 
 * <p>
 * Simple read of a URL using {@code ContentConnection}. No HTTP specific
 * behavior is needed or used.
 * 
 * <p>
 * {@code Connector.open} is used to open url and a {@code ContentConnection} is
 * returned. The {@code ContentConnection} may be able to provide the length. If
 * the length is available, it is used to read the data in bulk. From the
 * {@code ContentConnection} the {@code InputStream} is opened. It is used to
 * read every character until end of file (-1). If an exception is thrown the
 * connection and stream are closed.
 * 
 * <blockquote>
 * 
 * <pre>
 * void getViaContentConnection(String url) throws IOException {
 *     ContentConnection c= null;
 *     DataInputStream is = null;
 *     try {
 *         c = (ContentConnection)Connector.open(url);
 *         int len = (int) c.getLength();
 *         dis = c.openDataInputStream();
 *         if(len > 0) {
 *             byte[] data = new byte[len];
 *             dis.readFully(data);
 *         } else {
 *             int ch;
 *             while ((ch = dis.read()) != -1)
 *                 // ...
 *         }
 *     } finally {
 *         if (dis != null) dis.close();
 *         if (c != null) c.close();
 *     }
 * }
 * </pre>
 * 
 * </blockquote>
 * 
 * @since MIDP 1.0
 */
public interface HttpConnection extends ContentConnection {

    /**
     * HTTP Head method.
     */
    public final static String HEAD = "HEAD";

    /**
     * HTTP Get method.
     */
    public final static String GET = "GET";

    /**
     * HTTP Post method.
     */
    public final static String POST = "POST";

    /**
     * 200: The request has succeded.
     */
    public static final int HTTP_OK = 200;

    /**
     * 201: The request has been fulfilled and resulted in a new resource being
     * created.
     */
    public static final int HTTP_CREATED = 201;

    public static final int HTTP_ACCEPTED = 202;

    public static final int HTTP_NOT_AUTHORITATIVE = 203;

    public static final int HTTP_NO_CONTENT = 204;

    public static final int HTTP_RESET = 205;

    public static final int HTTP_PARTIAL = 206;

    public static final int HTTP_MULT_CHOICE = 300;

    public static final int HTTP_MOVED_PERM = 301;

    public static final int HTTP_MOVED_TEMP = 302;

    public static final int HTTP_SEE_OTHER = 303;

    public static final int HTTP_NOT_MODIFIED = 304;

    public static final int HTTP_USE_PROXY = 305;

    public static final int HTTP_TEMP_REDIRECT = 307;

    public static final int HTTP_BAD_REQUEST = 400;

    public static final int HTTP_UNAUTHORIZED = 401;

    public static final int HTTP_PAYMENT_REQUIRED = 402;

    public static final int HTTP_FORBIDDEN = 403;

    public static final int HTTP_NOT_FOUND = 404;

    public static final int HTTP_BAD_METHOD = 405;

    public static final int HTTP_NOT_ACCEPTABLE = 406;

    public static final int HTTP_PROXY_AUTH = 407;

    public static final int HTTP_CLIENT_TIMEOUT = 408;

    public static final int HTTP_CONFLICT = 409;

    public static final int HTTP_GONE = 410;

    public static final int HTTP_LENGTH_REQUIRED = 411;

    public static final int HTTP_PRECON_FAILED = 412;

    public static final int HTTP_ENTITY_TOO_LARGE = 413;

    public static final int HTTP_REQ_TOO_LONG = 414;

    public static final int HTTP_UNSUPPORTED_TYPE = 415;

    public static final int HTTP_UNSUPPORTED_RANGE = 416;

    public static final int HTTP_EXPECT_FAILED = 417;

    public static final int HTTP_INTERNAL_ERROR = 500;

    public static final int HTTP_NOT_IMPLEMENTED = 501;

    public static final int HTTP_BAD_GATEWAY = 502;

    public static final int HTTP_UNAVAILABLE = 503;

    public static final int HTTP_GATEWAY_TIMEOUT = 504;

    public static final int HTTP_VERSION = 505;

    public long getDate() throws IOException;

    public long getExpiration() throws IOException;

    public String getFile();

    public String getHeaderField(String name) throws IOException;

    public String getHeaderField(int n) throws IOException;

    public long getHeaderFieldDate(String name, long def) throws IOException;

    public int getHeaderFieldInt(String name, int def) throws IOException;

    public String getHeaderFieldKey(int n) throws IOException;

    public String getHost();

    public long getLastModified() throws IOException;

    public int getPort();

    public String getProtocol();

    public String getQuery();

    public String getRef();

    public String getRequestMethod();

    public String getRequestProperty(String key);

    public int getResponseCode() throws IOException;

    public String getResponseMessage() throws IOException;

    public String getURL();

    public void setRequestMethod(String method) throws IOException;

    public void setRequestProperty(String key, String value) throws IOException;
}