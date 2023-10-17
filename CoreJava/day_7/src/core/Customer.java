package core;

import java.time.LocalDate;

public class Customer {
    private int id;
    private String name;
    private String address;

    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Customer(String email) {
    }

    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

    public static Customer signUp(String firstName, String lastName, String email, String password, LocalDate dob,
            double registrationAmount) {
        return null;
    }
}
