
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * Main class for SDEV333 Term part 1 and 2, Generic List Implementations and Implementing Stacks, Queues and Bag ADT.
 *
 * @author Braedon Billingsley
 */
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!" + "\n");

        // Test the ArrayList<E> constructor
        ArrayList<String> list = new ArrayList<>();

        // Test the addfront() method
        list.addFront("Hello");
        list.addFront("Test");
        list.addFront("Test1");
        list.addFront("Test2");
        list.addFront("Test3");
        list.addFront("Test4");
        list.addFront("Test5");
        list.addFront("Test6");
        list.addFront("Test7");
        list.addFront("Test8");
        list.addBack("Test9"); // Tested resize method as default capacity was 10. Also tests addBack
        list.add(0, "World"); // Test add method
        list.set(8, "Set"); // Test set method
        System.out.println(list.removeFront()); // Test removeFront method
        System.out.println(list.removeBack()); // Test removeBack method

        // Test the get() method
        System.out.println("Elements:");
        for (int i = 0; i < list.size(); i++) { //
            System.out.println(i + ": " + list.get(i)); // Iterate and display each object
        }
        System.out.println("\n" + "Size: " + list.size());
        // Try accessing an out-of-bounds index

        //System.out.println(list.get(3)); // Should throw IndexOutOfBoundsException

    }
}