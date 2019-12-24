package javax.microedition.lcdui;

public class Alert extends Screen {
    public static final int FOREVER = -2;
    public static final Command DISMISS_COMMAND = new Command("", Command.OK, 0);

    public Alert(String title) {
        throw new UnsupportedOperationException();
    }

    public Alert(String title, String alertText, Image alertImage, AlertType alertType) {
        throw new UnsupportedOperationException();
    }

    public void addCommand(Command cmd) {
        throw new UnsupportedOperationException();
    }

    public int getDefaultTimeout() {
        throw new UnsupportedOperationException();
    }

    public Image getImage() {
        throw new UnsupportedOperationException();
    }

    public Gauge getIndicator() {
        throw new UnsupportedOperationException();
    }

    public String getString() {
        throw new UnsupportedOperationException();
    }

    public int getTimeout() {
        throw new UnsupportedOperationException();
    }

    public AlertType getType() {
        throw new UnsupportedOperationException();
    }

    public void removeCommand(Command cmd) {
        throw new UnsupportedOperationException();
    }

    public void setCommandListener(CommandListener l) {
        throw new UnsupportedOperationException();
    }

    public void setImage(Image img) {
        throw new UnsupportedOperationException();
    }

    public void setIndicator(Gauge indicator) {
        throw new UnsupportedOperationException();
    }

    public void setString(String str) {
        throw new UnsupportedOperationException();
    }

    public void setTimeout(int time) {
        throw new UnsupportedOperationException();
    }

    public void setType(AlertType type) {
        throw new UnsupportedOperationException();
    }
}