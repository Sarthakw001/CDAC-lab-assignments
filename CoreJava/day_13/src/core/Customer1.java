package core;

import java.time.LocalDate;
import java.util.Map;

public class Customer1 {
    private static int id = 0;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private boolean subscribe;
    private double registrationAmount;

    public static Customer1 signUp(String firstName, String lastName, String email, String password,
            LocalDate dateOfBirth, double registrationAmount) {
        return new Customer1(firstName, lastName, email, password, dateOfBirth, registrationAmount);
    }

    public static void changePassword(String email, String newPassword, Map<String,Customer1> customers) {
        Customer1 cv = customers.get(email);
        cv.setPassword(newPassword);
    }

    public static boolean unSubscribe(String email, Map<String,Customer1> customers) {
        if(customers.containsKey(email)){
            Customer1 cv = customers.get(email);
            cv.setSubscribe();
            return true;
        }
        return false;
    }

    public static boolean signIn(String email, String password, Map<String,Customer1> customers) {
        if(customers.containsKey(email)){
            Customer1 cv = customers.get(email);
            if(cv.password.equals(password)){
                return true;
            }
        }
        return false;
    }
    public Customer1(String firstName, String lastName, String email, String password, LocalDate dateOfBirth,
            double registrationAmount) {
        Customer1.id = Customer1.id + 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.subscribe = true;
        this.registrationAmount = registrationAmount;
    }

    public Customer1(String email) {
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
        if (o instanceof Customer1) {
            return this.email.equals(((Customer1) o).email);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name :" + firstName + " " + lastName + "\nEmail : " + email + "\nDOB : " + dateOfBirth + "\nSubscribed"
                + subscribe + "\nPlan : " + ServicePlan.getPlanName((int) registrationAmount);
    }
}
