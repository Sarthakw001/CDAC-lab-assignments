package com.cdac.tester;

import com.cdac.core.Point2D;
import java.util.Scanner;

class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 2 points with space as 1st 2D point");
		Point2D p1 = new Point2D(sc.nextInt(), sc.nextInt());

		System.out.println("Enter 2 points as 2nd 2D point");
		Point2D p2 = new Point2D(sc.nextInt(), sc.nextInt());

		System.out.println("1st 2D point is : ");
		System.out.println(p1.show());

		System.out.println("2nd 2D point is : ");
		System.out.println(p2.show());

		if (p1.isEqual(p2)) {
			System.out.println("Points are same");
		} else {
			System.out.println("Points are different");
		}

		System.out.println("Distance between both points are " + p1.calculateDistance(p2));
		sc.close();
	}
}
