package core;

import java.time.LocalDate;
import java.util.List;

public class Customer {
    private static int id = 0;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private boolean subscribe;
    private double registrationAmount;

    public static Customer signUp(String firstName, String lastName, String email, String password,
            LocalDate dateOfBirth, double registrationAmount) {
        return new Customer(firstName, lastName, email, password, dateOfBirth, registrationAmount);
    }

    public static void changePassword(String email, String currPassword, String newPassword, List<Customer> customers) {
        for (Customer c : customers) {
            if (email.equals(c.getEmail())) {
                c.setPassword(newPassword);
                return;
            }
        }
    }

    public static boolean unSubscribe(String email, List<Customer> customers) {
        for (Customer c : customers) {
            if (email.equals(c.getEmail())) {
                c.setSubscribe();
                return true;
            }
        }
        return false;
    }

    public static boolean signIn(String email, String password, List<Customer> customers) {
        for (Customer c : customers) {
            if (email.equals(c.getEmail()) && password.equals(c.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public Customer(String firstName, String lastName, String email, String password, LocalDate dateOfBirth,
            double registrationAmount) {
        Customer.id = Customer.id + 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.subscribe = true;
        this.registrationAmount = registrationAmount;
    }

    public Customer(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setSubscribe() {
        this.subscribe = false;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof Customer) {
            return this.email.equals(((Customer) o).email);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name :" + firstName + " " + lastName + "\nEmail : " + email + "\nDOB : " + dateOfBirth + "\nSubscribed"
                + subscribe + "\nPlan : " + ServicePlan.getPlanName((int) registrationAmount);
    }
}
