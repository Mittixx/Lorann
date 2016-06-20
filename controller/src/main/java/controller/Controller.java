package controller;

import contract.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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

	/**
	 * The monster to kill when hited by a spell
	 */
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

				if(model.getMap().getHero()!=null && monster.getX()==model.getMap().getHero().getX() && monster.getY()==model.getMap().getHero().getY() )
					gameOver();

				if(isSpell()) {
					if (monster.getX() == model.getMap().getSpell().getX() && monster.getY() == model.getMap().getSpell().getY()) {
						monsterToKill=monster;
						destroySpell();
						model.getMap().setScore(model.getMap().getScore()+500);
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


				//test if its a key
				else if(model.testType(model.getMap().getElement(x,y))==4)
				{
					model.getMap().setElement(x,y,null);	//deletes key

					for(IElement[] element:model.getMap().getElements())
					{

						for(IElement iElement:element)
						{		//Tests if its a door
							if(model.testType(iElement)==1)
								model.setDoor(iElement);

						}

					}
				}

				if(model.testType(model.getMap().getElement(x,y))==1 && model.getMap().getElement(x,y).getStateElement()==StateElement.DOOR)
				{
					//TODO lets win madafucka
					model.setMessage("YOU WIN !");
					model.flush();
					clock.setStopped(true);
				}
			}

			return true;
		}



		if(model.getMap().getElement(x,y).getStateElement()==StateElement.DRAGON)
					gameOver();


		 if((model.testType(model.getMap().getElement(x,y)))==1 && model.getMap().getElement(x,y).getStateElement()==StateElement.DOOR)
		{
			System.out.print("Porte de victoire !");
			model.setMessage("YOU WIN !");
			this.clock.setStopped(true);
			return true;


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
				if(model.getMap().getHero().getStateElement()!=StateElement.WEAK && canCastSpell(model.getMap().getHero().getDirection()))	//Test if it is able to cast a spell
				{
					castSpell(model.getMap().getHero().getDirection());
				}
			break;

			case RETRY:

				model.loadMap(model.getMap().getID());
				model.setMessage("");
			System.out.println(clock.isStopped());
				if(clock.isStopped())
				{
					clock=new Clock(this);
					clock.start();

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
		model.flush();

	}

	/**
	 * Create a spell if there is not already one on the map
	 * @param direction
	 * @throws IOException
     */
	public void castSpell(ControllerOrder direction) throws IOException {
		if(!isSpell())
		model.createSpell("fireball",direction);
		model.flush();


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
		destroyMonster(monsterToKill);
		model.flush();
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

	public synchronized void destroySpell(){

		model.getMap().getHero().setStateElement(StateElement.STRONG);

		model.getMap().setSpell(null);

		model.flush();
	}

	public synchronized void destroyMonster(IMobileElement monster)
	{
		model.getMap().getMobiles().remove(monster);
	}

	public boolean canCastSpell(ControllerOrder direction)
	{
		switch (direction)
		{
			case UP:
				if(model.getMap().getElement(model.getMap().getHero().getX(),model.getMap().getHero().getY()-1)==null)
				{
					return true;
				}
				break;
			case DOWN:
				if(model.getMap().getElement(model.getMap().getHero().getX(),model.getMap().getHero().getY()+1)==null)
				{
					return true;
				}
				break;
			case RIGHT:
			if(model.getMap().getElement(model.getMap().getHero().getX()+1,model.getMap().getHero().getY())==null)
			{
				return true;
			}
			break;

			case LEFT:
				if(model.getMap().getElement(model.getMap().getHero().getX()-1,model.getMap().getHero().getY())==null)
				{
					return true;
				}
				break;
			default:
				return false;
		}
		return false;
	}
}
