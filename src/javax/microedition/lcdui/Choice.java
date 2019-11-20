package javax.microedition.lcdui;

/**
 * <p>
 * Choice defines an API for a user interface components implementing selection
 * from predefined number of choices. Such UI components are {@link List} and
 * {@link ChoiceGroup}. The contents of the {@code Choice} are represented with
 * strings and images.
 * </p>
 * 
 * <p>
 * Each element of a {@code Choice} is composed of a text string part, an
 * {@link Image} part, and a font attribute that are all treated as a unit. The
 * font attribute applies to the text part can be controlled by the application.
 * The application may provide {@code null} for the image if the element is not
 * to have an image part. The implementation must display the image at the
 * beginning of the text string. If the {@code Choice} also has a selection
 * indicator (such as a radio button or a checkbox) placed at the beginning of
 * the text string, the element's image should be placed between the selection
 * indicator and the beginning of the text string.
 * </p>
 * 
 * <p>
 * When a new element is inserted or appended, the implementation provides a
 * default font attribute. This default font is the same font that is used if
 * the application calls {@code setFont(i, null)}. All {@code ChoiceGroup}
 * instances must have the same default font, and all {@code List} instances
 * must have the same default font. However, the default font used for
 * {@code Choice} objects may differ from the font returned by
 * {@link Font.getDefaultFont}.
 * </p>
 * 
 * <p>
 * The {@code Image} part of a {@code Choice} element may be mutable or
 * immutable. If the {@code Image} is mutable, the effect is as if snapshot of
 * its contents is taken at the time the {@code Choice} is constructed with this
 * {@code Image} or when the {@code Choice} element is created or modified with
 * the {@link append}, {@link insert}, or {@link set} methods. The snapshot is
 * used whenever the contents of the {@code Choice} element are to be displayed.
 * Even if the application subsequently draws into the {@code Image}, the
 * snapshot is not modified until the next call to one of the above methods. The
 * snapshot is <i>not</i> updated when the {@code Choice} becomes visible on the
 * display. (This is because the application does not have control over exactly
 * when {@code Displayable}s and {@code Item}s) appear and disappear from the
 * display.)
 * </p>
 * 
 * <p>
 * The following code illustrates a technique to refresh the image part of
 * element {@code k} of a {@code Choice ch}:
 * </p>
 * 
 * <pre>
 * ch.set(k, ch.getString(k), ch.getImage(k));
 * </pre>
 * 
 * <p>
 * If the application provides an image, the implementation may choose to
 * truncate it if it exceeds the capacity of the device to display it.
 * {@code Image}s within any particular {@code Choice} object should be of the
 * same size, because the implementation is allowed to allocate the same amount
 * of space for every element. The application can query the
 * {@code Display.getBestImageHeight(int)}.
 * </p>
 * 
 * <p>
 * If an element is very long or contains a link break, the implementation may
 * display only a portion of it. If this occurs, the implementation should
 * provide the user with a means to see as much as possible of the element. If
 * this is done by wrapping an element to multiple lines, the second and
 * subsequent lines should show a clear indication to the user that thay are
 * part of the same element and are not a new element.
 * </p>
 * 
 * <p>
 * The application can express a preference for the policy used by the
 * implementation for display of long elements including those that contain line
 * break characters. The characters after the first line break may only be
 * visible if the policy permits it. The {@code setFitPolicy(int)} and
 * {@code getFitPolicy()} methods control this preference. The valid settings
 * are {@code TEXT_WRAP_DEFAULT}, {@code TEXT_WRAP_ON}, and
 * {@code TEXT_WRAP_OFF}. Unless specified otherwise by {@code Choice}
 * implementation classes, the initial value of the element fit policy is
 * {@code TEXT_WRAP_DEFAULT}.
 * </p>
 * 
 * <p>
 * After a {@code Choice} object has been created, elements may be inserted,
 * appended, and deleted, and each element's string part and image part may be
 * get and set. Elements within a {@code Choice} object are referred to by their
 * indexes, which are consecutive integers in the range from zero to
 * {@code size()-1}, with zero referring to the first element and
 * {@code size()-1} to the last element.
 * </p>
 * 
 * <p>
 * There are four types of {@code Choice}s: implicit-choice (valid only for
 * {@code List}), exclusive-choice, multiple-choice, and pop-up (valid only for
 * {@code ChoiceGroup}).
 * </p>
 * 
 * <p>
 * The exclusive-choice presents a series of elements and interacts with the
 * user. That is, when the user selects an element, that element is shown to be
 * selected using a distinct visual representation. If there are elements
 * present in the {@code Choice}, one element must be selected at any given
 * time. If at any time a situation would result where there are elements in the
 * exclusive-choice but none is selected, the implementation will choose an
 * element and select it. This situation can arise when an element is added to
 * an empty {@code Choice}, when the selected element is deleted from the
 * {@code Choice}, or when a {@code Choice} is created and populated with
 * elements by a constructor. In these cases, the choice of which element is
 * selected is left to the implementation. Applications for which the selected
 * element is significant should set the selection explicitly. There is no way
 * for the user to unselect an element within an exclusive {@code Choice}.
 * </p>
 */
public interface Choice {
    /**
     * <p>
     * {@code EXCLUSIVE} is a choice having exactly one element selected at a time.
     * All elements of an {@code EXCLUSIVE} type {@code Choice} should be displayed
     * in-line. That is, the user should not need to perform any extra action to
     * traverse among and select from the elements.
     * </p>
     * 
     * <p>
     * Value {@code 1} is assigned to {@code EXCLUSIVE}.
     * </p>
     */
    public static final int EXCLUSIVE = 1;
    /**
     * <p>
     * {@code MULTIPLE} is a choice that can have arbitrary number of elements
     * selected at a time.
     * </p>
     * 
     * <p>
     * Value {@code 2} is assigned to {@code MULTIPLE}.
     * </p>
     */
    public static final int MULTIPLE = 2;
    public static final int IMPLICIT = 3;
    public static final int POPUP = 4;
    public static final int TEXT_WRAP_DEFAULT = 0;
    public static final int TEXT_WRAP_ON = 1;
    public static final int TEXT_WRAP_OFF = 2;

    public int size();

    public String getString(int elementNum);

    public Image getImage(int elementNum);

    public int append(String stringPart, Image imagePart);
}