package shapes;

public class Rectangle extends BoundedShapes {
    private int length;
    private int width;

    public Rectangle(int x,int y, int length, int width){
        super(x, y);
        this.length = length;
        this.width = width;
    }

    public String toString(){
        return super.toString() + "length : " + this.length + "width" + this.width;
    }

    public double area(){
        return length*width;
    }
}
