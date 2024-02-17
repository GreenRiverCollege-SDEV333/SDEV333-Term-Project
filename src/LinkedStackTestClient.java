/**
 * demos the linked stack
 *
 * @author R.J. Trenchard
 * 2/15/2024
 */
import java.util.Scanner;


public class LinkedStackTestClient {
    public static void main(String[] args) {
        Stack<String> s = new LinkedStack<>();

        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                s.push(item);
            }
            else if (!s.isEmpty()) {
                System.out.print(s.pop() + " ");
            }
        }

        System.out.println("\n(" + s.size() + " left in the stack)");

    }

}
