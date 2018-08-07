
/**
 * This is an abstract player class that will hold all the essential isntance variables and 
 * methods that will be contained for all of the players.  However, the algorithm method 
 * will be left as abstract because the players will all have different algorithms 
 *
 * @author (Ray Tomatsu)
 * @version (May 3, 2018)
 */
import java.util.*;
public abstract class Player
{
    protected int limit,whereAt,whereTo,steps; 
    protected ArrayList<Integer> end,shortestPaths,visited,prev;
    protected UndirectedGraph graph; 
    protected String playerName;

    public Player(UndirectedGraph graph,int limit, int beginning, ArrayList<Integer> end){
        this.limit = limit;
        this.graph = graph;
        this.whereAt = beginning;
        this.end= end; 
        steps = 0;
        whereTo =0;
        Dijkstra();
    }

    /**
     * This method performs the Dijkstra's shortest path algorithm and my shortestPaths
     * arraylist will contain all the node and the distance from my instance variable
     * whereAt which will be the player's current location.  Also in this algorithm I
     * implemented a prev arraylist that allows me to traverse and keep track my way to 
     * each of the node in a shortet paths.
     */
    public void Dijkstra(){
        shortestPaths= new ArrayList<Integer>();
        prev = new ArrayList<Integer>();
        visited = new ArrayList<Integer>();
        shortestPaths.add(0,-1);
        prev.add(0,-1);
        //initilize the prev and shortestPaths will infinty.  
        for(int i= 1; i<=graph.getAmountNodes();i++){
            prev.add(i,(int)(Integer.MAX_VALUE));
            shortestPaths.add(i,(int)(Integer.MAX_VALUE));
        }
        //setting the distance from the source as 0
        shortestPaths.set(whereAt,0);
        for(int i = 1; i<graph.getAmountNodes(); i++){
            //get the smallest vertex from the source 
            int v = minVertex(shortestPaths);
            //add the smallest vertex to the visited array list to mark it as visited
            visited.add(v);
            if(shortestPaths.get(v) == (int)(Integer.MAX_VALUE)) return;
            ArrayList<Integer> nList = neighbors(v);
            for(int j=0; j<nList.size(); j++){
                int w = nList.get(j);
                if(shortestPaths.get(w) > (shortestPaths.get(v) + weight(v,w))){
                    shortestPaths.set(w,shortestPaths.get(v) + weight(v,w));
                    prev.set(w,v);
                }
            }
        }
    }

    /**
     * This method returns an arraylist of neighbors of the node that is inputted through
     * the parameter.  
     * 
     * @param integer Node
     * @return arraylist of integers of all of the param's neighbors
     */
    public ArrayList<Integer> neighbors(int v){
        ArrayList<UndirectedGraphEdge> nList = graph.getNodeValues().get(v).getEdges();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i<nList.size();i++){
            array.add(i,nList.get(i).getDestination());
        }
        return array;
    }
    
    /**
     * This returns the cost or the weight from one node to another 
     * 
     * @param integer node from v, to w,
     * @return an integer giving the cost from v to w
     */

    public int weight(int v, int w){
        ArrayList<UndirectedGraphEdge> nList = graph.getNodeValues().get(v).getEdges();
        for(int i = 0; i<nList.size();i++){
            if(w==nList.get(i).getDestination())
                return nList.get(i).getCost();
        }
        return 0;
    }

    /**
     * Thie method has to mainly deal with my dijkstra's algorithm and wil return the shortest
     * distance from the source that is not visted yet.  Or that does not contain in my
     * visited arraylist.  
     * 
     * @param all of the nodes in the shortestPath 
     * @return the shortest path from the source that is not visited yet 
     */
    public int minVertex(ArrayList<Integer> D){
        int v= 0;
        for(int i =1; i<graph.getAmountNodes(); i++)
            if(!visited.contains(graph.getNodeValues().get(i).getNodeNumber())){v = i; break;}
        for(int i =1; i<graph.getAmountNodes(); i++)
            if((!visited.contains(graph.getNodeValues().get(i).getNodeNumber()))&& (D.get(i) <D.get(v)))
                v = i;
        return v;
    }

    public ArrayList<Integer> getShortestPaths(){
        return this.shortestPaths;
    }

    /**
     * remains abstract as my players will have different algorithms
     */
    abstract void algorithm(int diceRoll);

    /**
     * This method check for a exit without the use of dikstras.  Therefore will simply 
     * check for an exit if the end is an neighbor of the current node.  
     * 
     * @param the current node 
     */
    public boolean checkForExitN(int current){
        for(int i = 0;i<end.size();i++){
            if(neighbors(current).contains(end.get(i))){
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method find which exit it is in the current value's neighbors method.  If 
     * the current value has multiple ends within it's neighbors that it will find the 
     * shortest one to the end within the neighbor
     * 
     * @param current node 
     */

    public int whichExitN(int current){
        int exit =(int)(Integer.MAX_VALUE);
        int where = -1;
        for(int i =0;i<end.size();i++){
            if(neighbors(current).contains(end.get(i))){ 
                if(exit>weight(current,end.get(i))){
                    exit = weight(current,end.get(i));
                    where = end.get(i);
                }
            }
        }
        return where;
    }

    /**
     * This method check for an exit using the Dijkstras shortest paths algorithm.  If 
     * the path is less of limit than it will return true.  If not if will return false.  
     */
    //This uses Dijsktras 
    public boolean checkForExitD(){
        for(int i = 0; i<end.size();i++){
            if(shortestPaths.get(end.get(i))<limit){
                return true;
            }
        }
        return false;
    }

    /**
     * This method check which exit it is that the shortestpath has found.  Because there
     * can be multiple ends if it finds multiple ends within the shortestPaths, it will
     * return the shorest of the shortest paths.
     */
    public int whichExitD(){
        int shortestShort = (int)(Integer.MAX_VALUE);
        for(int i = 0; i<end.size();i++){
            if(shortestPaths.get(end.get(i))<limit){
                if(shortestShort>end.get(i)){
                    shortestShort = end.get(i);
                }
            }
        }
        return shortestShort ;
    }
    
    /**
     * This method travereses throughout the shortest paths so I can be get the path to
     * the shortestpath 
     * 
     * @param the exit to the shortest path 
     */

    public int exitPath(int exit){
        if(prev.get(exit) == whereAt){
            return exit;
        }
        else{
            int i = prev.get(exit);
            while(prev.get(i)!=whereAt){
                i = prev.get(i);
            }
            return i;
        }
    }
    
    public String getPlayerName(){
        return playerName;
    }

    public String toString(){
        return playerName+  " player moving From: " + whereAt + " To: " + whereTo + " With Steps: " + steps + " left";
    } 
    
    public int getWhereAt(){
        return whereAt;
    }
    
    public int getWhereTo(){
        return whereTo;
    }
}

