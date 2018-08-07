
/**
 * Write a description of class Simulation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Simulation
{
    public static void main(String args[]){
        MyLinkedList newList = new MyLinkedList();
        newList.add("apple ");
        newList.add("pizza ");
        newList.add("watermelon ",1);
        newList.add("quesadilla ");
        newList.add("spicy tuna ");
        
        System.out.println("original: " + newList);
        
        newList.remove(2);
        System.out.println("remove index 2: " + newList);
        newList.shift(3);
        System.out.println("shift on index 3: " + newList);
    }
}
