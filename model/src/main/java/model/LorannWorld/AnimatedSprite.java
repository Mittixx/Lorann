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
     * Instanciate a new AnimatedSprite
     * @param image
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
     * gets the image
     * @return images
     */
   /* public Image[] getImages() {
        return images;
    } */

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
        this.step++;
        if(this.step >= this.images.length){
            this.step = 0;
        }
        setImage(images[step]);
    }

    @Override
    public Image getImage() {
        return this.images[this.step];
    }
}
