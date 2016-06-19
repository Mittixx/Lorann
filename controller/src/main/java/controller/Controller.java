package controller;

import contract.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The Class Controller.
 *@author Romain
 */
public class Controller implements IController{

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * The clock
	 */
	private Clock clock;

	private IMobileElement monsterToKill;
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
		clock=new Clock(this);
		clock.start();
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
	public synchronized void moveHero(int x, int y){

		model.getMap().getHero().setX(model.getMap().getHero().getX() + x);
		model.getMap().getHero().setY(model.getMap().getHero().getY() + y);
		model.flush();
	}

	/**
	 *Contact between the monsters and the elements
	 *
	 *@param x
	 *		easting
	 * @param y
	 * 		northing
	 */
	public synchronized boolean contactMonster(int x, int y){

		if(model.getMap().getElement(x, y) == null && model.getMap().getHero()!=null)
		{
			int notInContact=0;

			for(IMobileElement monster : model.getMap().getMobiles()) {
				
				if (monster.getX() != x && monster.getY() != y)
					notInContact++;

				if(monster.getX()==model.getMap().getHero().getX() && monster.getY()==model.getMap().getHero().getY() && model.getMap().getHero()!=null)
					gameOver();

				if(isSpell()) {
					if (monster.getX() == model.getMap().getSpell().getX() && monster.getY() == model.getMap().getSpell().getY()) {
						monsterToKill=monster;
					}
				}
			}


			if(notInContact>=model.getMap().getMobiles().size()-1)
			{
				return true;
			}
		}


		return false;
	}

	/**
	 *Contact between the hero and the elements
	 *
	 *@param x
	 *		easting
	 * @param y
	 * 		northing
	 */
	public synchronized boolean contactHero(int x, int y){
		if(model.getMap().getElement(x, y) == null) return true;
		if((model.getMap().getElement(x, y).getPermeability()) == Permeability.PENETRABLE ){
			if(model.getMap().getElement(x,y).getStateElement()==StateElement.COLLECTABLE )
			{
				if(model.testType(model.getMap().getElement(x,y))==2)
				{
					model.getMap().setElement(x,y,null);
					model.getMap().setScore(model.getMap().getScore()+100);
					model.flush();
				}



				else if(model.testType(model.getMap().getElement(x,y))==4)
				{
					System.out.println("KEY");
				}
			}

			return true;
		}


		if(model.getMap().getElement(x,y).getStateElement()==StateElement.FIXED)
					System.out.print("FIXED");

		if(model.getMap().getElement(x,y).getStateElement()==StateElement.DRAGON)
					gameOver();

		if(model.getMap().getElement(x,y).getStateElement()==StateElement.SPELL)
					System.out.print("SPELL");

		 if((model.testType(model.getMap().getElement(x,y)))==1 )
		{
			System.out.print("DOOR");
			gameOver();
			return false;
		}

		else {return false;}


	}

	/**
	 *
	 *Artificial Intelligence of the Monsters
	 */
	public synchronized void AIMonster(){

		for(IMobileElement monster : model.getMap().getMobiles()){
			double random = Math.random();
			if(random <= .25d && contactMonster(monster.getX(),monster.getY() -1)){
				monster.setDirection(ControllerOrder.UP);
				monster.setY(monster.getY()-1);
			}else if(random <= .50d && contactMonster(monster.getX() -1,monster.getY())){
				monster.setDirection((ControllerOrder.LEFT));
				monster.setX(monster.getX()-1);
			}else if(random <= .75d && contactMonster(monster.getX(),monster.getY() +1)){
				monster.setDirection(ControllerOrder.DOWN);
				monster.setY(monster.getY()+1);
			}else if(random <= 1d && contactMonster(monster.getX() +1,monster.getY())){
				monster.setDirection(ControllerOrder.RIGHT);
				monster.setX(monster.getX()+1);
			}
		destroyMonster(monsterToKill);
		model.flush();
		}
	}

