package javax.microedition.io;

/**
 * <p>
 * This interface defines the capabilities that a stream connection must have.
 * 
 * <p>
 * In a typical implementation of this interface (for instance in MIDP 2.0), all
 * {@code StreamConnections} have one underlying {@code InputStream} and one {@code OutputStream}.
 * Opening a {@code DataInputStream} counts as opening an {@code InputStream} and opening a
 * {@code DataOutputStream} counts as opening an {@code OutputStream}. Trying to open another
 * {@code InputStream} or {@code OutputStream} causes an {@code IOException}. Trying to open the
 * {@code InputStream} or {@code OutputStream} after they have been closed causes an
 * {@code IOException}.
 * 
 * <p>
 * The methods of {@code StreamConnection} are not synchronized. The only stream method that can be
 * called safely in another thread is close.
 * 
 * @since CLDC 1.0
 */
public interface StreamConnection extends InputConnection, OutputConnection {

}
