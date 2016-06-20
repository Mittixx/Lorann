package model.Mocks;

import contract.ISpell;
import contract.Permeability;
import contract.StateElement;

public class SpellMock extends ElementMock implements ISpell {
    public SpellMock(Permeability permeability, StateElement stateElement) {
        super(permeability, stateElement);
    }
}
