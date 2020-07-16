package javax.microedition.io;

import java.io.IOException;

/**
 * This class is used to signal that a connection target cannot be found, or the
 * protocol type is not supported.
 *
 * @since CLDC 1.0
 */
public class ConnectionNotFoundException extends IOException {
    /**
     * Constructs a ConnectionNotFoundException with no detail message.
     */
    public ConnectionNotFoundException() {
        throw new UnsupportedOperationException();
    }

    /**
     * Constructs a ConnectionNotFoundException with the specified detail message. A
     * detail message in a String that describes this particular exception.
     *
     * @param s the detail message
     */
    public ConnectionNotFoundException(String s) {
        throw new UnsupportedOperationException();
    }
}
