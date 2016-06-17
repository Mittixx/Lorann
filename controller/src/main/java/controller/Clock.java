package controller;

/**
 * The Class Clock
 * @author Romain
 */

public class Clock {
    /** The Controller */

    private Controller controller;


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
    public void run(){
        try{
            while(true){
                controller.AIMonster();
                Thread.sleep(500);
            }
        }catch(Exception ex) {}
    }
}
