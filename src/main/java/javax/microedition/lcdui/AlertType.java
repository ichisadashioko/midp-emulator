package javax.microedition.lcdui;

public class AlertType {
    protected AlertType() {
    }

    public static final AlertType ALARM = new AlertType();
    public static final AlertType CONFIRMATION = new AlertType();
    public static final AlertType ERROR = new AlertType();
    public static final AlertType INFO = new AlertType();
    public static final AlertType WARNING = new AlertType();

    public boolean playSound(Display display) {
        throw new UnsupportedOperationException();
    }
}
