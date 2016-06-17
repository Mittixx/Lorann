package model.LorannWorld.MotionlessElement;

import contract.StateMotionlessElement;
import contract.IMap;
import contract.ISprite;
import contract.Permeability;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Horizontal Bone.
 * @author Romain
 */
public class BoneH extends MotionlessElement{

    /** The Bone is fixed*/
    private StateMotionlessElement stateMotionlessElement = StateMotionlessElement.FIXED;

    /**
     *
     */
    public BoneH(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING);

    }

    public void setSprite(ISprite sprite) {

    }

    public void setMap(IMap map) {

    }
}
