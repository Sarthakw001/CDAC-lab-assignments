package tester;

import java.util.Scanner;
import core.Point2D;

class TestPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many points you want to plot");
		Point2D[] points = new Point2D[sc.nextInt()];
		int counter = 0;
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
					if (counter < points.length && points[counter] == null) {
						System.out.println("Enter x & y Co-ordinate");
						points[counter] = new Point2D(sc.nextInt(), sc.nextInt());
						counter++;
					} else {
						System.out.println("Already plotted or Limit excedded");
					}
					break;

				case 2:
					for (Point2D p : points) { // 2. Display all points
						if (p != null) {
							System.out.println(p.show());
						}
					}
					break;

				case 3:
					System.out.println("Enter indices of any 2 points you plotted");
					int p1 = sc.nextInt();
					int p2 = sc.nextInt();

					if (p1 < counter && p2 < counter && points[p1].isEqual(points[p2])) {
						System.out.println("Indices of points provided by you are equal");
					} else {
						System.out.println("Indices of points provided by you are NOT equal or not plotted");
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
