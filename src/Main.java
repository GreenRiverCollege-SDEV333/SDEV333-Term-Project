import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack<String> s = new ResizingArrayStack<String>();
        Scanner in = new Scanner("to be or not to - be - - that - - - is");
        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                s.pop();
            } else if (!s.isEmpty()) {
                System.out.println(s.pop() + " ");
            }
        }
        System.out.println("(" + s.size() + " left on the stack)");

    }
}