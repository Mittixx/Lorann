package model.LorannWorld;

import contract.IElement;
import contract.IMap;
import contract.IMobileElement;
import model.LorannWorld.MobileElement.Hero;
import model.LorannWorld.MotionlessElement.MotionlessElement;

import java.util.ArrayList;

/**
* The class Map
 *
 * @author Tanguy Blochet
 * @version 15.06.2016
 **/
public class Map implements IMap{
    /**
    * the width of the map
     **/
    private int width=20;
    /**
     * the height of the map
     **/
    private int height=12;
    /**
     * the static elements of the map
     **/
    private Element[][] elements;
    /**
     * the mobile elements of the map
     **/
    private ArrayList<IMobileElement> mobiles;
    /**
     * the Identifiant of the map
     **/
    private int ID;

    private IMobileElement hero;

    public Map( int height, int width) {

        this.height = height;
        this.width = width;
        elements=new Element[this.height][this.width];
        mobiles=new ArrayList<IMobileElement>();
    }

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public IElement getElement(int x, int y) {
        return elements[x][y];
    }

    public ArrayList<IMobileElement> getMobiles() {
        return mobiles;
    }

    public int getID() {
        return 0;
    }

    public void setWidth(int width) {

    }

    public void setHeight(int height) {

    }

    public void setElements(IElement[][] elements) {

    }



    public void addElementToMap(MotionlessElement element,int x,int y)
    {
        this.elements[x][y]=element;
    }

    public void setMobiles(ArrayList<IMobileElement> mobiles) {

    }

    public void setID(int ID) {

    }

    public void setHeroPosition(int x, int y){
        this.hero.setX(x);
        this.hero.setY(y);
    }

    public IMobileElement getHero(){
        return this.hero;
    }
}
