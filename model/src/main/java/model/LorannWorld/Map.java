package model.LorannWorld;

import contract.IElement;
import contract.IMap;
import contract.IMobileElement;

import java.util.ArrayList;

/**
* The class Map
 *
 * @author Tanguy Blochet
 * @version 15.06.2016
 **/
public class Map implements IMap{
    /**
    * The width of the map.
     **/
    private int width=20;
    /**
     * The height of the map.
     **/
    private int height=12;
    /**
     * The static elements of the ma.
     **/
    private IElement[][] elements;
    /**
     * The mobile elements of the map.
     **/
    private ArrayList<IMobileElement> mobiles;


    /**
     * The score of the map.
     **/
    private int score=0;
    /**
     * The ID of the map.
     */
    private int ID;

    /**
     * The hero of the map.
     */
    private IMobileElement hero;

    /**
     * The spell.
     */
    private IMobileElement spell;


    /**
     * Instantiates a new map.
     * @param height
     * @param width
     */
    public Map(int height, int width) {

        this.height = height;
        this.width = width;
        elements=new Element[this.height][this.width];
        mobiles=new ArrayList<IMobileElement>();
    }

    /**
     * gets an element at a position
     * @param x
     * @param y
     * @return an element of the map
     */
    public IElement getElement(int x, int y) {
        return elements[x][y];
    }

    /**
     * sets an element on the map
     * @param x
     * @param y
     * @param element
     */
    public void setElement(int x, int y,IElement element){
        this.elements[x][y]=element;
    }

    /**
     * gets all the elements of the map
     * @return the elements of the map
     */
    public IElement[][] getElements() {
        return elements;
    }

    /**
     * gets the mobiles elements of the map
     * @return mobiles elements
     */
    public ArrayList<IMobileElement> getMobiles() {
        return mobiles;
    }



    /**
     * add an element at a position on the ma
     * @param element
     * @param x
     * @param y
     */
    public void addElementToMap(IElement element, int x, int y)
    {
        this.elements[x][y]=element;
    }


    /**
     * sets the score on this map
     * @param score
     */
    public void setScore(int score) {
        this.score=score;
    }

    /**
     * gets the score on this map
     * @return
     */
    public int getScore() {
        return this.score;
    }

    /**
     * gets the ID of the map
     * @return the map ID
     */
    public int getID() {
        return ID;
    }

    /**
     * sets the ID of the map
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * sets the hero position
     * @param x
     * @param y
     */
    public void setHeroPosition(int x, int y){
        this.hero.setX(x);
        this.hero.setY(y);
    }

    /**
     * gets the hero of the map
     * @return the hero
     */
    public IMobileElement getHero(){
        return this.hero;
    }

    /**
     * sets the hero of the map
     * @param hero
     */
    public void setHero(IMobileElement hero) {
        this.hero = hero;
    }


    /**
     * gets the spell of the map
     * @return the spell
     */
    public IMobileElement getSpell() {
        return spell;
    }

    /**
     * sets the spell on the map
     * @param  spell
     */
    public void setSpell(IMobileElement spell) {
        this.spell = spell;
    }


}
