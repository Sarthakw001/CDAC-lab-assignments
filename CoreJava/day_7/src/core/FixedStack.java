package core;

public class FixedStack implements Stack {
    private Customer3[] cst;
    private int top;

    public FixedStack() {
        cst = new Customer3[STACK_SIZE];
        this.top = -1;
    }

    @Override
    public void push(Customer3 c) {
        if ((top + 1) < cst.length) {
            cst[top + 1] = c;
            top++;
        } else {
            System.out.println("Stack is full");
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
