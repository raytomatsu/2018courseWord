
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class ExperimentalController
{
    public static void main (String args[]){
        Input readingFiles = new Input(args[0], args[1]);
        System.out.println("Enter Search");
        Scanner sc= new Scanner(System.in);
        while(sc.hasNextLine()){
            long startTime = System.nanoTime();
            Search theSearch1 = new Search(readingFiles.dataBase.treeMap,sc.nextLine());
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
            theSearch1.printOut();
            System.out.println("Would like to make another Search?  If so press y!");
            if(!sc.nextLine().equals("y")){
                System.exit(0);
            }
            System.out.println("Enter Search");
        }
    }
}
