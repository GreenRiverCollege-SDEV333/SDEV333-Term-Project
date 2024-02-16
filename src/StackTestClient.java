import java.util.Scanner;

/**
 * StackTestClient demonstrates the usage of a stack data structure.
 * It uses the Stack interface and the LinkedStack implementation
 * to perform stack operations.
 *
 * @author Braedon Billingsley
 */
public class StackTestClient {
    public static void main(String[] args) {
        Stack<String> s = new LinkedStack<>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");
        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                System.out.println(s.pop());

            }
        }
        System.out.println("(" + s.size() + " left on the stack)");
    }
}