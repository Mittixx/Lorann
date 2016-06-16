package controller;

import contract.*;

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

	private IMobileElement hero;

	private IMap element;

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

		model.getMap().getHero().setY();
		/*hero.setX(hero.getX()+x);
		hero.setY(hero.getY()+y);
		this.setChanged();
		this.notifyObservers();*/

	}

	/**
	 *
	 *Artificial Intelligence of the Monsters
	 */
	public void AIMonster(){

	}

	/**
	 *Contact between hero/monsters/items
	 */
	public boolean contact(int x, int y){
		if((element.getElement(x, y).getPermeability()) == PENETRABLE){
			return true;
		}

		return false;
	}

	/**
	 * Where the hero begins the level
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
				System.out.println(" I'M GOING UP !");
				if(contact(model.getMap().getHero().getX(),model.getMap().getHero().getY() -1) == true) {
					moveHero(0,-1);
				}
				break;
			case DOWN :
				System.out.println(" I'M GOING DOWN !");
				if(contact(model.getMap().getHero().getX(),model.getMap().getHero().getY() +1) == true) {
					moveHero(0,+1);
				}
				break;
			case LEFT:
				System.out.println(" I'M GOING LEFT !");
				if(contact(model.getMap().getHero().getX() -1,model.getMap().getHero().getY()) == true) {
					moveHero(-1,0);
				}
				break;
			case RIGHT:
				System.out.println(" I'M GOING RIGHT !");
				if(contact(model.getMap().getHero().getX() +1,model.getMap().getHero().getY()) == true) {
					moveHero(+1,0);
				}
				break;

			default:
				System.out.println(" I'M NOT MOVING !");
		}
	}
}
