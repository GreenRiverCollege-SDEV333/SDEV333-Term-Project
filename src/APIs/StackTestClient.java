package APIs;

import java.util.Scanner;

public class StackTestClient {
    public static void main(String[] args) {
        // setup stack
        Stack<String> storage = new ResizingArrayStack<String>();

        // setup scanner, taking in given string
        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        // run through scanner
        while (in.hasNext()) {
            // get current item (word)
            String item = in.next();

            // if the current item is a dash
            if (item.equals("-")) {
                // add a value to stack
                storage.push("item");
            }

            // if the stack is not empty
            else if (!storage.isEmpty()) {
                System.out.println("s.pop()" + " ");
            }
        }

        // display how many items remain
        System.out.println("(" + storage.size() + " left on the stack");
    }
}
