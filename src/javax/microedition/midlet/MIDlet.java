package javax.microedition.midlet;

import javax.microedition.io.ConnectionNotFoundException;

/**
 * <p>
 * A {@code MIDlet} is a MID Profile application. The application must extend
 * this class to allow the application management software to control the MIDlet
 * and to be able to retrieve properties from the application descriptor and
 * notify and request state changes. The methods of this class allow the
 * application management software to create, start, pause, and destroy a
 * MIDlet. A {@code MIDlet} is a set of classes designed to be run and
 * controlled by the application management software via this interface. The
 * states allow the application management software to manage the activities of
 * multiple {@code MIDlet}s within a runtime environment. It can select which
 * {@code MIDlet}s and invokes methods on the {@code MIDlet} to notify the
 * MIDlet of change states. The {@code MIDlet} implements these methods to
 * update its internal activities and resource usage as directed by the
 * application management software. The {@code MIDlet} can initiate some state
 * changes itself and notifies the application management software of those
 * state changes by invoking the appropriate methods.
 *
 * <p>
 * <b>Note:</b> The methods on this interface signal state changes. The state
 * change is not considered complete until the state change method has returned.
 * It is intended that these methods return quickly.
 */
public abstract class MIDlet {

    /**
     * Protected constructor for subclasses. The application management software is
     * responsible for creating MIDlets and creation of MIDlets is restricted.
     * MIDlets should not attempt to create other MIDlets.
     *
     * @throws SecurityException unless the application management software is
     *                           creating the MIDlet.
     */
    protected MIDlet() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Signals the {@code MIDlet} that it has entered the <i>Active</i> state. In
     * the <i>Active</i> state the {@code MIDlet} may hold resources. The method
     * will only be called when the {@code MIDlet} is in the <i>Paused</i> state.
     *
     * <p>
     * Two kinds of failures can prevent the service from starting, transient and
     * non-transient. For transient failures the {@code MIDletStateChangeException}
     * exception should be thrown. For non-transient failures the
     * {@code notifyDestroyed} method should be called.
     *
     * <p>
     * If a Runtime exception occurs during {@code startApp} the MIDlet will be
     * destroyed immediately. Its {@code destroyApp} will be called allowing the
     * MIDlet to cleanup.
     *
     * @throws MIDletStateChangeException is thrown if the {@code MIDlet} cannot
     *                                    start now but might be able to start a
     *                                    later time.
     */
    protected abstract void startApp() throws MIDletStateChangeException;

    /**
     * <p>
     * Signals the {@code MIDlet} to enter the <i>Paused</i> state. In the
     * <i>Paused</i> state the {@code MIDlet} must release shared resources and
     * become quiescent. This method will only be called when the {@code MIDlet} is
     * in the <i>Active</i> state.
     *
     * <p>
     * If a Runtime exception occurs during {@code pauseApp} the MIDlet will be
     * destroyed immediately. Its {@code destroyApp} will be called allowing the
     * MIDlet to cleanup.
     */
    protected abstract void pauseApp();

    /**
     * <p>
     * Signals the {@code MIDlet} to terminate and enter the <i>Destroyed</i> state.
     * In the destroyed state the {@code MIDlet} must release all resources and save
     * any persistent state. This method may be called from the <i>Paused</i> or
     * <i>Active</i> states.
     *
     * <p>
     * {@code MIDlet}s should perform any operations required before being
     * terminated, such as releasing resources or saving preferences or state.
     *
     * <p>
     * <b>Note:</b> The {@code MIDlet} can request that it not enter the
     * <i>Destroyed</i> by throwing an {@code MIDletStateChangeException}. This is
     * only a valid response if the {@code unconditional} flag is set to false. If
     * it is {@code true} the {@code MIDlet} is assumed to be in the
     * <i>Destroyed</i> state regardless of how this method terminates. If it is not
     * an unconditional request, the {@code MIDlet} can signify that it wishes to
     * stay in its current state by throwing the {@code MIDletStateChangeException}.
     * This request may be honored and the {@code destroy()} method called again at
     * later time.
     *
     * <p>
     * If a Runtime exception occurs during {@code destroyApp} then they are ignored
     * and the MIDlet is put into the <i>Destroyed</i> state.
     *
     * @param unconditional If true when this method is called, the {@code MIDlet}
     *                      must cleanup and release all resources. If false the
     *                      {@code MIDlet} may throw
     *                      {@code MIDletStateChangeException} to indicate it does
     *                      not want to be destroyed at this time.
     * @throws MIDletStateChangeException is thrown if the {@code MIDlet} wishes to
     *                                    continue to execute (Not enter the
     *                                    <i>Destroyed</i> state). This exception is
     *                                    ignored if {@code unconditional} is equal
     *                                    to {@code true}.
     */
    protected abstract void destroyApp(boolean unconditional) throws MIDletStateChangeException;

    /**
     * Used by an {@code MIDlet} to notify the application management software that
     * it has entered into the <i>Destroyed</i> state. The application management
     * software will not call the MIDlet's {@code destroyApp} method, and all
     * resources held by the {@code MIDlet} will be considered eligible for
     * reclamation. The {@code MIDlet} must have performed the same operations
     * (clean up, releasing of resources, etc.) it would have if the
     * {@code MIDlet.destroyApp()} has been called.
     */
    public final void notifyDestroyed() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Notifies the application management software that the MIDlet does not want to
     * be active and has entered the <i>Paused</i> state. Invoking this method will
     * have no effect if the {@code MIDlet} is destroyed, or if it has not yet been
     * started.
     *
     * <p>
     * It may be invoked by the {@code MIDlet} when it is in the <i>Active</i>
     * state.
     *
     * <p>
     * If a {@code MIDlet} calls {@code notifyPaused()}, in the future its
     * {@code startApp()} method may be called make it active again, or its
     * {@code destroyApp()} method may be called request it to destroy itself.
     *
     * <p>
     * If the application pauses itself it will need to call {@code resumeRequest}
     * to request to re-enter the {@code active} state.
     */
    public final void notifyPaused() {
        throw new UnsupportedOperationException();
    }

