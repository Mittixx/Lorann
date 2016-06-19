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
	 * @param y
     */
	public void moveHero(int x, int y);

	/**
	 * move the monsters
	 */
	public void AIMonster();

	/**
	 * Test contact between monsters and elements
	 * @param x
	 * @param y
     * @return boolean
     */
	public boolean contactMonster(int x, int y);

	/**
	 * Test contact between the hero and the elements
	 * @param x
	 * @param y
     * @return boolean
     */
	public boolean contactHero(int x,int y);

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws IOException;
}
