
/**
 * Write a description of class ShapeList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class ShapeList
{
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void printList(){
        for(int i =0; i<shapes.size();i++){
            System.out.println("size"+ shapes.size());
            System.out.println(shapes.get(i));
        }
    }

    public void addSorted(Shape s){
        if(shapes.size() ==0){
            shapes.add(s);
        }
        else {
            for(int i = 0; i<shapes.size();i++){
                if(shapes.get(i).compareTo(s)>0){
                    shapes.add(i,s);
                    break;
                }
            }
        }
    }

    public String findShape(float a){
        for(int i=0; i<shapes.size();i++){
            if(shapes.get(i).area==a){
                return shapes.get(i).toString();
            }
        }
        return "not found";
    }
}
