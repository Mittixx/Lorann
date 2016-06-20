package model.LorannWorld.MotionlessElement;

import contract.StateElement;
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


    /**
     *Instantiates an horizontal bone.
     *
     * @param path
     *      Where to find the image.
     */
     public BoneH(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING,StateElement.FIXED);

    }

}
