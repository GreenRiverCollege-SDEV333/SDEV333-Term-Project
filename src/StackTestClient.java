import java.util.Scanner;

// Everything must be inside StackTestClient
// (just having public static void main without the StackTestClient declaration as implied by supplied code fails to run)

public class StackTestClient
{
    public static void main(String[] args) {
//        Stack<String> s = new ResizingArrayStack<String>();
        Stack<String> s = new LinkedStack<>();


        Scanner in = new Scanner("to be or not to - be - - that - - - is");

        // I made my own version for this StackTestClient since the supplied code seems incomplete/wrong

        while (in.hasNext()) {
            String item = in.next();

            if (!item.equals("-"))
            {
                s.push(item);
            }else if (!s.isEmpty()) {
                System.out.print(s.pop() + " ");
            }
        }

        // The supplied code doesn't work. I may be missing something but logically this isn't
        // doing what we're supposed to do and there is a bracket missing before the else if.

        // Apologies if I'm misunderstanding this, but adding the word "item" when there is a "-"
        // doesn't seem to be what the book wants us to do. Aren't we supposed to call s.pop() when
        // a "-" is found?

        // sout.println("s.pop" + " "); prints the word "s.pop" instead of calling function
        // and doesn't print within same line since its println not print

//        while (in.hasNext()) {
//            String item = in.next();
//
//            if (item.equals("-"))
//            {
//                s.push("item");
//             else if (!s.isEmpty()) {
//                System.out.println("s.pop()" + " ");
//            }
//        }

        System.out.println();

        // added for each loop to print contents of stack
        for (String string : s)
        {
            System.out.print(string + " ");
        }

        System.out.println();

        // Small nitpick but this println was also missing the ")" at the end of " left on the stack"
        System.out.println("(" + s.size() + " left on the stack)");
    }
}