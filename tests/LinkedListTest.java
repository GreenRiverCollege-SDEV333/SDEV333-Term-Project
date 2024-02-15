import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void addFront() {
        LinkedList<Integer> array = new LinkedList<>();

        for (int i = 0; i < 20; i++) {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }

    }

    @Test
    void addBack() {
        LinkedList<Integer> array = new LinkedList<>();

        for (int i = 0; i < 20; i++) {
            array.addBack(i);
            assertEquals(array.get(array.size()-1), i);
        }

    }

    @Test
    void add() {
        LinkedList<Integer> array = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(1, 8));

        for (int i = 0; i < 20; i++) {
            array.add(i, i+1);
            assertEquals(array.get(i), i+1);
        }

    }

    @Test
    void removeFront() {
        LinkedList<String> array = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> array.removeFront());
        assertEquals(array.size(), 0);

        array.addFront("test1");
        array.removeFront();
        assertEquals(array.size(), 0);

        array.addFront("test2");
        array.addFront("test3");
        array.removeFront();
        assertEquals(array.size(), 1);

        array.addFront("test4");
        array.addFront("test5");
        array.removeFront();
        assertEquals(array.size(), 2);

    }

    @Test
    void removeBack() {
        LinkedList<Integer> array = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> array.removeBack());
        assertEquals(array.size(), 0);

        array.addFront(6);
        array.removeBack();
        assertEquals(0, array.size());

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(1, array.size());

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(2, array.size());

    }

    @Test
    void removeItem() {
        LinkedList<String> array = new LinkedList<>();

        array.addFront("test1");
        array.remove("test1");
        assertEquals(array.size(), 0);

        array.addFront("test2");
        array.addFront("test3");
        array.remove("test3");
        assertEquals(array.size(), 1);

        array.addFront("test4");
        array.addFront("test5");
        array.remove("test4");
        assertEquals(array.size(), 2);
    }

    @Test
    void removeIndex() {
        LinkedList<String> array = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(0));

        array.addFront("test1");
        array.remove(0);
        assertEquals(array.size(), 0);

        array.addFront("test2");
        array.addFront("test3");
        array.remove(1);
        assertEquals(array.size(), 1);

        array.addFront("test4");
        array.addFront("test5");
        array.remove(2);
        assertEquals(array.size(), 2);
    }

    @Test
    void get() {
        LinkedList<Integer> array = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));

        for (int i = 0; i < 20; i++) {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }
    }

    @Test
    void set() {
        LinkedList<Integer> array = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> array.set(0, 3));
        array.addFront(1);

        for (int i = 1; i < 10; i++) {
            array.addFront(i);
        }

        array.set(4, 7);
        assertEquals(7, array.get(4));

    }

    @Test
    void contains() {
        LinkedList<Integer> array = new LinkedList<>();

        assertFalse(array.contains(4));

        array.addFront(3);
        assertTrue(array.contains(3));
        assertFalse(array.contains(9));


        array.addFront(8);
        assertTrue(array.contains(3));
        assertFalse(array.contains(0));

        for (int i = 0; i < 4; i++) {
            array.addFront(i);
        }
        assertTrue(array.contains(2));
        assertFalse(array.contains(100));
    }

    @Test
    void isEmpty() {
        LinkedList<Integer> array = new LinkedList<>();
        assertTrue(array.isEmpty());

        for (int i = 0; i < 20; i++) {
            array.addBack(i);
            assertFalse(array.isEmpty());
        }
    }

    @Test
    void size() {
        LinkedList<Integer> array = new LinkedList<>();
        assertEquals(array.size(), 0);

        for (int i = 1; i < 20; i++) {
            array.addBack(i);
            assertEquals(array.size(), i);
        }
    }


}
