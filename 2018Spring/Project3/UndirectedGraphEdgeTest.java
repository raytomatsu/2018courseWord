

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UndirectedGraphEdgeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UndirectedGraphEdgeTest
{
    @Test 
    public void testDestinationAndCost(){
        UndirectedGraphEdge test = new UndirectedGraphEdge(5, 10);
        int expectedDestination = 5;
        int expectedCost = 10;
        assertEquals(test.getCost(),expectedCost);
        assertEquals(test.getDestination(),expectedDestination);
    }
    @Test public void testToString(){
        UndirectedGraphEdge test = new UndirectedGraphEdge(5, 10);
        
        assertTrue(test.toString().length()!=0);
    }
}
