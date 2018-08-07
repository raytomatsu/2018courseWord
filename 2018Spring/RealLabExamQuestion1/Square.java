
/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends Shape
{
    private float side; 
    
    Square(float s){
        this.side = s;
        calcArea();
    }
    
    public void setSide(float settingSide){
        this.side = settingSide;
    }
    
    public float getSide(){
        return side;
    }
    
    public float calcArea(){
        area = side*side;
        return area;
    }
    
    public String toString(){
        return "a Square with a area of " + area;
    }
    
    
}
