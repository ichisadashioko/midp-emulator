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
 * 
 * <pre>
 * ┌─────────────┬────────────────────┬───────────────────────────────────────────────────────────────────────────────────────────────┐
 * | Parameter   | Default            | Description                                                                                   |
 * ├─────────────┼────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────┤
 * | baudrate    | platform dependent | The speed of the port.                                                                        |
 * ├─────────────┼────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────┤
 * | bitsperchar | 8                  | The number bits per character (7 or 8).                                                       |
 * ├─────────────┼────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────┤
 * | stopbits    | 1                  | The number of stop bits per char (1 or 2).                                                    |
 * ├─────────────┼────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────┤
 * | parity      | none               | The parity can be odd, even, or none.                                                         |
 * ├─────────────┼────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────┤
 * | blocking    | on                 | If on, wait for a full buffer when reading.                                                   |
 * ├─────────────┼────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────┤
 * | autocts     | on                 | If on, wait for the CTS line to be on before writing.                                         |
 * ├─────────────┼────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────┤
 * | autorts     | on                 | If on, turn on RTS line when the input buffer is not full. If off, the RTS line is always on. |
 * └─────────────┴────────────────────┴───────────────────────────────────────────────────────────────────────────────────────────────┘
 * </pre>
 * 
 * <h2>BNF Format for {@code Connector.open()} string</h2>
 * 
 * <p>
 * The URI must conform to the BNF syntax specified below. If the URL does not
 * conform to this syntax, an {@code IllegalArgumentException} is thrown.
 * 
 * <pre>
 * ┌──────────────────────────┬───────────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * | <comm_connection_string> | ::= "comm:"<port_id>[<options_list>];                                                                     |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <port_id>                | ::= string of alphanumeric characters                                                                     |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <options_list>           | ::= *(<baud_rate_string>|<bitsperchar>|<stopbits>|<stopbits>|<parity>|<blocking>|<autocts>|<autorts>);    |
 * |                          | ; if an option duplicates a previous option in the option list, that option overrides the previous option |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <baud_rate_string>       | ::= ";baudrate="<baud_rate>                                                                               |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <baud_rate>              | ::= string of digits                                                                                      |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <bitsperchar>            | ::= ";bitsperchar="<bit_value>                                                                            |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <bit_value>              | ::= "7" | "8"                                                                                             |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <stopbits>               | ::= ";stopbits="<stop_value>                                                                              |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <stop_value>             | ::= "1" | "2"                                                                                             |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <parity>                 | ::= ";parity="<parity_value>                                                                              |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <parity_value>           | ::= "even" | "odd" | "none"                                                                               |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <blocking>               | ::= ";blocking="<on_off>                                                                                  |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <autocts>                | ::= ";autocts="<on_off>                                                                                   |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <autorts>                | ::= ";autorts="<on_off>                                                                                   |
 * ├──────────────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 * | <on_off>                 | ::= "on" | "off"                                                                                          |
 * └──────────────────────────┴───────────────────────────────────────────────────────────────────────────────────────────────────────────┘
 * </pre>
 * 
 * <h2>Security</h2>
 * 
 * <p>
 * Access to serial ports is restricted to prevent unauthorized transmission or
 * reception of data. The security model applied to the serial port connection
 * is defined in the implementing profile. The security model may be applied to
 * the serial port connection is defined in the implementing profile. The
 * security model may be applied on the invocation of the
 * {@code Connector.open()} method with a valid serial port connection string.
 * Should the application not be granted access to the serial port through the
 * profile authorization scheme, a {@code java.lang.SecurityException} will be
 * thrown from the {@code Connector.open()} method. The security model MAY also
 * be applied during execution, specifically when the methods
 * {@code openInputStream()}, {@code openDataInputStream()},
 * {@code openOutputStream()}, and {@code openDataOutputStream()} are invoked.
 * 
 * <h2>Examples</h2>
 * 
 * <p>
 * The following examples shows how a {@code CommConnection} would be used to
 * access a simple loopback program.
 * 
 * <pre>
 * CommConnection cc = (CommConnection) Connector.open("comm:com0;baudrate=19200");
 * int baudrate = cc.getBaudRate();
 * InputStream is = cc.openInputStream();
 * OutputStream os = cc.openOutputStream();
 * int ch = 0;
 * while (ch != 'Z') {
 *     os.write(ch);
 *     ch = is.read();
 *     ch++;
 * }
 * is.close();
 * os.close();
 * cc.close();
 * </pre>
 * 
 * <p>
 * The following example shows how a {@code CommConnection} would be used to
 * discover available comm ports.
 * 
 * <pre>
 * String port1;
 * String port2 = System.getProperty("microedition.commports");
 * int comma = ports.indexOf(',');
 * if (comma > 0) {
 *     // Parse the first port from the available ports list.
 *     port1 = ports.substring(0, comma);
 * } else {
 *     // Only one serial port available.
 *     port1 = ports;
 * }
 * </pre>
 * 
 * <h2>Recommended Port Naming Convention</h2>
 * 
 * <p>
 * Logical port names can be defined to match platform naming conventions using
 * any combination of alphanumeric characters. However, it is recommended that
 * ports be named consistently among the implementations of this class according
 * to a proposed convention. VM implementations should following convention:
 * 
 * <p>
 * Port names contain a text abbreviation indicating ports capabilities followed
 * by a sequential number for the port. The following device name types should
 * be used:
 * 
 * <ul>
 * <li>COM#, where COM is for RS-232 ports and # is a number assigned to the
 * port
 * <li>IR#, where IR is for IrDA IRCOMM ports and # is a number assigned to the
 * port
 * </ul>
 * 
 * <p>
 * This naming scheme allows API users to generally determine the type of port
 * that they would like to use. For instance, if a application desires to "beam"
 * a piece of data, the app could look for "IR#" ports for opening the
 * connection. The alternative is a trial and error approach with all available
 * ports.
 * 
 * @since MIDP 2.0
 */
public interface CommConnection extends StreamConnection {
    /**
     * Gets the baudrate for the serial port connection.
     * 
     * @return the baudrate of the connection
     * @see #setBaudRate(int)
     */
    public int getBaudRate();

    /**
     * Sets the baudrate for the serial port connection. If the requested
     * {@code baudrate} is not supported on the platform, then the system MAY use an
     * alternate valid setting. The alternate value can be accessed using the
     * {@code getBaudRate} method.
     * 
     * @param baudrate the baudrate for the connection
     * @return the previous baudrate of the connection
     * @see #getBaudRate()
     */
    public int setBaudRate(int baudrate);
}