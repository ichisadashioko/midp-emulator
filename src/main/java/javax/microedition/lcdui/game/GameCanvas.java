package javax.microedition.lcdui.game;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public abstract class GameCanvas extends Canvas {
    public static final int UP_PRESSED = 1 << Canvas.UP;
    public static final int DOWN_PRESSED = 1 << Canvas.DOWN;
    public static final int LEFT_PRESSED = 1 << Canvas.LEFT;
    public static final int RIGHT_PRESSED = 1 << Canvas.RIGHT;
    public static final int FIRE_PRESSED = 1 << Canvas.FIRE;
    public static final int GAME_A_PRESSED = 1 << Canvas.GAME_A;
    public static final int GAME_B_PRESSED = 1 << Canvas.GAME_B;
    public static final int GAME_C_PRESSED = 1 << Canvas.GAME_C;
    public static final int GAME_D_PRESSED = 1 << Canvas.GAME_D;

    protected GameCanvas(boolean suppressKeyEvents) {
        throw new UnsupportedOperationException();
    }

    public void flushGraphics() {
        throw new UnsupportedOperationException();
    }

    public void flushGraphics(int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }

    protected Graphics getGraphics() {
        throw new UnsupportedOperationException();
    }

    public int getKeyStates() {
        throw new UnsupportedOperationException();
    }

    public void paint(Graphics g) {
        throw new UnsupportedOperationException();
    }
}