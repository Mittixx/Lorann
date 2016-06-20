package model.LorannWorld.MobileElement;

import contract.*;
import model.LorannWorld.AnimatedSprite;
import model.LorannWorld.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The class Hero
 * @author Tanguy Blochet
 */
public class Hero extends MobileElement implements IAnimatedSprite {
    private AnimatedSprite sprites;
    /**
     *instanciate the hero
     */
    public Hero(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING, StateElement.WEAK);

        String imagesPaths[] = {
                "lorann_b",
                "lorann_bl",
                "lorann_l",
                "lorann_ul",
                "lorann_u",
                "lorann_ur",
                "lorann_r",
                "lorann_br",
        };

        sprites = new AnimatedSprite((ImageIO.read(new File("sprite/lorann_b.png"))),imagesPaths);
    }

    public void next() {
        sprites.next();
        setImage(sprites.getImage());
    }

    public Image getImage() {
        return sprites.getImage();
    }

    public void setImage(Image image) {
        this.getSprite().setImage(image);
    }
}
