//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        ArrayList<Integer> listTest = new ArrayList<>();
        listTest.addFront(21);
        listTest.addFront(20);
        listTest.addFront(19);

        for(Integer i : listTest) {
            System.out.println(i);
        }


    }
}