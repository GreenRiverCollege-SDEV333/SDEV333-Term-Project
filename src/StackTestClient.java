import java.util.Scanner;
/**
 *
 * test the methods in the ResizingArrayStack<E> and LinkedStack
 *
 * Linked-list implementation and resizing array
 * @author Kayley Young
 */
public class StackTestClient {

    public static void main(String[] args) {
        //Stack<String> s = new ResizingArrayStack<>();
        Stack<String> s = new LinkedStack<>();
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
