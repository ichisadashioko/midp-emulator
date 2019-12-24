package javax.microedition.lcdui;

public class Command {
    public static final int SCREEN = 1;
    public static final int BACK = 2;
    public static final int CANCEL = 3;
    public static final int OK = 4;
    public static final int STOP = 6;
    public static final int EXIT = 7;
    public static final int ITEM = 7;

    public Command(String label, int commandType, int priority) {
        throw new UnsupportedOperationException();
    }

    public Command(String shortLabel, String longLabel, int commandType, int priority) {
        throw new UnsupportedOperationException();
    }

    public int getCommandType() {
        throw new UnsupportedOperationException();
    }

    public String getLabel() {
        throw new UnsupportedOperationException();
    }

    public String getLongLabel() {
        throw new UnsupportedOperationException();
    }

    public int getPriority() {
        throw new UnsupportedOperationException();
    }
}