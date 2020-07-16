package javax.microedition.lcdui;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * The {@code Image} class is used to hold graphical image data. {@code Image}
 * objects exist independently of the display device. They exist only in
 * off-screen memory and will not be painted on the display unless an explicit
 * command is issued by the application (such as within the {@code paint()}
 * method of a {@code Canvas}) or when an {@code Image} object is placed within
 * a {@code Form} screen or an {@code Alert} screen and the screen is made
 * current.
 * 
 * <p>
 * Images are either <i>mutable</i> or <i>immutable</i> depending upon how they
 * are created. Immutable images are generally created by loading image data
 * from resource bundles, from files, or from the network. They may not be
 * modified once created. Mutable images are created as blank images containing
 * only while pixels. The application may render on a mutable image by calling
 * {@code getGraphics()} on the {@code Image} to obtain a {@code Graphics}
 * object expressly for this purpose.
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
 * 
 * <p>
 * An immutable image may be created from a mutable image through the use of the
 * {@code createImage} method. It is possible to create a mutable copy of an
 * immutable image using a technique similar to the following:
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
 * may contain a combination of fully opaque pixels
 * ({@code alpha = 2 ^ bitdepth - 1}), fully transparent pixels
 * ({@code alpha = 0}), and semitransparent pixels
 * ({@code 0 < alpha < 2 ^ bitdepth - 1}), where <i>bitdepth</i> is the number
 * of bits per sample in the source data.
 * 
 * <p>
 * Implementations must support storage, processing, and rendering of fully
 * opaque pixels and fully transparent pixels in immutable images. When creating
 * an image from source data (whether from a PNG file or from an array of ARGB
 * data), a fully opaque pixel in the source data must always result in a fully
 * opaque pixel in the new image, and a fully transparent pixel in the source
 * data must always result in a fully transparent pixel in the new image.
 * 
 * <p>
 * The required treatment of semitransparent pixel data depends upon whether the
 * implementation supports alpha blending at rendering time. If the
 * implementation supports alpha bending, a semitransparent pixel in the source
 * data must result in a semitransparent pixel in the new image. The resulting
 * alpha value may be modified to accommodate the number of levels
 * semi-transparency supported by the platform. (See the
 * {@code Display.numAlphaLevels()} method.) If an implementation does not
 * support alpha blending, any semitransparent pixels in the source data must be
 * replaced with fully transparent pixels in the new image.
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
 * 
 * <h4>Critical Chunks</h4>
 * 
 * <p>
 * All of the 'critical' chunks specified by PNG must be supported. The
 * paragraphs below describe these critical chunks.
 * 
 * <p>
 * The IHDR chunk. MIDP devices must handle the following values in the IHDR
 * chunk:
 * 
 * <ul>
 * <li>All positive values of width and height are supported; however, a very
 * large image may not be readable because of memory constraints. The dimensions
 * of the resulting {@code Image} object must match the dimensions of the PNG
 * image. That is, the values returned by {@code getWidth()} and
 * {@code getHeight()} and the rendered width and height must equal the width
 * and height specified in the IHDR chunk.
 * 
 * <li>All color types are supported, although the appearance of the image will
 * be dependent on the capabilities of the device's screen. Color types that
 * include alpha channel data are supported.
 * 
 * <li>For color types {@code 4} & {@code 6} (grayscale with alpha and RGB width
 * alpha, respectively) the alpha channel must be decoded. Any pixels with an
 * alpha value of zero must be treated as transparent. Any pixels with an alpha
 * value of {@code 255} (for images with {@code 8} bits per sample) or
 * {@code 65535} (for images with {@code 16} bits per sample) must be treated as
 * opaque. If rendering with alpha blending is supported, any pixels with
 * intermediate alpha values must be carried through to the resulting image. If
 * alpha blending is not supported, any pixels with intermediate alpha values
 * must be replaced with fully transparent pixels.
 * 
 * <li>All bit depth values for the given color type are supported.
 * <li>Compression method {@code 0} (deflate) is the only supported compression
 * method. This method utilizes the "zlib" compression scheme, which is also
 * used for jar files; thus, the decompression (inflate) code may be shared
 * between the jar decoding and PNG decoding implementations. As noted in the
 * PNG specification, the compressed data stream may comprised internally of
 * both compressed and uncompressed (raw) data.
 * 
 * <li>The filter method represents a series of encoding schemes that may be
 * used to optimize compression. The PNG spec currently defines a single method
 * (method {@code 0}) that is an adaptive filtering scheme with five basic
 * filter types. Filtering is essential for optimal compression since it allows
 * the deflate algorithm to exploit spatial similarities within the image.
 * Therefore, MIDP devices must support all five filter types defined by filter
 * method {@code 0}.
 * 
 * <li>MIDP devices are required to read PNG images that are encoded with either
 * interlace method {@code 0} (None) or interlace method {@code 1} (Adam7).
 * Image loading in MIDP is synchronous and cannot be overlapped with image
 * rendering, and so there is no advantage for an application to use interlace
 * method {@code 1}. Support for decoding interlace images is required for
 * compatibility with PNG and for the convenience of developers who may already
 * have interlaced images available.
 * </ul>
 * 
 * <p>
 * The PLTE chunk. Palette-based images must be supported.
 * 
 * <p>
 * The IDAT chunk. Image data may be encoded using any of the {@code 5} filter
 * types defined by filter method {@code 0} (None, Sub, Up, Average, Paeth).
 * 
 * <p>
 * The IEND chunk. this chunk must be found in order for the image to be
 * considered valid.
 * 
 * <h4>Ancillary Chunks</h4>
 * 
 * <p>
 * PNG defines several 'ancillary' chunks that may be present in a PNG image but
 * are not critical for image decoding.
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
 * 
 * <p>
 * The implementation <i>may</i> (but is not required to) support any of the
 * other ancillary chunks. The implementation <i>must</i> silently ignore any
 * unsupported ancillary chunks that it encounters. The currently defined
 * optional ancillary chunks are:
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
 * 
 * @since MIDP 1.0
 */
