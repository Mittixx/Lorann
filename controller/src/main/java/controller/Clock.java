package controller;

/**
 * The Class Clock
 * @author Romain
 */

public class Clock implements Runnable{
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


                controller.moveSpell();


                Thread.sleep(300);
            }
        }catch(Exception ex) {}
    }
}
