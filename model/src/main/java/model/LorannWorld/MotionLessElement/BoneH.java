package model.LorannWorld.MotionlessElement;

import contract.Collectable;
import contract.ISprite;

/**
 * Horizontal Bone.
 * @author Romain
 */
public class BoneH extends MotionlessElement{

    /** The Bone is fixed*/
    private Collectable collectable = Collectable.FIXED;

    /**
     *
     */
    public BoneH() {
        super(null,null);
    }

    public void setSprite(ISprite sprite) {

    }
}
