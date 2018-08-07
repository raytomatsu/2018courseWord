
/**
 * This is my game class.  This class will contain all the players in the game as well as 
 * the maze.  Depending on the user's input it will run the program in different ways 
 *
 * @author (Ray Tomatsu)
 * @version (May 3, 2018)
 */
import java.util.*;
public class Game
{
    private Scanner sc = new Scanner(System.in);
    private PlayerContainer players;
    private int diceNumber;
    private Random roll;
    
    public Game(){
    }
    
    public Game(PlayerContainer players,int maxValueForDice){
        this.diceNumber = maxValueForDice;
        this.players = players;
        roll = new Random(11);
    }

    /**
     * This method will give the users many options to play the program.  While the 
     * program is playing the user will be able to play or choose one of these options.  
     */
    public void run(){
        System.out.println("Press 'x' to exit the program");
        System.out.println("Press 'c' to continue the program without stopping to prompt the user");
        System.out.println("Press 'p' to print the position of every player");
        System.out.println("Press 'i' to continue with the round, making sure every player has a turn");

        while(sc.hasNext()){
            String user = sc.next();
            Switch(user);
        }
    }

    /**
     * This is the switch statement that depending on the user's input will run the program
     * in a different way.  If the user inputs x, the program will simply exit.  If the 
     * user input c then the program will continue until there is a winner.  If the input
     * is p then it will printout all the players position at that time. Finally if the 
     * input is i then the program will take one turn for all of my players. 
     * 
     * @param userInput
     */
    public void Switch(String user){
        switch(user){
            case "x": System.out.println("exit");
            System.exit(0);
            break;
            case "c": System.out.println("continue without stopping...");
            //This while loop will continue until the program comes to a halt 
            while(true){
                
                for(int i= 0; i<players.getAllPlayers().size();i++){
                    players.getAllPlayers().get(i).algorithm(diceRoll());
                }
            }
            case "p": System.out.println("Printing Position of every player...");
            //Will print the positions of all of the players 
            for(int i =0; i<players.getAllPlayers().size();i++){
                System.out.println(players.getAllPlayers().get(i));
            }
            break;
            //One turn for all of the players
            case "i": System.out.println("Continue the round, everyplayer with a turn");
            for(int i= 0; i<players.getAllPlayers().size();i++){
                int dice = diceRoll();
                System.out.println("rolls: " + dice + " for " + players.getAllPlayers().get(i).getPlayerName());
                players.getAllPlayers().get(i).algorithm(dice);
            }
            break;
        }
    }
    
    /**
     * This is the dice roll that will have a range depending on the max number within 
     * this dice that the user will input.  
     */
    public int diceRoll(){
        return roll.nextInt((diceNumber - 1) +1 ) + 1;

    }
}
