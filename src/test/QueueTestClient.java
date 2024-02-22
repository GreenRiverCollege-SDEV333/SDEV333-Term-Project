package test; /**
 * Test client for the LinkedStack
 *
 * @author Lillian Nelson
 * @version 1.0
 */

import lists.LinkedQueue;

import java.util.Scanner;

public class QueueTestClient
{
    public static void main(String[] args) {
        LinkedQueue<Object> q = new LinkedQueue<>();
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
