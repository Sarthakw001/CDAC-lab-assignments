package core;

import java.util.List;

public class Customer3 {
    private int id;
    private String name;
    private String address;

    public Customer3(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Customer3(String email) {
    }

    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

    public static boolean signIn(String email11, String password11, List<Customer3> customers) {
        return false;
    }
}
