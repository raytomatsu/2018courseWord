
/**
 * This shortest Player class will perform dijstraks to find the exit node.  If the exit 
 * node is within limit it will set a path to it.  If not it will find a longest path 
 * within each neighbor 
 *
 * @author (Ray Tomatsu)
 * @version (May 3, 2018)
 */
import java.util.*;
public class farthestPlayer extends Player
{
    private ArrayList<Integer> oneBefore;
    public farthestPlayer(UndirectedGraph graph,int limit, int beginning, ArrayList<Integer> end){
        super(graph,limit,beginning,end);
        oneBefore = new ArrayList<Integer>();
        oneBefore.add(0);
        playerName = "Farthest algorithm";
    }
    
    /**
     * This algorithm keeps track of the place each player is and the place they are 
     * trying to go as well as all of the steps it takes to get there.  Because this
     * is the first player algorithm if the exit is not found with in the neighbors it 
     * will choose a path to the longest distance of the neighbors of the current index
     */

    public void algorithm(int diceRoll){
        int value = diceRoll;
        while(value !=0){
            if(steps ==0){
                Dijkstra();
                if(checkForExitD()){
                    int exit = whichExitD();
                    if(exitPath(whichExitD()) !=exit){
                        whereTo = exitPath(whichExitD());
                    }
                    else{
                        whereTo = exit;
                    }
                    int cost = weight(whereAt,whereTo);
                    steps = cost;
                    if(steps - value <=0 && whereTo == exit){
                        System.out.println("farthest Algorithm Wins!");
                        System.exit(0);
                    }
                    else if(steps- value<=0){
                        whereAt = whereTo;
                        value = Math.abs(steps-value);
                        steps = 0;

                    }
                    else{
                        steps = steps - value;
                        value = 0;
                    }
                }
                else{
                    if(neighbors(whereAt).size()==1){

                        int whichNeihbor = neighbors(whereAt).get(neighbors(whereAt).size()-1);
                        whereTo= neighbors(whereAt).get(whichNeihbor);

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
                        int whichNeihbor = farthest(withOutOneICameFrom);
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
                        System.out.println("farthest Algorithm Wins!");
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

    

    public int farthest(ArrayList<Integer> find){
        int shortest = 0;
        for(int i =0;i<find.size();i++){
            if(shortest < weight(whereAt,find.get(i))){
                shortest = find.get(i);
            }
        }
        return shortest;
    }
}
