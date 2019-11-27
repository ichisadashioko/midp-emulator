package javax.microedition.io;

/**
 * This interface defines the stream connection over which content is passed.
 * 
 * @since CLDC 1.0
 */
public interface ContentConnection {

    /**
     * Returns the type of the content that the resource connected to is providing. For instance, if
     * the connection is via HTTP, then the value of the {@code content-type} header field is
     * returned.
     * 
     * @return the content type of the resource that the URL references, or {@code null} if not
     *         known.
     */
    public String getType();

    /**
     * Returns a string describing the encoding of the content which the resource connected to is
     * providing. E.g. if the connection is via HTTP, the value of the {@code content-encoding}
     * header field is returned.
     * 
     * @return the content encoding of the resource that the URL references, or {@code null} if not
     *         known.
     */
    public String getEncoding();

    /**
     * Returns the length of the content which is being provided. E.g. if the connection is via
     * HTTP, then the value of the {@code content-length} header field is returned.
     * 
     * @return the content length of the resource that this connection's URL references, or
     *         {@code -1} if the content length is not known.
     */
    public long getLength();
}
