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

		map=new Map(20,12);
		daoGetMap=new DAOGetMap();
		ResultSet resultSet=daoGetMap.query("{call getElementMapByID(?)}",ID);
		int monsterPlus=1;
		try {
			while (resultSet.next())
			{

				String name=resultSet.getString("name");
				System.out.println(name);
				if(name.equals("boneH"))
				{
					MotionlessElement e = new BoneH(name);
					map.addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));

				}
				else if(name.equals("boneC"))
				{
					MotionlessElement e=new BoneC(name);
					map.addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
				}
				else if(name.equals("boneV"))
				{
					MotionlessElement e=new BoneV(name);
					map.addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
				}
				else if(name.equals("purse"))
				{
					MotionlessElement e=new Purse(name);
					map.addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
				}
				else if(name.equals("key"))
				{
					MotionlessElement e=new Key(name);
					map.addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
				}
				else if(name.equals("lorann_b"))
				{
					MobileElement e=new Hero(name);
					e.setX(resultSet.getInt("PosX"));
					e.setY(resultSet.getInt("PosY"));
				}
				else if(name.equals("monster"))
				{
					switch(monsterPlus)
					{
						case(1):
						{
							MobileElement e=new Monster("monster_1");
							map.getMobiles().add(e);
							monsterPlus++;
						}
						case(2):
						{
							MobileElement e=new Monster(name+"_2");
							map.getMobiles().add(e);
							monsterPlus++;
						}
						case(3):
						{
							MobileElement e=new Monster(name+"_3");
							map.getMobiles().add(e);
							monsterPlus++;
						}
						case(4):
						{
							MobileElement e=new Monster(name+"_4");
							map.getMobiles().add(e);

						}
					}

				}
				else if (name.equals("door"))
				{
					MotionlessElement e=new Door(name);
					map.addElementToMap(e,resultSet.getInt("PosX"),resultSet.getInt("PosY"));
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