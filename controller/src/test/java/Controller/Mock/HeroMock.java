package Controller.Mock;

import contract.IHero;

import java.awt.*;

/**
 * Interface of the Hero.
 * Created by Romain on 20/06/2016.
 * @author Romain
 */
public class HeroMock implements IHero{
    AnimatedSpriteMock sprites;

    public void next() {
        sprites.next();
        setImage(sprites.getImage());
    }

    public Image getImage() {
        return null;
    }

    public void setImage(Image image) {

    }
}
