package model.LorannWorld.MotionlessElement;

import contract.DoorState;
import contract.ISprite;
import contract.Permeability;
import model.LorannWorld.Sprite;

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
        super(null,null);
    }

    public void setSprite(ISprite sprite) {

    }
}
