package controller;

import contract.*;

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
		Thread clock = new Thread(new Clock(this));
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
	public void moveHero(int x, int y){

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
	public boolean contactMonster(int x, int y){

		if(model.getMap().getElement(x, y) == null)
		{
			int notInContact=0;
			for(IMobileElement monster : model.getMap().getMobiles()) {
				
				if (monster.getX() != x && monster.getY() != y)
					notInContact++;

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
	public boolean contactHero(int x, int y){
		if(model.getMap().getElement(x, y) == null) return true;
		if((model.getMap().getElement(x, y).getPermeability()) == Permeability.PENETRABLE ){
			if(model.getMap().getElement(x,y).getStateElement()==StateElement.COLLECTABLE)
			{
				System.out.print("COLLECTABLE");
			}
			return true;
		}

		if(model.getMap().getElement(x,y).getStateElement()==StateElement.DEATH)
					model.setMessage("GAME OVER !");


		if(model.getMap().getElement(x,y).getStateElement()==StateElement.FIXED)
					System.out.print("FIXED");

		if(model.getMap().getElement(x,y).getStateElement()==StateElement.DRAGON)
					System.out.print("DRAGON");

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
	public void AIMonster(){
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

			case SPACE : //TODO inverse == to !=
				if(model.getMap().getHero().getStateElement()==StateElement.WEAK)	//Test if it is able to cast a spell
				{
					castSpell(model.getMap().getHero().getDirection());
				}
			break;
			default:
		}
	}

	public void gameOver()
	{
		model.setMessage("GAME OVER !");
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


	/**
	 * AI to move the spell
	 */
	public void moveSpell()
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

	public void moveSpellDirection(int x,int y) {

		if(isSpell()) //Check if the spell exist
		{
			int xHero = model.getMap().getHero().getX();
			int xSpell = model.getMap().getSpell().getX();
			int yHero = model.getMap().getHero().getY();
			int ySpell = model.getMap().getSpell().getY();

			if (xHero == xSpell && yHero == ySpell)
				destroySpell();

			if (y != 0) {

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
			} else if (x != 0) {
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
	}
	public void destroySpell(){

		model.getMap().getHero().setStateElement(StateElement.STRONG);

		model.getMap().setSpell(null);

		model.flush();
	}

}
