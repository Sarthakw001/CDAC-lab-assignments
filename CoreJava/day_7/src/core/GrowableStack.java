package core;

public class GrowableStack implements Stack {
    private Customer3[] cst;
    private int size = STACK_SIZE;
    private int top;

    public GrowableStack() {
        cst = new Customer3[size];
        this.top = -1;
    }

    private boolean isFull() {
        if ((top + 1) == size) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void push(Customer3 c) {
        if (isFull()) {
            size *= 2;
            Customer3[] temp = new Customer3[cst.length];
            for (int i = 0; i < cst.length; i++)
                temp[i] = cst[i];
            cst = new Customer3[size];
            for (int i = 0; i < size - 1; i++)
                cst[i] = temp[i];
            cst[top + 1] = c;
            top++;
        } else {
            cst[top + 1] = c;
            top++;
        }
    }

    @Override
    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(cst[top]);
            cst[top] = null;
            top--;
        }
    }

    @Override
    public void display(){
        for(Customer3 c : cst){
            System.out.println(c);
        }
    }
}
