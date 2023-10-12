package core;

public class GrowableStack implements Stack{
    private Customer[] cst;
    private int top;
    private int size = STACK_SIZE;
    public GrowableStack(Customer[] cst, int counter){
        cst = new Customer[size];
        this.top = -1;
    }

    private boolean isFull(){
        if((top+1) == size){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public void push(Customer c){
        if(isFull()){
            size++;
            Customer[] temp = new Customer[cst.length];
            for(int i=0;i<cst.length;i++)
                temp[i] = cst[i];
            cst = new Customer[size];
            for(int i=0;i<size-1;i++)
                cst[i] = temp[i];
            cst[top+1] = c;
            top++;
        }else {
            cst[top+1] = c;
            top++;
        }
    }

    @Override
    public void pop(){
        if(top == -1){
            System.out.println("Stack is empty");
        }else{
            System.out.println(cst[top]);
            cst[top] = null;
            top--;
        }
    }
}
