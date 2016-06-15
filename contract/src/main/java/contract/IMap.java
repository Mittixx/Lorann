package contract;

import java.util.ArrayList;

public interface IMap {

    public int getWidth();

    public int getHeight();

    public IElement[][] getElements();

    public ArrayList<IMobileElement> getMobiles();

    public int getID();

}
