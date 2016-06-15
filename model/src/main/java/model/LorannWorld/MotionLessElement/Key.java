package model.LorannWorld.MotionlessElement;

import contract.Collectable;
import contract.ISprite;

/**
 * The key.
 * @author Romain
 */
public class Key extends MotionlessElement{

    /** The key is collectable*/
    private Collectable collectable = Collectable.COLLECTABLE;

    /**
     *
     */
    public Key() {
        super(null,null);
    }

    public void setSprite(ISprite sprite) {

    }
}
