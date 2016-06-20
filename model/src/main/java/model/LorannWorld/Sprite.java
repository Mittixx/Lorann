package model.LorannWorld;

import contract.ISprite;

import java.awt.*;

/**
 * A sprite.
 * @author Romain
 */
public class Sprite implements ISprite{

    /** The sprite/Image*/
    private Image image;

    /**
     * Instantiate a new Sprite.
     *
     * @param image
     *      The image.
     */
    public Sprite(Image image) {
        this.image = image;
    }

    /**
     * Gets the Image.
     *
     * @return
     *      The image.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the image.
     *
     * @param image
     *      The image.
     */
    public void setImage(Image image) {
        this.image = image;
    }
}
