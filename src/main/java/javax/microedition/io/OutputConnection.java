package javax.microedition.io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This interface defines the capabilities that an output stream connection must have.
 * 
 * @since CLDC 1.0
 */
public interface OutputConnection extends Connection {
    /**
     * Open and return an output stream for a connection.
     * 
     * @return An output stream
     * @throws IOException If an I/O error occurs
     */
    public OutputStream openOutputStream() throws IOException;

    /**
     * Open and return a data output stream for a connection.
     * 
     * @return An output stream
     * @throws IOException If an I/O error occurs
     */
    public DataOutputStream openDataOutputStream() throws IOException;
}
