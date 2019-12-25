package javax.microedition.rms;

public class RecordStore {
    public static final int AUTHMODE_PRIVATE = 0;
    public static final int AUTHMODE_ANY = 1;

    public int addRecord(byte[] data, int offset, int numBytes) {
        throw new UnsupportedOperationException();
    }

    public void addRecordListener(RecordListener listener) {
        throw new UnsupportedOperationException();
    }

    public void closeRecordStore() {
        throw new UnsupportedOperationException();
    }

    public void deleteRecord(int recordId) {
        throw new UnsupportedOperationException();
    }

    public static void deleteRecordStore(String recordStoreName) {
        throw new UnsupportedOperationException();
    }

    public RecordEnumeration enumerateRecord(RecordFilter filter, RecordComparator comparator, boolean keepUpdated) {
        throw new UnsupportedOperationException();
    }

    public long getLastModified() {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public int getNextRecordId() {
        throw new UnsupportedOperationException();
    }

    public int getNumRecords() {
        throw new UnsupportedOperationException();
    }

    public byte[] getRecord(int recordId) {
        throw new UnsupportedOperationException();
    }

    public int getRecord(int recordId, byte[] buffer, int offset) {
        throw new UnsupportedOperationException();
    }

    public int getRecordSize(int recordId) {
        throw new UnsupportedOperationException();
    }

    public int getSize() {
        throw new UnsupportedOperationException();
    }

    public int getSizeAvailable() {
        throw new UnsupportedOperationException();
    }

    public int getVersion() {
        throw new UnsupportedOperationException();
    }

    public static String[] listRecordStores() {
        throw new UnsupportedOperationException();
    }

    public static RecordStore openRecordStore(String recordStoreName, boolean createIfNecessary) {
        throw new UnsupportedOperationException();
    }

    public static RecordStore openRecordStore(String recordStoreName, String vendorName, String suiteName) {
        throw new UnsupportedOperationException();
    }

    public void removeRecordListener(RecordListener listener) {
        throw new UnsupportedOperationException();
    }

    public void setMode(int authmode, boolean writable) {
        throw new UnsupportedOperationException();
    }

    public void setRecord(int recordId, byte[] newData, int offset, int numBytes) {
        throw new UnsupportedOperationException();
    }
}