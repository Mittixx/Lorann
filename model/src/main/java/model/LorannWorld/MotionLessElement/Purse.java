package model.LorannWorld.MotionlessElement;

import contract.Collectable;
import contract.ISprite;

/**
 * The purse.
 * @author Romain
 */
public class Purse extends MotionlessElement{

    /** The Purse is collectable*/
    private Collectable collectable = Collectable.COLLECTABLE;

    /**
     *
     */
    public Purse() {
        super(null,null);
    }

    public void setSprite(ISprite sprite) {

    }
}
