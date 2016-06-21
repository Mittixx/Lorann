package model.LorannWorld.MotionlessElement;

import contract.StateElement;
import contract.Permeability;
import contract.ISprite;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * The Door.
 *@author Romain
 */
public class Door extends MotionlessElement {


    /**
     *Instantiates a door.
     *
     * @param path
     *      Where to find the image.
     *@throws IOException
     *       Can't read file.
     */
    public Door(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING,StateElement.DRAGON);
    }



}
