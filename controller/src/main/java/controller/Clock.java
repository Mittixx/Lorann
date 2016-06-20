package controller;

import contract.IClock;

/**
 * The Class Clock
 * @author Romain
 */

public class Clock extends Thread implements IClock{
    /** The Controller */

    private Controller controller;

    /**
     * the state of the clock
     */
    private boolean stopped=false;

    /**
     * Instanciate a new Controller
     * @param controller
     *          the Controller
     */
    public Clock(Controller controller) {
        this.controller = controller;
    }

    /**
     * Launch a Thread.
     */
    public synchronized void run() {

        while (!stopped) {
            controller.updateController();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.updateSprite();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.updateSprite();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.updateSprite();


        }
    }

    /**
     * gets the running state of the clock
     * @return value of stopped (true or false)
     */
    public boolean isStopped() {
        return stopped;
    }

    /**
     * sets the state of the clock
     * @param stopped
     *          State of the thread
     */
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
