package model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import model.LorannWorld.Element;
import model.LorannWorld.Map;
import model.LorannWorld.MobileElement.Hero;
import model.LorannWorld.MobileElement.MobileElement;
import model.LorannWorld.MobileElement.Monster;
import model.LorannWorld.MotionlessElement.*;
import model.dataBase.DAOGetMap;

/**
 * The Class Model.
 *
 * @author Tanguy Blochet
 */
public class Model extends Observable implements IModel {

	/**
	 * The map.
	 */
	private Map map;
	private DAOGetMap daoGetMap;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map =null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMap()
	 */
	public Map getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	private void setMap(final Map map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel(java.lang.String)
	 */
	public void loadMap(final int ID) {
		ResultSet resultSet=daoGetMap.query("{getElementMapByID}",ID);

		try {
			while (resultSet.next())
			{
				String name=resultSet.getString("name");
				if(name=="boneH")
				{
					MotionlessElement e= null;
					try {
						e = new BoneH(name);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					e.setX(resultSet.getInt("PosX"));
					e.setY(resultSet.getInt("PosY"));
				}
				else if(name=="boneC")
				{
					MotionlessElement e=new BoneC("name");
					e.setX(resultSet.getInt("PosX"));
					e.setY(resultSet.getInt("PosY"));
				}
				else if(name=="boneV")
				{
					MotionlessElement e=new BoneV("name");
					e.setX(resultSet.getInt("PosX"));
					e.setY(resultSet.getInt("PosY"));
				}
				else if(name=="purse")
				{
					MotionlessElement e=new Purse("name");
					e.setX(resultSet.getInt("PosX"));
					e.setY(resultSet.getInt("PosY"));
				}
				else if(name=="key")
				{
					MotionlessElement e=new Key("name");
					e.setX(resultSet.getInt("PosX"));
					e.setY(resultSet.getInt("PosY"));
				}
				else if(name=="lorann_b")
				{
					MobileElement e=new Hero("name");
					e.setX(resultSet.getInt("PosX"));
					e.setY(resultSet.getInt("PosY"));
				}
				else if(name=="monster")
				{
					MobileElement e=new Monster("name");
					e.setX(resultSet.getInt("PosX"));
					e.setY(resultSet.getInt("PosY"));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

}