package archeryGameOOP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player playerOne;
    private Player playerTwo;
    private Player playerThree;
    private Player playerFour;

    @BeforeEach
    void setUp() {
        playerOne = new Player();
        playerTwo = new Player();
        playerThree = new Player();
        playerFour = new Player();
    }

    @Test
    void testToGetPlayerNumber(){
        assertEquals(1, playerOne.getPlayerNumber());
        assertEquals(2, playerTwo.getPlayerNumber());
        assertEquals(3, playerThree.getPlayerNumber());
        assertEquals(4, playerFour.getPlayerNumber());
    }
    @Test
    void testThatPointIsGeneratedWhenAPlayerShoots(){
        int point = playerOne.shoot();
        assertEquals(0,point);
    }
    @Test
    void testThatPointsGeneratedWhenAPlayerShootsIsBetweenZeroToTen_ZeroAndTenInclusive(){
        assertTrue(playerOne.isAValidPoint());
    }
}