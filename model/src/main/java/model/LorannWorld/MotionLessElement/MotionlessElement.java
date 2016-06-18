package model.LorannWorld.MotionlessElement;

import contract.StateElement;
import model.LorannWorld.Element;
import contract.Permeability;
import model.LorannWorld.Sprite;

/**
 * @author Romain
 */
public abstract class MotionlessElement extends Element{
    /** Easting */
    private int x;

    /** Northing */

    private int y;

    /**
     *
     * @param sprite
     * @param permeability
     * @param stateElement
     */
    public MotionlessElement (Sprite sprite, Permeability permeability, StateElement stateElement){
        super(sprite,permeability,stateElement);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }


}
