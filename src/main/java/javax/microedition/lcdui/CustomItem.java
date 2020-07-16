package javax.microedition.lcdui;

public abstract class CustomItem extends Item {
    protected static final int TRAVERSE_HORIZONTAL = 1;
    protected static final int TRAVERSE_VERTICAL = 2;
    protected static final int KEY_PRESS = 4;
    protected static final int KEY_RELEASE = 8;
    protected static final int KEY_REPEAT = 0x10;
    protected static final int POINTER_PRESS = 0x20;
    protected static final int POINTER_RELEASE = 0x40;
    protected static final int POINTER_DRAG = 0x80;
    protected static final int NONE = 0;

    protected CustomItem(String label) {
        throw new UnsupportedOperationException();
    }

    public int getGameAction(int keyCode) {
        throw new UnsupportedOperationException();
    }

    protected int getInteractionModes() {
        throw new UnsupportedOperationException();
    }

    protected abstract int getMinContentHeight();

    protected abstract int getMinContentWidth();

    protected abstract int getPrefContentHeight(int width);

    protected abstract int getPrefContentWidth(int height);

    protected void hideNotify() {
        throw new UnsupportedOperationException();
    }

    protected void invalidate() {
        throw new UnsupportedOperationException();
    }

    protected void keyPressed(int keyCode) {
        throw new UnsupportedOperationException();
    }

    protected void keyReleased(int keyCode) {
        throw new UnsupportedOperationException();
    }

    protected abstract void paint(Graphics g, int w, int h);

    protected void pointerDragged(int x, int y) {
        throw new UnsupportedOperationException();
    }

    protected void pointerReleased(int x, int y) {
        throw new UnsupportedOperationException();
    }

    protected void repaint() {
        throw new UnsupportedOperationException();
    }

    protected void repaint(int x, int y, int w, int h) {
        throw new UnsupportedOperationException();
    }

    protected void showNotify() {
        throw new UnsupportedOperationException();
    }

    protected void sizeChanged(int w, int h) {
        throw new UnsupportedOperationException();
    }

    protected boolean traverse(int dir, int viewportWidth, int viewportHeight, int[] visRect_inout) {
        throw new UnsupportedOperationException();
    }

    protected void traverseOut() {
        throw new UnsupportedOperationException();
    }
}
