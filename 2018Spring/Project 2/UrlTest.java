

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UrlTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UrlTest
{
    @Test
    public void testNameThePriority1(){
        Url test = new Url("test.txt","high","www.test.com");
        assertTrue(test.searchPriority.equals("high"));
        assertTrue(test.priority == 1);
    }
    @Test
    public void testNameThePriority2(){
        Url test = new Url("test.txt","medium","www.test.com");
        assertTrue(test.searchPriority.equals("medium"));
        assertTrue(test.priority == 0.5);
    }
    
    @Test
    public void testNameThePriority3(){
        Url test = new Url("test.txt","low","www.test.com");
        assertTrue(test.searchPriority.equals("low"));
    }
    
    @Test
    public void addToPriority(){
        Url test = new Url("test.txt","high","www.test.com");
        test.addToPrioity();
        assertTrue(test.priority == 2);
    }
    
}
