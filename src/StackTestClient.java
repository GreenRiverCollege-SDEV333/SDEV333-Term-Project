import java.util.Scanner;

/**
 * Tests the LinkedStack and ResizingArrayStack classes
 * with a string using a scanner. Prints the results
 * of the changes in the stacks.
 *
 * @author Will Castillo
 */
public class StackTestClient {

    /**
     * Tests for the LinkedQueue
     * @param args Not used
     */
    public static void main(String[] args) {
//        Stack<String> s = new ResizingArrayStack<String>();
        Stack <String> s = new LinkedStack<>();

        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();

            if (!item.equals("-")) {
                s.push(item);
            }
            else if (!s.isEmpty()) {
                System.out.println(s.pop() +  " ");
            }
        }

        System.out.println("(" + s.size() + " left on the stack)");
    }
}
