package shapes;
import java.lang.Math;

public class Circle extends BoundedShapes{
    private int radius;
    public Circle(int x,int y,int radius){
        super(x,y);
        this.radius = radius;
    }

    public String toString(){
        return super.toString() + "Radius : " + this.radius;
    }

    public double area() {
        return (Math.PI)*radius*radius;
    }
}
