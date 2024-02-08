import java.util.Scanner;

/**
 * StackTestClient for term-project assignment 2 to implement and test a Stack ADT class, ResizingArrayStack..
 * @author Rob Smith
 * @version 1.0
 */
public class StackTestClient {
    public static void main(String[]args){

        Stack<String> s = new ResizingArrayStack<String>();
        Scanner in = new Scanner ("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")){
                s.push(item);
            } else if (!s.isEmpty()) {
                System.out.println(s.pop()+" ");
            }
        }
        System.out.println("(" + s.size() + " left on the stack"+")");
    }
}
