package tester;
import java.util.Scanner;
import core.Point2D;

class TestPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many points you want to plot");
		Point2D[] points = new Point2D[sc.nextInt()];
		boolean flag = false;
		while (!flag) {
			System.out.println("1 -> Plot points");
			System.out.println("2 -> Display all points");
			System.out.println("3 -> Check whether 2 points are equal or NOT!");
			System.out.println("0 -> Exit from application");

			int option = sc.nextInt();

			switch (option) {
				case 0: // 0. to exit from application
					flag = true;
					break;

				case 1:
					for (int i = 0; i < points.length; i++) { // 1. Plot all points
						System.out.println("Enter x & y Co-ordinate");
						double x = sc.nextInt();
						double y = sc.nextInt();
						Point2D temp = new Point2D(x, y);
						for (int j = 0; j < i - 1; j++) {
							if (points[j].isEqual(temp)) {
								System.out.println("Point already plotted ! exit from app .... Try again");
								System.exit(0);
							}
						}
						points[i] = temp;
					}
					break;

				case 2:
					for (Point2D p : points) { // 2. Display all points
						System.out.println(p.show());
					}
					break;

				case 3:
					System.out.println("Enter indices of any 2 points you plotted");
					int p1 = sc.nextInt();
					int p2 = sc.nextInt();

					if (points[p1].isEqual(points[p2])) {
						System.out.println("Indices of points provided by you are equal");
					} else {
						System.out.println("Indices of points provided by you are NOT equal");
					}
					break;

				default:
					System.out.println("Invalid Choice");
					break;
			}
		}
		sc.close();
	}
}
