package model.LorannWorld.MobileElement;

import contract.IMobileElement;

/**
 * The class MobileElement
 * @author Tanguy Blochet
 */
public class MobileElement implements IMobileElement{
    /**
     * The X position of the element
     */
    private int x;
    /**
     * The Y position of the element
     */
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {this.y = y;}

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}
}
