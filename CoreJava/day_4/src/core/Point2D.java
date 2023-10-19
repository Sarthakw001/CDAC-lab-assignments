package core;
import java.lang.Math;

public class Point2D {
	private double x;
	private double y;

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String show() {
		return "X : " + this.x + " Y : " + this.y;
	}

	public boolean isEqual(Point2D point) {
		if (this.x == point.x && this.y == point.y)
			return true;
		else
			return false;
	}

	public double calculateDistance(Point2D point) {
		double xValue = Math.pow((this.x - point.x), 2);
		double yValue = Math.pow((this.y - point.y), 2);

		double distance = Math.sqrt((xValue + yValue));

		return distance;
	}
}