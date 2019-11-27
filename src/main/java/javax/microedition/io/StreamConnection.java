package javax.microedition.io;

/**
 * <p>
 * This interface defines the capabilities that a stream connection must have.
 * 
In a typical implementation of this interface (for instance in MIDP 2.0), all StreamConnections have one underlying InputStream and one OutputStream. Opening a DataInputStream counts as opening an InputStream and opening a DataOutputStream counts as opening an OutputStream. Trying to open another InputStream or OutputStream causes an IOException. Trying to open the InputStream or OutputStream after they have been closed causes an IOException.

The methods of StreamConnection are not synchronized. The only stream method that can be called safely in another thread is close.
 * @since CLDC 1.0
 */
public interface StreamConnection extends InputConnection, OutputConnection {

}