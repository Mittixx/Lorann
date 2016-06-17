package model.LorannWorld.MotionlessElement;

import contract.StateMotionlessElement;
import contract.ISprite;
import contract.Permeability;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * The key.
 * @author Romain
 */
public class Key extends MotionlessElement{

    /** The key is stateMotionlessElement*/
    private StateMotionlessElement stateMotionlessElement = StateMotionlessElement.COLLECTABLE;

    /**
     *
     */
    public Key(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.PENETRABLE);
    }

    public void setSprite(ISprite sprite) {

    }
}
