

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WordTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WordTest
{
    @Test
    public void testAddUrl(){
        Word testWord = new Word("test");
        Url testUrl = new Url("test.txt","high","www.test.com");
        assertTrue(testWord.addUrl(testUrl));
        assertFalse(testWord.addUrl(testUrl));
    }
    
}
