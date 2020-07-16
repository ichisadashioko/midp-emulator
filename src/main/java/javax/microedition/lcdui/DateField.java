package javax.microedition.lcdui;

import java.util.Date;
import java.util.TimeZone;

public class DateField extends Item {
    public static final int DATE = 1;
    public static final int TIME = 2;
    public static final int DATE_TIME = 3;

    public DateField(String label, int mode) {
        throw new UnsupportedOperationException();
    }

    public DateField(String label, int mode, TimeZone timeZone) {
        throw new UnsupportedOperationException();
    }

    public Date getDate() {
        throw new UnsupportedOperationException();
    }

    public int getInputMode() {
        throw new UnsupportedOperationException();
    }

    public void setDate(Date date) {
        throw new UnsupportedOperationException();
    }

    public void setInputMode(int mode) {
        throw new UnsupportedOperationException();
    }
}
