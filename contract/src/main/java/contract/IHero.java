package contract;

import java.awt.*;

/**
 * Created by Romain on 20/06/2016.
 */
public interface IHero {

    /**
     * Increments the value to run through the images
     */
    void next();

    /**
     * Gets the Image.
     *
     * @return
     *      Image.
     */
    Image getImage();

    /**
     * Sets the Image.
     * @param image
     */
    public void setImage(Image image);


    }
