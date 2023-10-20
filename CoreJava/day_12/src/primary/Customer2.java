package primary;

import java.time.LocalDate;
import java.util.Map;

public class Customer2 {
    private static int id = 0;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private boolean subscribe;
    private double registrationAmount;

    public static Customer2 signUp(String firstName, String lastName, String email, String password,
            LocalDate dateOfBirth, double registrationAmount) {
        return new Customer2(firstName, lastName, email, password, dateOfBirth, registrationAmount);
    }

    public static void changePassword(String email, String newPassword, Map<String,Customer2> customers) {
        Customer2 cv = customers.get(email);
        cv.setPassword(newPassword);
    }

    public static boolean unSubscribe(String email, Map<String,Customer2> customers) {
        if(customers.containsKey(email)){
            Customer2 cv = customers.get(email);
            cv.setSubscribe();
            return true;
        }
        return false;
    }

    public static boolean signIn(String email, String password, Map<String,Customer2> customers) {
        if(customers.containsKey(email)){
            Customer2 cv = customers.get(email);
            if(cv.password.equals(password)){
                return true;
            }
        }
        return false;
    }
    public Customer2(String firstName, String lastName, String email, String password, LocalDate dateOfBirth,
            double registrationAmount) {
        Customer2.id = Customer2.id + 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.subscribe = true;
        this.registrationAmount = registrationAmount;
    }

    public Customer2(String email) {
        this.email = email;
    }

    public LocalDate getdob(){
        return this.dateOfBirth;
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
        if (o instanceof Customer2) {
            return this.email.equals(((Customer2) o).email);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name :" + firstName + " " + lastName + "\nEmail : " + email + "\nDOB : " + dateOfBirth + "\nSubscribed"
                + subscribe + "\nPlan : " + SerPlan.getPlanName((int) registrationAmount);
    }
}

