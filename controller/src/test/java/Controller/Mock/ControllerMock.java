package Controller.Mock;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

import java.io.IOException;

/**
 * Created by Romain on 21/06/2016.
 */
public class ControllerMock implements IController {

    private IModel modelMock;

    public ControllerMock(IView view,IModel model) {
        this.setModel(model);
    }

    public void moveHero(int x, int y) {
        
    }

    public void AIMonster() {

    }

    public boolean contactMonster(int x, int y) {
        return false;
    }

    public boolean contactHero(int x, int y) {
        return false;
    }

    public void orderPerform(ControllerOrder controllerOrder) throws IOException {

    }

    /**
     * Sets the model.
     *
     * @param model
     *          the new model
     */
    private void setModel(final IModel model) {
        this.modelMock = model;
    }

}
