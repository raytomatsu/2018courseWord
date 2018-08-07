
/**
 * This is a class for creating the data base from the textFiles 
 * that was brought in to the program.  
 * 
 * @author Ray Tomatsu
 * @version April 15, 2018
 */
import java.io.*;
import java.util.*;

public class Input
{
    ArrayList<Url> initialUrls;
    ArrayList<String> commonWords;
    ArrayList<Word> makingWords;
    ArrayList<Url> test;
    WordsContainer dataBase;
    Url url;  

    Input(String input, String theCommonWords){
        commonWords = new ArrayList<String>();
        initialUrls = new ArrayList<Url>();
        makingWords = new ArrayList<Word>();
        dataBase = new WordsContainer();
        readUrls(input);
        readCommonWords(theCommonWords);
        readWords();
        addToDataBase();
    }
    
    /**
     * This method read all the Urls in the Url file and creates
     * a new Url everytime it finds a new Url.
     * 
     * @param the Url.file will go in here 
     */
    public void readUrls(String input){
        try{
            Scanner reader = new Scanner (new FileReader(input));
            while (reader.hasNextLine()){
                String [] textFile = reader.nextLine().split(" ");
                String com = textFile[2];
                String priority = textFile[1];
                String aUrl = textFile[0];
                url = new Url(com,priority,aUrl);
                initialUrls.add(url);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * this method reads the common words file and creates an 
     * ArrayList of all the common words found in the file
     * 
     * @param the common words file 
     */
    public void readCommonWords(String theCommonWords){
        try{
            Scanner reader = new Scanner(new FileReader(theCommonWords));
            while(reader.hasNext()){
                String commonWord = reader.next();
                commonWords.add(commonWord);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * This method reads the words within each Url and for every 
     * new Word found, it initilizes a word and if the word is 
     * already there it adds the current Url to that word
     */
    public void readWords(){
        try{
            for(int i = 0; i<initialUrls.size();i++){
                Scanner file = new Scanner (new FileReader(initialUrls.get(i).com));
                while(file.hasNext()){
                    String word = file.next();
                    String [] sameWords = word.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
                    for(String theWord: sameWords){
                        Word newWord = new Word(theWord);
                        if(!commonWords.contains(theWord)){
                            if(makingWords.size() == 0){
                                newWord.addUrl(initialUrls.get(i));
                                makingWords.add(newWord);
                            }
                            else if(searchWord(newWord)){
                                for(int j = 0; j<makingWords.size();j++){
                                    if(makingWords.get(j).word.equals(newWord.word)){
                                        makingWords.get(j).addUrl(initialUrls.get(i));
                                    }
                                }
                            }
                            else{
                                newWord.addUrl(initialUrls.get(i));
                                makingWords.add(newWord);
                            }
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * This method adds all the words into my tree map
     */
    public void addToDataBase(){
        for(int i = 0; i<makingWords.size();i++){
            dataBase.treeMap.put(makingWords.get(i).word,makingWords.get(i).urlContainer);
        }
    }

    /**
     * This method searches for the word with in my arrayList
     * of words and retruns true if it is already a word within
     * my array list of words
     */
    public boolean searchWord(Word newWord){
        for(int j = 0; j<makingWords.size();j++){
            if(makingWords.get(j).word.equals(newWord.word)){
                return true;
            }
        }
        return false;  
    }
    
}

