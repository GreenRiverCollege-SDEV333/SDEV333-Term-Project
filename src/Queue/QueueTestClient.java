package Queue;

import java.util.Scanner;

public class QueueTestClient {
    public static void main(String[] args) {
        // setup storage queue
        Queue<String> storage = new LinkedQueue<String>();

        // setup scanner, taking in given string
        Scanner line = new Scanner("to be or not to - be - - that - - - is");

        // run through line
        while (line.hasNext()) {
            // get current item
            String item = line.next();

            // if the current item is not a dash
            if (!item.equals("-")) {
                // it is a word, add it to queue
                storage.enqueue(item);
                System.out.println();
            }

            // if it is a dash, and the stack is not empty
            else if (!storage.isEmpty()) {
                // get the item at front of queue, and display it
                System.out.println(storage.dequeue());
            }
        }

        // display how many items remain in queue at end of line
        System.out.println("(" + storage.size() + " left in the queue)");
    }
}
