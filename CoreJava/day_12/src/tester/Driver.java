package tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import customException.CusException;
import primary.Customer2;
import utility.Utilss;

class testCustomer {
    public static void main(String[] args) {
        Map<String, Customer2> customers = new HashMap<>();
        try (Scanner sc = new Scanner(System.in)) {
            boolean flag = false;
            while (!flag) {
                System.out.println("Menu\n" + "1 -> Sign up\n" + "2 -> Sign In\n" + "3 -> Change Password\n"
                        + "4 -> Unsubscribe Customer\n" + "5 -> Display Customer\n" + "6 -> Sort acc. to email\n" + "7 -> Sort according to dob\n"+ "0 -> Exit");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter FirstName");
                        String firstName = sc.next();
                        System.out.println("Enter lastName");
                        String lastName = sc.next();
                        System.out.println("Enter email");
                        String email = sc.next();
                        System.out.println("Enter password");
                        String password = sc.next();
                        System.out.println("Enter Date of Birth");
                        String dateOfBirth = sc.next();
                        System.out.println("Enter Registration Amount");
                        double registrationAmount = sc.nextDouble();

                        Customer2 cv = Utilss.validateUser(firstName, lastName, email, password, dateOfBirth,
                                registrationAmount, customers);

                        customers.put(email, cv);
                        break;
                    case 2:
                        System.out.println("Enter email");
                        String email1 = sc.next();
                        System.out.println("Enter Password");
                        String password1 = sc.next();
                        if (Customer2.signIn(email1, password1, customers)) {
                            System.out.println("You are Signed In");
                        } else {
                            throw new CusException("Either email or password is incorrect ! Try Again");
                        }
                        break;
                    case 3:
                        System.out.println("Enter email");
                        String email11 = sc.next();
                        System.out.println("Enter Password");
                        String password11 = sc.next();
                        if (Customer2.signIn(email11, password11, customers)) {
                            System.out.println("Valid User\n Enter new Password");
                            Customer2.changePassword(email11, sc.next(), customers);
                            System.out.println("Password changed");
                        } else {
                            throw new CusException("Invalid Customer");
                        }
                        break;
                    case 4:
                        System.out.println("Enter email to Unsubscribe");
                        String email3 = sc.next();
                        if (Customer2.unSubscribe(email3, customers)) {
                            System.out.println("You are now unsubscribed");
                        } else {
                            System.out.println("User does not exist");
                        }
                        break;
                    case 5:
                        System.out.println(customers);
                        break;
                    case 6:
                        TreeMap<String, Customer2> tm = new TreeMap<>(customers);
                        System.out.println("All customers details sorted as per email : ");
                        for (Customer2 c : tm.values())
                            System.out.println(c);
                        break;

                    case 7: 
                        ArrayList<Customer2> list = new ArrayList<>(customers.values());
                        Comparator<Customer2> comp = (c1, c2) -> c1.getdob().compareTo(c2.getdob());
                        Collections.sort(list, comp);
                        System.out.println("customers sorted as per dob");
                        list.forEach(c -> System.out.println(c));
                        break;
                    case 0:
                        flag = true;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}