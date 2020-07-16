package javax.microedition.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;

/**
 * This interface defines the capabilities that an input stream connection must
 * have.
 * 
 * @since CLDC 1.0
 */
public interface InputConnection extends Connection {

    /**
     * Open and return an input stream for a connection.
     * 
     * @return An input stream
     * @throws IOException If an I/O error occurs
     */
    public InputStream openInputStream() throws IOException;

    /**
     * Open and return a data input stream for a connection.
     * 
     * @return An input stream
     * @throws IOException If an I/O error occurs
     */
    public DataInputStream openDataInputStream() throws IOException;
}
