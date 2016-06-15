package model.LorannWorld;

import model.LorannWorld.MobileElement.MobileElement;

import java.util.ArrayList;

/**
* The class Map
 *
 * @author Tanguy Blochet
 * @version 15.06.2016
 **/
public class Map {
    /**
    * the width of the map
     **/
    private int width;
    /**
     * the height of the map
     **/
    private int height;
    /**
     * the static elements of the map
     **/
    private Element[][] elements;
    /**
     * the mobile elements of the map
     **/
    private ArrayList<MobileElement> mobiles;
    /**
     * the Identifiant of the map
     **/
    private int ID;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Element[][] getElements() {
        return elements;
    }

    public ArrayList<MobileElement> getMobiles() {
        return mobiles;
    }

    public int getID() {
        return ID;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setElements(Element[][] elements) {
        this.elements = elements;
    }

    public void setMobiles(ArrayList<MobileElement> mobiles) {
        this.mobiles = mobiles;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
