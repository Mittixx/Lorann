package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Tanguy Blochet
 */
public interface IModel {

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	//Map getMap();

	/**
	 * Load the map.
	 *
	 * @param ID
	 *          the key
	 */
	void loadMap(int ID);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
