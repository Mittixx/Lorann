package model.LorannWorld.MobileElement;

import model.LorannWorld.Permeability;
import model.LorannWorld.Sprite;

/**
 * The class Monster
 * @author Tanguy Blochet
 */
public class Monster {
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
     * @param sprite,permeability,ID
     */
    public Monster(Sprite sprite, Permeability permeability,int ID) {
        this.ID = ID;
    }
}
