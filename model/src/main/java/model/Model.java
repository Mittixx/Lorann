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
		daoGetMap=new DAOGetMap();
		ResultSet resultSet=daoGetMap.query("{call getElementMapByID(?)}",ID);

		try {
			while (resultSet.next())
			{
				String name=resultSet.getString("name");
				if(name=="boneH")
				{
					MotionlessElement e = new BoneH(name);

					this.getMap().addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));

				}
				else if(name=="boneC")
				{
					MotionlessElement e=new BoneC(name);
					this.getMap().addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
				}
				else if(name=="boneV")
				{
					MotionlessElement e=new BoneV(name);
					this.getMap().addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
				}
				else if(name=="purse")
				{
					MotionlessElement e=new Purse(name);
					this.getMap().addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
				}
				else if(name=="key")
				{
					MotionlessElement e=new Key(name);
					this.getMap().addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
				}
				else if(name=="lorann_b")
				{
					MobileElement e=new Hero(name);
					e.setX(resultSet.getInt("PosX"));
					e.setY(resultSet.getInt("PosY"));
				}
				else if(name=="monster")
				{
					MobileElement e=new Monster(name);
					this.getMap().getMobiles().add(e);
				}
				else if (name=="door")
				{
					MotionlessElement e=new Door(name);
					this.getMap().addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
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

	public void flush(){
		setChanged();
		notifyObservers();
	}


}