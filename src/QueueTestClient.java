import java.util.Scanner;

/**
 * Queue test client for term-project assignment 2 to implement and test a Stack ADT class, LinkedQueue.
 *
 * @author Rob Smith
 * @version 1.0
 */
public class QueueTestClient {

    public static void main(String[] args) {

        Queue<String> stringQueue = new LinkedQueue<>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                stringQueue.enqueue(item);
            } else if (!stringQueue.isEmpty()) {
                System.out.print(stringQueue.dequeue() + " ");
            }
        }
        System.out.println("(" + stringQueue.size() + " left on the stack" + ")");
    }
}
