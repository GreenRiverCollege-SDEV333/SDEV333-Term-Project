import java.util.Scanner;

/**
 * A test for the linked queue
 * @author Lois Lanctot
 * @version 1.0
 */
public class QueueTestClient {

    /**
     * runs tests for the linked queue
     * @param args command line arguments passed to the program
     */
    public static void main(String[] args) {
        Queue<String> queue = new LinkedQueue<>();
        Scanner input = new Scanner("to be or not to - be - - that - - - is");

        while (input.hasNext()) {
            String item = input.next();
            if (!item.equals("-")) {
                queue.enqueue(item);
            }
            else if (!queue.isEmpty()) {
                System.out.println(queue.dequeue() + " ");
            }
        }

        System.out.println("(" + queue.size() + " left on the stack)");

    }
}
