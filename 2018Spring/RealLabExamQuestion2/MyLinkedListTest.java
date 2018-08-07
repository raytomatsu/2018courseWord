

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MyLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyLinkedListTest
{
    @Test
    public void testReverse(){
        MyLinkedList test = new MyLinkedList();
        test.add(10);
        test.add(50);
        LinkedListNode expected1 = new LinkedListNode(10);
        
        assertEquals(test.head.whatItHolds, expected1.whatItHolds);
        test.reverse();
        
    }
}
