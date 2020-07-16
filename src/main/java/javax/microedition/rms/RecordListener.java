package javax.microedition.rms;

public interface RecordListener {
    public void recordAdded(RecordStore recordStore, int recordId);

    public void recordChanged(RecordStore recordStore, int recordId);

    public void recordDeleted(RecordStore recordStore, int recordId);
}
