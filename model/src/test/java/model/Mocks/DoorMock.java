package model.Mocks;

import contract.IDoor;
import contract.Permeability;
import contract.StateElement;

public class DoorMock extends ElementMock implements IDoor {
    public DoorMock(Permeability permeability, StateElement stateElement) {
        super(permeability, stateElement);
    }
}
