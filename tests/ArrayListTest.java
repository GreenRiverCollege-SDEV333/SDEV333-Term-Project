import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
        ArrayList<String> list = new ArrayList<>();

        //no items
        list.addFront("sleepy");
        assertEquals("sleepy", list.get(0));

        //one item
        list.addFront("nemui");
        assertEquals("sleepy", list.get(1));

        //multiple items
        list.addFront("frog");
        list.addFront("legs");
        assertEquals("legs", list.get(0));
        assertEquals("sleepy", list.get(3 ));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        ArrayList<String> list = new ArrayList<>();

        //no items
        list.addBack("last");
        assertEquals("last", list.get(0));

        //one item
        list.addBack("newLast");
        assertEquals("newLast", list.get(1));

        //multiple items
        list.addBack("something");
        list.addBack("is");
        list.addBack("not working");
        assertEquals("last",list.get(0));
        assertEquals("not working",list.get(4));
    }

    @org.junit.jupiter.api.Test
    void add() {
        ArrayList<String> list = new ArrayList<>();

        //no items
        list.add(0, "nothing");
        assertEquals("nothing", list.get(0));

        //one item
        list.add(1, "here");
        assertEquals("here", list.get(1));

        //multiple items
        list.add(1, "haha");
        assertEquals("haha", list.get(1));
        assertEquals("here", list.get(2));
    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayList<String> list = new ArrayList<>();

        //testing thrown errors
        assertThrows(IndexOutOfBoundsException.class, ()->{
            list.get(19);
        });

        //testing
        list.addBack("mary");
        list.addBack("had");
        list.addBack("a");
        list.addBack("little lamb");
        assertEquals("mary", list.get(0));
        assertEquals("little lamb", list.get(3));
    }

    @org.junit.jupiter.api.Test
    void set() {
        ArrayList<String> list = new ArrayList<>();

        //testing errors
        assertThrows(IndexOutOfBoundsException.class, ()->{
            list.set(1, "haha");
        });

        //no item
        list.addBack("bruh");
        list.set(0, "something else");
        assertEquals("something else", list.get(0));

        //no item
        list.addBack("bruhAgain");
        list.set(1, "something elseAgain");
        assertEquals("something elseAgain", list.get(1));

        //multiple items
        list.addBack("more");
        list.addBack("random");
        list.addBack("items");
        list.addBack("in this list");

        list.set(3, "new value");
        assertEquals("new value", list.get(3));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        ArrayList<String> list = new ArrayList<>();

        assertThrows(NoSuchElementException.class, ()->{
            list.removeFront();
        });

        //one item and no items
        list.addFront("something here");
        list.addFront("most front now");
        list.removeFront();
        assertEquals("something here", list.get(0));
        list.removeFront();
        assertNull(list.get(0));


        //multiples items
        list.addFront("1");
        list.addFront("2");
        list.addFront("3");
        list.addFront("4");
        assertEquals("4", list.removeFront());

    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        ArrayList<String> list = new ArrayList<>();

        assertThrows(NoSuchElementException.class, ()->{
            list.removeBack();
        });

        //one and no items
        list.addBack("something here");
        assertEquals("something here", list.removeBack());
        assertNull(list.get(0));

        //multiple items
        list.addBack("1");
        list.addBack("2");
        list.addBack("3");
        list.addBack("4");
        assertEquals("4", list.removeBack());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        ArrayList<String> list = new ArrayList<>();
        list.addBack("one");
        list.addBack("two");
        list.addBack("three");

        //remove with multiple items
        list.remove("one");
        assertEquals("two", list.get(0));

        //removing with only one time
        list.removeFront();
        assertEquals("three", list.get(0));
    }


    @org.junit.jupiter.api.Test
    void testRemove() {
        ArrayList<String> list = new ArrayList<>();
        list.addBack("one");
        list.addBack("two");
        list.addBack("three");

        //removing with multiple items
        list.remove(0);
        assertEquals("two", list.get(0));

        //removing to one item remaining
        list.remove(1);
        assertEquals("two", list.get(0));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        ArrayList<String> list = new ArrayList<>();

        //one item
        list.addBack("im sleepy");
        assertTrue(list.contains("im sleepy"));
        assertFalse(list.contains("awake"));

        //multiples
        list.addBack("one");
        list.addBack("two");
        list.addBack("three");

        //with items multiple items
        assertTrue(list.contains("one"));
        assertFalse(list.contains("four"));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        ArrayList<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());

        //one item
        list.addBack("an item");
        assertFalse(list.isEmpty());

        //more items
        list.addBack("more item");
        assertFalse(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        //nothing
        ArrayList<String> list = new ArrayList<>();
        assertEquals(0, list.size());

        //one item
        list.addBack("one item");
        assertEquals(1, list.size());

        //multiple
        list.addBack("one item");
        list.addBack("one item");
        list.addBack("one item");
        assertEquals(4, list.size());

    }

    @org.junit.jupiter.api.Test
    void iterator() {
        ArrayList<String> list = new ArrayList<>();
        Iterator<String> iterator =list.iterator();
        //nothing in here
        assertFalse(iterator.hasNext());

        //items added
        list.addBack("one");
        list.addBack("two");
        list.addBack("three");
        list.addBack("four");
        list.addBack("five");
        assertTrue(iterator.hasNext());

        //one item
        assertEquals("one", iterator.next());

        //next item
        assertEquals("two", iterator.next());

    }
}