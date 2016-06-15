package model.LorannWorld;

import model.LorannWorld.Sprite;

import java.awt.*;
/**
 * The Class for the animated element
 * @author Tanguy Blochet
 * @version 15.06.2016
 */
public class AnimatedSprite extends Sprite {
    /**
     * The images of the element
     */
    private Image[] images;
    /**
     * The maximum step corresponding to the number of sprite of the element
     */
    private int stepNumber;
    /**
     * The actual step of the loop
     */
    private int step;

    /**
     * Instanciate a new AnimatedSprite
     * @param image
     */
    public AnimatedSprite(Image image) {
        super(image);
    }

    /**
     * gets the image
     * @return images
     */
    public Image[] getImages() {
        return images;
    }
    /**
     * sets the image
     * @param images
     */

    public void setImages(Image[] images) {
        this.images = images;
    }
    /**
     * increments the step
     */
    public void next()
    {

    }
}
