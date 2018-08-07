
/**
 * This is a player container class that depedning on the user's input will have as much 
 * as five players all with diferrent algorithms.  
 *
 * @author (Ray Tomatsu)
 * @version (May 3, 2018)
 */
import java.util.*;
public class PlayerContainer
{
    private ArrayList<Player> allPlayers;
    private int limit, numberOfPlayer;
    private UndirectedGraph fileGraph;
    private InputFile input;
    
    public PlayerContainer(){
    }
    
    public PlayerContainer(int limit, int numberOfPlayer,UndirectedGraph fileGraph, InputFile input){
        allPlayers = new ArrayList<Player>();
        this.limit = limit;
        this.numberOfPlayer = numberOfPlayer;
        this.fileGraph = fileGraph;
        this.input = input;
        
        //initilizing all of the players 
        initilizePlayers();
    }

    public ArrayList<Player> getAllPlayers(){
        return allPlayers;
    }
    
    /**
     * This method will depending on the number of players inputting will initilize 
     * these players.  The first player will contain the random algorithm, the second 
     * player will contain the first algorithm the thrid player will contain the 
     * last algorithm, the fourth player will contain the shortest algorithm, and 
     * finally the fifth algorithm will contain the farthtest algorithm
     */
    public void initilizePlayers(){
        for(int i =0; i<numberOfPlayer;i++){
            if(i == 0){
                randomPlayer playerOne = new randomPlayer(fileGraph,limit,input.getStart(),input.getEnds());
                allPlayers.add(playerOne);
            }
            if(i == 1){
                firstPlayer playerTwo = new firstPlayer(fileGraph, limit, input.getStart(),input.getEnds());
                allPlayers.add(playerTwo);
            }
            if(i == 2){
                lastPlayer playerThree = new lastPlayer(fileGraph, limit, input.getStart(),input.getEnds());
                allPlayers.add(playerThree);
            }
            if(i == 3){
                shortestPlayer playerFour = new shortestPlayer(fileGraph, limit, input.getStart(),input.getEnds());
                allPlayers.add(playerFour);
            }
            if(i == 4){
                farthestPlayer playerFive = new farthestPlayer(fileGraph, limit, input.getStart(),input.getEnds());
                allPlayers.add(playerFive);
            }
        }
    }

}
