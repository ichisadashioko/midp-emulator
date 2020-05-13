package javax.microedition.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class is factory for creating new Connection objects.
 * 
 * <p>
 * The creation of Connections is performed dynamically by looking up a protocol
 * implementation class whose name is formed from the platform name (read from a
 * system property) and the protocol name of the requested connection (extracted
 * from the parameter string supplied by the application programmer). The
 * parameter string that describes the target should conform to the URL format
 * as described in RFC 2396. This takes the general from:
 * 
 * <pre>
 * {scheme}:[{target}][{params}]
 * </pre>
 * 
 * <p>
 * where <code>{scheme}</code> is the name of a protocol such as <i>http</i>.
 * 
 * <p>
 * The <code>{target}</code> is normally some kind of network address.
 * 
 * <p>
 * Any <code>{params}</code> are formed as a series of equates of the form
 * ";x=y". Example: ";type=a".
 * 
 * <p>
 * An optional second parameter may be specified to the open function. This is a
 * mode flag that indicates to the protocol handler the intentions of the
 * calling code. The options here specify if the connection is going to be read
 * (READ), written (WRITE), or both (READ_WRITE). The validity of these flag
 * settings is protocol dependent. For instance, a connection for a printer
 * would not allow read access, and would throw an IllegalArgumentException. If
 * the mode parameter is not specified, READ_WRITE is used by default.
 * 
 * <p>
 * An optional third parameter is a boolean flag that indicates if the calling
 * code can handle timeout exceptions. If this flag is set, the protocol
 * implementation may throw an InterruptedIOException when it detects a timeout
 * condition. This flag is only a hint to the protocol handler, it does not
 * guarantee that such exceptions will actually be thrown. If this parameter is
 * not set, no timeout exceptions will be thrown.
 * 
 * <p>
 * Because connections are frequently opened just to gain access to a specific
 * input or output stream, four convenience functions are provided for this
 * purpose. See also {@code DatagramConnection} for information relating to
 * datagram addressing.
 * 
 * @since CLDC 1.0
 */
public class Connector {

    /**
     * Access mode READ.
     */
    public static final int READ = 1;

    /**
     * Access mode WRITE.
     */
    public static final int WRITE = 2;

    /**
     * Access mode READ_WRITE.
     */
    public static final int READ_WRITE = 3;

    /**
     * Create and open a Connection.
     * 
     * @param name the URL for the connection.
     * @return A new Connection object.
     * @throws IllegalArgumentException    If a parameter is invalid.
     * @throws ConnectionNotFoundException If the target of the name cannot be
     *                                     found, or if the requested protocol type
     *                                     is not supported.
     * @throws IOException                 If some other kind of I/O error occurs.
     * @throws SecurityException           May be thrown if access to the protocol
     *                                     handler is prohibited.
     */
    public static Connection open(String name) throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Create and open a Connection.
     * 
     * @param name the URL for the connection.
     * @param mode The access mode.
     * @return A new Connection object.
     * @throws IllegalArgumentException    If a parameter is invalid.
     * @throws ConnectionNotFoundException If the target of the name cannot be
     *                                     found, or if the requested protocol type
     *                                     is not supported.
     * @throws IOException                 If some other kind of I/O error occurs.
     * @throws SecurityException           May be thrown if access to the protocol
     *                                     handler is prohibited.
     */
    public static Connection open(String name, int mode) throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Create and open a Connection.
     * 
     * @param name    the URL for the connection.
     * @param mode    The access mode.
     * @param timouts A flag to indicate that the caller wants timeout exceptions.
     * @return A new Connection object.
     * @throws IllegalArgumentException    If a parameter is invalid.
     * @throws ConnectionNotFoundException If the target of the name cannot be
     *                                     found, or if the requested protocol type
     *                                     is not supported.
     * @throws IOException                 If some other kind of I/O error occurs.
     * @throws SecurityException           May be thrown if access to the protocol
     *                                     handler is prohibited.
     */
    public static Connection open(String name, int mode, boolean timeouts) throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Create and open a connection input stream.
     * 
     * @param name The URL for the connection.
     * @return A DataInputStream.
     * @throws IllegalArgumentException    If a parameter is invalid.
     * @throws ConnectionNotFoundException If the target of the name cannot be
     *                                     found, or if the requested protocol type
     *                                     is not supported.
     * @throws IOException                 If some other kind of I/O error occurs.
     * @throws SecurityException           May be thrown if access to the protocol
     *                                     handler is prohibited.
     */
    public static DataInputStream openDataInputStream(String name) throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Create and open a connection output stream.
     * 
     * @param name The URL for the connection.
     * @return A DataOutputStream.
     * @throws IllegalArgumentException    If a parameter is invalid.
     * @throws ConnectionNotFoundException If the target of the name cannot be
     *                                     found, or if the requested protocol type
     *                                     is not supported.
     * @throws IOException                 If some other kind of I/O error occurs.
     * @throws SecurityException           May be thrown if access to the protocol
     *                                     handler is prohibited.
     */
    public static DataOutputStream openDataOutputStream(String name) throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Create and open a connection inputStream.
     * 
     * @param name The URL for the connection.
     * @return An InputStream.
     * @throws IllegalArgumentException    If a parameter is invalid.
     * @throws ConnectionNotFoundException If the target of the name cannot be
     *                                     found, or if the requested protocol type
     *                                     is not supported.
     * @throws IOException                 If some other kind of I/O error occurs.
     * @throws SecurityException           May be thrown if access to the protocol
     *                                     handler is prohibited.
     */
    public static InputStream openInputStream(String name) throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Create and open a connection output stream.
     * 
     * @param name The URL for the connection.
     * @return An OutputStream
     * @throws IllegalArgumentException    If a parameter is invalid.
     * @throws ConnectionNotFoundException If the target of the name cannot be
     *                                     found, or if the requested protocol type
     *                                     is not supported.
     * @throws IOException                 If some other kind of I/O error occurs.
     * @throws SecurityException           May be thrown if access to the protocol
     *                                     handler is prohibited.
     */
    public static OutputStream openOutputStream(String name) throws IOException {
        throw new UnsupportedOperationException();
    }
}