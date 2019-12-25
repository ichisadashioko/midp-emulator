package javax.microedition.media;

public interface Player extends Controllable {
    public static final int UNREALIZED = 100;
    public static final int REALIZED = 200;
    public static final int PREFETCHED = 300;
    public static final int STARTED = 400;
    public static final int CLOSED = 0;
    public static final int TIME_UNKNOWN = -1;

    public void addPlayerListener(PlayerListener playerListener);

    public void close();

    public void deallocate();

    public String getContentType();

    public long getDuration();

    public long getMediaTime();

    public int getState();

    public void prefetch();

    public void realize();

    public void removePlayerListener(PlayerListener playerListener);

    public void setLoopCount(int count);

    public long setMediaTime(long now);

    public void start();

    public void stop();
}