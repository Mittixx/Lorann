package model.Mocks;

import contract.IElement;
import contract.IMap;
import contract.IMobileElement;


import java.util.ArrayList;

public class MapMock implements IMap {

    private IElement[][] elements;

    private ArrayList<IMobileElement> mobiles;

    private int width=20;

    private int height=12;

    private int ID;

    private int score=0;

    private IMobileElement hero;

    private IMobileElement spell;


    public MapMock(int height,int width) {
        this.height = height;
        this.width = width;
        elements=new ElementMock[this.height][this.width];
        mobiles=new ArrayList<IMobileElement>();

    }

    public void addElementToMap(IElement element, int x, int y) {

    }

    public void setElement(int x, int y, IElement element) {

    }

    public void setScore(int score) {
        this.score=score;
    }

    public int getScore() {
        return this.score;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID=ID;
    }

    public IElement getElement(int x, int y) {
        return null;
    }

    public IElement[][] getElements() {
        return new IElement[0][];
    }

    public ArrayList<IMobileElement> getMobiles() {
        return this.mobiles;
    }

    public void setHeroPosition(int x, int y) {
        this.hero.setX(x);
        this.hero.setY(y);
    }

    public IMobileElement getHero() {
        return this.hero;
    }

    public void setHero(IMobileElement hero) {
        this.hero=hero;
    }

    public IMobileElement getSpell() {
        return this.spell;
    }

    public void setSpell(IMobileElement spell) {
        this.spell=spell;
    }
}
