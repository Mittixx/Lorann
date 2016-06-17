package contract;

import java.awt.geom.Point2D;

public interface IElement {

    ISprite getSprite();

    void setSprite(ISprite sprite);

    public Permeability getPermeability();

    public void setPermeability(Permeability permeability);

    public IMap getMap();

    public void setMap(IMap map);

    public Point2D getSpawn();

    public void setSpawn(Point2D spawn);

    public StateMotionlessElement getStateMotionlessElement();

    public void setStateMotionlessElement(StateMotionlessElement doorState);

}




