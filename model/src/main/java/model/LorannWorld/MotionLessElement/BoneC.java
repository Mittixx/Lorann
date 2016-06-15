package model.LorannWorld.MotionlessElement;

import contract.Collectable;
import contract.ISprite;

/**
 * Circular Bone.
 * @author Romain
 */
public class BoneC extends MotionlessElement{

    /** The Bone is fixed*/
    private Collectable collectable = Collectable.FIXED;

    /**
     *
     */
    public BoneC() {
        super(null,null);
    }

    public void setSprite(ISprite sprite) {

    }
}
