
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InputFileTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class InputFileTest
{
    @Test
    public void readFileStart(){
        InputFile test = new InputFile("teststartEnd.txt");
        int expected = 7;
        assertEquals(expected,test.getStart());

    }

    @Test
    public void readFileEnds(){
        InputFile test = new InputFile("teststartEnd.txt");
        int [] expectedEnd = {8,4,5};
        ArrayList<Integer> testEnd = test.getEnds();
        int [] testArray = new int [3];
        for(int i =0;i<testEnd.size();i++){
            testArray[i] = testEnd.get(i);
        }
        assertArrayEquals(expectedEnd,testArray);
    }
}
