package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import core.Customer;
import customException.CustomerException;
import utils.CustomerValidation;

class testCustomer {
    public static void main(String[] args) {
        HashMap<String,Customer> customers = new HashMap<>();
        try (Scanner sc = new Scanner(System.in)) {
            boolean flag = false;
            while (!flag) {
                System.out.println("Menu\n" + "1 -> Sign up\n" + "2 -> Sign In\n" + "3 -> Change Password\n"
                        + "4 -> Unsubscribe Customer\n" + "5 -> Display Customer\n" + "0 -> Exit");
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

                        Customer cv = CustomerValidation.validateUser(firstName, lastName, email, password, dateOfBirth,
                                registrationAmount, customers);

                        customers.put(email, cv);
                        break;
                    case 2:
                        System.out.println("Enter email");
                        String email1 = sc.next();
                        System.out.println("Enter Password");
                        String password1 = sc.next();
                        if (Customer.signIn(email1, password1, customers)) {
                            System.out.println("You are Signed In");
                        } else {
                            throw new CustomerException("Either email or password is incorrect ! Try Again");
                        }
                        break;
                    case 3:
                        System.out.println("Enter email");
                        String email11 = sc.next();
                        System.out.println("Enter Password");
                        String password11 = sc.next();
                        if (Customer.signIn(email11, password11, customers)) {
                            System.out.println("Valid User\n Enter new Password");
                            Customer.changePassword(email11, password11, sc.next(), customers);
                            System.out.println("Password changed");
                        } else {
                            throw new CustomerException("Invalid Customer");
                        }
                        break;
                    case 4:
                        System.out.println("Enter email to Unsubscribe");
                        String email3 = sc.next();
                        if(Customer.unSubscribe(email3, customers)) {
                            System.out.println("You are now unsubscribed");
                        }else{
                            System.out.println("User does not exist");
                        }
                        break;
                    case 5:
                        for(Customer customer : customers){
                            System.out.println(customer);
                        }
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