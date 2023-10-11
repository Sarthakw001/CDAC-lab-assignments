package tester;
import shapes.*;


public class TestAbstractClass {
    public static void main(String[] args) {
        BoundedShapes[] shape = {new Circle(1, 2, 5), new Rectangle(1, 2, 5, 6)};


        for (BoundedShapes s : shape){
            System.out.println(s);
            System.out.println(s.area());
        }
    }
}