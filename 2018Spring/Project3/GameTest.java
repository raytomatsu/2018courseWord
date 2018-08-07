

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GameTest
{
    @Test
    public void testDiceRoll(){
        PlayerContainer players = new PlayerContainer();
        Game test = new Game(players,1);
        int expected = 1;
        assertEquals(expected,test.diceRoll());
    }
}
