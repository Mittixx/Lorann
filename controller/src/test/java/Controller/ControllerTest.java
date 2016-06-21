package Controller;

import Controller.Mock.ControllerMock;
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

    ControllerMock t;

    @Before
    public void setUp() throws Exception {
        this.t = new ControllerMock(new ViewMock(), new ModelMock());
    }

    @Test
    public void moveHeroTest() throws Exception {
        assertNotNull("Hero should not be null",t.getModelMock().getMap().getHero());

        int heroPositionBefore=t.getModelMock().getMap().getHero().getX();  //stock position of the hero before move
        t.moveHero(1,0);
        assertNotEquals("X position should be different",heroPositionBefore,t.getModelMock().getMap().getHero().getX());
        assertEquals("X should be the same",heroPositionBefore+1,t.getModelMock().getMap().getHero().getX());
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