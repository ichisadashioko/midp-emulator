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

    /**
     * 202: The request has been accepted for processing, but the processing has not
     * been completed.
     */
    public static final int HTTP_ACCEPTED = 202;

    /**
     * 203: The returned meta-information in the entity-header is not the definitive
     * set as available from the original server.
     */
    public static final int HTTP_NOT_AUTHORITATIVE = 203;

    /**
     * 204: The server has fulfilled the request but does not need to return an
     * entity-body, and might want to return updated meta-information.
     */
    public static final int HTTP_NO_CONTENT = 204;

    /**
     * 205: The server has fulfilled the request and the user agent SHOULD reset the
     * document view which caused the request to be sent.
     */
    public static final int HTTP_RESET = 205;

    /**
     * 206: The server has fulfilled the partial GET request for the resource.
     */
    public static final int HTTP_PARTIAL = 206;

    /**
     * 300: The requested resource corresponds to any one of a set of
     * representations, each with its own specific location, and agent-driven
     * negotiation information is being provided so that the user (or user agent)
     * can select a preferred representation and redirect its request to that
     * location.
     */
    public static final int HTTP_MULT_CHOICE = 300;

    /**
     * 301: The requested resource has been assigned a new permanent URI and any
     * future references to this resource SHOULD use one of the returned URIs.
     */
    public static final int HTTP_MOVED_PERM = 301;

    /**
     * 302: The requested resource resides temporarily under a different URI. (Note:
     * the name of this status code reflects the earlier publication of RFC2068,
     * which was changed in RFC2616 from "moved temporalily" to "found". The
     * semantics were not changed. The <code>Location</code> header indicates where
     * the application should resend the request.)
     */
    public static final int HTTP_MOVED_TEMP = 302;

    /**
     * 303: The response to the request can be found under a different URI and
     * SHOULD be retrieved using a GET method on that resource.
     */
    public static final int HTTP_SEE_OTHER = 303;

    /**
     * 304: If the client has performed a conditional GET request and access is
     * allowed, but the document has not been modified, the server SHOULD respond
     * with this status code.
     */
    public static final int HTTP_NOT_MODIFIED = 304;

    /**
     * 305: The requested resource MUST be accessed through the proxy given by the
     * Location field.
     */
    public static final int HTTP_USE_PROXY = 305;

    /**
     * 307: The requested resource resides temporarily under a different URI.
     */
    public static final int HTTP_TEMP_REDIRECT = 307;

    /**
     * 400: The request could not be understood by the server due to malformed
     * syntax.
     */
    public static final int HTTP_BAD_REQUEST = 400;

    /**
     * 401: The request requires user authentication. The response MUST include a
     * WWW-Authenticate header field containing a challenge applicable to the
     * requested resource.
     */
    public static final int HTTP_UNAUTHORIZED = 401;

    /**
     * 402: This code is reserved for future use.
     */
    public static final int HTTP_PAYMENT_REQUIRED = 402;

    /**
     * 403: The server understood the request, but is refusing to fulfill it.
     * Authorization will not help and the request SHOULD NOT be repeated.
     */
    public static final int HTTP_FORBIDDEN = 403;

    /**
     * 404: The server has not found anything matching the Request-URI. No
     * indication is given of whether the condition is temporary or permanent.
     */
    public static final int HTTP_NOT_FOUND = 404;

    /**
     * 405: The method specified in the Request-Line is not allowed for the resource
     * identified by the Request-URI.
     */
    public static final int HTTP_BAD_METHOD = 405;

    /**
     * 406: The resource identified by the request is only capable of generating
     * response entities which have content characteristics not acceptable according
     * to the accept headers sent in the request.
     */
    public static final int HTTP_NOT_ACCEPTABLE = 406;

    /**
     * 407: This code is similar to 401 (Unauthorized), but indicates that the
     * client must first authenticate itself with the proxy.
     */
    public static final int HTTP_PROXY_AUTH = 407;

    /**
     * 408: The client did not produce a request within the time that the server was
     * prepared to wait. The client MAY repeat the request without modifications at
     * any later time.
     */
    public static final int HTTP_CLIENT_TIMEOUT = 408;

    /**
     * 409: The request could not be completed due to a conflict with the current
     * state of the resource.
     */
    public static final int HTTP_CONFLICT = 409;

    /**
     * 410: The requested resource is no longer available at the server and no
     * forwarding address is known.
     */
    public static final int HTTP_GONE = 410;

    /**
     * 411: The server refuses to accept the request without a defined
     * Content-Length.
     */
    public static final int HTTP_LENGTH_REQUIRED = 411;

    /**
     * 412: The precondition given in one or more of the request-header fields
     * evaluated to false when it was tested on the server.
     */
    public static final int HTTP_PRECON_FAILED = 412;

    /**
     * 413: The server is refusing to process a request because the request entity
     * is larger than the server is willing or able to process.
     */
    public static final int HTTP_ENTITY_TOO_LARGE = 413;

    /**
     * 414: The server is refusing to service the request because the Request-URI is
     * longer than the server is willing to interpret.
     */
    public static final int HTTP_REQ_TOO_LONG = 414;

    /**
     * 415: The server is refusing to service the request because the entity of the
     * request is in a format not supported by the request resource for the request
     * method.
     */
    public static final int HTTP_UNSUPPORTED_TYPE = 415;

    /**
     * 416: A server SHOULD return a response with this status code if a request
     * included a Range request-header field.
     */
    public static final int HTTP_UNSUPPORTED_RANGE = 416;

    /**
     * 417: The expectation given in an Expect request-header field could not be met
     * by this server, or, if the server is a proxy, the server has unambiguous
     * evidence that the request could not be met by the next-hop server.
     */
    public static final int HTTP_EXPECT_FAILED = 417;

    /**
     * 500: The server encountered an unexpected condition which prevented it from
     * fulfilling the request.
     */
    public static final int HTTP_INTERNAL_ERROR = 500;

    /**
     * 501: The server does not support the functionality required to fulfill the
     * request.
     */
    public static final int HTTP_NOT_IMPLEMENTED = 501;

    /**
     * 502: The server, while acting as a gateway or proxy, received an invalid
     * response from the upstream server it accessed in attempting to fulfull the
     * request.
     */
    public static final int HTTP_BAD_GATEWAY = 502;

    /**
     * 503: The server is currently unable to handle the request due to a temporary
     * overloading or maintenance of the server.
     */
    public static final int HTTP_UNAVAILABLE = 503;

    /**
     * 504: The server, while acting as a gateway or proxy, did not receive a timely
     * response from the upstream server specified by the URI or some other
     * auxiliary server it needed to access in attempting to complete the request.
     */
    public static final int HTTP_GATEWAY_TIMEOUT = 504;

    /**
     * 505: The server does not support, or refuses to support, the HTTP protocol
     * version that was used in the request message.
     */
    public static final int HTTP_VERSION = 505;

    /**
     * Return a string representation of the URL for this connection.
     * 
     * @return the string representation of the URL for this connection.
     */
    public String getURL();

    /**
     * Returns the protocol name of the URL of this {@code HttpConnection}. e.g.,
     * http or https
     * 
     * @return the protocol of the URL of this {@code HttpConnection}.
     */
    public String getProtocol();

    /**
     * Returns the host information of the URL of this {@code HttpConnection}. e.g.
     * host name or IPv4 address
     * 
     * @return the host information of the URL of this {@code HttpConnection}.
     */
    public String getHost();

    /**
     * Returns the file portion of the URL of this {@code HttpConnection}.
     * 
     * @return the file portion of the URL of this {@code HttpConnection}.
     *         {@code null} is returned if there is no file.
     */
    public String getFile();

    /**
     * Returns the ref portion of the URL of this {@code HttpConnection}. RFC2396
     * specifies the optional fragment identifier as the text after the crosshatch
     * (#) character in the URL. This information may be used by the user agent as
     * additional reference information after the resource is successfully
     * retrieved. The format and interpretation of the fragment identifier is
     * dependent on the media type [RFC2046] of the retrieved information.
     * 
     * @return the ref portion of the URL of this {@code HttpConnection}.
     *         {@code null} is returned if there is no value.
     */
    public String getRef();

    /**
     * Returns the query portion of the URL of this {@code HttpConnection}. RFC2396
     * defines the query component as the text after the first question-mark (?)
     * character in the URL.
     * 
     * @return the query portion of the URL of this {@code HttpConnection}.
     *         {@code null} is returned if there is no value.
     */
    public String getQuery();

    /**
     * Returns the network port number of the URL for this {@code HttpConnection}.
     * 
     * @return the network port number of the URL for this {@code HttpConnection}.
     *         The default HTTP port number (80) is returned if there was no port
     *         number in the string passed to {@code Connector.open}.
     */
    public int getPort();

    /**
     * Get the current request method. e.g. HEAD, GET, POST. The default value is
     * GET.
     * 
     * @return the HTTP request method
     * @see #setRequestMethod(String)
     */
    public String getRequestMethod();

    /**
     * Set the method for the URL request, one of:
     * 
     * <ul>
     * <li>GET
     * <li>POST
     * <li>HEAD
     * </ul>
     * 
     * are legal, subject to protocol restrictions. The default method is GET.
     * 
     * @param method the HTTP method
     * @throws IOException if the method cannot be reset or if the requested method
     *                     isn't valid for HTTP.
     * @see #getRequestMethod()
     */
    public void setRequestMethod(String method) throws IOException;

    /**
     * Returns the value of the named general request property for this connection.
     * 
     * @param key the keyword by which the request property is known (e.g.,
     *            "accept").
     * @return the value of the named general request property for this connection.
     *         If there is no key with the specified name then {@code null} is
     *         returned.
     * @see #setRequestProperty(String, String)
     */
    public String getRequestProperty(String key);

    /**
     * Sets the general request property. If a property with the key already exists,
     * overwrite its value with the new value.
     * 
     * <p>
     * Note: HTTP requires all request properties which can legally have multiple
     * instances with the same key to use a comma-separated list syntax which
     * enables multiple properties to be appended into a single property.
     * 
     * @param key   the keyword by which the request is known (e.g.,
     *              "{@code accept}").
     * @param value the value associated with it.
     * @throws IOException is thrown if the connection is in the connected state.
     * @see #getRequestProperty(String)
     */
    public void setRequestProperty(String key, String value) throws IOException;

    /**
     * Returns the HTTP response status code. It parses responses like:
     * 
     * <pre>
     * HTTP/1.0 200 OK
     * HTTP/1.0 401 Unauthorized
     * </pre>
     * 
     * and extracts the ints 200 and 401 respectively from the response (note the
     * sample response is not valid HTTP).
     * 
     * @return the HTTP Status-Code or -1 if no status code can be discerned.
     * @throws IOException if an error occurrred connecting to the server.
     */
    public int getResponseCode() throws IOException;

    /**
     * Gets the HTTP response message, if any, returned along with the response code
     * from a server. From responses like:
     * 
     * <pre>
     * HTTP/1.0 200 OK
     * HTTP/1.0 404 Not Found
     * </pre>
     * 
     * Extracts the Strings "OK" and "Not Found" respectively. Returns null if none
     * could be discerned from the response (the result was not valid HTTP).
     * 
     * @return the HTTP response message, or {@code null}
     * @throws IOException if an error occurred connecting to the server.
     */
    public String getResponseMessage() throws IOException;

    /**
     * Returns the value of the {@code expires} header field.
     * 
     * @return the expiration date of the resource that this URL references, or 0 if
     *         not known. The value is the number of milliseconds since January 1,
     *         1970 GMT.
     * @throws IOException if an error occurred connecting to the server.
     */
    public long getExpiration() throws IOException;

    /**
     * Returns the value of the {@code date} header field.
     * 
     * @return the sending date of the resource that the URL references, or
     *         {@code 0} if not known. The value returned is the number of
     *         milliseconds since January 1, 1970 GMT.
     * @throws IOException if an error occurred connecting to the server.
     */
    public long getDate() throws IOException;

    /**
     * Returns the value of the {@code last-modified} header field. The result is
     * the number of milliseconds since January 1, 1970 GMT.
     * 
     * @return the date the resource referenced by this {@code HttpConnection} was
     *         last modified, or 0 if not known.
     * @throws IOException if an error occurred connecting to the server.
     */
    public long getLastModified() throws IOException;

    /**
     * Returns the value of the named header field.
     * 
     * @param name of a header field
     * @return the value of the named header field, or {@code null} if there is no
     *         such field in the header.
     * @throws IOException if an error occurred connecting to the server.
     */
    public String getHeaderField(String name) throws IOException;

    /**
     * Returns the value of the named field parsed as a number.
     * 
     * <p>
     * This form of {@code getHeaderField} exists because some connection types
     * (e.g. {@code http-ng}) have pre-parsed headers. Classes for that connection
     * type can override this method and short-circuit the parsing.
     * 
     * @param name the name of the header field
     * @param def  the default value
     * @return the value of the named field, parsed as an integer. The {@code def}
     *         value is returned if the field is missing or malformed.
     * @throws IOException if an error occurred connecting the the server.
     */
    public int getHeaderFieldInt(String name, int def) throws IOException;

    /**
     * Returns the value of the named field parsed as date. The result is the number
     * of milliseconds since January 1, 1970 GMT represented by the named field.
     * 
     * <p>
     * This form of {@code getHeaderField} exists because some connection types
     * (e.g. {@code http-ng}) have pre-parsed headers. Classes for that connection
     * type can override this method and short-circuit the parsing.
     * 
     * @param name the name of the header field.
     * @param def  a default value.
     * @return the value of the field, parsed as a date. The value of the
     *         {@code def} argument is returned if the field is missing or
     *         malformed.
     * @throws IOException if an error occurred connecting to the server.
     */
    public long getHeaderFieldDate(String name, long def) throws IOException;

    /**
     * Gets a header field value by index.
     * 
     * @param n the index of the header field
     * @return the value of the nth header field or {@code null} if the array index
     *         is out of range. An empty String is returned if the field does not
     *         have a value.
     * @throws IOException if an error occurred connecting to the server.
     */
    public String getHeaderField(int n) throws IOException;

    /**
     * Gets a header field key by index.
     * 
     * @param n the index of the header field
     * @return the key of the nth header field or {@code null} if the array index is
     *         out of range.
     * @throws IOException if an error occurred connecting to the server.
     */
    public String getHeaderFieldKey(int n) throws IOException;
}
