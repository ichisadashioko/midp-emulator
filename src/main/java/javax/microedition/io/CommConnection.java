package javax.microedition.io;

/**
 * <p>
 * This interface defines a logical serial port connection. A "logical" serial
 * port is defined as a logical connection through which bytes are transferring
 * serially. The logical serial port is defined within the underlying operating
 * system and may not necessarily correspond to a physical RS-232 serial port.
 * For instance, IrDA IRCOMM ports can commonly be configured as a logical
 * serial port within the operating system so that it can act as a "logical"
 * serial port.
 * 
 * <p>
 * A comm port is accessed using a Generic Connection Framework string with an
 * explicit port identifier and embedded configuration parameters, each
 * separated with a semi-colon (;).
 * 
 * <p>
 * Only one application may be connected to a particular serial port at a given
 * time. An {@code java.io.IOException} is thrown, if an attempt is made to open
 * the serial port with {@code Connector.open()} and the connection is already
 * open.
 * 
 * <p>
 * A URI with the type and parameters is used to open the connection. The scheme
 * (defined in RFC 2396) must be:
 * {@code comm:<port identifier>[<optional parameters>]}
 * 
 * <p>
 * The first parameter must be a port identifier, which is a logical device
 * name. These identifiers are most likely device specific and should be used
 * with care.
 * 
 * <p>
 * The valid identifiers for a particular device and OS can be queried through
 * the method {@code System.getProperty()} using the key
 * "microedition.commports". A comma separated list of ports is returned which
 * can be combined with a {@code comm:} prefix as the URL string to be used to
 * open a serial port connection. (See port naming convention below.)
 * 
 * <p>
 * Any additional parameters must be separated by a semi-colon (;) and spaces
 * are not allowed in the string. If a particular optional parameter is not
 * applicable to a particular port, the parameter MAY be ignored. The port
 * identifier MUST NOT contain a semi-colon (;).
 * 
 * <p>
 * Legal parameters are defined by the definition of the parameters below.
 * Illegal or unrecognized parameters cause an {@code IllegalArgumentException}.
 * If the value of a parameter is supported by the device, it must be honored.
 * If the value of a parameter is not supported a {@code java.io.IOException} is
 * thrown. If a {@code baudrate} parameter is requested, it is treated in the
 * same way that the {@code setBaudRate} method handles baudrates. e.g., if the
 * baudrate requested is not supported the system MAY substitute a valid
 * baudrate, which can be discovered using the {@code getBaudRate} method.
 * 
 * <h2>Optional Parameters</h2>
 * <table>
 * <thead>
 * <tr>
 * <th>Parameter</th>
 * <th>Default</th>
 * <th>Description</th>
 * </tr>
 * </thead> <tbody>
 * <tr>
 * <td><code>baudrate</code></td>
 * <td><code>platform dependent</code></td>
 * <td>The speed of the port.</td>
 * </tr>
 * <tr>
 * <td><code>bitsperchar</code></td>
 * <td><code>8</code></td>
 * <td>The number bits per character (<code>7</code> or <code>8</code>).</td>
 * </tr>
 * <tr>
 * <td><code>stopbits</code></td>
 * <td><code>1</td>
 * <td>Them number of stop bits per char (<code>1</code> or
 * <code>2</code>).</td>
 * </tr>
 * <tr>
 * <td><code>parity</code></td>
 * <td><code>none</code></td>
 * <td>The parity can be <code>odd</code>, <code>even</code>, or
 * <code>none</code>.</td>
 * </tr>
 * <tr>
 * <td><code>blocking</code></td>
 * <td><code>on</code></td>
 * <td>If <code>on</code>, wait for a full buffer when reading.</td>
 * </tr>
 * <tr>
 * <td><code>autocts</code></td>
 * <td><code>on</code></td>
 * <td>If <code>on</code>, wait for the CTS line to be on before writing.</td>
 * </tr>
 * <tr>
 * <td><code>autorts</code></td>
 * <td><code>on</code></td>
 * <td>If <code>on</code>, turn on the RTS line when the input buffer is not
 * full. If <code>off</code>, the RTS line is always on.</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * <h2>BNF Format for <code>Connector.open()</code> string</h2>
 * 
 * <p>
 * The URI must conform to the BNF syntax specified below. If the URL does not
 * conform to this syntax, an {@code IllegalArgumentException} is thrown.
 * 
 * <table>
 * <tbody>
 * <tr>
 * <td><code>&lt;comm_connection_string&gt;</code></td>
 * <td><code>::= "comm:"&lt;port_id&gt;[&lt;options_list&gt;];</code></td>
 * </tr>
 * <tr>
 * <td><code>&lt;port_id&gt;</code></td>
 * <td><code>::= string of alphanumeric characters</code></td>
 * </tr>
 * <tr>
 * <td><code>&lt;options_list&gt;</code></td>
 * <td>
 * <pre>::= *(&lt;baud_rate_string&gt;|&lt;bitsperchar&gt;|&lt;stopbits&gt;|&lt;parity&gt;|&lt;blocking&gt;|&lt;autocts&gt;|&lt;autorts&gt;);</pre>
 * </td>
 * </tr>
 * </tbody>
 * </table>
 */
public interface CommConnection extends StreamConnection {

}