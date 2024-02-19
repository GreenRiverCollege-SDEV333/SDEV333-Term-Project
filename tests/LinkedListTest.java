import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList <String> list= new LinkedList<>();

    @Test
    void addFront() {
//          TODO  Does the method work when the data structure is empty?
        list.addFront("1");
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront("2");
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront("3");
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addFront( " " + i + " ");
        }
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void addBack() {
        //          TODO  Does the method work when the data structure is empty?
        list.addBack("1");
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addBack("2");
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addBack("3");
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addBack( " " + i + " ");
        }
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void add() {
        //          TODO  Does the method work when the data structure is empty?
        list.add(0, "1");
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.add(1, "2");
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.add(2, "3");
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addBack( " " + i + " ");
        }
        list.add(23, "change");
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void get() {
        //  TODO  Does the method work when the data structure is empty?
//it will throw an exception if the list is empty//          T
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront( "jkdsjfkls");
        list.get(0);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(" jdshfjksdhj ");
        list.get(1);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addBack( " " + i + " ");
        }
        list.add(23," chjasjdfas");
        list.get(23);
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void set() {
        //  TODO  Does the method work when the data structure is empty?
//it will throw an exception if the list is empty//          T
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront( "jkdsjfkls");
        list.set(0, "changed ");
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(" jdshfjksdhj ");
        list.set(1 , " changeeed 2 ");
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addBack( " " + i + " ");
        }
        list.add(23," chjasjdfas");
        list.set(23 , "changeeedddd");
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void removeFront() {
        //  TODO  Does the method work when the data structure is empty?
//it will throw an exception if the list is empty//          T
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront( "jkdsjfkls");
        list.removeFront();
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(" jdshfjksdhj ");
        list.removeFront();
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addBack( " " + i + " ");
        }
        list.add(23," chjasjdfas");
        list.removeFront();
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void removeBack() {
        //  TODO  Does the method work when the data structure is empty?
//it will throw an exception if the list is empty//          T
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront( "jkdsjfkls");
        list.removeBack();
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(" jdshfjksdhj ");
        list.removeBack();
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addBack( " " + i + " ");
        }
        list.add(23," chjasjdfas");
        list.removeBack();
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void remove() {
        //  TODO  Does the method work when the data structure is empty?
//it will throw an exception if the list is empty//          T
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront( "jkdsjfkls");
        list.remove(0);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(" jdshfjksdhj ");
        list.addFront(" jdshfjksdhj 12 ");
        list.remove(1);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addBack( " " + i + " ");
        }
        list.add(23," chjasjdfas");
        list.remove(23);
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void testRemove() {
        //  TODO  Does the method work when the data structure is empty?
//it will throw an exception if the list is empty//          T
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront( "jkdsjfkls");
        list.remove("jkdsjfkls");
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(" jdshfjksdhj ");
        list.addFront(" jdshfjksdhj 12 ");
        list.remove(" jdshfjksdhj 12 ");
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addBack( " " + i + " ");
        }
        list.add(23," theonetoremove");
        list.remove(" theonetoremove");
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void contains() {
        //  TODO  Does the method work when the data structure is empty?
//it will throw an exception if the list is empty//          T
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront( "jkdsjfkls");
        list.contains("jkdsjfkls");
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(" jdshfjksdhj ");
        list.addFront(" jdshfjksdhj 12 ");
        list.contains(" jdshfjksdhj 12 ");
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 20000; i++) {
            list.addBack( " " + i + " ");
        }
        list.add(23," theonetoremove");
        list.contains(" theonetoremove");
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void isEmpty() {
        //  TODO  Does the method work when the data structure is empty?
        assertEquals(true, list.isEmpty());
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addBack("200");
        assertEquals(false, list.isEmpty());
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addBack("203");
        assertEquals(false, list.isEmpty());
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 3000; i++) {
            list.addBack(i + " ");
        }
        assertEquals(false, list.isEmpty());
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        int index = 0;
        for (String item : list) {
            index++;
            System.out.println("index " + (index - 1 ) + ": " +  item);
        }
    }

    @Test
    void size() {
        //          TODO  Does the method work when the data structure is empty?
        assertEquals(0, list.size());
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront("203");
        assertEquals(1, list.size());
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront("39490");
        assertEquals(2, list.size());
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 304534; i++) {
            list.addFront(i + " ");
        }
        assertEquals(304536, list.size());
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s

    }
}