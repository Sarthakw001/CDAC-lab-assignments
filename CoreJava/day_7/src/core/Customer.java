package core;

public class Customer {
    private int id;
    private String name;
    private String address;

    public Customer (int id, String name, String address) {
        this.id = id;
        this.name =name;
        this.address = address;
    }

    public String toString(){
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
}
