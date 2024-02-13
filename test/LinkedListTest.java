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
        arrayTest.addBack(1);
        assertEquals(1, arrayTest.get(arrayTest.size()));
    }

    @Test
    void add() {
        arrayTest.addFront(1);
        arrayTest.add(0, 21);
        assertEquals(21, arrayTest.get(0));
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeBack() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }
}