import java.util.Scanner;

public class QueueTestClient {

    public static void main(String[] args) {
        Queue<String> q = new LinkedQueue<String>();
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

        System.out.println("(" + q.size() + " left on the stack)");

    }
}
