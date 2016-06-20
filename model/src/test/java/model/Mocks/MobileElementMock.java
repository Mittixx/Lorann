package model.Mocks;

import contract.*;
import model.LorannWorld.Sprite;


public class MobileElementMock extends ElementMock implements IMobileElement {

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

    public MobileElementMock(Permeability permeability, StateElement stateElement) {
        super(permeability,stateElement);
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y=y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x=x;
    }

    public void setDirection(ControllerOrder direction) {
        this.direction=direction;
    }

    public ControllerOrder getDirection() {
        return direction;
    }

    public ISprite getSprite() {
        return this.sprite;
    }

    public StateElement getStateElement() {
        return this.stateElement;
    }

    public void setStateElement(StateElement stateElement) {
        this.stateElement=stateElement;
    }
}
