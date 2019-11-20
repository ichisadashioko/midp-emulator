package javax.microedition.lcdui;

/**
 * <p>
 * The {@code Image} class is used to hold graphical image data. {@code Image}
 * objects exist independently of the display device. They exist only in
 * off-screen memory and will not be painted on the display unless an explicit
 * command is issued by the application (such as within the {@code paint()}
 * method of a {@code Canvas}) or when an {@code Image} object is placed within
 * a {@code Form} screen or an {@code Alert} screen and the screen is made
 * current.
 * </p>
 * 
 * <p>
 * Images are either <i>mutable</i> or <i>immutable</i> depending upon how they
 * are created. Immutable images are generally created by loading image data
 * from resource bundles, from files, or from the network. They may not be
 * modified once created. Mutable images are created as blank images containing
 * only while pixels. The application may render on a mutable image by calling
 * {@code getGraphics()} on the {@code Image} to obtain a {@code Graphics}
 * object expressly for this purpose.
 * </p>
 * 
 * <p>
 * {@code Image}s may be placed within {@code Alert}, {@code Choice},
 * {@code Form}, or {@code ImageItem} objects. The high-level user interface
 * implementation may need to update the display at any time, without notifying
 * the application. In order to provide predictable behavior, the high-level
 * user interface objects provide snapshot semantics for the image. That is,
 * when a mutable image is placed within an {@code Alert}, {@code Choice},
 * {@code Form}, or {@code ImageItem} object, the effect is as if a snapshot is
 * taken of its current contents. This snapshot is then used for all subsequent
 * painting of the high-level user interface component. If the application
 * modifies the contents of the image, the application must update the component
 * containing the image (for example, by calling {@code ImageItem.setImage}) in
 * order to make the modified contents visible.
 * </p>
 * 
 * <p>
 * An immutable image may be created from a mutable image through the use of the
 * {@code createImage} method. It is possible to create a mutable copy of an
 * immutable image using a technique similar to the following:
 * </p>
 * 
 * <pre>
 * Image source; // the image to be copied
 * source = Image.createImage(...);
 * Image copy = Image.createImage(source.getWidth(), source.getHeight());
 * Graphics g = copy.getGraphics();
 * g.drawImage(source, 0, 0, TOP|LEFT);
 * </pre>
 * 
 * <h2>Alpha Processing</h2>
 * 
 * <p>
 * Every pixel within a mutable image is always fully opaque. Immutable images
 * may contain a comination of fully opaque pixels
 * ({@code alpha = 2 ^ bitdepth - 1}), fully transparent pixels
 * ({@code alpha = 0}), and semitransparent pixels
 * ({@code 0 < alpha < 2 ^ bitdepth - 1}), where <i>bitdepth</i> is the number
 * of bits per sample in the source data.
 * </p>
 * 
 * <p>
 * Implementations must support storage, processing, and rendering of fully
 * opaque pixels and fully transparent pixels in immutable images. When creating
 * an image from source data (whether from a PNG file or from an array of ARGB
 * data), a fully opaque pixel in the source data must always result in a fully
 * opaque pixel in the new image, and a fully transparent pixel in the source
 * data must always result in a fully transparent pixel in the new image.
 * </p>
 * 
 * <p>
 * The required treatment of semitransparent pixel data depends upon whether the
 * implementation supports alpha blending at rendering time. If the
 * implementation supports alpha bending, a semitransparent pixel in the source
 * data must result in a semitransparent pixel in the new image. The resulting
 * alpha value may be modified to accommodate the number of levels
 * semitransparency supported by the platform. (See the
 * {@code Display.numAlphaLevels()} method.) If an implementation does not
 * support alpha blending, any semitransparent pixels in the source data must be
 * replaced with fully transparent pixels in the new image.
 * </p>
 */
public class Image {

}