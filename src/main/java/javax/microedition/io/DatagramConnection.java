package javax.microedition.io;

import java.io.IOException;

/**
 * <p>
 * This interface defines the capabilities that a datagram connection must have.
 * 
 * <p>
 * Reminder: Since the CLDC Specification does not define any actual network
 * protocol implementations, the syntax for datagram addressing is not defined
 * in the CLDC Specification. Rather, syntax definition takes place at the level
 * of J2ME profiles such as MIDP.
 * 
 * <p>
 * In the sample implementation that is provided as part of the CLDC reference
 * implementation, the following addressing scheme is used:
 * 
 * <p>
 * The parameter string describing the target of a connection in the CLDC
 * reference implementation takes the following form:
 * 
 * <pre>
 * {protocol}://[{host}]:[{port}]
 * </pre>
 * 
 * <p>
 * A datagram connection can be opened in a "client" mode or "server" mode. If
 * the "//{host}" part is missing then the connection is opened as a "server"
 * (by "server", we mean that a client application initiates communication).
 * When the "//{host}" part is specified, the connection is opened as a
 * "client".
 * 
 * <p>
 * Examples:
 * 
 * <p>
 * A datagram connection for accepting datagrams
 * 
 * <pre>
 * datagram://:1234
 * </pre>
 * 
 * <p>
 * A datagram connection for sending to a server:
 * 
 * <pre>
 * datagram://123.201.64.12:1234
 * </pre>
 * 
 * <p>
 * Note that the port number in "server mode" (unspecified host name) is that of
 * the receiving port. The port number in "client mode" (host name specified) is
 * that of the target port. The reply-to port in both cases is never
 * unspecified. In "server mode", the same port number is used for both
 * receiving and sending. In "client mode", the reply-to port is always
 * dynamically allocated.
 * 
 * <p>
 * Also note that the allocation of datagram objects is done in a more abstract
 * way than in Java 2 Standard Edition (J2SE). Instead of providing a concrete
 * {@code DatagramPacket} class, an abstract {@code Datagram} interface is
 * provided. This is to allow a single platform to support several different
 * datagram interfaces simultaneously. Datagram objects must be allocated by
 * calling the {@code newDatagram} methods of the {@code DatagramConnection}
 * object. The resulting object is defined using another interface type called
 * {@code javax.microedition.io.Datagram}.
 * 
 * @since CLDC 1.0
 */
public interface DatagramConnection extends Connection {

    /**
     * Get the maximum length a datagram can be. Maximum length determines the
     * maximum size of the datagram that can b created using the {@code newDatagram}
     * method, and the maximum size of the datagram that can be sent or received.
     * 
     * @return The maximum length of a datagram.
     * @throws IOException If an I/O error occurs.
     */
    public int getMaximumLength() throws IOException;

    /**
     * Get the nominal length of a datagram. Nominal length refers to the size of
     * the datagram that is stored into the data buffer. Nominal length may be equal
     * or less than the maximum length of the datagram.
     * 
     * @return The nominal length of a datagram.
     * @throws IOException If an I/O error occurs.
     */
    public int getNominalLength() throws IOException;

    /**
     * Send a datagram. The {@code Datagram} object includes the information
     * indicating the data to be sent, its length, and the address of the receiver.
     * The method sends {@code length} bytes starting at the current {@code offset}
     * of the {@code Datagram} object, where {@code length} and {@code offset} are
     * internal state variables of the {@code Datagram} object.
     * 
     * @param dgram A datagram
     * @throws IOException            If an I/O error occurs.
     * @throws InterruptedIOException Timeout or interrupt occurred.
     */
    public void send(Datagram dgram) throws IOException;

    /**
     * <p>
     * Receive a datagram. When this method returns, the internal buffer in the
     * {@code Datagram} object is filled with the data received, starting at the
     * location determined by the {@code offset} state variable, and the data is
     * ready to be read using the methods of the {@code DataInput} interface.
     * 
     * <p>
     * This method blocks until a datagram is received. The internal {@code length}
     * state variable in the {@code Datagram} object contains the length of the
     * received datagram. If the received data is longer than the length of the
     * internal buffer minus offset, data is truncated.
     * 
     * <p>
     * This method does not change the internal <i>read/write state</i> variable of
     * the {@code Datagram} object. Use method {@code Datagram.reset} to change the
     * pointer before reading if necessary.
     * 
     * @param dgram A datagram
     * @throws IOException            If an I/O error occurs.
     * @throws InterruptedIOException Timeout or interrupt occurred.
     */
    public void receive(Datagram dgram) throws IOException;

    /**
     * Create a new datagram object.
     * 
     * @param size The size of the buffer needed for the datagram
     * @return A new datagram
     * @throws IOException              If an I/O error occurs.
     * @throws IllegalArgumentException if the size is negative or larger than the
     *                                  maximum size
     */
    public Datagram newDatagram(int size) throws IOException;

    /**
     * Create a new datagram object.
     * 
     * @param size The size of the buffer needed for the datagram
     * @param addr The I/O address to which the datagram will be sent
     * @return A new datagram
     * @throws IOException              If an I/O error occurs.
     * @throws IllegalArgumentException if the size is negative or larger than the
     *                                  maximum size, or if the address parameter is
     *                                  invalid
     */
    public Datagram newDatagram(int size, String addr) throws IOException;

    /**
     * Create a new datagram object.
     * 
     * @param buf  The buffer to be used for the datagram
     * @param size The size of the buffer needed for the datagram
     * @return A new datagram
     * @throws IOException              If an I/O error occurs.
     * @throws IllegalArgumentException if the size is negative or larger than the
     *                                  maximum size or the given buffer's length,
     *                                  or if the buffer parameter is invalid
     */
    public Datagram newDatagram(byte[] buf, int size) throws IOException;

    /**
     * Make a new datagram object.
     * 
     * @param buff The buffer to be used for the datagram
     * @param size The size of the buffer needed for the datagram
     * @param addr The I/O address to which the datagram will be sent
     * @return A new datagram
     * @throws IOException              If an I/O error occurs.
     * @throws IllegalArgumentException if the size is negative or larger than the
     *                                  maximum size or the given buffer's length,
     *                                  or if the address or buffer parameter is
     *                                  invalid
     */
    public Datagram newDatagram(byte[] buff, int size, String addr) throws IOException;
}
