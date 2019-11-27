package javax.microedition.midlet;

/**
 * Signals that a requested {@code MIDlet} state change failed. This exception
 * is thrown by the {@code MIDlet} is response to state change calls into the
 * application via the {@code MIDlet} interface
 * 
 * @since MIDP 1.0
 */
public class MIDletStateChangeException extends Exception {

    /**
     * Constructs an exception with no specified detail message.
     */
    public MIDletStateChangeException() {
        throw new UnsupportedOperationException();
    }

    /**
     * Constructs an exception with the specified detail message.
     * 
     * @param s the detail message
     */
    public MIDletStateChangeException(String s) {
        throw new UnsupportedOperationException();
    }
}