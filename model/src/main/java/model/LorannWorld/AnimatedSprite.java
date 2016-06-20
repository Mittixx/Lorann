package model.LorannWorld;

import contract.IAnimatedSprite;
import contract.ISprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The Class for the animated element
 * @author Tanguy Blochet
 * @version 15.06.2016
 */
public class AnimatedSprite extends Sprite implements IAnimatedSprite {
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
     * Instanciate a new AnimatedSprite.
     *
     * @param image
     *      The image.
     * @param images
     *      Board of the images' paths.
     */
    public AnimatedSprite(Image image, String[] images) {
        super(image);
        this.images = new Image[images.length];
        for(int i = 0; i<images.length; i++){
            try {
                // this.images[i] = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(images[i]));
               this.images[i] = ImageIO.read(new File("sprite/"+images[i]+".png"));
            } catch (IOException e) {
                System.err.println("Cannot load "+images[i]);
                e.printStackTrace();
            }
        }
        this.step = 0;
    }


    /**
     * Sets the image.
     *
     * @param images
     *      Board of images.
     */
    public void setImages(Image[] images) {
        this.images = images;
    }

    /**
     * Increments the steps.
     */
    public void next()
    {
        this.step++;
        if(this.step >= this.images.length){
            this.step = 0;
        }
        setImage(images[step]);
    }

    /**
     * Gets the Image.
     *
     * @return
     *      return the image in the board. It depends of the step.
     */
    public Image getImage() {
        return this.images[this.step];
    }
}
