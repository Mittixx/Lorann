package model.LorannWorld.MobileElement;

import contract.IHero;
import contract.Permeability;
import contract.State;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * The class Hero
 * @author Tanguy Blochet
 */
public class Hero extends MobileElement implements IHero {
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
     */
    public Hero(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING);
    }
}