	/**
	 * Pick up user's action
	 * @param controllerOrder
	 *
     */
	public void orderPerform(ControllerOrder controllerOrder) throws IOException {
		switch (controllerOrder){
			case UP :
				if(contactHero(model.getMap().getHero().getX(),model.getMap().getHero().getY() -1)) {
					model.getMap().getHero().setDirection(ControllerOrder.UP);
					moveHero(0,-1);

				}
				break;
			case DOWN :
				if(contactHero(model.getMap().getHero().getX(),model.getMap().getHero().getY() +1)) {
					model.getMap().getHero().setDirection(ControllerOrder.DOWN);
					moveHero(0,+1);

				}
				break;
			case LEFT:
				if(contactHero(model.getMap().getHero().getX() -1,model.getMap().getHero().getY())) {
					model.getMap().getHero().setDirection(ControllerOrder.LEFT);
					moveHero(-1,0);

				}
				break;
			case RIGHT:
				if(contactHero(model.getMap().getHero().getX() +1,model.getMap().getHero().getY())) {
					model.getMap().getHero().setDirection(ControllerOrder.RIGHT);
					moveHero(+1,0);

				}
				break;

			case SPACE :
				if(model.getMap().getHero().getStateElement()!=StateElement.WEAK)	//Test if it is able to cast a spell
				{
					castSpell(model.getMap().getHero().getDirection());
				}
			break;

			case RETRY:

				model.loadMap(model.getMap().getID());
			System.out.println(clock.isStopped());
				if(clock.isStopped())
				{
					clock.setStopped(false);
					clock.run();
				}

				System.out.println(clock.isStopped());

				model.flush();
			default:
		}
	}

	/**
	 * Sets the message to Game over
	 *
	 * */
	public void gameOver()
	{
		model.setMessage("GAME OVER !");
		this.clock.setStopped(true);
		model.getMap().setHero(null);

	}

	/**
	 * Create a spell if there is not already one on the map
	 * @param direction
	 * @throws IOException
     */
	public void castSpell(ControllerOrder direction) throws IOException {
		if(!isSpell())
		model.createSpell("fireball",direction);


	}

	public boolean isSpell()
	{
		if(model.getMap().getSpell()!=null)
			return true;

		return false;
	}

	public synchronized void updateController()
	{
		AIMonster();
		moveSpell();
	}

	/**
	 * AI to move the spell
	 */
	public synchronized void moveSpell()
	{

		if(isSpell())  //Check if the spell exist
		{


			switch (model.getMap().getSpell().getDirection()) {
				case DOWN:
					moveSpellDirection(0, 1);
					break;

				case UP:
					moveSpellDirection(0, -1);
					break;

				case LEFT:
					moveSpellDirection(-1, 0);
					break;

				case RIGHT:
					moveSpellDirection(1, 0);
					break;

			}
			model.flush();
		}
	}

	public synchronized void moveSpellDirection(int x,int y) {

			int xHero = model.getMap().getHero().getX();
			int xSpell = model.getMap().getSpell().getX();
			int yHero = model.getMap().getHero().getY();
			int ySpell = model.getMap().getSpell().getY();

			if (xHero == xSpell && yHero == ySpell)
				destroySpell();

			if (y != 0 && isSpell()) {

				if (model.getMap().getElement(model.getMap().getSpell().getX(), model.getMap().getSpell().getY() + y) == null)
					model.getMap().getSpell().setY(model.getMap().getSpell().getY() + y);

				else {
					model.getMap().getSpell().setY(model.getMap().getSpell().getY() - y);


					if (model.getMap().getSpell().getDirection() == ControllerOrder.UP)
						model.getMap().getSpell().setDirection(ControllerOrder.DOWN);
					else {
						model.getMap().getSpell().setDirection(ControllerOrder.UP);
					}
				}
			} else if (x != 0 && isSpell()) {
				//If there is no element next to the spell
				if (model.getMap().getElement(model.getMap().getSpell().getX() + x, model.getMap().getSpell().getY()) == null)
					model.getMap().getSpell().setX(model.getMap().getSpell().getX() + x);

					//If there is an element next to the spell
				else {
					model.getMap().getSpell().setX(model.getMap().getSpell().getX() - x);

					if (model.getMap().getSpell().getDirection() == ControllerOrder.LEFT)
						model.getMap().getSpell().setDirection(ControllerOrder.RIGHT);
					else {
						model.getMap().getSpell().setDirection(ControllerOrder.LEFT);
					}
				}
			}

		}

	public void destroySpell(){

		model.getMap().getHero().setStateElement(StateElement.STRONG);

		model.getMap().setSpell(null);

		model.flush();
	}

	public void destroyMonster(IMobileElement monster)
	{
		model.getMap().getMobiles().remove(monster);
	}

}
