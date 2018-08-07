
/**
 * This is a undirected graph and will create a graph based on the input files.  It is 
 * a undirected graph to be specific.  
 *
 * @author (Ray Tomatsu)
 * @version (May 3, 2018)
 */
import java.util.*;
import java.io.*;
public class UndirectedGraph 
{
    private ArrayList<UndirectedGraphNode> nodeValues;
    private String filename;
    
    public UndirectedGraph(String fileName){
        filename = fileName;
        nodeValues = new ArrayList<UndirectedGraphNode>();
        int size = numberOfNodes();

        UndirectedGraphNode zeroIndex = new UndirectedGraphNode(-1);
        nodeValues.add(0,zeroIndex);
        for(int i = 1; i<=size;i++){
            UndirectedGraphNode newNode = new UndirectedGraphNode(i);
            nodeValues.add(i,newNode);
        }
        addFromFiles();
    }
    
    /**
     * This method reads each line in the input file and will split the numbers up so that 
     * it connects the nodes in the undirected way.  
     */
    //adds all the edges from file
    public void addFromFiles(){
        try{
            Scanner sc = new Scanner(new FileReader(filename));
            while(sc.hasNextLine()){
                String array [] = sc.nextLine().split(" - ");
                int vertex = Integer.parseInt(array[0]);
                String newArray [] = array[1].split(" ");
                int destination = Integer.parseInt(newArray[0]);
                int cost = Integer.parseInt(newArray[1]);
                addEdge(vertex,destination,cost);
            }
        }catch  (Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * This goes through the whole file to find the biggest nodes so that I can initilize 
     * the size of the graph.   
     */
    //returns the number of Nodes in this program 
    public int numberOfNodes(){
        int howManyNodes = 0;
        try{
            Scanner sc = new Scanner(new FileReader(filename));
            while(sc.hasNextLine()){
                String array [] = sc.nextLine().split(" - ");
                int vertex = Integer.parseInt(array[0]);
                if(vertex>howManyNodes){
                    howManyNodes = vertex;
                }
                String newArray [] = array[1].split(" ");
                int destination = Integer.parseInt(newArray[0]);
                if(howManyNodes<destination){
                    howManyNodes = destination;
                }
            }
        }catch  (Exception e){
            System.out.println(e);
        }
        return howManyNodes;
    }
    
    /**
     * This method adds the edges from node to node with a ceratin cost.  
     * Returns true if the edge is successfully added.  Edge will not 
     * be added if either node does not exist.  If the edge already exists
     * it will simple change its weight.  
     */
    public boolean addEdge(int k1, int k2, int w){
      
        if(nodeValues.get(k1).getEdges().size() == 0){
            UndirectedGraphEdge newEdge1 = new UndirectedGraphEdge(k2,w);
            nodeValues.get(k1).getEdges().add(newEdge1);
            UndirectedGraphEdge newEdge2 = new UndirectedGraphEdge(k1,w);
            nodeValues.get(k2).getEdges().add(newEdge2);
            return true;
        }
        else {
            for(int i =0; i<nodeValues.get(k1).getEdges().size();i++){
                if(nodeValues.get(k1).getEdges().get(i).getDestination()==k2){
                    nodeValues.get(k1).getEdges().get(i).setCost(w);
                    for(int j =0; j<nodeValues.get(k2).getEdges().size();j++){
                    if(nodeValues.get(k2).getEdges().get(j).getDestination()==k1){
                        nodeValues.get(k2).getEdges().get(j).setCost(w);
                    }
                    return true;
                }
            }
        }
            UndirectedGraphEdge newEdge1 = new UndirectedGraphEdge(k2,w);
            nodeValues.get(k1).getEdges().add(newEdge1);
            UndirectedGraphEdge newEdge2 = new UndirectedGraphEdge(k1,w);
            nodeValues.get(k2).getEdges().add(newEdge2);
            return true;
        }
    }
    
    public String toString(){
        String s= "";
        for(int i =0; i<nodeValues.size(); i++){
            s+=nodeValues.get(i);
        }
        return s;
    }
    
    public ArrayList<UndirectedGraphNode> getNodeValues(){
        return nodeValues;
    }
    
    public int getAmountNodes(){
        return nodeValues.size();
    }
    
}

