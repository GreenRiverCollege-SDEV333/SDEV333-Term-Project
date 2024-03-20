import java.util.Scanner;

/**
 * class for test testing the linked stack class
 * @author Huy Nguyen
 * @version 1.0
 */
public class LinkedStackTestClient {
    public static void main(String[] args) {
        Stack<String> Links = new LinkedStack<>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                Links.push(item);
            } else if (!Links.isEmpty()) {
                System.out.print(Links.pop() + " ");
            }
        }
        System.out.println("(" + Links.size() + " left on the stack" + ")");
    }
}
