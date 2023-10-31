package ADS_Java.day_6;
public class Node <T>{
    T data;
    Node<T> next;
    Node<T> previous;

    public Node(T data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}
