package model.LorannWorld.MotionlessElement;

import contract.StateElement;
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


    /**
     *Instantiates a vertical bone
     *
     * @param path
     *      Where to find the image.
     */
    public BoneV(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING,StateElement.FIXED);
    }


}
