import java.util.Iterator;
import java.util.ListIterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        List<String> obj = new ArrayList<>();
        obj.addBack("hi");
        obj.addBack("bye");
        obj.addFront("first");
        obj.set(1,"set");
        obj.remove("bye");
        System.out.println(obj.contains("B"));
        System.out.println(obj);

       // System.out.println(obj.iterator());

        LinkedList<String> linked = new LinkedList<>();
        linked.addFront("hello");
        linked.addBack("dance");
        linked.add(0,"55.5");
        linked.set(2,"set");
        System.out.println(linked);


        Iterator<String> iterating = linked.iterator();
        while (iterating.hasNext()){
            System.out.println(iterating.next());
        }


    }
}