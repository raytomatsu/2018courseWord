
/**
 * This class is a player that will have a first algorithm which will if one of the ends
 * is not a neighbor will choose the first neighbor as the next path.  
 *
 * @author (Ray Tomatsu)
 * @version (May 3, 2018)
 */
import java.util.*;
public class firstPlayer extends Player
{
    private ArrayList<Integer> oneBefore;
    
    public firstPlayer(UndirectedGraph graph,int limit, int beginning, ArrayList<Integer> end){
        super(graph,limit,beginning,end);
        oneBefore = new ArrayList<Integer>();
        playerName = "First algorithm";
        oneBefore.add(0);
    }
    
    /**
     * This algorithm keeps track of the place each player is and the place they are 
     * trying to go as well as all of the steps it takes to get there.  Because this
     * is the first player algorithm if the exit is not found with in the neighbors it 
     * will choose a path to the first index of the neighbors of the current index
     */
    
    public void algorithm(int diceRoll){
        int value = diceRoll;
        while(value !=0){
            if(steps ==0){
                if(checkForExitN(whereAt)){
                    whereTo = whichExitN(whereAt);
                    int cost = weight(whereAt,whereTo);
                    steps = cost;
                    if(steps - value <=0){
                        System.out.println("First Algorithm Wins!");
                        System.exit(0);
                    }
                    steps = steps - value;
                    value = 0;
                }
                else{
                    if(neighbors(whereAt).size()==1){
                        
                        int whichNeihbor = neighbors(whereAt).get(0);
                        whereTo= whichNeihbor;
                        
                        int cost = weight(whereAt,whereTo);
                        steps = cost;
                        if(steps - value<=0){
                            oneBefore.remove(0);
                            oneBefore.add(whereAt);
                            whereAt = whereTo;
                            value = Math.abs(steps-value);
                            steps = 0;
                        }
                        else {
                            steps = steps - value;
                            value =0;
                        }
                    }
                    else {
                        ArrayList<Integer> withOutOneICameFrom = neighbors(whereAt);
                        withOutOneICameFrom.remove(oneBefore.get(0));
                        oneBefore.remove(0);
                        int whichNeihbor = withOutOneICameFrom.get(0);
                        whereTo= whichNeihbor;
                        int cost = weight(whereAt,whereTo);
                        steps = cost;
                        if(steps - value<=0){
                            oneBefore.add(whereAt);
                            whereAt = whereTo;
                            value = Math.abs(steps-value);
                            steps = 0;
                        }
                        else {
                            steps = steps - value;
                            value =0;
                        }
                    }
                }
            }
            else{
                if((checkForExitN(whereAt))){
                    if(steps - value<=0){
                        System.out.println("First Algorithm Wins!");
                        System.exit(0);
                    }
                    else{
                        steps = steps-value;
                        value = 0;
                    }
                    
                }
                else if(steps- value<=0){
                    oneBefore.add(whereAt);
                    whereAt = whereTo;
                    value = Math.abs(steps-value);
                    steps = 0;
                }
                else{
                    steps = steps - value;
                    value = 0;
                }
            }
        }
    }   

}
