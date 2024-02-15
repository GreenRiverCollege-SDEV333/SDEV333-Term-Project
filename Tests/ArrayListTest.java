import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void addFront() {
        // Check if list is initially empty
        assertTrue(list.isEmpty());

        // Adding to an empty list
        list.addFront(1);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        // nearly empty list
        list.addFront(2);
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));

        // non-empty list
        for (int i = 3; i <= 10; i++) {
            list.addFront(i);
        }
        assertEquals(10, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void addBack() {
        // Check if list is initially empty
        assertTrue(list.isEmpty());

        // empty list
        list.addBack(1);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        // nearly empty list
        list.addBack(2);
        assertEquals(2, list.size());
        assertEquals(2, list.get(1));

        //non-empty list
        for (int i = 3; i <= 10; i++) {
            list.addBack(i);
        }
        assertEquals(10, list.size());
        assertEquals(10, list.get(9));
    }

    @Test
    void add() {
        // empty list
        assertTrue(list.isEmpty());
        list.add(0, 30);
        assertEquals((Integer)30, list.get(0));

        // nearly empty list
        list.add(1, 60);
        assertEquals((Integer)60, list.get(1));

        // non-empty list
        for (int i = 2; i < 10; ++i) {
            list.add(i, i * 30);
            assertEquals((Integer)(i * 30), list.get(i));
        }
    }

    @Test
    void get() {
        // empty list
        assertTrue(list.isEmpty());

        list.addBack(40);
        assertEquals((Integer)40, list.get(0));

        // nearly empty list
        list.addBack(80);
        assertEquals((Integer)80, list.get(1));

        // non-empty list
        for (int i = 2; i < 10; ++i) {
            list.addBack(i * 40);
            assertEquals((Integer)(i * 40), list.get(i));
        }
    }

    @Test
    void set() {
        // empty list
        assertTrue(list.isEmpty());

        list.addBack(50);
        list.set(0, 60);
        assertEquals((Integer)60, list.get(0));

        // nearly empty list
        list.addBack(100);
        list.set(1, 120);
        assertEquals((Integer)120, list.get(1));

        // non-empty list
        for (int i = 2; i < 10; ++i) {
            list.addBack(i * 50);
            list.set(i, i * 60);
            assertEquals((Integer)(i * 60), list.get(i));
        }
    }

    @Test
    void removeFront() {

        // nearly empty list
        list.addBack(15);
        list.removeFront();
        assertEquals(0, list.size());

        // non-empty list
        list.addBack(15);
        list.addBack(30);
        list.removeFront();
        assertEquals(1, list.size());
        assertEquals((Integer)30, list.get(0));
    }

    @Test
    void removeBack() {

        // nearly empty list
        list.addBack(25);
        list.removeBack();
        assertEquals(0, list.size());

        // non-empty list
        list.addBack(25);
        list.addBack(50);
        list.removeBack();
        assertEquals(1, list.size());
        assertEquals((Integer)25, list.get(0));
    }

    @Test
    void remove() {
        // empty list

        // nearly empty list
        list.addBack(35);
        list.remove((Integer)35);
        assertEquals(0, list.size());

        // non-empty list
        list.addBack(35);
        list.addBack(70);
        list.remove((Integer)35);
        assertEquals(1, list.size());
        assertEquals((Integer)70, list.get(0));
    }

    @Test
    void contains() {
        // empty list
        assertTrue(list.isEmpty());
        assertFalse(list.contains(55));

        // nearly empty list
        list.addBack(55);
        assertTrue(list.contains(55));
        assertFalse(list.contains(65));

        // non-empty list
        list.addBack(65);
        assertTrue(list.contains(55));
        assertTrue(list.contains(65));
    }

    @Test
    void isEmpty() {
        // empty list
        assertTrue(list.isEmpty());

        // nearly empty list
        list.addBack(75);
        assertFalse(list.isEmpty());

        // non-empty list
        list.addBack(85);
        assertFalse(list.isEmpty());
    }

    @Test
    void size() {
        // empty list
        assertEquals(0, list.size());

        // nearly empty list
        list.addBack(85);
        assertEquals(1, list.size());

        // non-empty list
        list.addBack(170);
        assertEquals(2, list.size());
    }

    @Test
    void iterator() {
        // empty list
        assertTrue(list.isEmpty());

        Iterator<Integer> iterator = list.iterator();
        assertFalse(iterator.hasNext());

        // nearly empty list
        list.addBack(10);
        iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals((Integer)10, iterator.next());

        // non-empty list
        list.addBack(20);
        list.addBack(30);
        iterator = list.iterator();

        assertTrue(iterator.hasNext());
        assertEquals((Integer)10, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals((Integer)20, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals((Integer)30, iterator.next());

        assertFalse(iterator.hasNext());
    }
}