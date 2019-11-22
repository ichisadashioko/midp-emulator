package javax.microedition.midlet;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        throw new NotImplementedException();
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
}