package javax.microedition.rms;

public interface RecordFilter {
    public boolean matches(byte[] candiate);
}
