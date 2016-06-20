package model.LorannWorld.MobileElement;

import contract.Permeability;
import contract.StateElement;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * The class Monster
 * @author Tanguy Blochet
 */
public class Monster extends MobileElement{


    /** Instanciates a monster.
     *
     * @param path
     *         Where to find the image.
     */
    public Monster(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING, StateElement.DEATH);
    }

}
