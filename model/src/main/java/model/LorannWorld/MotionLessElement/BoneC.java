package model.LorannWorld.MotionlessElement;

import contract.StateElement;
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


    /**
     *instantiates a round bone
     */
    public BoneC(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING,StateElement.FIXED);
    }

    public void setSprite(ISprite sprite) {

    }
}
