package model.LorannWorld.MotionlessElement;

import contract.Collectable;
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
     * Instantiates a new MotionlessElement.
     * Overloading of the constructor depending of the element.
     * @param sprite
     * @param permeability
     */
    public MotionlessElement(Sprite sprite, Permeability permeability) {
        super(sprite,permeability);
    }

    /**
     *
     * @param sprite
     * @param permeability
     * @param collectable
     */
    public MotionlessElement (Sprite sprite, Permeability permeability, Collectable collectable){
        super(sprite,permeability);
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
