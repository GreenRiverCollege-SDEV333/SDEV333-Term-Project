/*
 * SDEV333 Best class :D
 * Ming Li
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    // testing placeholders
    LinkedList<Integer> arrayTest = new LinkedList<>();

    @Test
    void addFront() {
        arrayTest.addFront(1);
        assertEquals(1, arrayTest.get(0));
    }

    @Test
    void addBack() {
        arrayTest.addFront(1);
        arrayTest.addFront(1);

        arrayTest.addBack(2);
        assertEquals(2, arrayTest.get(arrayTest.size() - 1));
    }

    @Test
    void add() {
        arrayTest.addFront(1);
        arrayTest.add(1, 21);
        assertEquals(21, arrayTest.get(1));
    }

    @Test
    void get() {
        arrayTest.addFront(2);
        arrayTest.addFront(32);
        arrayTest.addFront(2);

        assertEquals(32, arrayTest.get(1));
    }

    @Test
    void set() {
        arrayTest.addFront(2);
        arrayTest.addFront(32);
        arrayTest.addFront(2);

        arrayTest.set(1, 200);
        assertEquals(200, arrayTest.get(1));
    }

    @Test
    void removeFront() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);

        arrayTest.removeFront();
        assertEquals(2, arrayTest.get(0));
    }

    @Test
    void removeBack() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);

        arrayTest.removeBack();
        assertEquals(2, arrayTest.get(arrayTest.size() - 1));
    }

    @Test
    void remove() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);

        assertEquals(2, arrayTest.remove(1));
    }

    @Test
    void contains() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(53);

        assertEquals(true, arrayTest.contains(53));
    }

    @Test
    void isEmpty() {
        arrayTest.addFront(1);

        assertEquals(false, arrayTest.isEmpty());
    }

    @Test
    void size() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);

        assertEquals(3, arrayTest.size());
    }
}