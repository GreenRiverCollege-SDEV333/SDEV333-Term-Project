import java.util.Scanner;

public class QueueTestClient {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedQueue<String>();
        Scanner console = new Scanner("to be or not to - be - - that - - - is");
        while (console.hasNext()) {
            String item = console.next();
            if (!item.equals("-")) {
                queue.enqueue(item);
            } else if (!queue.isEmpty()) {
                System.out.print(queue.dequeue() + " ");
            }
        }
        System.out.println("(" + queue.size() + " left in the queue)");
    }
}