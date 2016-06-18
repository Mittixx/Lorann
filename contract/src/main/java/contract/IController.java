package contract;

import java.io.IOException;

/**
 * The Interface IController.
 *
 * @author Tanguy Blochet
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	public void moveHero(int x, int y);

	public void AIMonster();

	public boolean contactMonster(int x, int y);

	public boolean contactHero(int x,int y);

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws IOException;
}
