package contract;

import java.util.ArrayList;

public interface IMap {

    public int getWidth();

    public int getHeight();

    public IElement getElement(int x, int y);

    public ArrayList<IMobileElement> getMobiles();

    public int getID();

    public void setHeroPosition(int x, int y);

    public IMobileElement getHero();


    }
