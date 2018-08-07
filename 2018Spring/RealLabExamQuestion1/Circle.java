
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle extends Shape
{
    private float radius;
    
    Circle(float r){
        this.radius = r;
        calcArea();
    }
    
    public void setRadius(float settingR){
        this.radius = settingR;
    }
    
    public float getRadius(){
        return this.radius;
    }
    
    public float calcArea(){
        float pi = 3;
        area =  pi* this.radius*this.radius;
        return area;
    }

    public String toString(){
        return "a circle with the area of " + area;
    }
    
}
