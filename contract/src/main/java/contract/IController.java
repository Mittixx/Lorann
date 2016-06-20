package contract;

import java.io.IOException;

/**
 * The Interface IController.
 *
 * @author Tanguy Blochet
 */
public interface IController {


	/**
	 * Move the hero
	 * @param x
	 * 			easting
	 * @param y
	 * 			northing
     */
	public void moveHero(int x, int y);

	/**
	 * move the monsters
	 */
	public void AIMonster();

	/**
	 * Test contact between monsters and elements
	 * @param x
	 * 			easting
	 * @param y
	 * 			northing
     * @return boolean
     */
	public boolean contactMonster(int x, int y);

	/**
	 * Test contact between the hero and the elements
	 * @param x
	 * 			easting
	 * @param y
	 * 			northing
     * @return boolean
     */
	public boolean contactHero(int x,int y);

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 * @throws IOException
	 * 				Can"t read the file.
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws IOException;
}
