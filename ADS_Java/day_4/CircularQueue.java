package ADS_Java.day_4;

public class CircularQueue {
    private int size;
    private int front, rear, currSize;
    private int[] arr = new int[size];

    public CircularQueue(int size) {
        this.size = size;
        front = rear = -1;
        currSize = 0;
    }

    public boolean isFull() {
        if (front == 0 && rear == size - 1)
            return true;
        else if (front == rear + 1)
            return true;
        else
            return false;
    }

    public boolean isEmpty() {
        if (front == -1)
            return true;
        return false;
    }

    public void enQueue(int element) {
        if (isFull())
            System.out.println("Queue Full");
        else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            arr[rear] = element;
            System.out.println(element + " Inserted");
            currSize++;
        }

    }

    public int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        } else {
            element = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            currSize--;
            return element;
        }
    }

    public int getPeek() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        } else
            return arr[front];
    }

    public int getCurrSize() {
        return this.currSize;
    }

    public void displayCircularQueue() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % size)
                System.out.print(arr[i] + " ");
            System.out.println(arr[i]);
            System.out.println("Rear -> " + rear);
        }
    }
}
