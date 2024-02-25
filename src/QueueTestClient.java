import interfaces.Queue;

import java.util.Scanner;

/**
 *
 * @Ryder Dettloff
 * Test for the LinkedQueue Class
 *
 */
public class QueueTestClient
{
    public static void main(String[] args)
    {
        Queue<String> s = new LinkedQueue<>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");
// checks next string for "-" if it doesn't contain it places it at the end of the queue
        while(in.hasNext()){
            String item = in.next();
                if(!item.equals("-")) {
                    s.enqueue(item);
                    //if it contains "-" and is not empty it removes it from the head and replace it with a space
                } else if(!s.isEmpty()) {
                System.out.println(s.dequeue() + " ");
            }
        }
        //after all items are processed it returns the size left in the stack
        System.out.println("(" + s.size() + " left on the stack)");
    }
}
