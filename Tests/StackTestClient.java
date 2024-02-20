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

        System.out.println();
        System.out.println();

        Stack<String> s = new LinkedStack<String>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");
        while (in.hasNext()) {
            String item = in.next();
            if (item.equals("-")) {
                if (!s.isEmpty()) {
                    System.out.println(s.pop() + " ");
                }
            } else {
                s.push(item);
            }
        }
        System.out.println("(" + s.size() + " left on the stack)");
    }
}
