package model.LorannWorld;

import java.awt.geom.Point2D;

/**
 * The class Element
 */
public class Element {
    /**
     * The image of the element
     */
    private Sprite sprite;
    /**
     * The permeability of the element
     */
    private Permeability permeability;
    /**
     * The map wich contains the element
     */
    private Map map;
    /**
     * The point where the element will spawn
     */
    private Point2D spawn;

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Permeability getPermeability() {
        return permeability;
    }

    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Point2D getSpawn() {
        return spawn;
    }

    public void setSpawn(Point2D spawn) {
        this.spawn = spawn;
    }
}
