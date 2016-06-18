package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import javafx.scene.input.KeyCode;

/**
 * The Class View.
 *
 * @author Dimitri
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	public static ControllerOrder keyCodeToControllerOrder(final KeyEvent keyCode) {
		switch (keyCode.getKeyCode()) {
			case KeyEvent.VK_UP: case KeyEvent.VK_Z :
				return ControllerOrder.UP;
			case KeyEvent.VK_DOWN: case KeyEvent.VK_S :
				return ControllerOrder.DOWN;
			case KeyEvent.VK_LEFT: case KeyEvent.VK_Q :
				return ControllerOrder.LEFT;
			case KeyEvent.VK_RIGHT: case KeyEvent.VK_D :
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_SPACE:
				return ControllerOrder.SPACE;
			default:
				return ControllerOrder.DOWN;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
