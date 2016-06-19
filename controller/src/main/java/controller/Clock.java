package controller;

import contract.IClock;

/**
 * The Class Clock
 * @author Romain
 */

public class Clock extends Thread implements IClock{
    /** The Controller */

    private Controller controller;

    private boolean stopped=false;

    /**
     * Instanciate a new Controller
     * @param controller
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
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
