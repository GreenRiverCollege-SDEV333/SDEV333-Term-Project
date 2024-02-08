import java.util.Scanner;

/**
 * StackTestClient for term-project assignment 2 to implement and test a Stack ADT class, ResizingArrayStack.
 *
 * @author Rob Smith
 * @version 1.0
 */
public class StackTestClient {
    public static void main(String[] args) {

        Stack<String> stringStack = new ResizingArrayStack<String>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                stringStack.push(item);
            } else if (!stringStack.isEmpty()) {
                System.out.print(stringStack.pop() + " ");
            }
        }
        System.out.println("(" + stringStack.size() + " left on the stack" + ")");
    }
}
