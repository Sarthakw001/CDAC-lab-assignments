import java.util.Scanner;

public class SinglyLinkedList {
    private int cnt = 0;
    private Node<Integer> head = null;
    private Node<Integer> tail = null;

    public void insert(int data) {
        Node<Integer> temp = new Node<>(data);
        if (head == null) {
            head = tail = temp;
            cnt++;
            return;
        }
        tail.next = temp;
        tail = temp;
        cnt++;
    }

    public void display() {
        Node<Integer> currHead = head;
        if (currHead == null)
            System.out.println("List Empty");
        while (currHead != null) {
            System.out.print(currHead.data + " -> ");
            currHead = currHead.next;
        }
        System.out.println("null");
    }

    public int size() {
        return this.cnt;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            SinglyLinkedList ls = new SinglyLinkedList();
            boolean flag = true;
            while (flag) {
                System.out.println(
                        "1 -> Display\n 2 -> Insert element to Linked List\n 3 -> Size of Linked List\n 4 -> Check if empty or Not\n  0 -> exit");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        ls.display();
                        break;
                    case 2:
                        System.out.println("Enter the data to push to linked list");
                        ls.insert(sc.nextInt());
                        break;
                    case 3:
                        int sz = ls.size();
                        System.out.println(sz);
                        break;
                    case 4:
                        if (ls.isEmpty())
                            System.out.println("List empty");
                        else
                            System.out.println("List not empty");
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        }
    }
}

