package controller;

import contract.*;

import static com.sun.deploy.trace.Trace.flush;
import static contract.Permeability.PENETRABLE;

/**
 * The Class Controller.
 *@author Romain
 */
public class Controller implements IController{

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/** The element of the Map. */
	private IMap map;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Move your character !");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}


	/**
	 * Move the hero.
	 * @param x
	 *		easting
	 * @param y
	 * 		northing
	 */
	public void moveHero(int x, int y){

		model.getMap().getHero().setX(model.getMap().getHero().getX() + x);
		model.getMap().getHero().setY(model.getMap().getHero().getY() + y);
		model.flush();
	}

	/**
	 *Contact between hero/monsters/items
	 *
	 *@param x
	 *		easting
	 * @param y
	 * 		northing
	 */
	public boolean contact(int x, int y){
		if(model.getMap().getElement(x, y) == null) return true;
		if((model.getMap().getElement(x, y).getPermeability()) == PENETRABLE){
			if(model.testType(model.getMap().getElement(x,y))==1)	//Door test
			{
				model.getMap().getElement(x,y).getStateMotionlessElement();
			}
			return true;
		}

		else {return false;}
	}

	/**
	 *
	 *Artificial Intelligence of the Monsters
	 */
	public void AIMonster(){
		for(IMobileElement monster : model.getMap().getMobiles()){
			double random = Math.random();
			if(random <= .25d && contact(model.getMap().getHero().getX(),model.getMap().getHero().getY() -1) == true){
				monster.setControllerOrder(ControllerOrder.UP);
				monster.setY(monster.getY()-1);
			}else if(random <= .50d && contact(model.getMap().getHero().getX() -1,model.getMap().getHero().getY()) == true){
				monster.setControllerOrder((ControllerOrder.LEFT));
				monster.setX(monster.getX()-1);
			}else if(random <= .75d && contact(model.getMap().getHero().getX(),model.getMap().getHero().getY() +1) == true){
				monster.setControllerOrder(ControllerOrder.DOWN);
				monster.setY(monster.getY()+1);
			}else if(random <= 1d && contact(model.getMap().getHero().getX() +1,model.getMap().getHero().getY()) == true){
				monster.setControllerOrder(ControllerOrder.RIGHT);
				monster.setX(monster.getX()+1);
			}
		model.flush();
		}
	}

	 /**
	  * Where the hero begins the level
	  *
	  * @param x
	  *		easting
	  * @param y
	  * 		northing
	 */
	public void heroStart(int x, int y){
		model.getMap().getHero();
	}

	/**
	 * Where the monsters begin the level
	 */
	public void monstersStart(){

	}


	/**
	 * Pick up user's action
	 * @param controllerOrder
	 *
     */
	public void orderPerform(ControllerOrder controllerOrder){

		switch (controllerOrder){
			case UP :
				if(contact(model.getMap().getHero().getX(),model.getMap().getHero().getY() -1) == true) {
					moveHero(0,-1);
				}
				break;
			case DOWN :
				if(contact(model.getMap().getHero().getX(),model.getMap().getHero().getY() +1) == true) {
					moveHero(0,+1);
				}
				break;
			case LEFT:
				if(contact(model.getMap().getHero().getX() -1,model.getMap().getHero().getY()) == true) {
					moveHero(-1,0);
				}
				break;
			case RIGHT:
				if(contact(model.getMap().getHero().getX() +1,model.getMap().getHero().getY()) == true) {
					moveHero(+1,0);
				}
				break;

			default:
		}
	}
}
