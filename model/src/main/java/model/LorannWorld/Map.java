package model.LorannWorld;

import contract.IElement;
import contract.IMap;
import contract.IMobileElement;
import model.LorannWorld.MobileElement.MobileElement;

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
    private ArrayList<IMobileElement> mobiles;
    /**
     * the Identifiant of the map
     **/
    private int ID;


    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public IElement[][] getElements() {
        return new IElement[0][];
    }

    public ArrayList<IMobileElement> getMobiles() {
        return null;
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

    public void setMobiles(ArrayList<IMobileElement> mobiles) {

    }

    public void setID(int ID) {

    }
}
