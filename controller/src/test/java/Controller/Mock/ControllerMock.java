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

    private IView view;

    public ControllerMock(ViewMock view,ModelMock model) {
        this.setModel(model);
        this.view=view;
    }

    public void moveHero(int x, int y) {
        this.modelMock.getMap().getHero().setX(modelMock.getMap().getHero().getX()+x);
        this.modelMock.getMap().getHero().setY(modelMock.getMap().getHero().getY()+y);
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
        this.modelMock =model;
    }

    public IModel getModelMock()
    {
        return  this.modelMock;
    }

}
