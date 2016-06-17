package model.LorannWorld.MobileElement;

import contract.ControllerOrder;
import contract.IMobileElement;
import contract.ISprite;
import contract.Permeability;
import model.LorannWorld.Sprite;

/**
 * The class MobileElement
 * @author Tanguy Blochet
 */
public class MobileElement  implements IMobileElement{
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


    private ControllerOrder position;


    public MobileElement(Sprite sprite, Permeability permeability) {
        this.sprite=sprite;
        this.permeability=permeability;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {this.y = y;}

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}


    public ISprite getSprite() {
        return sprite;
    }

    public void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }

    public Permeability getPermeability() {
        return permeability;
    }


    public void setControllerOrder(ControllerOrder position){
        this.position = position;
    }

    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }
}
