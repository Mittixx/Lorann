package model.LorannWorld.MotionlessElement;

import contract.StateMotionlessElement;
import contract.ISprite;
import contract.Permeability;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Vertical Bone.
 * @author Romain
 */
public class BoneV extends MotionlessElement{

    /** The Bone is fixed*/
    private StateMotionlessElement stateMotionlessElement = StateMotionlessElement.FIXED;

    /**
     *
     */
    public BoneV(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING);
    }

    public void setSprite(ISprite sprite) {

    }
}
