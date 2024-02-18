import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    ArrayList<Integer> arrayTest = new ArrayList<>();

    @org.junit.jupiter.api.Test
    void addFront() {
        arrayTest.addFront(5);
        assertEquals(5, arrayTest.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        arrayTest.addBack(1);
        assertEquals(1, arrayTest.get(0));
    }

    @org.junit.jupiter.api.Test
    void add() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);

        arrayTest.add(2, 2);
        assertEquals(2, arrayTest.get(2));
    }

    @org.junit.jupiter.api.Test
    void get() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);

        assertEquals(2, arrayTest.get(0));
        assertEquals(1, arrayTest.get(1));
    }

    @org.junit.jupiter.api.Test
    void set() {
        arrayTest.addBack(1);
        arrayTest.set(0, 2);

        assertEquals(2, arrayTest.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);

        assertEquals(2, arrayTest.removeFront());
        assertEquals(1, arrayTest.size());
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        arrayTest.addBack(1);
        arrayTest.addBack(2);

        assertEquals(2, arrayTest.removeBack());
        assertEquals(1, arrayTest.size());
    }

    @org.junit.jupiter.api.Test
    void remove1() {
        arrayTest.addBack(1);
        arrayTest.addBack(2);
        arrayTest.addBack(3);

        arrayTest.remove(Integer.valueOf(2));
        assertEquals(2, arrayTest.size());
        assertEquals(1, arrayTest.get(0));
        assertEquals(3, arrayTest.get(1));
    }

    @org.junit.jupiter.api.Test
    void remove2() {
        arrayTest.addBack(1);
        arrayTest.addBack(2);
        arrayTest.addBack(3);

        assertEquals(2, arrayTest.remove(1));
        assertEquals(2, arrayTest.size());
        assertEquals(3, arrayTest.get(1));

    }

    @org.junit.jupiter.api.Test
    void contains() {
        arrayTest.addBack(1);

        assertTrue(arrayTest.contains(1));
        assertFalse(arrayTest.contains(2));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(arrayTest.isEmpty());

        arrayTest.addBack(1);

        assertFalse(arrayTest.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0, arrayTest.size());

        arrayTest.addBack(1);
        arrayTest.addBack(2);

        assertEquals(2, arrayTest.size());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        arrayTest.addBack(1);
        arrayTest.addBack(2);

        Iterator<Integer> iterator = arrayTest.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertFalse(iterator.hasNext());
    }
}