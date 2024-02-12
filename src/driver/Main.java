package driver;

import abstractDataTypes.ArrayList;

import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final int ITERATIONS = 25;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        class Cat {
            String breed;

            public Cat(String breed) {
                this.breed = breed;
            }

            @Override
            public String toString() {
                return breed;
            }
        }

        String[] breeds = new String[]{
                "Tabby", "Siamese", "Calico",
                "Tabby", "Siamese", "Calico",
                "Tabby", "Siamese", "Calico",
                "Tabby", "Siamese", "Calico",
                "Tabby", "Siamese", "Calico",
                "Tabby", "Siamese", "Calico",
                "Tabby", "Siamese", "Calico",
                "Tabby", "Siamese", "Calico",
                "Tabby", "Siamese", "Calico",};

        Cat[] cats = new Cat[ITERATIONS];
        for (int i = 0; i < ITERATIONS; i++) {
            cats[i] = new Cat(breeds[i]);
//            System.out.println(cats[i]);

        }

        ArrayList<Cat> list = new ArrayList<>();
//        testArrayList(list);
        
        ArrayList<Object> listOfObjects = new ArrayList<>();
        listOfObjects.addFront(10);
        listOfObjects.addFront("Fresno");
        listOfObjects.addFront(1.55555555);
        listOfObjects.addFront('a');
        listOfObjects.addFront(new Cat(breeds[1]));
        listOfObjects.addFront(breeds);

        System.out.println(listOfObjects);
        
        listOfObjects.addBack(new Cat(breeds[0]));
        listOfObjects.addBack(new Cat(breeds[1]));
        listOfObjects.addBack(new Cat(breeds[0]));
        listOfObjects.addBack(new Cat(breeds[0]));
        listOfObjects.addBack(new Cat(breeds[0]));
        listOfObjects.addBack(new Cat(breeds[0]));
        System.out.println(listOfObjects);
//
        listOfObjects.set(0, 0);
        System.out.println(listOfObjects);


        listOfObjects.set((listOfObjects.size() -1), (listOfObjects.size() - 1));
        listOfObjects.set(0, "front");
        System.out.println(listOfObjects.size());
        System.out.println(listOfObjects);

        System.out.println(listOfObjects.removeFront());
        System.out.println(listOfObjects.removeFront());
        System.out.println(listOfObjects.removeBack());
        System.out.println(listOfObjects.removeBack());
        Cat lion = new Cat("Lion");
        listOfObjects.addFront(lion);

        System.out.println(listOfObjects.contains(lion));
        listOfObjects.removeBack();
        listOfObjects.removeBack();
        listOfObjects.removeBack();
        listOfObjects.removeBack();
        listOfObjects.removeBack();
        System.out.println(listOfObjects.contains("Fresn!"));
        
        System.out.println(listOfObjects);

        System.out.println(listOfObjects.contains('a'));




        System.out.println();
        System.out.println(listOfObjects);
        listOfObjects.remove((Object) "Fresno");
        System.out.println(listOfObjects);




//        while (!listOfObjects.isEmpty()) {
//            System.out.println(listOfObjects.removeFront());
//            System.out.println(listOfObjects);
//        }
//
//        System.out.println(listOfObjects.removeFront());
//        System.out.println(listOfObjects);



    }

    public static void testArrayList(ArrayList list) {

        for (int i = 0; i < ITERATIONS; i++) {
            list.addFront(i);

        }
        
        System.out.println(list);


    }
}