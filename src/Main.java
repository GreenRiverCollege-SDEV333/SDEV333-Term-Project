import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        ArrayList <String>  test1 = new ArrayList<>();
        test1.addBack("1");
        test1.addBack("2");
        test1.addBack("3");
        test1.addBack("4");
        test1.addBack("5");
        test1.addBack("6");

        test1.remove("10000");
        for (int i = 0; i < test1.size(); i++) {
            System.out.println(test1.get(i));
        }

    }
}