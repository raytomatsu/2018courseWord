

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class randomPlayerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class randomPlayerTest
{
    @Test
    public void testDijkstra(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        test.Dijkstra();
        int expected = 5;
        int path = test.getShortestPaths().get(4);
        assertEquals(expected,path);
    }
    
    @Test 
    public void testNeighbors(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        
        assertEquals(test.neighbors(2).size(),3);
        assertTrue(test.neighbors(2).contains(1));
        assertTrue(test.neighbors(2).contains(3));
        assertTrue(test.neighbors(2).contains(4));
    }
    
    @Test 
    public void testWeight(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        
        assertEquals(test.weight(1,2),3);
        assertEquals(test.weight(2,1),3);
    }
    
    @Test
    public void testMinVertex(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        ArrayList<Integer> shortestPaths = new ArrayList<Integer>();
        shortestPaths.add(0,(int)(Integer.MAX_VALUE));
        for(int i = 1;i<=graph.getAmountNodes();i++){
            shortestPaths.add(i,(int)(Integer.MAX_VALUE));
        }
        int expected = 0;
        assertEquals(expected,test.minVertex(shortestPaths));
    }
    
    @Test 
    public void testCheckForExitN1(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        
        assertFalse(test.checkForExitN(1));
    }
    @Test 
    public void testCheckForExitN2(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(2);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        
        assertTrue(test.checkForExitN(1));
    }
    
    @Test
    public void testWhichExitN(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(2);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        int test1 = test.whichExitN(1);
        assertTrue(test1==(2));
        
    }
    
    @Test
    public void testCheckForExitD1(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        
        assertTrue(test.checkForExitD());
    }
    
    @Test
    public void testCheckForExitD2(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,1,1,ends);
        
        assertFalse(test.checkForExitD());
    }
    
    @Test
    public void testCheckForWhichD1(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        
        assertTrue(test.whichExitD() == 4);
    }
    
    @Test
    public void testExitPath1(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        
        assertTrue(test.exitPath(4) == 2);
    }
    
    @Test
    public void testExitPath2(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        
        assertTrue(test.exitPath(2) == 2);
    }
    
    @Test
    public void testString(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(4);
        randomPlayer test = new randomPlayer(graph,10,1,ends);
        
        assertTrue(test.toString().length()!=0);
        
    }
    
    @Test
    public void testAlgorithm2(){
        UndirectedGraph graph = new UndirectedGraph("testnodeFile.txt");
        ArrayList<Integer> ends = new ArrayList<Integer>();
        ends.add(2);
        randomPlayer test = new randomPlayer(graph,10,3,ends);
        
        test.algorithm(3);
        
        assertEquals(test.getWhereTo(),2);
    }
}
