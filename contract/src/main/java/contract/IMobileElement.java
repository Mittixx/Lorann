package contract;

public interface IMobileElement {

    int getY();

    void setY(int Y);

    int getX();

    void setX(int x);

    void setDirection (ControllerOrder direction);

    ControllerOrder getDirection();


    ISprite getSprite();

    StateElement getStateElement();

    void setStateElement(StateElement stateElement);



}
