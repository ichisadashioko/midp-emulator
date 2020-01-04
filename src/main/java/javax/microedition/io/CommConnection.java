package javax.microedition.io;

/**
 * <P>This interface defines a logical serial port connection. A "logical" serial port is defined as a logical connection through which bytes are transferring serially. The logical serial port is defined within the underlying operating system and may not necessarily correspond to a physical RS-232 serial port. For instance, IrDA IRCOMM ports can commonly be configured as a logical serial port within the operating system so that it 
 */
public interface CommConnection extends StreamConnection {
    
}