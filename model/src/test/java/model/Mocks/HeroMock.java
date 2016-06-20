package model.Mocks;

import contract.IHero;
import contract.Permeability;
import contract.StateElement;

import java.awt.*;

public class HeroMock extends MobileElementMock implements IHero  {



    public HeroMock() {
        super(Permeability.BLOCKING, StateElement.WEAK);
    }

    public void next() {

    }

    public Image getImage() {
        return null;
    }

    public void setImage(Image image) {

    }
}
