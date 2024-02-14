/*
 * SDEV333 Best class :D
 * Ming Li
 */
import java.util.*;

public class StackTestClient {
    public static void main(String[] args) {
        // Stack<String> s = new ResizingArrayStack<>();
        Stack<String> s = new LinkedStack<>();

        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        // while there is next
        while (in.hasNext()) {
            // saves the next item
            String item = in.next();

            // if "-" push "item", otherwise print s.pop()
            if (!item.equals("-")) {
                s.push(item);
            }
            else if (!s.isEmpty()) {
                System.out.println(s.pop() + " ");
            }
        }

        System.out.println("(" + s.size() + " left on the stack)");
    }
}
