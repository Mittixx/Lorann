/**
 *
 */
package model;

import com.sun.istack.internal.NotNull;
import junit.framework.TestCase;
import model.LorannWorld.Map;
import model.dataBase.DAOGetMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class ModelTest.
 *
 * @author Tanguy Blochet
 */
public class ModelTest extends TestCase {
	private Model model;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model();

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
	 * Test method for {@link model.Model#loadMap(int ID)}.
	 */
	@Test
	public void testloadMap() {

		DAOGetMap daoGetMap=new DAOGetMap();
		assertNotNull(daoGetMap);
	}



}
