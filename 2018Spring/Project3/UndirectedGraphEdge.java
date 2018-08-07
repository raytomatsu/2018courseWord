
/**
 * This is a edge class in which will store the destination and the cost to get to that 
 * destination.  This class connects the node's together.  
 *
 * @author (Ray Tomatsu)
 * @version (<ay 3, 2018)
 */
public class UndirectedGraphEdge
{
    private int cost;
    private int destination;
    
    UndirectedGraphEdge(int n, int cost){
        this.cost = cost;
        this.destination = n; 
    }
    
    public void setCost(int cost){
        this.cost = cost;
    }
    
    public int getCost(){
        return cost;
    }
    
    public void setDestination(int next){
        this.destination = next;
    }
    
    public int getDestination(){
        return this.destination;
    }
    
    public String toString(){
        return this.destination + " " + this.cost;
    }
    
}
