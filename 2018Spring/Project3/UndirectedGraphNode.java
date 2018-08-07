
/**
 * This is a node class in which will contain a instance variable node number as well as 
 * the arraylist of edges for the destination as well as the cost to get there
 *
 * @author (Ray Tomatsu)
 * @version (May 3, 2018)
 */
import java.util.*;
public class UndirectedGraphNode
{
    private int nodeNumber;
    private ArrayList<UndirectedGraphEdge> edges;

    public UndirectedGraphNode(int nodeNumber){
        this.nodeNumber = nodeNumber;
        edges = new ArrayList<UndirectedGraphEdge>();
    }

    public int getNodeNumber(){
        return this.nodeNumber;
    }

    public void setNodeNumber(int nodeNumber){
        this.nodeNumber = nodeNumber;
    }

    public ArrayList<UndirectedGraphEdge> getEdges(){
        return this.edges;
    }
}
    

