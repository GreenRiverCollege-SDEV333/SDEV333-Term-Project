package queue;


import java.util.Scanner;

public class QueueTestClient {
    public static void main(String[] args) {
        Queue <String> s = new LinkedQueue<String>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");
        while (in.hasNext())
        {
            String item = in.next();
            if (!item.equals("-"))
            {
                s.enqueue(item);
            }
            else if (!s.isEmpty())
            {
                System.out.println(s.dequeue() + " ");
            }
        }
        System.out.println( s.size() + " left on queue");
    }
}
