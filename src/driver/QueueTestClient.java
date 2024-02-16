/**
 * Toby Goetz
 */

package driver;

import abstractDataTypes.LinkedQueue;
import java.util.Scanner;

/**
 * @author Book People
 * @version 1.0
 */
public class QueueTestClient
{
    public static final String SHAKESPREARE = "to be or not to - be - - that - - - is";

    public static void main(String[] args)
    {  // Create a queue and enqueue/dequeue strings.
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        Scanner in = new Scanner(SHAKESPREARE);
        String poppedValues = "";

        System.out.println("LinkedQueue:::Trace");
        System.out.println("-------------------");

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                linkedQueue.enqueue(item);
            }
            else if (!linkedQueue.isEmpty()) {
                poppedValues += linkedQueue.dequeue() + " ";
            }
            System.out.println("(" + linkedQueue);
        }
        System.out.println("\n" + poppedValues + " (" + linkedQueue.size() + " left on stack)");
    }
}
