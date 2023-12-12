public class StackImpl {
    private static final int DEFAULT_SIZE = 10;
    private final int [] st;
    private int top;
    private final int size;
    private final int [] maxStack;

    StackImpl(){
        this(DEFAULT_SIZE);
    }
    StackImpl(int size){
        this.size = size;
        this.top = -1;
        st = new int[size];
        maxStack = new int[size];
    }

    void push(int x) throws StackException{
        if(isFull()){
            throw new StackException("Stack Overflow");
        }
        st[++top] = x;
        maxStack[top] = top == 0 ? x : Math.max(x,st[top-1]);
    }

    int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack Underflow");
        }
        return st[top--];
    }

    int top() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack UnderFlow");
        }
        return st[top];
    }

    int max() throws StackException {
        if(isEmpty()){
            throw new StackException("Stack underflow");
        }
        return maxStack[top];
    }
    boolean isFull(){
        return top + 1 == size;
    }

    boolean isEmpty(){
        return top == -1;
    }
}
