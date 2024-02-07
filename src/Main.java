//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static <T> void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Integer a = 1;
        Character c = '2';
        String b = "Test Value";
        Integer d = 4;
        ArrayList<T> example= new ArrayList<>();
        System.out.println("Is the array empty? "+example.isEmpty());
        example.addFront((T)a);
        System.out.println("Should add a 1"+example);
        example.addFront((T)c);
        System.out.println("Should show 2, 1" + example);
        example.addFront((T)d);
        System.out.println("Should show 4, 2, 1" + example);
        example.set(0, (T)b);
        System.out.println(example);
        example.addBack((T)c);
        System.out.println(example);
        example.remove((T)a);
        System.out.println(example);
        System.out.println("\nFor Each Test\n");
        for (int i=0;i<example.size();i++) {
            Double j = i+1*3.1415;
            for (T t:example) {
                example.set(i,(T)j);
                System.out.println(t);
            }
        }
    }
}