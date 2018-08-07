
/**
 * This experimentalController will run my program and will take in the user input in 
 * the beggining of the program.  It will take in a limit, numberf of players, max value 
 * for dice, filegraph, and input that includes the starting node and all of the end nodes
 *
 * @author (Ray Tomatsu)
 * @version (May 3, 2018)
 */
import java.util.*;
public class ExperimententController
{
    public static void main (String args[]){
        int limit = Integer.parseInt(args[0]);
        int numbersOfPlayers = Integer.parseInt(args[1]);
        int maxValueForDice = Integer.parseInt(args[2]);
        UndirectedGraph fileGraph = new UndirectedGraph(args[3]);
        InputFile input = new InputFile(args[4]);
    
        
        PlayerContainer players = new PlayerContainer(limit,numbersOfPlayers,fileGraph,input);
        Game project = new Game(players,maxValueForDice);
        
        project.run();
        
        
    }
}
