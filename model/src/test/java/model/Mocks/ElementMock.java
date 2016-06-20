package model.Mocks;

import contract.IElement;
import contract.ISprite;
import contract.Permeability;
import contract.StateElement;

public class ElementMock implements IElement {
    /**
     * The image of the element.
     */
    private ISprite sprite;

    /**
     * The permeability of the element.
     */
    private Permeability permeability;

    /**
     * The state of the element.
     */
    private StateElement stateElement;

    public ElementMock(Permeability permeability,StateElement stateElement) {
        this.permeability = permeability;
        this.stateElement=stateElement;

    }

    public ISprite getSprite() {
        return this.sprite;
    }

    public void setSprite(ISprite sprite) {
        this.sprite=sprite;
    }

    public Permeability getPermeability() {
        return this.permeability;
    }

    public void setPermeability(Permeability permeability) {
        this.permeability=permeability;
    }

    public StateElement getStateElement() {
        return this.stateElement;
    }

    public void setStateElement(StateElement stateElement) {
        this.stateElement=stateElement;
    }
}
