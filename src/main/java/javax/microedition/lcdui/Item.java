package javax.microedition.lcdui;

/**
 * A superclass for components that can be added to a {@code Form}.
 */
public abstract class Item {
    public static final int LAYOUT_DEFAULT = 0;
    public static final int LAYOUT_LEFT = 1;
    public static final int LAYOUT_RIGHT = 2;
    public static final int LAYOUT_CENTER = 3;
    public static final int LAYOUT_TOP = 0x10;
    public static final int LAYOUT_BOTTOM = 0x20;
    public static final int LAYOUT_VCENTER = 0x30;
    public static final int LAYOUT_NEWLINE_BEFORE = 0x100;
    public static final int LAYOUT_NEWLINE_AFTER = 0x200;
    public static final int LAYOUT_SHRINK = 0x400;
    public static final int LAYOUT_EXPAND = 0x800;
    public static final int LAYOUT_VSHRINK = 0x1000;
    public static final int LAYOUT_VEXPAND = 0x2000;
    public static final int LAYOUT_2 = 0x4000;
    public static final int PLAIN = 0;
    public static final int HYPERLINK = 1;
    public static final int BUTTON = 2;

    public void addCommand(Command cmd) {
        throw new UnsupportedOperationException();
    }

    public String getLabel() {
        throw new UnsupportedOperationException();
    }

    public int getLayout() {
        throw new UnsupportedOperationException();
    }

    public int getMinimumHeight() {
        throw new UnsupportedOperationException();
    }

    public int getMinimumWidth() {
        throw new UnsupportedOperationException();
    }

    public int getPreferredHeight() {
        throw new UnsupportedOperationException();
    }

    public int getPreferredWidth() {
        throw new UnsupportedOperationException();
    }

    public void notifyStateChanged() {
        throw new UnsupportedOperationException();
    }

    public void removeCommand(Command cmd) {
        throw new UnsupportedOperationException();
    }

    public void setDefaultCommand(Command cmd) {
        throw new UnsupportedOperationException();
    }

    public void setItemCommandListener(ItemCommandListener l) {
        throw new UnsupportedOperationException();
    }

    public void setLabel(String label) {
        throw new UnsupportedOperationException();
    }

    public void setLayout(int layout) {
        throw new UnsupportedOperationException();
    }

    public void setPreferredSize(int width, int height) {
        throw new UnsupportedOperationException();
    }
}
