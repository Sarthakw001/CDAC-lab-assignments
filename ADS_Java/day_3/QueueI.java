package ADS_Java.day_3;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Iterator;

public class QueueI {
    private static void displayQueue(ArrayDeque<Integer> q) {
        Iterator<Integer> it = q.iterator();
        while (it.hasNext()) {
            int x = it.next();
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of elements to insert in stack");
            int n = sc.nextInt();
            ArrayDeque<Integer> q = new ArrayDeque<>();

            boolean flag = true;
            while (flag) {
                System.out.println(
                        "1 -> Display\n 2 -> Store the data in the queue\n 3 -> Access the data from the queue\n 4 ->  Check how many elements are there in the queue.\n 5 -> Check to see if the queue is full?\n 6 -> f. Check to see if queue is empty\n 0 -> Exit");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        displayQueue(q);
                        break;
                    case 2:
                        System.out.println("Enter " + n + " elements to push to queue");
                        for (int i = 0; i < n; i++)
                            q.add(sc.nextInt());
                        break;
                    case 3:
                        System.out.println("data popped from stack is :: " + q.getFirst());
                        break;
                    case 4:
                        int sz = q.size();
                        System.out.println(sz);
                        break;
                    case 5:
                        if (q.size() == n)
                            System.out.println("queue is full");
                        else
                            System.out.println("Not full");
                        break;
                    case 6:
                        if (q.isEmpty())
                            System.out.println("empty queue");
                        else
                            System.out.println("Not empty");
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        }
    }
}
