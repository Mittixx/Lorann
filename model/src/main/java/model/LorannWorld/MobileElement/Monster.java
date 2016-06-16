package model.LorannWorld.MobileElement;

import contract.Permeability;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * The class Monster
 * @author Tanguy Blochet
 */
public class Monster extends MobileElement{
    /**
     * The ID of the monster
     */
    private int ID;

    /**
     * gets the ID of the monster
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * sets the ID of the monster
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    /**
     * Instanciate a monster
     */
    public Monster(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING);
    }
}
