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
     *Instantiates a circular bone.
     *
     * @param path
     *      Where to find the image.
     *@throws IOException
     *       Can't read file.
     */
    public BoneC(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING,StateElement.FIXED);
    }

}
