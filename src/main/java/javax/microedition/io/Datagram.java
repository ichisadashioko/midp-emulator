package javax.microedition.io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * <p>
 * This class defines an abstract interface for datagram packets. The implementations of this
 * interface hold data to be sent or received from a {@code DatagramConnection} object.
 * 
 * <p>
 * Since this is an interface class, the internal structure of the datagram packets is not defined
 * here. However, it is assumed that each implementation of this interface will provide the
 * following fields / state variables (the actual implementation and the names of these fields may
 * vary):
 * 
 * <ul>
 * <li><i>buffer</i>: the internal buffer in which data is stored
 * <li><i>offset</i>: the read/write offset for the internal buffer
 * <li><i>length</i>: the length of the data in datagram packet
 * <li><i>address</i>: the destination or source address
 * <li><i>read/write pointer</i>: a pointer that is added to the <i>offset</i> to point to the
 * current data location during a read or write operation
 * </ul>
 * 
 * <strong>Reading and Writing</strong>
 * 
 * <p>
 * The {@code Datagram} interface extends interfaces {@code DataInput} and {@code DataOutput} in
 * order to provide a simple way to read and write binary data in and out of the datagram buffer
 * instead of using {@code getData} and {@code setData} methods. Writing automatically increments
 * <i>length</i> and reading will continue while the <i>read/write pointer</i> is less than
 * <i>length</i>. Before any writing is done {@code reset} must be called. If {@code setData()} is
 * to be used when reading or writing, any value for the {@code offset} parameter other than 0 is
 * not supported.
 * 
 * <p>
 * Example to write to datagram:
 * 
 * <blockquote>
 * 
 * <pre>
 * datagram = connection.newDatagram(max);
 * 
 * // Reset and prepare the datagram for writing new message.
 * datagram.reset();
 * 
 * // writeUTF automatically increases the datagram length.
 * datagram.writeUTF("hello world");
 * 
 * connection.send(datagram);
 * </pre>
 * 
 * </blockquote>
 * 
 * <p>
 * Example to read from a datagram (single use only):
 * 
 * <blockquote>
 * 
 * <pre>
 * datagram = connection.newDatagram(max);
 * 
 * connection.receive(datagram);
 * 
 * message = datagram.readUTF();
 * </pre>
 * 
 * </blockquote>
 * 
 * <strong>Reusing Datagram</strong>
 * 
 * <p>
 * It should be noted the <i>length</i> above is returned from {@code getLength} and can have
 * different meanings at different times. When sending <i>length</i> is the number of bytes to send.
 * Before receiving <i>length</i> is the maximum number of bytes to receive. After receiving
 * <i>length</i> is the number of bytes that were received. So when reusing a datagram to receive
 * after sending or receiving, length must be set back to the maximum using {@code setLength}.
 * 
 * <blockquote>
 * 
 * <pre>
 * datagram = connection.newDatagram(max);
 * 
 * while (notDone) {
 *     // The last receive in the loop changed the length
 *     // so put it back to the maximum length.
 *     datagram.setLength(max);
 *     connection.receive(datagram);
 * 
 *     data = datagram.getData();
 *     bytesReceived = datagram.getLength();
 * 
 *     // process datagram ...
 * }
 * </pre>
 * 
 * </blockquote>
 * 
 * <p>
 * When reading instead of using {@code getData} the {@code reset} method must be used.
 * 
 * <blockquote>
 * 
 * <pre>
 * datagram = connection.newDatagram(max);
 * 
 * while (notDone) {
 *     // The last read in the loop changed the read pointer
 *     // so reset the pointer.
 *     datagram.reset();
 *     datagram.setLength(max);
 *     connection.receive(datagram);
 * 
 *     message = datagram.readUTF(message);
 * 
 *     // process message ...
 * }
 * </pre>
 * 
 * </blockquote>
 * 
 * <p>
 * Example to re-read a datagram:
 * 
 * <blockquote>
 * 
 * <pre>
 * connection.receive(datagram);
 * 
 * message = datagram.readUTF(message);
 * 
 * len = datagram.setLength();
 * 
 * datagram.reset();
 * 
 * datagram.setLength(len);
 * 
 * copy = datagram.readUTF(message);
 * </pre>
 * 
 * </blockquote>
 * 
 * @since CLDC 1.0
 */
public interface Datagram extends DataInput, DataOutput {

    /**
     * Get the address of the datagram.
     * 
     * @return the address in string form, or {@code null} if no address was set
     * @see #setAddress(String)
     */
    public String getAddress();

    /**
     * <p>
     * Get the contents of the data buffer.
     * 
     * <p>
     * Depending on the implementation, this operation may return the internal buffer or copy of it.
     * However, the user must not assume that the contents of the internal data buffer can be
     * manipulated by modifying the data returned by this operation. Rather, the {@code setData}
     * operation should be used for changing the contents of the internal buffer.
     * 
     * @return the data buffer as a byte array
     * @see #setData(byte[], int, int)
     */
    public byte[] getData();

    /**
     * Get the length of the datagram.
     * 
     * @return the length state variable
     * @see #setLength(int)
     */
    public int getLength();

    /**
     * Get the offset
     * 
     * @return the {@code offset} state variable
     */
    public int getOffset();

    /**
     * <p>
     * Set datagram address.
     * 
     * <p>
     * The actual addressing scheme is implementation-dependent. Please read the general comments on
     * datagram addressing in {@link DatagramConnection}.
     * 
     * <p>
     * Note that if the address of a datagram is not specified, then it defaults to that of the
     * connection.
     * 
     * @param addr the new target address as a URL
     * @throws IllegalAccessException if the address is not valid
     * @throws IOException            if some kind of I/O error occurs
     * @see #getAddress()
     */
    public void setAddress(String addr) throws IOException;

    /**
     * Set datagram address, copying the address from another datagram.
     * 
     * @param reference to the datagram whose address will be copied as the new target address for
     *                  this datagram.
     * @throws IllegalArgumentException if the address is not valid
     * @see #getAddress()
     */
    public void setAddress(Datagram reference);

    /**
     * Set the {@code length} state variable.
     * 
     * @param len the new length of the datagram
     * @throws IllegalArgumentException if the length or length plus offset fall outside the buffer
     * @see #getLength()
     */
    public void setLength(int len);

    /**
     * Set the {@code buffer}, {@code offset}, and {@code length} state variables. Depending on the
     * implementation, this operation may copy the buffer or just set the variable {@code buffer} to
     * the value of the {@code buffer} argument. However, the user must not assume that the contents
     * of the internal data buffer can be manipulated by modifying the buffer passed on to this
     * operation.
     * 
     * @param buffer the data buffer
     * @param offset the offset into the data buffer
     * @param len    the length of the data in the buffer
     * @throws IllegalArgumentException if the length or offset plus length fall outside the buffer,
     *                                  or if the buffer parameter is invalid
     * @see #getData()
     */
    public void setData(byte[] buffer, int offset, int len);

    /**
     * Zero the {@code read/write pointer} as well the {@code offset} and {@code length} state
     * variables.
     */
    public void reset();
}
