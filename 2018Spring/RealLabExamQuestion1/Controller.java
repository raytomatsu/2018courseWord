
/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controller
{
    public static void main (String args[]){
        ShapeList allShapes = new ShapeList();
        
        Triangle firstTraingle = new Triangle(10,50);
        Square firstSquare = new Square(70);
        Square secondSquare = new Square(50);
        
        allShapes.addSorted(firstTraingle);
        allShapes.addSorted(firstSquare);
        allShapes.addSorted(secondSquare);
        
        allShapes.printList();
    }
}
