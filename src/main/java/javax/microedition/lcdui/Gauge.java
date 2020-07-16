package javax.microedition.lcdui;

public class Gauge extends Item {
    public static final int IDEFINITE = -1;
    public static final int CONTINUOUS_IDLE = 0;
    public static final int INCREMENTAL_IDLE = 1;
    public static final int CONTINUOUS_RUNNING = 2;
    public static final int INCREMENTAL_UPDATING = 3;

    public Gauge(String label, boolean interactive, int maxValue, int initialValue) {
        throw new UnsupportedOperationException();
    }

    public void addCommand(Command cmd) {
        throw new UnsupportedOperationException();
    }

    public int getMaxValue() {
        throw new UnsupportedOperationException();
    }

    public int getValue() {
        throw new UnsupportedOperationException();
    }

    public boolean isInteractive() {
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

    public void setMaxValue(int maxValue) {
        throw new UnsupportedOperationException();
    }

    public void setPreferredSize(int width, int height) {
        throw new UnsupportedOperationException();
    }

    public void setValue(int value) {
        throw new UnsupportedOperationException();
    }
}
