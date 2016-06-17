package model.LorannWorld.MotionlessElement;

import contract.DoorState;
import contract.ISprite;
import contract.Permeability;
import contract.StateMotionlessElement;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * The Door.
 *@author Romain
 */
public class Door extends MotionlessElement{

    /** The default state of the door is DRAGON*/
    StateMotionlessElement doorState = StateMotionlessElement.DRAGON;

    /**
     *
     */
    public Door(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING);
    }

    public void setSprite(ISprite sprite) {

    }


}
