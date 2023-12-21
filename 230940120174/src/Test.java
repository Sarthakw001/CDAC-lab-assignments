import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter the size of Stack");
            int size = sc.nextInt();
            StackImpl stack = new StackImpl(size);
            boolean flag = true;
            while(flag){
                System.out.println("1 -> Push Element to Stack\n 2 -> Pop element from Stack\n 3 -> Top element of stack\n 4 -> Max Element from stack\n 0 -> Exit ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter the element to push to stack");
                        stack.push(sc.nextInt());
                        break;
                    case 2:
                        int pop = stack.pop();
                        System.out.println("Element popped is : "+pop);
                        break;
                    case 3:
                        int top = stack.top();
                        System.out.println("Top Element is : "+top);
                        break;
                    case 4:
                        int max = stack.max();
                        System.out.println("Max Element is : "+max);
                        break;
                    case 0:
                        flag = false;
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
