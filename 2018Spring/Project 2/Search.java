
/**
 * This class searches through tree map dealing with the words 
 * searched with the connectors "and" "or" or "-"; 
 *
 * @author Ray Tomatsu 
 * @version April 15, 2018 
 */
import java.util.*;
public class Search
{
    PriorityQueue<Url> printOutUrls;
    TreeMap<String,ArrayList<Url>> dataBase;
    TreeMap<String,ArrayList<Url>> clone;

    Search(){
        
    }
    Search(TreeMap<String,ArrayList<Url>> dataBase, String search){
        this.dataBase=dataBase;
        clone = new TreeMap<String,ArrayList<Url>> ();
        clone = (TreeMap)this.dataBase.clone();
        printOutUrls = new PriorityQueue<Url>();
        String [] listOfSearch1;
        String [] listOfSearch2;
        listOfSearch1 = search.toLowerCase().split(" ");

        if(contains(listOfSearch1,"or")){
            listOfSearch2 = search.toLowerCase().split(" or ");
            String firstHalf = listOfSearch2[0];
            readLines(firstHalf);
            String secondHalf =listOfSearch2[1];
            readLines(secondHalf);
        }
        else{
            String lowerCase = search.toLowerCase();
            readLines(lowerCase);
        }
    }
    
    /**
     * This reads the lines.  If it has a "and" connector it 
     * splits all the words with the "and" and finds all the Urls
     * connected with it.  
     * Also it takes in the consideration of the negated words and at the end, 
     * adds all the Urls without the negated words Url into the
     * Priority Queue of Urls.  
     * 
     * @param the lines it is reading 
     */

    public void readLines(String readingLines){
        String [] lineRead1 = readingLines.split(" ");

        if(contains(lineRead1,"and")){
            String [] lineRead2 = readingLines.split(" and ");
            ArrayList<String> lineRead2List = inToArrayList(lineRead2);
            ArrayList<String> negationWords = negationList(lineRead2List);
            if(containsInDataBase(lineRead2List) && containsInDataBase(negationWords)){
                addPriority(lineRead2List);
                ArrayList<Url> finishedWithAdd = readingAddLines(lineRead2List);
                ArrayList<Url> negationUrls = negationUrl(negationWords);
                ArrayList<Url> finalUrls = finalUrl(negationUrls,finishedWithAdd);
                inToPQ(finalUrls);
            }
            else {
                System.out.println("Not Found");
            }
        }
        else {
            if(clone.containsKey(readingLines)){
                ArrayList<Url> oneWord = clone.get(readingLines);
                inToPQ(oneWord);
            }
            else{
                System.out.println("Not Found");
            }
        }
    } 

    /**
     * this returns all the urls in the negated Words. 
     * 
     * @Param all the words that were negated 
     * @reuturn urls of the negated words 
     */
    public ArrayList<Url> negationUrl(ArrayList<String> negationString){
        ArrayList<Url> negationUrl = new ArrayList<Url>();
        for(int i =0; i<negationString.size(); i++){
            for(int j = 0; j<clone.get(negationString.get(i)).size();j++)
                negationUrl.add(clone.get(negationString.get(i)).get(j));
        }
        return negationUrl;
    }

    /**
     * This return the final urls without the negated word's Urls 
     * in it.  
     * 
     * @param negated word's Urls, and normal word's Urls
     * @return final Urls without negated word's Urls 
     */
    public ArrayList<Url> finalUrl(ArrayList<Url> negation, ArrayList<Url> andLine){
        ArrayList<Url> newUrl = new ArrayList<Url>();
        for(int i =0; i<andLine.size();i++){
            if(!negation.contains(andLine.get(i))){
                newUrl.add(andLine.get(i));
            }
        }
        return newUrl;
    }

    /**
     * Adds one everytime a word is found dealing with the "and"
     * connectors.  This allows so that if it "A and B and C", is inserterd
     * the urls that his the most words will be prioritized higher
     * 
     * @param the words connected with "and"
     */
    public void addPriority(ArrayList<String> andLine){
        for(int i = 0;i<andLine.size();i++){
            if(clone.containsKey(andLine.get(i))){
                for(int j = 0; j<clone.get(andLine.get(i)).size();j++){
                    clone.get(andLine.get(i)).get(j).addToPrioity();            
                }
            }
            else {
                System.out.println("Not Found");
            }
        }
    }

    /**
     * This returns all of the urls from the words that are connected 
     * with "and".
     * 
     * @param words that are not negated words 
     * @return urls from normal words  
     */
    public ArrayList<Url> readingAddLines(ArrayList<String> andLine){
        ArrayList<Url> urlsBeforeNegation = new ArrayList<Url>();
        for(int i =0; i<andLine.size(); i++){
            for(int j = 0; j<clone.get(andLine.get(i)).size();j++){
                if(!urlsBeforeNegation.contains(clone.get(andLine.get(i)).get(j))){
                    urlsBeforeNegation.add(clone.get(andLine.get(i)).get(j));
                }
            }
        }
        return urlsBeforeNegation;
    }

    /**
     * This method transters all the urls in to my priority queu
     * 
     * @param the final urls will be entered in here
     */
    public void inToPQ(ArrayList<Url> transfer){
        for(int i =0; i<transfer.size();i++){
            if(!printOutUrls.contains(transfer.get(i))){
                printOutUrls.add(transfer.get(i));
            }
        }
    }

    /**
     * This method checks if a certain variable is in my 
     * array of Strings
     * 
     * @param, the array of Strings to be checked and the variable 
     */
    public boolean contains(String [] check, String variable){
        for(int i = 0; i<check.length;i++){
            if(check[i].equals(variable)){
                return true;
            }
        }
        return false;
    }

    /**
     * This method simply transfers an String of arrays in to
     * and ArrayList of Strings 
     */
    public ArrayList<String> inToArrayList(String [] a){
        ArrayList<String> transfered = new ArrayList<String>();
        for(int i=0; i<a.length;i++){
            transfered.add(a[i]);
        }
        return transfered;
    }

    /**
     * This method returns all the negated words and removed from
     * the list with all the words in it.  
     */
    public ArrayList<String> negationList(ArrayList<String> list){
        ArrayList<String> negationList = new ArrayList<String>();
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).contains("-")){
                String withOutSign = list.get(i).substring(1);
                negationList.add(withOutSign);
                list.remove(list.get(i));
            }
        }
        return negationList;
    }

    /**
     * This method prinouts all the Urls in my Priority Queue 
     */
    public void printOut(){
        int i =0;
        if(printOutUrls.size()!=0){
            while(printOutUrls.size()!=0 && i<5){
                System.out.println(printOutUrls.remove());
                i++;
            }
        }
        else {
            System.out.println("nothing");
        }
    }

    /**
     * This method checks if the words in the ArrayList is 
     * contained in my dataBase.  
     */
    public boolean containsInDataBase(ArrayList <String> check){
        for(int i =0;i<check.size();i++){
            if(!clone.containsKey(check.get(i))){
                return false;
            }
        }
        return true;
    }
    
    
   
}
