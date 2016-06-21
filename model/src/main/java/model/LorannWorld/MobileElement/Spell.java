package model.LorannWorld.MobileElement;

import contract.*;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * The class Monster
 * @author Tanguy Blochet
 */
public class Spell extends MobileElement {


    /** Instanciates a spell.
     *
     * @param path
     *      Where to find the image.
     *@param direction
     *      The direction the spell will take
     *@throws IOException
     *      Can't read file
     */
    public Spell(String path, ControllerOrder direction) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+"_1"+".png")))), Permeability.PENETRABLE, StateElement.SPELL);
        this.setDirection(direction);
    }

}