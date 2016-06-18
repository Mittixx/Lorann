package model.LorannWorld;

import contract.*;

import java.awt.geom.Point2D;

/**
 * The class Element
 * @author Tanguy Blochet
 * @version 15.06.2016
 */
public class Element implements IElement {
    /**
     * The image of the element
     */
    private ISprite sprite;
    /**
     * The permeability of the element
     */
    private Permeability permeability;
    /**
     * The map wich contains the element
     */
    private IMap map;
    /**
     * The point where the element will spawn
     */
    private Point2D spawn;

    private StateElement stateElement;


    public Element(ISprite sprite, Permeability permeability,StateElement stateElement) {
        this.sprite = sprite;
        this.permeability = permeability;
        this.stateElement=stateElement;
    }

    public ISprite getSprite() {
        return this.sprite;
    }

    public void setSprite(ISprite sprite) {

    }


    public Permeability getPermeability() {
        return this.permeability;
    }

    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }

    public IMap getMap() {
        return map;
    }

    public void setMap(IMap map) {
        this.map = map;
    }

    public Point2D getSpawn() {
        return spawn;
    }

    public void setSpawn(Point2D spawn) {
        this.spawn = spawn;
    }

    /**
     * gets the Element's state
     * @return stateElement
     */
    public StateElement getStateElement() {
        return this.stateElement;
    }

    /**
     * sets the Element's state
     * @param stateElement
     */
    public void setStateElement(StateElement stateElement) {
        this.stateElement = stateElement;
    }


}