public class Image {

    /**
     * Creates a new, mutable image for off-screen drawing. Every pixel within the
     * newly created image is white. The width and height of the image must both be
     * greater than zero.
     * 
     * @param width  the width of the new image, in pixels
     * @param height the height of the new image, in pixels
     * @return the created image
     * @throws IllegalArgumentException if either {@code width} or {@code height} is
     *                                  zero or less
     */
    public static Image createImage(int width, int height) {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Creates an immutable image from a source image. If the source image is
     * mutable, an immutable copy is created and returned. If the source image is
     * immutable, the implementation may simply return it without creating a new
     * image. If an immutable source image contains transparency information, this
     * information is copied to the new image unchanged.
     * 
     * <p>
     * This method is useful for placing the contents of mutable images into
     * {@code Choice} objects. The application can create an off-screen image using
     * the {@code createImage(w, h)} method, draw into it using a {@code Graphics}
     * object obtained with the {@code getGraphics()} method, and then create an
     * immutable copy of it with this method. The immutable copy may then be placed
     * into {@code Choice} objects.
     * 
     * @param source the source image to be copied
     * @return the new, immutable image
     * @throws NullPointerException if {@code source} is {@code null}
     */
    public static Image createImage(Image source) {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates an immutable image from decoded image data obtained from the named
     * resource. The name parameter is a resource name as defined by
     * {@code Class.getResourceAsStream(name)}. The rules for resolving resource
     * names are defined in the Application Resource Files section of the
     * {@code java.lang} package documentation.
     * 
     * @param name the name of the resource containing the image data in one of the
     *             supported image formats
     * @return the created image
     * @throws NullPointerException if {@code name} is {@code null}
     * @throws IOException          if the resource does not exist, the data cannot
     *                              be loaded, or the image data cannot be decoded
     */
    public static Image createImage(String name) throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Creates an immutable image which is decoded from the data stored in the
     * specified byte array at the specified offset and length. The data must be in
     * a self-identifying image file format supported by the implementation, such as
     * PNG.
     * 
     * <p>
     * The {@code imageOffset} and {@code imageLength} parameters specify a range of
     * data within the {@code imageData} byte array. The {@code imageOffset}
     * parameter specifies the offset into the array of the first data byte to be
     * used. It must therefore lie within the range
     * {@code [0..(imageData.length-1)]}. The {@code imageLength} parameter
     * specifies the number of data bytes to be used. It must be a positive integer
     * and it must not cause the range to extend beyond the end of the array. That
     * is, it must be true that
     * {@code imageOffset + imageLength < imageData.length}.
     * 
     * @param imageData   the array of image data in a supported image format
     * @param imageOffset the offset of the start of the data in the array
     * @param imageLength the length of the data in the array
     * @return the created image
     * @throws ArrayIndexOutOfBoundsException if {@code imageOffset} and
     *                                        {@code imageLength} specify an invalid
     *                                        range
     * @throws NullPointerException           if {@code imageData} is {@code null}
     * @throws IllegalArgumentException       if {@code imageData} is incorrectly
     *                                        formatted or otherwise cannot be
     *                                        decoded
     */
    public static Image createImage(byte[] imageData, int imageOffset, int imageLength) {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Creates an immutable image using pixel data from the specified region of a
     * source image, transformed as specified.
     * 
     * <p>
     * The source image may be mutable or immutable. For immutable source images,
     * transparency information, if any, is copied to the new image unchanged.
     * 
     * <p>
     * On some devices, pre-transformed images may render more quickly than images
     * that are transformed on the fly using {@code drawRegion}. However, creating
     * such images does consume additional heap space, so this technique should be
     * applied only to images whose rendering speed is critical.
     * 
     * <p>
     * The transform function used must be one of the following, as defined in the
     * {@link Sprite} class:
     * 
     * <ul>
     * <li>{@code Sprite.TRANS_NONE} - causes the specified image region to be
     * copied unchanged
     * <li>{@code Sprite.TRANS_ROT90} - cause the specified image region to be
     * rotated clockwise by 90 degrees.
     * <li>{@code Sprite.TRANS_ROT180} - cause the specified image region to be
     * rotated clockwise by 180 degrees.
     * <li>{@code Sprite.TRANS_ROT270} - cause the specified image region to be
     * rotated clockwise by 270 degrees.
     * <li>{@code Sprite.TRANS_MIRROR} - cause the specified image region to be
     * reflected about its vertical center.
     * <li>{@code Sprite.TRANS_MIRROR_ROT90} - cause the specified image region to
     * be reflected about its vertical center and then rotated clockwise by 90
     * degrees.
     * <li>{@code Sprite.TRANS_MIRROR_ROT180} - cause the specified image region to
     * be reflected about its vertical center and then rotated clockwise by 180
     * degrees.
     * <li>{@code Sprite.TRANS_MIRROR_ROT270} - cause the specified image region to
     * be reflected about its vertical center and then rotated clockwise by 270
     * degrees.
     * </ul>
     * 
     * <p>
     * The size of the returned image will be the size of the specified region with
     * the transform applied. For example, if the region is {@code 100 x 50} pixels
     * and the transform is {@code TRANS_ROT90}, the returned image will be
     * {@code 50 x 100} pixels.
     * 
     * <p>
     * <b>Note:</b> If all of the following conditions are met, this method may
     * simply return the source {@code Image} without creating a new one:
     * <ul>
     * <li>the source image is immutable;
     * <li>the region represents the entire source image; and
     * <li>the transform is {@code TRANS_NONE}.
     * </ul>
     * 
     * @param image     the source image to be copied from
     * @param x         the horizontal location of the region to be copied
     * @param y         the vertical location of the region to be copied
     * @param width     the width of the region to be copied
     * @param height    the height of the region to be copied
     * @param transform the transform to be applied to the region
     * @return the new, immutable image
     * @throws NullPointerException     if {@code image} is {@code null}
     * @throws IllegalArgumentException if the region to be copied exceeds the
     *                                  bounds of the source image
     * @throws IllegalArgumentException if either {@code width} or {@code height} is
     *                                  zero or less
     * @throws IllegalArgumentException if the {@code transform} is not valid
     * @since MIDP 2.0
     */
    public static Image createImage(Image image, int x, int y, int width, int height, int transform) {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates an immutable image from decoded image data obtained from an
     * {@code InputStream}. This method blocks until all image data has been read
     * and decoded. After this method completes (whether by returning or by throwing
     * an exception) the stream is left open and its current position is undefined.
     * 
     * @param stream the name of the resource containing the image data in one of
     *               the supported image formats
     * @return the created image
     * @throws NullPointerException if {@code stream} is {@code null}
     * @throws IOException          if an I/O error occurs, if the image data cannot
     *                              be loaded, or if the image data cannot be
     *                              decoded
     * @since MIDP 2.0
     */
    public static Image createImage(InputStream stream) throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Creates an immutable image from a sequence of ARGB values, specified as
     * {@code 0xAARRGGBB}. The ARGB data within the {@code rgb} array is arranged
     * horizontally from left to right within each row, row by row from top to
     * bottom. If {@code processAlpha} is {@code true}, the high-order byte
     * specifies opacity; that is, {@code 0x00RRGGBB} specifies a fully transparent
     * pixel and {@code 0xFFRRGGBB} specifies a fully opaque pixel. Intermediate
     * alpha values specify semi-transparency. If the implementation does not
     * support alpha blending for image rendering operations, it must replace any
     * semitransparent pixels with fully transparent pixels. (See Alpha Processing
     * for further discussion.) If {code processAlpha} is {@code false}, the alpha
     * values are ignored and all pixels must be treated as fully opaque.
     * 
     * <p>
     * Consider {@code P(a, b)} to be the value of the pixel located at column
     * {@code a} and row {@code b} of the Image, where rows and columns are numbered
     * downward from the top starting at zero, and columns are numbered rightward
     * from the left starting at zero. This operation can then be defined as:
     * 
     * <pre>
     * P(a, b) = rgb[a + b * width];
     * </pre>
     * 
     * for
     * 
     * <pre>
     * 0 <= a < width
     * 0 <= b < height
     * </pre>
     * 
     * @param rgb          an array of ARGB values that composes the image
     * @param width        the width of the image
     * @param height       the height of the image
     * @param processAlpha {@code true} if {@code rgb} has an alpha channel,
     *                     {@code false} if all pixels are fully opaque
     * @return the created image
     * @throws NullPointerException           if {@code rgb} is {@code null}
     * @throws IllegalArgumentException       if either {@code width} or
     *                                        {@code height} is zero or less
     * @throws ArrayIndexOutOfBoundsException if the length of {@code rgb} is less
     *                                        than {@code width * height}
     * @since MIDP 2.0
     */
    public static Image createRGBImage(int[] rgb, int width, int height, boolean processAlpha) {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Creates a new {@code Graphics} object that renders to this image. This image
     * must be mutable; it is illegal to call this on an immutable image. The
     * mutability of an image may be tested with the {@code isMutable()} method.
     * 
     * <p>
     * The newly created {@code Graphics} object has the following properties
     * 
     * <ul>
     * <li>the destination is this {@code Image} object;
     * <li>the clip region encompasses the entire {@code Image};
     * <li>the current color is black;
     * <li>the font is the same as the font returned by
     * {@code Font.getDefaultFont()};
     * <li>the stroke style is {@code SOLID}; and
     * <li>the origin of the coordinate system is located at the upper-left corner
     * of the {@code Image}.
     * </ul>
     * 
     * <p>
     * The lifetime of {@code Graphics} objects created using this method is
     * indefinite. They may be used at any time, by any thread.
     * 
     * @return a {@code Graphics} object with this image as its destination
     * @throws IllegalStateException if the image is immutable
     */
    public Graphics getGraphics() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the width of the image in pixels. The value returned must reflect the
     * actual with of the image when rendered.
     * 
     * @return width of the image
     */
    public int getWidth() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the height of the image in pixels. The value returned must reflect the
     * actual height of the image when rendered.
     * 
     * @return height of the image
     */
    public int getHeight() {
        throw new UnsupportedOperationException();
    }

    /**
     * Check if this image is mutable. Mutable images can be modified by rendering
     * to them through a {@code Graphics} object obtained from the
     * {@code getGraphics()} method of this object.
     * 
     * @return {@code true} if the image is mutable, {@code false} otherwise
     */
    public boolean isMutable() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Obtains ARGB pixel data from the specified region of this image and stores it
     * in the provided array of integers. Each pixel value is stored in
     * {@code 0xAARRGGBB} format, where the high-order byte contains the alpha
     * channel and the remaining bytes contain color components for red, green and
     * blue, respectively. The alpha channel specifies the opacity of the pixel,
     * where a value of {@code 0x00} represents a pixel that is fully transparent
     * and a value of {@code 0xFF} represents a fully opaque pixel.
     * 
     * <p>
     * The returned values are not guaranteed to be identical to values from the
     * original source, such as from {@code createRGBImage} or from a PNG image.
     * Color values may be re-sampled to reflect the display capabilities of the
     * device (for example, red, green or blue pixels may all be represented by the
     * same gray value on a grayscale device). On devices that do not support alpha
     * blending, the alpha value will be {@code 0xFF} for opaque pixels and
     * {@code 0x00} for all other pixels. On devices that support alpha blending,
     * alpha channel values may be re-sampled to reflect the number of levels of
     * semi-transparency supported.
     * 
     * <p>
     * The {@code scanlength} specifies the relative offset within the array between
     * the corresponding pixels of consecutive rows. In order to prevent rows of
     * stored pixels from overlapping, the absolute value of {@code scanlength} must
     * be greater than or equal to {@code width}. Negative values of
     * {@code scanlength} are allowed. In all cases, this must result in every
     * reference being within the bounds of the {@code rgbData} array.
     * 
     * <p>
     * Consider {@code P(a,b)} to be the value of the pixel located at column
     * {@code a} and row {@code b} of the Image, where rows and columns are numbered
     * downward from the top starting at zero, and columns are numbered rightward
     * from the left starting at zero. This operation can then be defined as:
     * 
     * <pre>
     * rgbData[offset + (a - x) + (b - y) * scanlength] = P(a, b);
     * </pre>
     * 
     * for
     * 
     * <pre>
     * x <= a < x + width
     * y <= b < y + height
     * </pre>
     * 
     * The source rectangle is required to not exceed the bounds of the image. This
     * means:
     * 
     * <pre>
     * x >= 0
     * y >= 0
     * x + width <= image width
     * y + height < image height
     * </pre>
     * 
     * <p>
     * If any of these conditions is not met, an {@code IllegalArgumentException} is
     * thrown. Otherwise, in cases where {@code width <= 0} or {@code height <= 0},
     * no exception is thrown, and no pixel data is copied to {@code rgbData}.
     * 
     * @param rgbData    an array of integers in which the ARGB pixel data is stored
     * @param offset     the index into the array where the first ARGB value is
     *                   stored
     * @param scanlength the relative offset in the array between corresponding
     *                   pixels in consecutive rows of the region
     * @param x          the x-coordinate of the upper left corner of the region
     * @param y          the y-coordinate of the upper left corner of the region
     * @param width      the width of the region
     * @param height     the height of the region
     * @throws ArrayIndexOutOfBoundsException if the requested operation would
     *                                        attempt to access an element in the
     *                                        {@code rgbData} array whose index is
     *                                        either negative or beyond its length
     *                                        (the contents of array are unchanged)
     * @throws IllegalArgumentException       if the area being retrieved exceeds
     *                                        the bounds of the source image
     * @throws IllegalArgumentException       if the absolute value of
     *                                        {@code scanlength} is less than
     *                                        {@code width}
     * @throws NullPointerException           if {@code rgbData} is {@code null}
     * @since MIDP 2.0
     */
    public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }
}
