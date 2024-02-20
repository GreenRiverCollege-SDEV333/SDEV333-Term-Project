/**
 * This class is a test client program to test the LinkedStack class.
 * It reads input from the scanner and performs push
 * and pop operations on a stack based on the input.
 *
 * @author Dhiyaa Nazim
 */
import java.util.Scanner;
public class StackTestClient {
    public static void main(String[] args) {
        Stack<String> s = new LinkedStack<String>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");
        while (in.hasNext()) {
            String item = in.next();
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
