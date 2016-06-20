package Controller.Mock;

import contract.ControllerOrder;
import contract.IMobileElement;
import contract.ISprite;
import contract.StateElement;

/**
 * Created by Romain on 20/06/2016.
 */
public class MobileElementMock implements IMobileElement {
    int y;
    int x;
    ControllerOrder direction;
    StateElement stateElement;

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

    public void setDirection(ControllerOrder direction) {
        this.direction = direction;
    }

    public ControllerOrder getDirection() {
        return direction;
    }

    public ISprite getSprite() {
        return null;
    }

    public StateElement getStateElement() {
        return stateElement;
    }

    public void setStateElement(StateElement stateElement) {
        this.stateElement = stateElement;
    }
}