    /**
     * Provides a {@code MIDlet} with a mechanism to retrieve named properties from
     * the application management software. The properties are retrieved from the
     * combination of the application descriptor file and the manifest. For trusted
     * applications the values in the manifest MUST NOT be overridden by those in
     * the application descriptor. If they differ, the MIDlet will not be installed
     * on the device. For untrusted applications, if an attribute in the descriptor
     * has the same as an attribute in the manifest, the value from the descriptor
     * is used and the value from the manifest is ignored.
     * 
     * @param key the name of the property
     * @return A string with the value of the property. {@code null} is returned if
     *         no value is available for the key.
     * @throws NullPointerException is thrown if key is {@code null}.
     */
    public final String getAppProperty(String key) {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Provides a {@code MIDlet} with a mechanism to indicate that it is interested
     * in entering the <i>Active</i> state. Calls to this method can be used by the
     * application management software to determine which applications to move to
     * the <i>Active</i> state.
     * 
     * <p>
     * When the application management software decides to activate this application
     * it will call the {@code startApp} method.
     * 
     * <p>
     * The application is generally in the <i>Paused</i> state when this is called.
     * Even in the paused state the application may handle asynchronous events such
     * as timers or callbacks.
     */
    public final void resumeRequest() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Requests that the device handle (for example, display or install) the
     * indicated URL.
     * 
     * <p>
     * If the platform has the appropriate capabilities and resources available, it
     * SHOULD bring the appropriate application to the foreground and let the user
     * interact with the content, while keeping the MIDlet suite running in the
     * background. If the platform does not have appropriate capabilities or
     * resources available, it MAY wait to handle the URL request until after the
     * MIDlet suite exits. In this case, when the requesting MIDlet suite exits, the
     * platform MUST then bring the appropriate application (if one exists) to the
     * foreground to let the user interact with the content.
     * 
     * <p>
     * This is a non-blocking method. In addition, this method does NOT queue
     * multiple requests. On platforms where the MIDlet suite must exit before the
     * request is handled, the platform MUST handle only the last request made. On
     * platforms where the MIDlet suite and the request can be handled concurrently,
     * each request that the MIDlet suite makes MUST be passed to the platform
     * software for handling in a timely fashion.
     * 
     * <p>
     * If the URL specified refers to a MIDlet suite (either an Application
     * Descriptor or a JAR file), the application handling the request MUST
     * interpret it as a request to install the named package. In this case, the
     * platform's normal MIDlet suite installation process SHOULD be used, and the
     * user MUST be allowed to control the process (including cancelling the
     * download and/or installation). If the MIDlet suite being installed is an
     * <i>update</i> of the currently running MIDlet suite, the platform MUST first
     * stop the currently running MIDlet suite before performing the update. On some
     * platforms, the currently running MIDlet suite MAY need to be stopped before
     * any installations can occur.
     * 
     * <p>
     * If the URL specified is of the form {@code tel:<number>}, as specified in
     * <a href="https://www.ietf.org/rfc/rfc2806.txt">RFC2806</a>, then the platform
     * MUST interpret this as a request to initiate a voice call. The request MUST
     * be passed to the "phone" application to handle if one is present in the
     * platform. The "phone" application, if present, MUST be able to set up local
     * and global phone calls and also perform DTMF post dialing. Not all elements
     * of RFC2806 need be implemented, especially the area-specifier or any other
     * requirement on the terminal to know its context. This isdn-subaddress,
     * service-provider and future-extension may also be ignored. Pauses during
     * dialing are not relevant in some telephony services.
     * 
     * <p>
     * Devices MAY choose to support addition URL schemes beyond the requirements
     * listed above.
     * 
     * <p>
     * Many of the ways this method will be used could have a finacial impact to the
     * user (e.g. transferring data through a wireless network, or initiating a
     * call). Therefore the platform MUST ask the user to explicitly acknowledge
     * each request before the action is taken. Implementation freedoms are possible
     * so that a pleasant user experience is retained. For example, some platforms
     * may put up a dialog for each request asking the user for permission, while
     * other platforms may launch the appropriate application and populate the URL
     * or phone number fields, but not take the action until the user explicitly
     * clicks the load or dial buttons.
     * 
     * @param URL The URL for the platform to load. An empty string (not null)
     *            cancels any pending requests.
     * @return true if the MIDlet suite MUST first exit before the content can be
     *         fetched.
     * @throws ConnectionNotFoundException if the platform cannot handle the URL
     *                                     requested.
     * @since MIDP 2.0
     */
    public final boolean platformRequest(String URL) throws ConnectionNotFoundException {
        throw new UnsupportedOperationException();
    }

    /**
     * Get the status of the specified permission. If no API on the device defines
     * the specific permission requested then it must be reported as denied. If the
     * status of the permission is not known because it might require a user
     * interaction then it should be reported as unknown.
     * 
     * @param permission to check if denied, allowed, or unknown
     * @return 0 if the permission is denied; 1 if the permission is allowed; -1 if
     *         the status is unknown
     * @since MIDP 2.0
     */
    public final int checkPermission(String permission) {
        throw new UnsupportedOperationException();
    }
}