

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerContainerTest
{
    @Test
    public void testInitilizePlayers(){
        UndirectedGraph fileGraph = new UndirectedGraph("");
        InputFile input = new InputFile("");
        PlayerContainer test = new PlayerContainer(1,5,fileGraph,input);
        int expected = 5;
        
        assertEquals(expected,test.getAllPlayers().size());
    }
}
