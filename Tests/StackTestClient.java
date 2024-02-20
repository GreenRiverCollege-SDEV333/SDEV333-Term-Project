import java.util.Scanner;

public class StackTestClient {
    public static void main(String[] args) {
        Stack<String> stack = new ResizingArrayStack<String>();
        Scanner console = new Scanner("to be or not to - be - - that - - - is");
        while (console.hasNext()) {
            String item = console.next();
            if (item.equals("-")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop() + " ");
                }
            } else {
                stack.push(item);
            }
        }
        System.out.println("(" + stack.size() + " left on the stack)");
    }
}
