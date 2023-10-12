package tester;
import java.util.Scanner;
import core.*;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select your Stack \n");
        System.out.println("1 -> Choose Fixed Stack");
        System.out.println("2 -> Choose Growable Stack");

        int option = sc.nextInt();

        switch(option){
            case 1:
            System.out.println("Fixed Array Selected");
            System.out.println();
            System.out.println("Enter customer Details");
            System.out.println("Enter customer ID");
            int id = sc.nextInt();
            System.out.println("Enter Name of Customer");
            String name = sc.next();
            System.out.println("Enter customer Address");
            String address = sc.next();

            break;
            case 2:
            break;
            default:
            break;
        }
        sc.close();
    }
}
