

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.*;


/**
 * The test class SearchTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SearchTest
{
    @Test
    public void testReadingLines(){
        Input test = new Input("testUrl.txt","commonWords.txt");
        Search searchTest = new Search(test.dataBase.treeMap,"test and junit");
        
        assertTrue(searchTest.printOutUrls.peek().searchPriority.equals("high"));
    }
    
    @Test
    public void testNegationUrl(){
        Input test = new Input("testUrl.txt","commonWords.txt");
        Search searchTest = new Search(test.dataBase.treeMap,"test and -junit");
        ArrayList<String> words = new ArrayList<String>();
        words.add("test");
        
        ArrayList<Url> experiment = searchTest.negationUrl(words);
        
        assertTrue(experiment.get(0).searchPriority.equals("high"));
        
    }
    
    @Test
    public void testFinalUrl(){
        ArrayList<Url> negationUrl = new ArrayList<Url>();
        ArrayList<Url> otherUrl = new ArrayList<Url>();
        Search searchTest = new Search();
        Url first = new Url("dog.txt","medium","www.dog.com");
        negationUrl.add(first);
        otherUrl.add(first);
        
        ArrayList<Url> test = searchTest.finalUrl(negationUrl,otherUrl);
        
        assertFalse(test.contains(first));
    }
    
    @Test 
    public void testReadingAddLines(){
        Input test = new Input("testUrl.txt","commonWords.txt");
        Search searchTest = new Search(test.dataBase.treeMap,"test and -junit");
        ArrayList<String> yeet = new ArrayList<String>();
        yeet.add("test");
        
        ArrayList<Url> test2 = searchTest.readingAddLines(yeet);
        
        assertFalse(test2.get(0).searchPriority.equals("low"));
    }
    
    @Test
    public void testInToPQ(){
        Input test = new Input("testUrl.txt","commonWords.txt");
        Search searchTest = new Search(test.dataBase.treeMap,"test and junit");
        
        assertTrue(searchTest.printOutUrls.peek().searchPriority.equals("high"));
        
    }
    
    @Test
    public void testContains(){
        String a [] = new String[1];
        a[0] = "word";
        String test = "word";
        Search search = new Search();
        
        assertTrue(search.contains(a,test));
        
    }
    
    @Test
    public void testIntoArrayList(){
        Search search = new Search();
        String a [] = new String[1];
        a[0] = "word";
        
        ArrayList<String> test = search.inToArrayList(a);
        
        assertTrue(test.contains("word"));
    }
    
    @Test
    public void testNegationList(){
        ArrayList<String> test = new ArrayList<String>();
        test.add("word");
        test.add("-test");
        
        Search search = new Search();
        ArrayList<String> negation = search.negationList(test);
        
        assertTrue(negation.contains("test"));
        
    }
    @Test
    public void testContainsInDataBase(){
        Input test = new Input("testUrl.txt","commonWords.txt");
        Search searchTest = new Search(test.dataBase.treeMap,"test and junit");
        ArrayList<String> test1 = new ArrayList<String>();
        test1.add("test");
        assertTrue(searchTest.containsInDataBase(test1));
    }
}
