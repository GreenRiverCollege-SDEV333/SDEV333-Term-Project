import java.util.Scanner;

/**
 * class for testing the LinkedQueue class
 * @author Huy Nguyen
 * @version 1.0
 */
public class QueueTestClient {
    public static void main(String[] args) {
        Queue<String> q = new LinkedQueue<>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                q.enqueue(item);
            } else if (!q.isEmpty()) {
                System.out.print(q.dequeue() + " ");
            }
        }
        System.out.println("(" + q.size() + " left on the stack" + ")");
    }
}
