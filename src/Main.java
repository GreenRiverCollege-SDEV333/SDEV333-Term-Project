import java.util.Arrays;

/**
 * Implementation of the LinkedList<E> and ArrayList<E> using the List<E> interface. This is my term assignment 1.
 * @author Rob Smith
 * "
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static <T> void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        LinkedList<T> example= new LinkedList<T>();
        example.addFront((T)"Front Value");
        System.out.println(example);
        example.addBack((T)"Back Value");
        System.out.println(example);
        for (int i = 1; i < 99; i++) {
            example.add(i, (T)(i+" Value"));
        }
        System.out.println(example);
        example.set(23, (T)"VALUE TWENTY THREE");
        System.out.println(example);
        for(T t: example){
            System.out.println(t);
        }
    }
}