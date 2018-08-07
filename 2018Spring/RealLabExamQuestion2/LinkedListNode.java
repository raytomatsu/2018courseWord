
/**
 * Write a description of class LinedListNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class LinkedListNode <E>
{
    private LinkedListNode nextNode;
    E whatItHolds;
    
    LinkedListNode(E e){
        this.whatItHolds =e;
    }
    public void setNextNode(LinkedListNode e){
        nextNode = e;
    }

    public LinkedListNode getNextNode(){
        return nextNode;
    }
    
    public String toString(){
        return whatItHolds + " ";
    }
}
