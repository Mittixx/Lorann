package Controller;

import Controller.Mock.ModelMock;
import Controller.Mock.ViewMock;
import controller.Controller;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Romain on 20/06/2016.
 * @author Romain
 */
public class ControllerTest {

    Controller t;

    @Before
    public void setUp() throws Exception {
        this.t = new Controller(new ViewMock(), new ModelMock());
    }

    @Test
    public void moveHeroTest() throws Exception {

    }

    @Test
    public void contactMonsterTest() throws Exception {

    }

    @Test
    public void contactHeroTest() throws Exception {

    }

    @Test
    public void AIMonsterTest() throws Exception {

    }

    @Test
    public void orderPerformTest() throws Exception {

    }

    @Test
    public void gameOverTest() throws Exception {

    }

    @Test
    public void castSpellTest() throws Exception {

    }

    @Test
    public void isSpellTest() throws Exception {

    }

    @Test
    public void updateControllerTest() throws Exception {

    }

    @Test
    public void updateSpriteTest() throws Exception {

    }

    @Test
    public void moveSpellTest() throws Exception {

    }

    @Test
    public void moveSpellDirectionTest() throws Exception {

    }

    @Test
    public void destroySpellTest() throws Exception {

    }

    @Test
    public void destroyMonsterTest() throws Exception {

    }

    @Test
    public void canCastSpellTest() throws Exception {

    }

}