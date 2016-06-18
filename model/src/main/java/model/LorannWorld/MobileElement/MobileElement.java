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

    private StateElement stateElement;


    private ControllerOrder direction;


    public MobileElement(Sprite sprite, Permeability permeability, StateElement stateElement) {
        super(sprite,permeability,stateElement);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {this.y = y;}

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }

    public Permeability getPermeability() {
        return permeability;
    }

    public void setDirection(ControllerOrder direction){
        this.direction = direction;
    }

    public ControllerOrder getDirection() {
        return direction;
    }

    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }

    public StateElement getStateElement() {
        return stateElement;
    }


    public void setStateElement(StateElement stateElement) {
        this.stateElement = stateElement;
    }

}
