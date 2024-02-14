/*
 * SDEV333 Best class :D
 * Ming Li
 */
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    // testing placeholders
    ArrayList<Integer> arrayTest = new ArrayList<>();

    @org.junit.jupiter.api.Test
    void addFront() {
        arrayTest.addFront(1);
        assertEquals(1, arrayTest.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        arrayTest.addBack(1);
        assertEquals(1, arrayTest.get(arrayTest.size()));
    }

    @org.junit.jupiter.api.Test
    void add() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);
        arrayTest.addFront(4);

        arrayTest.add(3, 2);
        assertEquals(2, arrayTest.get(3));
    }

    @org.junit.jupiter.api.Test
    void get() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);
        arrayTest.addFront(4);

        arrayTest.get(1);
        assertEquals(3, arrayTest.get(1));
    }

    @org.junit.jupiter.api.Test
    void set() {
        arrayTest.addFront(1);

        arrayTest.set(0, 21);
        assertEquals(21, arrayTest.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        arrayTest.addFront(2);
        arrayTest.addFront(1);

        arrayTest.removeFront();
        assertEquals(2, arrayTest.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        arrayTest.addFront(2);
        arrayTest.addFront(1);

        arrayTest.removeBack();
        assertEquals(2, arrayTest.get(arrayTest.size()));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);
        arrayTest.addFront(4);

        assertEquals(2, arrayTest.remove(2));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);
        arrayTest.addFront(42);

        assertEquals(true, arrayTest.contains(42));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertEquals(true, arrayTest.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0, arrayTest.size());
    }
}
