package contract;

import java.util.ArrayList;

public interface IMap {

    public void setWidth(int width);

    public void setHeight(int height);

    public void addElementToMap(IElement element, int x, int y);

    public void setMobiles(ArrayList<IMobileElement> mobiles);

    public void setElements (IElement[][] elements);

    public void setID(int ID);

    public int getWidth();

    public int getHeight();

    public IElement getElement(int x, int y);

    public IElement[][] getElements();

    public ArrayList<IMobileElement> getMobiles();

    public int getID();

    public void setHeroPosition(int x, int y);

    public IMobileElement getHero();

    public void setHero(IMobileElement hero);


    }
