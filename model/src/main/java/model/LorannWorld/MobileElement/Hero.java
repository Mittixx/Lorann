package model.LorannWorld.MobileElement;

import model.LorannWorld.Permeability;
import model.LorannWorld.Sprite;

/**
 * The class Hero
 * @author Tanguy Blochet
 */
public class Hero extends MobileElement{
    /**
     * The state of the hero
     */
    private State state=State.WEAK;
    /**
     * gets the state of the hero
     * @return state
     */
    public State getState() {
        return state;
    }

    /**
     * sets the state of the hero
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     *instanciate the hero
     * @param sprite,permeability
     */
    public Hero(Sprite sprite, Permeability permeability) {

    }
}
