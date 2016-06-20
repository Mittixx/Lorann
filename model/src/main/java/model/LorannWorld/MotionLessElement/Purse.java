package model.LorannWorld.MotionlessElement;

import contract.StateElement;
import contract.ISprite;
import contract.Permeability;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * The purse.
 * @author Romain
 */
public class Purse extends MotionlessElement{


    /**
     *Instantiates a purse.
     *
     * @param path
     *      Where to find the image.
     */
    public Purse(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.PENETRABLE,StateElement.COLLECTABLE);
    }

}
