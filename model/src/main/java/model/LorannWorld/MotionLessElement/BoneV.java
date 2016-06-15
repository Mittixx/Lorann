package model.LorannWorld.MotionlessElement;

import contract.Collectable;
import contract.ISprite;

/**
 * Vertical Bone.
 * @author Romain
 */
public class BoneV extends MotionlessElement{

    /** The Bone is fixed*/
    private Collectable collectable = Collectable.FIXED;

    /**
     *
     */
    public BoneV() {
        super(null,null);
    }

    public void setSprite(ISprite sprite) {

    }
}
