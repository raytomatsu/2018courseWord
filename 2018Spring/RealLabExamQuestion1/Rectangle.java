
/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle extends Shape
{
    private float base;
    private float height;
    
    
    Rectangle(float a, float b){
        this.base = a;
        this.height = b;
        calcArea();
    }
    
    public void setBase(float settingBase){
        this.base = settingBase;
    }
    
    public float getBase(){
        return this.base;
    }
    
    public void setHeight(float settingHeight){
        this.base = settingHeight;
    }
    
    public float getHeight(){
        return this.height;
    }
    
    public float calcArea(){
        area = this.base * this.height;
        return area;
    }
    
    public String toString(){
        return "a rectagle with the area of " + area;
    }
}
