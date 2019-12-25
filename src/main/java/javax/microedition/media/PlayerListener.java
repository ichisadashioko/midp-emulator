package javax.microedition.media;

public interface PlayerListener {
    public static final String STARTED = "started";
    public static final String STOPPED = "stopped";
    public static final String END_OF_MEDIA = "endOfMedia";
    public static final String DURATION_UPDATED = "durationUpdated";
    public static final String DEVICE_UNAVAILABLE = "deviceUnavailable";
    public static final String DEVICE_AVAILABLE = "deviceAvailable";
    public static final String VOLUME_CHANGED = "volumeChanged";
    public static final String ERROR = "error";
    public static final String CLOSED = "closed";

    public void playerUpdate(Player player, String event, Object eventData);
}