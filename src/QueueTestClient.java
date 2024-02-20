/**
 *  This class serves as a test client for the methods found in LinkedQueue.java.
 *  @author Jared Eller
 *  @verison 1.0
 *  @date 2/20/24
 */

import java.util.Scanner;

public class QueueTestClient
{
    public static void main(String[] args) {
        Queue<String> q = new LinkedQueue<>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");
        while (in.hasNext())
        {
            String item = in.next();
            if (!item.equals("-"))
            {
                q.enqueue(item);
            }
            else if (!q.isEmpty())
            {
                System.out.print(q.dequeue() + " ");
            }
        }
        System.out.println("(" + q.size() + " left on the queue)");
    }
}
