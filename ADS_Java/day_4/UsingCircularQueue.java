package ADS_Java.day_4;

import java.util.Scanner;

public class UsingCircularQueue {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of Circular Queue");
            CircularQueue cq = new CircularQueue(sc.nextInt());

            boolean flag = true;
            while (flag) {
                System.out.println(
                        "1 -> Display\n 2 -> Enqueue the data in the circular queue\n 3 -> Access the data from the circular queue\n 4 ->  Check how many elements are there in the circular queue.\n 5 -> Check to see if the circular queue is full?\n 6 -> f. Check to see if circular queue is empty\n 0 -> Exit");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                       cq.displayCircularQueue();
                        break;
                    case 2:
                        System.out.println("Enter the element to queue");
                        cq.enQueue(sc.nextInt());
                        break;
                    case 3:
                        System.out.println(cq.getPeek());
                        break;
                    case 4:
                        int sz = cq.getCurrSize();
                        System.out.println(sz);
                        break;
                    case 5:
                        if (cq.isFull())
                            System.out.println("queue is full");
                        else
                            System.out.println("Not full");
                        break;
                    case 6:
                        if (cq.isEmpty())
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
