import java.util.Scanner;

public class QueueTestClient {
    public static void main(String[] args)
    { // Create a queue and enqueue/dequeue strings.
        Queue<String> q = new LinkedQueue<>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");
        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")){
                q.enqueue(item);
            }
            else if (!q.isEmpty()) {
                System.out.println((q.dequeue() + " "));
            }
        }
        System.out.println("(" + q.size() + " left on queue)");
    }
}
