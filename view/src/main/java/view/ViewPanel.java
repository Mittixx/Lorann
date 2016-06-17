package view;

import java.awt.*;
import java.text.AttributedCharacterIterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.*;

/**
 * The Class ViewPanel.
 *
 * @author Dimitri
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		this.setSize(viewFrame.getWidth(),viewFrame.getHeight());


		viewFrame.getModel().getObservable().addObserver(this);
		repaint();
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, this.viewFrame.getWidth(), this.viewFrame.getHeight());
		int y;
		int x=0;
		for(IElement[] element: viewFrame.getModel().getMap().getElements())
		{
			y = 0;
			for(IElement e:element)
			{
				if(e!=null) {
					graphics.drawImage(e.getSprite().getImage(), x * 32 + 1, y * 32 + 1, null);
				}
				y++;
			}
			x++;
		}

		System.out.println(viewFrame.getModel().getMap().getHero().getY());

		System.out.println(viewFrame.getModel().getMap().getHero().getX());

		graphics.drawImage((viewFrame.getModel().getMap().getHero().getSprite().getImage()),viewFrame.getModel().getMap().getHero().getX()*32,viewFrame.getModel().getMap().getHero().getY()*32,null);

		/*for(IMobileElement mobileElement:viewFrame.getModel().getMap().getMobiles())
		{
			graphics.drawImage(mobileElement.getSprite().getImage(), mobileElement.getX() * 32 + 1, mobileElement.getY() * 32 + 1, null);
		}*/
    }
}
