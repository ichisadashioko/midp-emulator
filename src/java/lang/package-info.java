/**
 * <p>
 * MID Profile Lanaguage Classes included from Java 2 Standard Edition. In
 * addtion to the {@code java.lang} classes specified in the Connected Limited
 * Device Configuration the Mobile Information Device Profile includes the
 * following class from Java 2 Standard Edition.
 * 
 * <ul>
 * <li>{@code java.lang.IllegalStateException}
 * </ul>
 * 
 * <p>
 * {@code IllegalStateException}s are thrown when illegal transitions are
 * requested, such as scheduling a {@code TimerTask} or in the containment of
 * user interface components.
 * 
 * <h2>System Functions</h2>
 * 
 * <p>
 * The MIDP is based on the Connected, Limited Device Configuration (CLDC). Some
 * features of the CLDC are modified or extended by the MIDP.
 * 
 * <h2>System Properties</h2>
 * 
 * <p>
 * The MIDP defines the following property values (in addition to those defined
 * in the CLDC specification) that MUST be made available to the application
 * using {@code java.lang.System.getProperty}:
 * 
 * <h3>System Properties Defined by MIDP</h3>
 * 
 * <table>
 * <thead>
 * <th>System Property</th>
 * <th>Description</th> </thead> <tbody>
 * <tr>
 * <td>{@code microedition.local}</td>
 * <td>The current locale of the device, may be {@code null}</td>
 * </tr>
 * <tr>
 * <td>{@code microedition.profiles}</td>
 * <td>is a blank (Unicode U+0020) seprated list of the J2ME profiles that this
 * device supports. For MIDP 2.0 devices, this property MUST contain at least
 * "MIDP-2.0</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * <p>
 * Other properties may be available from other profiles or the implementation.
 * 
 * <p>
 * <i>Property microedition.locale</i>
 * <p>
 * The local property, if not {@code null}, MUST consist of the language and MAY
 * optionally also contain the country code, and variant separated by "-"
 * (Unicode U+002D). For example, "fr-FR" or "en-US". (Note: the MIDP 1.0
 * specification used the HTTP formatting of language tags as defined in
 * <a href="http://www.ietf.org/rfc/rfc3066.txt">RFC3066</a> <i>Tags for the
 * Identification of Languages</i>. This is different from the J2SE definition
 * for {@code Locale} printed strings where fields are separated by "_" (Unicode
 * U+005F))
 * 
 * <p>
 * The language codes MUST be lower-case, two-letter codes as defined by
 * <a href=
 * "http://www.ics.uci.edu/pub/ietf/http/related/iso639.txt">ISO-639</a>.
 * 
 * <p>
 * The country code MUST be the upper-case, two-letter codes as defined by
 * <a href=
 * "http://www.chemie.fu-berlin.de/diverse/doc/ISO_3166.html">ISO-3166</a>.
 * 
 * <h2>Application Resource Files</h2>
 * 
 * <p>
 * Application resource files are accessed using
 * {@code getResourceAsStream(String name)} in {@code java.lang.Class}. In the
 * MIDP specification, {@code getResourceAsStream} is used to allow resource
 * files to be retrieved from the MIDlet Suite's JAR file.
 * 
 * <p>
 * Resource names refer to the contents of the MIDlet Suite JAR file. Absolute
 * pathnames, beginning with "/" are fully qualified file names within the jar
 * file.
 * 
 * <p>
 * Relative pathnames, not beginning with "/" are relative to the class upon
 * which {@code getResourceAsStream} is called. Relative names are converted to
 * absolute by prepending a "/" following by the fully qualified package with
 * "." characters converted to "/" and a separator of "/". The resulting string
 * is reduced to canonical form by applying as many times as possible the
 * following:
 * 
 * <ul>
 * <li>All occurences of "/./" are replaced with "/".
 * <li>All occurences of "/segment/../" are replaced with "/" where segment does
 * not contain "/".
 * </ul>
 * 
 * <p>
 * The canonical resource name is the absolute pathname of the resource within
 * the JAR.
 * 
 * <p>
 * In no case can the path extend outside the JAR file, and resources outside
 * the JAR file MUST NOT be accessible. For example, using "../../" does NOT
 * point outside the JAR file. If there are any remaining "." or ".." characters
 * they are treated literally in locating the resource. No resource can exist
 * with that name so {@code null} is returned from
 * {@code Class.getResourceAsStream}. Also, devices MUST NOT allow classfiles to
 * be read from the JAR file as resources, but all other files MUST be
 * accessible.
 * 
 * <h2>System.exit</h2>
 * 
 * <p>
 * The behavior of {@code java.lang.System.exit} MUST throw a
 * {@code java.lang.SecurityException} when invoked by a MIDlet. The only way a
 * MIDlet can indicate that it is complete is by calling
 * {@code MIDlet.notifyDestroyed}.
 * 
 * <h2>Runtime.exit</h2>
 * 
 * <p>
 * The behavior of {@code java.lang.Runtime.exit} MUST throw a
 * {@code java.lang.SecurityException} when invoked by a MIDlet. The only way a
 * MIDlet can indicate that it is complete is by calling
 * {@code MIDlet.notifyDestroyed}.
 * 
 * @since MIDP 1.0
 */
package java.lang;