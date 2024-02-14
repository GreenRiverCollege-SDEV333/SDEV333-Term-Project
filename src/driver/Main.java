package driver;

import abstractDataTypes.ArrayList;
import abstractDataTypes.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * @author tobygoetz
 * @version 1.0
 * Driver class to test ArrayList and LinkedList that
 * implement list.java
 */
public class Main {

    public static final int ITERATIONS = 25;

    /**
     * program to run Main Class
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        class Cat {
            private String breed;

            public Cat(String breed) {
                this.breed = breed;
            }

            @Override
            public String toString() {
                return breed;
            }
        }

        String[] breeds = new String[]{
                "Tabby", "Siamese", "Calico"};

        ArrayList<Object> listOfObjects = new ArrayList<>();
        listOfObjects.addFront(10);
        listOfObjects.addFront("Fresno");
        listOfObjects.addFront(ITERATIONS);
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
        listOfObjects.remove((Object) 'a');
        System.out.println(listOfObjects);

        System.out.println(listOfObjects.remove(0));
        System.out.println(listOfObjects);






        // LinkedList Tests

        LinkedList linkedList = new LinkedList<>();

        linkedList.addFront("Toby");
        linkedList.addFront(Math.random());
        linkedList.addFront('%');

        linkedList.addBack(3);
        linkedList.addBack(4);
        linkedList.addBack(5);

        linkedList.add(3, "Middle");
        linkedList.add(0, "Front");
        linkedList.add(8, "End");
        
        System.out.println(linkedList);

        System.out.println(linkedList.get(3));

        System.out.println(linkedList.contains(Math.random()));

        System.out.println(linkedList);

        linkedList.set(0, "Tobiah");
        linkedList.set(8, "Howdy");
        linkedList.set(4, "Howdy");
        System.out.println(linkedList);

        System.out.println(linkedList.removeFront());
        System.out.println(linkedList);
        System.out.println(linkedList.removeFront());
        System.out.println(linkedList);
        System.out.println(linkedList.removeFront());
        System.out.println(linkedList);

        System.out.println(linkedList.removeBack());
        System.out.println(linkedList);
        System.out.println(linkedList.removeBack());
        System.out.println(linkedList);

        linkedList.remove("Toby");
        System.out.println(linkedList);

        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        ArrayList<Object> tobysList = new ArrayList<>();
        System.out.println(tobysList);
        tobysList.addFront("Toby");
        System.out.println(tobysList.get(0));
    }
}