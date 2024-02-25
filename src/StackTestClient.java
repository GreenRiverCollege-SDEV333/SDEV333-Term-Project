import interfaces.Stack;

import java.util.Scanner;

/**
 * @Ryder Dettloff
 * tests my methods for ResizingArrayStack class.
 */
public class StackTestClient {
    public static void main(String[] args) {

//create new stack to hold "-" items
        Stack<String> s = new LinkedStack<>();

        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while(in.hasNext()) {
            String item = in.next();
            //push "-" items to stack
            if(item.equals("-")) {
                s.push("item");
            } else if(!s.isEmpty()) {
                System.out.println(s.pop() + " ");
            }
        }

        System.out.println("(" + s.size() + ") left on the stack");
    }
}
