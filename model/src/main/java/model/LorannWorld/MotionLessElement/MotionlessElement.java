package model.LorannWorld.MotionLessElement;

import model.LorannWorld.Permeability;
import model.LorannWorld.Sprite;
import model.LorannWorld.MotionLessElement.Collectable;
import model.LorannWorld.MotionLessElement.DoorState;

/**
 * @author Romain
 */
public class MotionlessElement {
    /** Easting */
    private int x;

    /** Northing */

    private int y;

    /**
     * Instantiates a new MotionlessElement.
     * Overloading of the constructor depending of the element.
     * @param sprite
     * @param permeability
     */
    public MotionlessElement(Sprite sprite, Permeability permeability) {
    }

    /**
     *
     * @param sprite
     * @param permeability
     * @param collectable
     */
    public MotionlessElement (Sprite sprite, Permeability permeability, Collectable collectable){

    }
}
