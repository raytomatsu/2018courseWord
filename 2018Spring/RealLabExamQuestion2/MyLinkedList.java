
/**
 * Write a description of class MyLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class MyLinkedList <E extends Comparable <E>>
{
    LinkedListNode head;
    E e;
    int size = 0; 

    public void add(E e){
        LinkedListNode newNode = new LinkedListNode(e);
        if(head==null){
            head = newNode;
            head.setNextNode(head);
            size ++;
        }
        else {
            LinkedListNode currentNode = head; 
            while(currentNode.getNextNode() !=head){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
            newNode.setNextNode(head);
            size++;
        }
    }

    public boolean add(E e, int i){
        int whereAt = 1;
        LinkedListNode newNode = new LinkedListNode(e);
        if(i >= size){
            return false;
        }
        else if(i ==0){
            newNode.setNextNode(head);
            LinkedListNode currentNode1 = head;
            while(currentNode1.getNextNode() !=head){
                currentNode1 = currentNode1.getNextNode();
            }
            currentNode1.setNextNode(newNode);
            head = newNode;
            size ++;
            return true;
        }
        else {
            LinkedListNode currentNode2 = head;
            while(whereAt != i){
                currentNode2 = currentNode2.getNextNode();
                whereAt ++;
            }
            LinkedListNode tempNode = currentNode2.getNextNode();
            currentNode2.setNextNode(newNode);
            newNode.setNextNode(tempNode);
            size++;
            return true;
        }
    }

    public void remove(int i){
        int whereAt = 1;
        LinkedListNode currentNode =head;
        while(whereAt!=i){
            currentNode = currentNode.getNextNode();
            whereAt++;
        }
        //cannot keep the value from the currentNode.getNextNode().whatItHolds;
        currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        size --;

    }

    public void reverse(){
        LinkedListNode currentNode = head;
        LinkedListNode prevNode;
        LinkedListNode nextNode;
        for(int i = 0;i<size-1;i++){
            
            prevNode = currentNode;
            nextNode = currentNode.getNextNode();
            currentNode = currentNode.getNextNode();
            nextNode.setNextNode(prevNode);
        }
        head.setNextNode(currentNode);
        head = currentNode;

    }

    public void shift(int i){
        int whereAt = 0;
        LinkedListNode currentNode = head;
        while(whereAt!=i){
            currentNode = currentNode.getNextNode();
            whereAt++;
        }
        head = currentNode;
    }
    
    public String toString(){
        String list = "";
        LinkedListNode currentNode = head;
        while(currentNode.getNextNode() !=head){
            list +=currentNode.whatItHolds;
            currentNode = currentNode.getNextNode();
        }
        list += currentNode.whatItHolds;
        return list;
    }
}
