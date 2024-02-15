import java.util.Scanner;

/**
 * A test for the linked stack
 * @author Lois Lanctot
 * @version 1.0
 */
public class StackTestClient {

    /**
     * runs tests for the linked stack
     * @param args command line arguments passed to the program
     */
    public static void main(String[] args) {
        Stack<String> stack = new LinkedStack<>();
        Scanner input = new Scanner("to be or not to - be - - that - - - is");

        while (input.hasNext()) {
            String item = input.next();
            if (!item.equals("-")) {
                stack.push(item);
            }
            else if (!stack.isEmpty()) {
                System.out.println(stack.pop() + " ");
            }
        }

        System.out.println("(" + stack.size() + " left on the stack)");

    }
}
