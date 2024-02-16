/**
 * Toby Goetz
 */

package driver;
import abstractDataTypes.LinkedStack;
import abstractDataTypes.ResizingArrayStack;
import interfaces.Stack;

import java.util.Scanner;

/**
 * @author Book People
 * @version 1.0
 */
public class StackTestClient {

    public static final String SHAKESPREARE = "to be or not to - be - - that - - - is";

    public static void main(String[] args)
    {
        String poppedValues = "";

        System.out.println("ResizingArrayStack:::Trace");
        System.out.println("--------------------------");

        Stack<String> arrayStack = new ResizingArrayStack<String>();
        Scanner in = new Scanner(SHAKESPREARE);

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                arrayStack.push(item);
            }
            else if (!arrayStack.isEmpty()) {
                poppedValues += arrayStack.pop() + " ";
            }
            System.out.println("(" + arrayStack);
        }
        System.out.println("\n" + poppedValues + " (" + arrayStack.size() + " left on stack)");



        poppedValues = "";
        System.out.println("\n \nLinkedStack:::Trace");
        System.out.println("---------------------");

        Stack<String> linkedStack = new LinkedStack<String>();
        in = new Scanner(SHAKESPREARE);

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                linkedStack.push(item);
            }
            else if (!linkedStack.isEmpty()) {
                poppedValues += linkedStack.pop() + " ";
            }
            System.out.println("(" + linkedStack);
        }
        System.out.println("\n" + poppedValues + " (" + linkedStack.size() + " left on stack)");

    }
}
