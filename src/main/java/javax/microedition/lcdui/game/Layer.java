package javax.microedition.lcdui.game;

import javax.microedition.lcdui.Graphics;

public abstract class Layer {
    public int getHeight() {
        throw new UnsupportedOperationException();
    }

    public int getWidth() {
        throw new UnsupportedOperationException();
    }

    public int getX() {
        throw new UnsupportedOperationException();
    }

    public int getY() {
        throw new UnsupportedOperationException();
    }

    public boolean isVisible() {
        throw new UnsupportedOperationException();
    }

    public void move(int dx, int dy) {
        throw new UnsupportedOperationException();
    }

    public abstract void paint(Graphics g);

    public void setPosition(int x, int y) {
        throw new UnsupportedOperationException();
    }

    public void setVisible(boolean visible) {
        throw new UnsupportedOperationException();
    }
}