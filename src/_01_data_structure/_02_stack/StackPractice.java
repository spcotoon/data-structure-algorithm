package _01_data_structure._02_stack;

public class StackPractice {
    public static void main(String[] args) {
        StackSample stack = new StackSample();

        System.out.println("===first===");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());

        System.out.println("===second===");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek().getData());
        stack.pop();
        System.out.println(stack.peek().getData());
        System.out.println("isEmpty: " + stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println(stack.pop());
    }
}
