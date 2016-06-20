package model.LorannWorld.MotionlessElement;

import contract.StateElement;
import model.LorannWorld.Element;
import contract.Permeability;
import model.LorannWorld.Sprite;

/**
 * A MotionLess Element.
 * @author Romain
 */
public abstract class MotionlessElement extends Element{

    /** Easting */
    private int x;

    /** Northing */
    private int y;

    /**
     *
     * Instantiates a new MotionLessElement.
     *
     * @param sprite
     *      The sprite of the element.
     *
     * @param permeability
     *      The permeability of the element.
     *
     * @param stateElement
     *      The state of the element.
     */
    public MotionlessElement (Sprite sprite, Permeability permeability, StateElement stateElement){
        super(sprite,permeability,stateElement);
    }


}
