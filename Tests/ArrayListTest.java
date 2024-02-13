import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void addFront() {
        list.addFront(10);
        assertEquals((Integer)10, list.get(0));
    }

    @Test
    void addBack() {
        list.addBack(20);
        assertEquals((Integer)20, list.get(0));
    }

    @Test
    void add() {
        list.add(0, 30);
        assertEquals((Integer)30, list.get(0));
    }

    @Test
    void get() {
        list.addBack(40);
        assertEquals((Integer)40, list.get(0));
    }

    @Test
    void set() {
        list.addBack(50);
        list.set(0, 60);
        assertEquals((Integer)60, list.get(0));
    }

    @Test
    void removeFront() {
        list.addBack(15);
        list.removeFront();
        assertEquals(0, list.size());
    }

    @Test
    void removeBack() {
        list.addBack(25);
        list.removeBack();
        assertEquals(0, list.size());
    }

    @Test
    void remove() {
        list.addBack(35);
        list.remove((Integer)35);
        assertEquals(0, list.size());
    }

    @Test
    void removeAtIndex() {
        list.addBack(45);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void contains() {
        list.addBack(55);
        assertTrue(list.contains(55));
        assertFalse(list.contains(65));
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.addBack(75);
        assertFalse(list.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, list.size());
        list.addBack(85);
        assertEquals(1, list.size());
    }
}