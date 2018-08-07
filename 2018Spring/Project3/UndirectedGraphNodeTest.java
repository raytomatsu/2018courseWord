

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class UndirectedGraphNodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UndirectedGraphNodeTest
{
    @Test 
    public void testNodeNumber(){
        UndirectedGraphNode test = new UndirectedGraphNode(10);
        int expected = 10;
        assertEquals(expected,test.getNodeNumber());
    }
}
