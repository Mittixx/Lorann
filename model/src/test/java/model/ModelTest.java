/**
 *
 */
package model;


import contract.IElement;
import contract.IMap;
import contract.Permeability;
import contract.StateElement;
import model.LorannWorld.Map;
import model.Mocks.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

import static org.junit.Assert.*;


/**
 * The Class ModelTest.
 *
 * @author Tanguy Blochet
 */
public class ModelTest implements Observer {

	/**
	 * The model.
	 */
	private ModelMock model;

	/**
	 * The nototified state.
	 */
	private boolean notified=false;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new ModelMock();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests the map getter.
	 * @throws Exception
     */
	@Test
	public void getMapTest() throws Exception {
		assertNotNull("Map can't be null",model.getMap());
	}

	/**
	 * Tests the loading of the map and its elements (hero, monster...).
	 * @throws Exception
     */
	@Test
	public void loadMapTest() throws Exception {
		model.loadMap(1);
		assertNotNull("ID map should not be null",model.getMap().getID());

		assertNotNull("Hero X position shouldn't be null",model.getMap().getHero().getX());
		assertNotNull("Hero Y position shouldn't be null",model.getMap().getHero().getY());
		assertNotNull("Elements should have at least an element",model.getMap().getElements());
		assertNotNull("Mobiles should contain at least one monster",model.getMap().getMobiles());

	}

	/**
	 * Called when observable is changed.
	 * @param o
	 * @param arg
     */
	public void update(Observable o, Object arg) {
		notified=true;
	}

	/**
	 * Tests to flush data from the observable.
	 */
	@Test
	public void flushTest() {
		model.addObserver(this);
		assertFalse("Should be notified after flush",notified);
		model.flush();
		assertTrue("Should be notified",notified);
	}

	/**
	 * Tests to gets the Observable (the model).
	 * @throws Exception
     */
	@Test
	public void getObservableTest() throws Exception {

		assertEquals("The model should be observable",this.model,model.getObservable());
	}

	/**
	 * Tests the instance of the element.
	 * @throws Exception
     */
	@Test
	public void testTypeTest() throws Exception {

		ElementMock element=new ElementMock(Permeability.PENETRABLE, StateElement.COLLECTABLE);

		assertNotEquals("Element should be an instance of ElementMock",2,model.testType(element));

		assertEquals("Element should be an instance of ElementMock",3,model.testType(element));

		ElementMock elementMock=new HeroMock();
		assertNotEquals("Element shouldn't be an instance of MonsterMock",2,model.testType(elementMock));
		assertEquals("Element should be an instance of HeroMock",1,model.testType(elementMock));

		MobileElementMock mobileElementMock=new MonsterMock();
		assertNotEquals("Element shouldn't be an instance of HeroMock",1,model.testType(mobileElementMock));
		assertEquals("Element should be an instance of MonsterMock",2,model.testType(mobileElementMock));

	}

	/**
	 * Tests the message getter.
	 * @throws Exception
     */
	@Test
	public void getMessageTest() throws Exception {
			assertNull("The message should be null",model.getMessage());
			model.setMessage("test");
			assertNotNull("The message shouldn't be null",model.getMessage());
	}

	/**
	 * Tests the message setter.
	 * @throws Exception
     */
	@Test
	public void setMessageTest() throws Exception {
		model.setMessage("Test");
		assertEquals("Message should be 'Test'","Test",model.getMessage());
	}

	@Test
	public void createSpellTest() throws Exception {
		ElementMock spell=new SpellMock(Permeability.PENETRABLE,StateElement.SPELL);

	}

	@Test
	public void setDoorTest() throws Exception {

	}


}
