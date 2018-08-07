
/**
 * This class is for the all the words found in the urls.  Each
 * word contains all the Urls found.  
 *
 * @author Ray Tomatsu
 * @version April 15, 2018
 */
import java.util.*;
public class Word
{
    String word;
    ArrayList<Url> urlContainer; 
    
    Word(String theWord){
        word = theWord;
        urlContainer = new ArrayList<Url>();
    }
    
    /**
     * this method checks if the url is already a part of this 
     * word or not.  
     * 
     * @Param the new Url coming in 
     */
    public boolean addUrl(Url url){
        if(urlContainer.contains(url)){
            return false;
        }
        else{
            urlContainer.add(url);
            return true;
        }
    }
}
