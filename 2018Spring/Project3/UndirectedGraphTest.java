

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UndirectedGraphTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class UndirectedGraphTest
{
    @Test
    public void testAddFromFiles(){
        UndirectedGraph test = new UndirectedGraph("testnodeFile.txt");
        test.addFromFiles();
        int expectedDestination = 2;
        assertEquals(expectedDestination,test.getNodeValues().get(1).getEdges().get(0).getDestination());
        int expectedCost = 3;
        assertEquals(expectedCost,test.getNodeValues().get(1).getEdges().get(0).getCost());
        int expectedVertex = 1;
        assertEquals(expectedVertex,test.getNodeValues().get(1).getNodeNumber());
    }
    @Test
    public void testNumberOfNodes(){
        UndirectedGraph test = new UndirectedGraph("testnodeFile.txt");
        int expected = 4;
        assertEquals(expected,test.numberOfNodes());
    }
   
    @Test 
    public void testAddEdges(){
        UndirectedGraph test = new UndirectedGraph("testnodeFile.txt");
        int expectedDestination = 2;
        assertEquals(expectedDestination,test.getNodeValues().get(1).getEdges().get(0).getDestination());
        int expectedCost = 3;
        assertEquals(expectedCost,test.getNodeValues().get(1).getEdges().get(0).getCost());
        int expectedVertex = 1;
        assertEquals(expectedVertex,test.getNodeValues().get(1).getNodeNumber());
        
        assertEquals(test.getNodeValues().get(2).getEdges().get(0).getDestination(),1);
        assertEquals(test.getNodeValues().get(2).getEdges().get(1).getDestination(),3);
        assertEquals(test.getNodeValues().get(2).getEdges().get(2).getDestination(),4);
    }
    @Test 
    public void testToString(){
        UndirectedGraph test = new UndirectedGraph("testnodeFile.txt");
        
        assertTrue(test.toString().length()!=0);
    }
    
}
