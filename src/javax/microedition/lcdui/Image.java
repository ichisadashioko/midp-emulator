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
 * <h3>Alpha Processing</h3>
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
 * 
 * <h3>PNG Image Format</h3>
 * 
 * <p>
 * Implementations are required to support images stored in the PNG format, as
 * specified by the <i>PNG (Portable Network Graphics) Specification, Version
 * 1.0</i>. All conforming MIDP implementations are also conformant to the
 * minimum set of requirements given by the <i>PNG Specification</i>. MIDP
 * implementations also must conform to additional requirements given here with
 * respect to handling of PNG images. Note that the requirements listed here
 * take precedence over any conflicting recommendations given in the <i>PNG
 * Specification</i>.
 * </p>
 * 
 * <h4>Critical Chunks</h4>
 * 
 * <p>
 * All of the 'critical' chunks specified by PNG must be supported. The
 * paragraphs below describe these critical chunks.
 * </p>
 * 
 * <p>
 * The IHDR chunk. MIDP devices must handle the following values in the IHDR
 * chunk:
 * </p>
 * 
 * <ul>
 * <li>All positive values of width and height are supported; however, a very
 * large image may not be readable because of memory constraints. The dimensions
 * of the resulting {@code Image} object must match the dimemsions of the PNG
 * image. That is, the values returned by {@code getWidth()} and
 * {@code getHeight()} and the rendered width and height must equal the width
 * and height specified in the IHDR chunk.</li>
 * 
 * <li>All color types are supported, althought the appearance of the image will
 * be dependent on the capabilities of the device's screen. Color types that
 * include alpha channel data are supported.</li>
 * 
 * <li>For color types {@code 4} & {@code 6} (grayscale with alpha and RGB width
 * alpha, respectively) the alpha channel must be decoded. Any pixels with an
 * alpha value of zero must be treated as transparent. Any pixels with an alpha
 * value of {@code 255} (for images with {@code 8} bits per sample) or
 * {@code 65535} (for images with {@code 16} bits per sample) must be treated as
 * opaque. If rendering with alpha blending is supported, any pixels with
 * intermediate alpha values must be carried through to the resulting image. If
 * alpha blending is not supported, any pixels with intermediate alpha values
 * must be replaced with fully transparent pixels.</li>
 * 
 * <li>All bit depth values for the given color type are supported.</li>
 * <li>Compression method {@code 0} (deflate) is the only supported compression
 * method. This method utilizes the "zlib" compression scheme, which is also
 * used for jar files; thus, the decompression (inflate) code may be shared
 * between the jar decoding and PNG decoding implementations. As noted in the
 * PNG specification, the compressed data stream may comprised internally of
 * both compressed and uncompressed (raw) data.</li>
 * 
 * <li>The filter method represents a series of encoding schemes that may be
 * used to optimize compression. The PNG spec currently defines a single method
 * (method {@code 0}) that is an adaptive filtering scheme with five basic
 * filter types. Filtering is essential for optimal compression since it allows
 * the deflate algorithm to exploit spatial similarities within the image.
 * Therefore, MIDP devices must support all five filter types defined by filter
 * method {@code 0}.</li>
 * 
 * <li>MIDP devices are required to read PNG images that are encoded with either
 * interlace method {@code 0} (None) or interlace method {@code 1} (Adam7).
 * Image loading in MIDP is synchronous and cannot be overlapped with image
 * rendering, and so there is no advantage for an application to use interlace
 * method {@code 1}. Support for decoding interlace images is required for
 * compatibility with PNG and for the convenience of developers who may already
 * have interlaced images available.</li>
 * </ul>
 * 
 * <p>
 * The PLTE chunk. Palatte-based images must be supported.
 * </p>
 * 
 * <p>
 * The IDAT chunk. Image data may be encoded using any of the {@code 5} filter
 * types defined by filter method {@code 0} (None, Sub, Up, Average, Paeth).
 * </p>
 * 
 * <p>
 * The IEND chunk. this chunk must be found in order for the image to be
 * considered valid.
 * </p>
 * 
 * <h4>Ancillary Chunks</h4>
 * 
 * <p>
 * PNG defines several 'ancillary' chunks that may be present in a PNG image but
 * are not critical for image decoding.
 * </p>
 * 
 * <p>
 * The tRNS chunk. All implementations must support the tRNS chunk. This chunk
 * is used to implement transparency without providing alpha channel data for
 * each pixel. For color types {@code 0} and {@code 2}, a particular gray or RGB
 * value is defined to be a transparent pixel. In this case, the implementation
 * must treat pixels with this value as fully transparent. Pixel value
 * comparison must be based on the actual pixel values using the original sample
 * depth; that is, this alpha values are potentially provided for each entry in
 * the color palette. In this case, the implementation must treat pixels with an
 * alpha value of {@code 0} as fully transparent, and it must treat pixels with
 * an alpha value of {@code 255} as fully opaque. If rendering with alpha
 * blending is supported, any pixels with intermediate alpha values must be
 * carried through to the resulting image. If alpha blending is not supported,
 * any pixels with intermediate alpha values must be replaced with fully
 * transparent pixels.
 * </p>
 * 
 * <p>
 * The implementation <i>may</i> (but is not required to) support any of the
 * other ancillary chunks. The implementation <i>must</i> silently ignore any
 * unsupported ancillary chunks that it encounters. The currently defined
 * optional ancillary chunks are:
 * </p>
 * 
 * <pre>
 * cHRM gAMA hIST iCCP iTXt pHYs
 * sBIT sPLT sRGB tEXt tIME zTXt
 * </pre>
 * 
 * <h3>Reference</h3>
 * 
 * <p>
 * <i>PNG (Portable Network Graphics) Specification, Version 1.0.</i> W3C
 * Recommendation, October 1, 1996. http://www.w3.org/TR/REC-png.html. Also
 * available as RFC 2083, http://www.ietf.org/rfc/rfc2083.txt.
 * </p>
 * 
 * <dl>
 * <dt><b>Since:</b></dt>
 * <dd>MIDP 1.0</dd>
 * </dl>
 */
public class Image {

}