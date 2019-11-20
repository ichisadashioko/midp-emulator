package javax.microedition.lcdui;

/**
 * An object class that has the capability of being placed on the display. A
 * {@code Displayable} object may have a title, a ticker, zero or more commands and a
 * listener associated with it. The contents displayed and their interaction
 * with the user are defined by subclasses.
 *
 * The title string may contain line breaks. The display of the title string
 * must break accordingly. For example, if only a single line is available for a
 * title and the string contains a line break then only the characters up the
 * line break are displayed.
 * 
 * Unless otherwise specified by a subclass, the default state of newly created
 * {@code Displayable} objects is as follows:
 */
public abstract class Displayable {

    /**
     * Gets the title of the {@code Displayable}. Returns {@code null} if there is
     * no title.
     * 
     * @return the title of the instance, or {@code null} if no title
     */
    public abstract String getTitle();

    /**
     * Sets the title of the {@code Displayable}. If {@code null} is given, removes the title.
     * 
     * If the {@code Displayable} is actually visible on the display, the implementation
     * should update the display as soon as it is feasible to do so.
     * 
     * The existence of a title may affect the size of the area for {@code Displayable}
     * content. Addition, removal, or the setting of the title text at runtime may
     * dynamically change the size of the content area. This is most important to be
     * aware of when using the {@code Canvas} class. If the available area does change,
     * the application will be notified via a call to `sizeChanged()`.
     * 
     * @param s the new title, or {@code null} for no title
     */
    public abstract void setTitle(String s);

    /**
     * Add a command to the {@code Displayable}.
     * 
     * @param cmd
     */
    public abstract void addCommand(Command cmd);

    /**
     * Gets the height in pixels
     * 
     * @return
     */
    public abstract int getHeight();
}
