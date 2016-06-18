package contract;

import javax.naming.ldap.Control;
import java.io.IOException;
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
	IMap getMap();

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

	public void flush();

	public int testType(IElement element);

	public void setMessage(String message);

	public String getMessage();

	void createSpell(String path, ControllerOrder direction) throws IOException;

	}
