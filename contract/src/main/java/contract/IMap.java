package contract;

import java.util.ArrayList;

public interface IMap {

     void setWidth(int width);

     void setHeight(int height);

     void addElementToMap(IElement element, int x, int y);

     void setMobiles(ArrayList<IMobileElement> mobiles);

     void setElements (IElement[][] elements);

     void setElement(int x, int y,IElement element);

     void setScore(int score);

     int getScore();

     int getWidth();

     int getHeight();

     IElement getElement(int x, int y);

     IElement[][] getElements();

     ArrayList<IMobileElement> getMobiles();



     void setHeroPosition(int x, int y);

     IMobileElement getHero();

     void setHero(IMobileElement hero);

     IMobileElement getSpell();

     void setSpell(IMobileElement spell);


    }
