
/**
 * This class creates a Url for all the Urls found.  It has 
 * multiple variables for each of the Url assigned 
 *
 * @author Ray Tomatsu 
 * @version April 15, 2018 
 */
import java.util.*;
import java.io.*;
public class Url implements Comparable <Url>
{
    float priority;
    String searchPriority;
    String com;
    String thisUrl;

    Url(String textFile, String thePriority, String theUrl){
        com = textFile;
        thisUrl = theUrl;
        nameThePriority(thePriority);
    }

    /**
     * This method assings this Urls variables corolating to the 
     * priority found in the url file.  For ex:  if it is high this url gets
     * the searchPriority "high" and priority 1.  
     * 
     * @Param the priority found in the file 
     */
    public boolean nameThePriority(String incomingPriority){
        if(incomingPriority.equals("high")){
            searchPriority = "high";
            priority = 1;
            return true;
        }
        else if(incomingPriority.equals("medium")){
            priority = (float)0.5;
            searchPriority = "medium";
            return true;
        }
        else if(incomingPriority.equals("low")){
            priority = (float) 0.2;
            searchPriority = "low";
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return thisUrl + " " + searchPriority;
    }

    /**
     * Adds 1 to the priority of this Url.  
     */
    public void addToPrioity(){
        this.priority = this.priority +1;
    }

    /**
     * Over rides the compare to method so that it would be based
     * on the priority when inserted into the Priority Queue  
     * 
     * 
     */
    public int compareTo(Url url){
        if(this.priority == url.priority){
            if(this.thisUrl.compareTo(url.thisUrl)<0){
                return 1;
            }
            else {
                return -1;
            }
        }
        else if(this.priority < url.priority){
            return 1;
        }
        else{
            return-1;
        }
    }
}
