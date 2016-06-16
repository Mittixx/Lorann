package model.LorannWorld.MotionlessElement;

import contract.Collectable;
import contract.ISprite;
import contract.Permeability;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

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
    public BoneC(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING);
    }

    public void setSprite(ISprite sprite) {

    }
}
