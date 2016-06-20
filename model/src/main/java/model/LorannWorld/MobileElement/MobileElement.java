package model.LorannWorld.MobileElement;

import contract.*;
import model.LorannWorld.Element;
import model.LorannWorld.Sprite;

/**
 * The class MobileElement
 * @author Tanguy Blochet
 */
public class MobileElement extends Element implements IMobileElement{

    /**
     * The X position of the element
     */
    private int x;

    /**
     * The Y position of the element
     */
    private int y;

    /**
     * The image of the element
     */
    private ISprite sprite;

    /**
     * The permeability of the element
     */
    private Permeability permeability;

    /**
     * The state of the element.
     */
    private StateElement stateElement;

    /**
     * The direction of the order.
     */
    private ControllerOrder direction;


    /**
     * Instantiates a new MobileElement.
     * @param sprite
     * @param permeability
     * @param stateElement
     */
    public MobileElement(Sprite sprite, Permeability permeability, StateElement stateElement) {
        super(sprite,permeability,stateElement);
    }

    /**
     * Gets the northing.
     * @return
     *      int
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the northing.
     * @param y
     *       Northing.
     */
    public void setY(int y) {this.y = y;}

    /**
     * Gets the easting.
     * @return
     *      int
     */
    public int getX() {return x;}

    /**
     *Sets the easting.
     * @param x
     *      Easting.
     */
    public void setX(int x) {this.x = x;}

    /**
     * Sets the sprite.
     * @param sprite
     *      Image.
     */
    public void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }

    /**
     * Gets the permeability.
     *
     * @return
     *      Permeability.
     */
    public Permeability getPermeability() {
        return permeability;
    }

    /**
     * Sets the direction.
     *
     * @param direction
     *      The direction.
     */
    public void setDirection(ControllerOrder direction){
        this.direction = direction;
    }

    /**
     * Gets the direction.
     *
     * @return
     *       Direction.
     */
    public ControllerOrder getDirection() {
        return direction;
    }

    /**
     * Sets the permeability.
     *
     * @param permeability
     *      Permeability.
     */
    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }

    /**
     * Gets the state of an element.
     *
     * @return
     *      stateElement.
     */
    public StateElement getStateElement() {
        return stateElement;
    }

    /**
     * Sets the state of an element.
     *
     * @param stateElement
     *      The state of the element.
     */
    public void setStateElement(StateElement stateElement) {
        this.stateElement = stateElement;
    }


}
