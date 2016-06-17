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

    private StateMotionlessElement stateMotionlessElement;


    public Element(ISprite sprite, Permeability permeability) {
        this.sprite = sprite;
        this.permeability = permeability;
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

    public StateMotionlessElement getStateMotionlessElement() {
        return stateMotionlessElement;
    }

    public void setStateMotionlessElement(StateMotionlessElement stateMotionlessElement) {
        this.stateMotionlessElement = stateMotionlessElement;
    }
}
