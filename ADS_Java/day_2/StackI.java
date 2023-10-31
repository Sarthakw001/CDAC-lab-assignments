package ADS_Java.day_2;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class StackI {

    private static void displayStack(Stack<Integer> st) {
        ListIterator<Integer> it = st.listIterator(st.size());
        while (it.hasPrevious()) {
            int t = it.previous();
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of elements to insert in stack");
            int n = sc.nextInt();
            Stack<Integer> st = new Stack<>();

            boolean flag = true;
            while (flag) {
                System.out.println(
                        "1 -> Display\n 2 -> Push the data to stack\n 3 -> Pop the data from stack\n 4 ->  Check how many elemenst are on stack\n 5 -> Check to see if the stack is full?\n 6 -> Check to see if stack is empty.\n 0 -> Exit");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        displayStack(st);
                        break;
                    case 2:
                        System.out.println("Enter data to push to stack");
                        st.push(sc.nextInt());
                        break;
                    case 3:
                        System.out.println("data popped from stack is :: " + st.pop());
                        break;
                    case 4:
                        int sz = st.size();
                        System.out.println(sz);
                        break;
                    case 5:
                        if (st.size() == n)
                            System.out.println("Stack is full");
                        else
                            System.out.println("Not full");
                        break;
                    case 6:
                        if (st.isEmpty())
                            System.out.println("empty stack");
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
