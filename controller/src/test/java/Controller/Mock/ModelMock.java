package Controller.Mock;

import contract.ControllerOrder;
import contract.IElement;
import contract.IMap;
import contract.IModel;

import java.io.IOException;
import java.util.Observable;

/**
 * Created by Romain on 20/06/2016.
 */
public class ModelMock implements IModel {

    IMap map;
    public IMap getMap() {
        return this.map;
    }

    public void loadMap(int ID) {

    }

    public Observable getObservable() {
        return null;
    }

    public void flush() {

    }

    public int testType(IElement element) {
        return 0;
    }

    public void setMessage(String message) {

    }

    public String getMessage() {
        return null;
    }

    public void createSpell(String path, ControllerOrder direction) throws IOException {

    }

    public void setDoor(IElement element) {

    }
}
