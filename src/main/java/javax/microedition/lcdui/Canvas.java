package javax.microedition.lcdui;

public abstract class Canvas extends Displayable {
    protected Canvas() {
        throw new UnsupportedOperationException();
    }

    public static final int UP = 1;
    public static final int DOWN = 6;
    public static final int LEFT = 2;
    public static final int RIGHT = 5;
    public static final int FIRE = 8;
    public static final int GAME_A = 9;
    public static final int GAME_B = 10;
    public static final int GAME_C = 11;
    public static final int GAME_D = 12;
    public static final int KEY_NUM0 = 48;
    public static final int KEY_NUM1 = 49;
    public static final int KEY_NUM2 = 50;
    public static final int KEY_NUM3 = 51;
    public static final int KEY_NUM4 = 52;
    public static final int KEY_NUM5 = 53;
    public static final int KEY_NUM6 = 54;
    public static final int KEY_NUM7 = 55;
    public static final int KEY_NUM8 = 56;
    public static final int KEY_NUM9 = 57;
    public static final int KEY_STAR = 42;
    public static final int KEY_POUND = 35;

    public int getGameAction(int keyCode) {
        throw new UnsupportedOperationException();
    }

    public int getKeyCode(int gameAction) {
        throw new UnsupportedOperationException();
    }

    public String getKeyName(int keyCode) {
        throw new UnsupportedOperationException();
    }

    public boolean hasPointerEvents() {
        throw new UnsupportedOperationException();
    }

    public boolean hasPointerMotionEvents() {
        throw new UnsupportedOperationException();
    }

    public boolean hasRepeatEvents() {
        throw new UnsupportedOperationException();
    }

    protected void hideNotify() {
        throw new UnsupportedOperationException();
    }

    public boolean isDoubleBuffered() {
        throw new UnsupportedOperationException();
    }

    protected void keyPressed(int keyCode) {
        throw new UnsupportedOperationException();
    }

    protected void keyReleased(int keyCode) {
        throw new UnsupportedOperationException();
    }

    protected void keyRepeated(int keyCode) {
        throw new UnsupportedOperationException();
    }

    protected abstract void paint(Graphics g);

    protected void pointerDragged(int x, int y) {
        throw new UnsupportedOperationException();
    }

    protected void pointerPressed(int x, int y) {
        throw new UnsupportedOperationException();
    }

    protected void pointerReleased(int x, int y) {
        throw new UnsupportedOperationException();
    }

    public void repaint() {
        throw new UnsupportedOperationException();
    }

    public void repaint(int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }

    public void serviceRepaints() {
        throw new UnsupportedOperationException();
    }

    public void setFullScreenMode(boolean mode) {
        throw new UnsupportedOperationException();
    }

    protected void showNotify() {
        throw new UnsupportedOperationException();
    }

    protected void sizeChanged(int w, int h) {
        throw new UnsupportedOperationException();
    }

}
