package javax.microedition.rms;

public interface RecordEnumeration {
    public void destroy();

    public boolean hasNextElement();

    public boolean hasPreviousElement();

    public boolean isKeptUpdated();

    public void keepUpdated(boolean keepUpdated);

    public byte[] nextRecord();

    public int nextRecordId();

    public int numRecords();

    public byte[] previousRecord();

    public int previousRecordId();

    public void rebuild();

    public void reset();
}
