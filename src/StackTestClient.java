import java.util.Scanner;

public class StackTestClient {
    public static void main(String[] args) {
//        Stack<String> s = new ResizingArrayStack<String>();
        Stack <String> s = new LinkedStack<String>();

        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        while (in.hasNext()) {
            String item = in.next();

            if (!item.equals("-")) {
                s.push(item);
            }
            else if (!s.isEmpty()) {
                s.pop();
                System.out.println(item +  " ");
            }
        }

        System.out.println("(" + s.size() + " left on the stack)");
    }
}
