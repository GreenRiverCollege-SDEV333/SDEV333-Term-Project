package Stack;

import java.util.Scanner;

public class StackTestClient {
    public static void main(String[] args) {
        // setup stack
        //Stack<String> storage = new ResizingArrayStack<String>();
        Stack<String> storage = new LinkedStack<String>();

        // setup scanner, taking in given string
        Scanner line = new Scanner("to be or not to - be - - that - - - is");

        // run through scanner
        while (line.hasNext()) {
            // get current item
            String item = line.next();

            // if the current item is not a dash
            if (!item.equals("-")) {
                // it is a word, add it to stack
                storage.push(item);
                System.out.println();
            }

            // if it is a dash, and the stack is not empty
            else if (!storage.isEmpty()) {
                // pop the topmost item off the stack, and display it
                System.out.println(storage.pop());
            }
        }

        // display how many items remain at end of string
        System.out.println("(" + storage.size() + " left on the stack)");
    }
}