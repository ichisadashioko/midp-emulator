package javax.microedition.lcdui;

/**
 * <p>
 * An object class that has the capability of being placed on the display. A
 * {@code Displayable} object may have a title, a ticker, zero or more commands
 * and a listener associated with it. The contents displayed and their
 * interaction with the user are defined by subclasses.
 *
 * <p>
 * The title string may contain <a href=
 * "https://docs.oracle.com/javame/config/cldc/ref-impl/midp2.0/jsr118/javax/microedition/lcdui/Form.html#linebreak">line
 * breaks</a>. The display of the title string must break accordingly. For
 * example, if only a single line is available for a title and the string
 * contains a line break then only the characters up the line break are
 * displayed.
 * 
 * <p>
 * Unless otherwise specified by a subclass, the default state of newly created
 * {@code Displayable} objects is as follows:
 * 
 * <ul>
 * <li>it is not visible on the {@code Display}
 * <li>there is no {@code Ticker} associated with this {@code Displayable};
 * <li>the title is {@code null}
 * <li>there are no {@code Command}s present; and
 * <li>there is no {@code CommandListener} present.
 * </ul>
 * 
 * @since MIDP 1.0
 */
public abstract class Displayable {

    /**
     * Gets the title of the {@code Displayable}. Returns {@code null} if there is
     * no title.
     * 
     * @return the title of the instance, or {@code null} if no title
     * @since MIDP 2.0
     */
    public String getTitle() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Sets the title of the {@code Displayable}. If {@code null} is given, removes
     * the title.
     * 
     * <p>
     * If the {@code Displayable} is actually visible on the display, the
     * implementation should update the display as soon as it is feasible to do so.
     * 
     * <p>
     * The existence of a title may affect the size of the area for
     * {@code Displayable} content. Addition, removal, or the setting of the title
     * text at runtime may dynamically change the size of the content area. This is
     * most important to be aware of when using the {@code Canvas} class. If the
     * available area does change, the application will be notified via a call to
     * {@code sizeChanged()}.
     * 
     * @param s the new title, or {@code null} for no title
     */
    public void setTitle(String s) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the ticker used by this {@code Displayable}.
     * 
     * @return ticker object used, or {@code null} if no ticker is present
     * @since MIDP 2.0
     */
    public Ticker getTicker() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Sets a ticker for use with this {@code Displayable}, replacing any previous
     * ticker. If {@code null}, removes the ticker object from this
     * {@code Displayable}. The same ticker may be shared y several
     * {@code Displayable} objects within an application. This is done by calling
     * {@code setTicker()} with the same {@code Ticker} object on several different
     * {@code Displayable} objects. If the {@code Displayable} object is actually
     * visible on the display, the implementation should update the display as soon
     * as it is feasible to do so.
     * 
     * <p>
     * The existence of a ticker may affect the size of the area available for
     * {@code Displayable}'s contents. Addition, removal, or the setting of the
     * ticker at runtime may dynamically change the size of the content area. This
     * is most important to be aware of when using the {@code Canvas} class. If the
     * available area does change, the application will be notified via a call to
     * {@code sizeChanged()}.
     * 
     * @param ticker the ticker object used on this screen
     * @since MIDP 2.0
     */
    public void setTicker(Ticker ticker) {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks if the {@code Displayable} is actually visible on the display. In
     * order for a {@code Displayable} to be visible, all of the following must be
     * {@code true}: the {@code Display}'s {@code MIDlet} must be running in the
     * foreground, the {@code Displayable} must be the {@code Display}'s current
     * screen, and the {@code Displayable} must not be obscured by <a href=
     * "https://docs.oracle.com/javame/config/cldc/ref-impl/midp2.0/jsr118/javax/microedition/lcdui/Display.html#systemscreens">system
     * screen</a>.
     * 
     * @return {@code true} if the {@code Displayable} is currently visible
     */
    public boolean isShown() {
        throw new UnsupportedOperationException();
    }

    /**
     * Add a command to the {@code Displayable}. The implementation may choose, for
     * example, to add the command to any fo the available soft buttons or place it
     * in a menu. If the added command is already in the screen (tested by comparing
     * the object references), the method has no effect. If the {@code Displayable}
     * is actually visible on the display, and this call affects the set of visible
     * commands, the implementation should update the display as soon as it is
     * feasible to do so.
     * 
     * @param cmd the command to be added
     * @throws NullPointerException if {@code cmd} is {@code null}
     */
    public void addCommand(Command cmd) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes a command from the {@code Displayable}. If the command is not in the
     * {@code Displayable} (tested by comparing the object references), the method
     * has no effect. If the {@code Displayable} is actually visible on the display,
     * and this call affects the set of visible commands, the implementation should
     * update the display as soon as it is feasible to do so. If {@code cmd} is
     * {@code null}, this method does nothing.
     * 
     * @param cmd the command to be removed
     */
    public void removeCommand(Command cmd) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets a listener for {@code Command}s to this {@code Displayable}, replacing
     * any previous {@code CommandListener}. A {@code null} reference is allowed and
     * has the effect of removing any existing listener.
     * 
     * @param l the new listener, or {@code null}
     */
    public void setCommandListener(CommandListener l) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the width in pixels of the displayable area available to the
     * application. The value returned is appropriate for the particular
     * {@code Displayable} subclass. This value may depend on how the device uses
     * the display and may be affected by the presence of a title, a ticker, or
     * commands. This method returns the proper result at all times, even if the
     * {@code Displayable} object has not yet been shown.
     * 
     * @return width of the area available to the application
     * @since MIDP 2.0
     */
    public int getWidth() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the height in pixels of the displayable area available to the
     * application. The value returned is appropriate for the particular
     * {@code Displayable} subclass. This value may depend on how the device uses
     * the display and may be affected by the presence of a title, a ticker, or
     * commands. This method returns the proper result at all times, even if the
     * {@code Displayable} object has not yet been shown.
     * 
     * @return height of the area available to the application
     * @since MIDP 2.0
     */
    public int getHeight() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * The implementation calls this method when the available area of the
     * {@code Displayable} has been changed. The "available area" is the area of the
     * display that may be occupied by a title, a ticker, command labels, scroll
     * bars, system status area, etc. A size change can occur as a result of the
     * addition, removal, or changed contents of any of these display features.
     * 
     * <p>
     * This method is called at least once before the {@code Displayable} is shown
     * for the first time. If the size of a {@code Displayable} changes while it is
     * visible, {@code sizeChanged} will be called. If the size of a
     * {@code Displayable} changes while it is <i>not</i> visible, calls to
     * {@code sizeChanged} may be deferred. If the size had changed while the
     * {@code Displayable} was not visible, {@code sizeChanged} will be called at
     * least once at the time the {@code Displayable} becomes visible once again.
     * 
     * <p>
     * The default implementation of this method in {@code Displayable} and its
     * subclasses defined in this specification must be empty. This method is
     * intended solely for being overridden by the application. This method is
     * defined on {@code Displayable} even though applications are prohibited from
     * creating direct subclasses of {@code Displayable}. It is defined here so that
     * applications can override it in subclasses of {@code Canvas} and
     * {@code Form}. This is useful for {@code Canvas} subclasses to tailor their
     * graphics and for {@code Form}s to modify {@code Item} sizes and layout
     * directives in order to fit their contents within the available display area.
     * 
     * @param w the new width in pixels of the available area
     * @param h the new height in pixels of the available area
     * @since MIDP 2.0
     */
    protected void sizeChanged(int w, int h) {
        throw new UnsupportedOperationException();
    }
}
