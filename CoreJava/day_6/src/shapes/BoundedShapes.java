package shapes;

public abstract class BoundedShapes {
    private int x;
    private int y;

    public BoundedShapes(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "x : " + this.x + " y : " + this.y;
    }

    public abstract double area();
}