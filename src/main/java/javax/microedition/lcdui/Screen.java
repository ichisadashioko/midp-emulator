package javax.microedition.lcdui;

/**
 * <p>
 * The common superclass of all high-level user interface classes. The contents
 * displayed and their interaction with the user are defined by subclasses.
 * 
 * <p>
 * Using subclass-defined methods, the application may change the contents of a
 * {@code Screen} object while it is shown to the user. If this occurs, and the
 * {@code Screen} object is visible, the display will be updated automatically.
 * That is, the implementation will refresh the display in a timely fashion
 * without waiting for any further action by the application. For example,
 * suppose a {@code List} object is currently displayed, and every element of
 * the {@code List} is visible. If the applicaiton inserts a new element at the
 * beginning of the {@code List}, it is displayed immediately, and the other
 * elements will be rearranged appropriately. There is no need for the
 * application to call another method to refresh the display.
 * 
 * <p>
 * It is recommended that applications change the contents of a {@code Screen}
 * only while it is not visible (that is, while another {@code Displayable} is
 * current). Changing the contents of a {@code Screen} while it is visible may
 * result in performance problems on some devices, and it may also be confusing
 * if the {@code Screen}'s contents changes while the user is interacting with
 * it.
 * 
 * <p>
 * In MIDP 2.0 the four {@code Screen} methods that defined read/write ticker
 * and title properties were moded to {@code Displayable}, {@code Screen}'s
 * superclass. The semantics of these methods have not changed.
 * 
 * @since MIDP 1.0
 */
public abstract class Screen extends Displayable {

}
