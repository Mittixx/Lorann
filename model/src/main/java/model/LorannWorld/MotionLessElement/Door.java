package model.LorannWorld.MotionLessElement;

import model.LorannWorld.MobileElement.State;

/**
 * The Door.
 *@author Romain
 */
public class Door extends MotionlessElement{

    /** The default state of the door is DRAGON*/
    DoorState doorState = DoorState.DRAGON;

    /**
     *
     */
    public Door() {
        super();
    }
}
