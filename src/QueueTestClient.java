import java.util.Scanner;

/**
 * This class is a test client for the Queue interface.
 * It demonstrates the usage of a Queue by creating a linked queue
 * and enqueueing/dequeueing strings.
 *
 * @author Braedon Billingsley
 */
public class QueueTestClient {
    public static void main(String[] args) { // Create a queue and enqueue/dequeue strings.
        Queue<String> q = new LinkedQueue<>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                q.enqueue(item);
            }
            else if (!q.isEmpty()) {
                System.out.println(q.dequeue() + " ");
            }
        }
        System.out.println("(" + q.size() + " left on queue)");
    }
}
