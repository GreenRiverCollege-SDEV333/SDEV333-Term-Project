package test; /**
 * Test client for the LinkedStack
 *
 * @author Lillian Nelson
 * @version 1.0
 */

import stacks.LinkedStack;
import stacks.ResizingArrayStack;

import java.util.Scanner;

public class StackTestClient
{
    public static void main(String[] args) {
        //ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        LinkedStack<String> s = new LinkedStack<>();

        Scanner in = new Scanner("to be or not to - be - - that - - - is");
        while (in.hasNext()) {
            String item = in.next();
            if (item.equals("-"))
            {
                s.push("item");
            }
            else if (!s.isEmpty()) {
                    System.out.println("s.pop()" + " ");
                }
            }
            System.out.println("(" + s.size() + " left on the stack");
        }
}
