
/**
 * Abstract class Shape - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Shape implements Comparable <Shape> 
{
    public float area;
    
    public abstract float calcArea();

    public abstract String toString(); 

    public int compareTo(Shape s){
        if(this.area==s.area){
            return 0; 
        }
        else if(this.area<s.area){
            return 1;
        }
        else {
            return -1;
        }
    }
}
