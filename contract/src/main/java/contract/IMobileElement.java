package contract;

public interface IMobileElement {

    int getY();

    void setY(int Y);

    int getX();

    void setX(int x);

    void setControllerOrder (ControllerOrder position);

    ISprite getSprite();

}
