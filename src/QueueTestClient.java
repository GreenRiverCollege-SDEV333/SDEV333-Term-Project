/**
 * demos the queue
 *
 * @author R.J. Trenchard
 * 2/15/2024
 */
import java.util.Scanner;


public class QueueTestClient {
    public static void main(String[] args) {
        Queue<String> q = new LinkedQueue<>();

        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                q.enqueue(item);
            }
            else if (!q.isEmpty()) {
                System.out.print(q.dequeue() + " ");
            }
        }

        System.out.println("\n(" + q.size() + " left in the queue)");

    }

}
