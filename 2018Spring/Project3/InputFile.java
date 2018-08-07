
/**
 * This is the input file that will read the start and all of the end nodes.  
 *
 * @author (Ray Tomatsu)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class InputFile
{
    private String file;
    private int start; 
    private ArrayList<Integer> ends;
    InputFile(String file){
        this.file =file;
        readFile();
    }

    /**
     * Thie method will read in the scanner input and will find the starting node then
     * add as many of the end nodes into the end node arraylist.
     */
    public void readFile(){
        ends = new ArrayList<Integer>();
        try{
            Scanner sc1 = new Scanner(new FileReader(file)); 
            String firstLine = sc1.nextLine();
            String [] array = firstLine.split(" ");
            start = Integer.parseInt(array[1]);
            String [] secondLine = sc1.nextLine().substring(6).split(" ");
            for(int i = 0;i<secondLine.length;i++){
                ends.add(Integer.parseInt(secondLine[i]));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public int getStart(){
        return this.start;
    }
    
    public ArrayList<Integer> getEnds(){
        return ends;
    }
}
