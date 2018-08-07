
/**
 * Write a description of class Triangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Triangle extends Shape
{
    private float base; 
    private float height; 
    
    Triangle(float b, float h){
        this.base = b;
        this.height = h; 
        calcArea();
    }
    
    public void setBase(float settingBase){
        this.base = settingBase;
    }
    
    public float getBase(){
        return this.base;
    }
    
    public void setHeight(float settingHeight){
        this.height = settingHeight;
    }
    
    public float getHeight(){
        return this.height;
    }
    
    public float calcArea(){
        area = (this.base*this.height)/2;
        return area;
    }

    public String toString(){
        return "a triangle with the area of " + area;
    }
}
