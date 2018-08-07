
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InputTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class InputTest
{
    @Test
    public void testReadUrls(){
        Input test = new Input("testUrl.txt","commonWords.txt");
        String webSite = test.initialUrls.get(0).thisUrl;
        String expectedWebSite = "www.test.com";
        String textFile = test.initialUrls.get(0).com;
        String expectedTestFile = "test.txt";
        String priority = test.initialUrls.get(0).searchPriority;
        String expectedPriority = ("high");

        assertTrue(webSite.equals(expectedWebSite));
        assertTrue(textFile.equals(expectedTestFile));
        assertTrue(priority.equals(expectedPriority));
    }

    @Test
    public void testReadCommonWords(){

        Input test = new Input("testUrl.txt","commonWords.txt"); 
        String aCommonWord = "the";
        assertTrue(test.commonWords.contains(aCommonWord));
        String notACommonWord = "dog";
        assertFalse(test.commonWords.contains(notACommonWord));
    }

    @Test
    public void testReadWords(){
        Input test = new Input("testUrl.txt","commonWords.txt");
        test.readWords();
        Word word = test.makingWords.get(0);
        String expctedWebsite = "www.test.com";

        assertTrue(word.urlContainer.get(0).thisUrl.equals(expctedWebsite));

    }

    @Test 
    public void addToBase(){
        Input test = new Input("testUrl.txt","commonWords.txt");

        assertTrue(test.dataBase.treeMap.containsKey("test"));
        assertFalse(test.dataBase.treeMap.containsKey("dog"));
    }

    @Test
    public void searchWord(){
        Input test = new Input("testUrl.txt","commonWords.txt");
        Word test1 = new Word("test");
        assertTrue(test.searchWord(test1));
        
        
    }
}

