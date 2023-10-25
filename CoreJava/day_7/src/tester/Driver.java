package tester;

import java.util.Scanner;
import core.*;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("Select your Stack \n");
            System.out.println("1 -> Choose Fixed Stack");
            System.out.println("2 -> Choose Growable Stack");
            System.out.println("0 -> Exit from application");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nFixed Array Selected");
                    boolean flag1 = true;
                    FixedStack st = new FixedStack();
                    while (flag1) {
                        System.out.println();
                        System.out.println("1 -> Push customer to fixed Stack");
                        System.out.println("2 -> Pop customer from fixed Stack");
                        System.out.println("3 -> Display contents of Stack");
                        System.out.println("0 -> Exit from fixed stack");
                        int option1 = sc.nextInt();
                        switch (option1) {
                            case 1:
                                System.out.println("\nEnter customer Details");
                                System.out.println();
                                System.out.println("Enter customer ID");
                                int id = sc.nextInt();
                                System.out.println("Enter Name of Customer");
                                String name = sc.next();
                                System.out.println("Enter customer Address");
                                String address = sc.next();
                                Customer3 c = new Customer3(id, name, address);
                                st.push(c);
                                break;
                            case 2:
                                st.pop();
                                break;
                            case 3:
                                st.display();
                                break;
                            case 0:
                                flag1 = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nGrowable Array Selected");
                    boolean flag2 = true;
                    GrowableStack st1 = new GrowableStack();
                    while (flag2) {
                        System.out.println();
                        System.out.println("1 -> Push customer to Growable Stack");
                        System.out.println("2 -> Pop customer from Growable Stack");
                        System.out.println("3 -> Display contents of Stack");
                        System.out.println("0 -> Exit from Growable stack");
                        int option1 = sc.nextInt();
                        switch (option1) {
                            case 1:
                                System.out.println("\nEnter customer Details");
                                System.out.println();
                                System.out.println("Enter customer ID");
                                int id = sc.nextInt();
                                System.out.println("Enter Name of Customer");
                                String name = sc.next();
                                System.out.println("Enter customer Address");
                                String address = sc.next();
                                Customer3 c = new Customer3(id, name, address);
                                st1.push(c);
                                break;
                            case 2:
                                st1.pop();
                                break;
                            case 3:
                                st1.display();
                                break;
                            case 0:
                                flag2 = false;
                                break;
                        }
                    }
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
        sc.close();
    }
}
