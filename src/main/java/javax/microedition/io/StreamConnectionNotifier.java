package javax.microedition.io;

import java.io.IOException;

/**
 * This interface defines the capabilities that a connection notifier must have.
 * 
 * @since CLDC 1.0
 */
public interface StreamConnectionNotifier extends Connection {

    /**
     * Returns a {@code StreamConnection} object that represents a server side
     * socket connection. The method blocks until a connection is made.
     * 
     * @return A {@code StreamConnection} to communicate with a client.
     * @throws IOException If an I/O error occurs.
     */
    public StreamConnection acceptAndOpen() throws IOException;
}
