import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

    @Test
    void addFront() {
        // initially empty
        assertTrue(list.isEmpty());

        // empty list
        list.addFront(70);
        assertEquals(1, list.size());
        assertEquals(70, list.get(0));

        // nearly empty list
        list.addFront(100);
        assertEquals(2, list.size());
        assertEquals(100, list.get(0));
        assertEquals(70, list.get(1));

        // non-empty list
        for (int i = 2; i <= 10; i++) {
            list.addFront(i * 70);
        }
        assertEquals(11, list.size());
        assertEquals(700, list.get(0));
    }

    @Test
    void addBack() {
        // initially empty
        assertTrue(list.isEmpty());

        // empty list
        list.addBack(150);
        assertEquals(1, list.size());
        assertEquals(150, list.get(0));

        // nearly empty list
        list.addBack(200);
        assertEquals(2, list.size());
        assertEquals(150, list.get(0));
        assertEquals(200, list.get(1));

        // non-empty list
        for (int i = 3; i <= 10; i++) {
            list.addBack(i * 50);
        }
        assertEquals(10, list.size());
        assertEquals(500, list.get(9));
    }

    @Test
    void add() {
        // initially empty
        assertTrue(list.isEmpty());

        list.add(0,170); // empty list
        assertEquals(1, list.size());
        assertEquals(170, list.get(0));

        list.add(1,200); // nearly empty list
        assertEquals(2, list.size());
        assertEquals(200, list.get(1));

        // non-empty list
        for (int i = 2; i < 10; i++) {
            list.add(i, i*100);
        }
        assertEquals(10, list.size());
        assertEquals(900, list.get(9));
    }

    @Test
    void get() {
        // initially empty
        assertTrue(list.isEmpty());

        list.addFront(70);
        assertEquals(1, list.size());
        assertEquals(70, list.get(0)); // empty list

        list.addBack(90);
        assertEquals(2, list.size());
        assertEquals(90, list.get(1)); // nearly empty list

        // non-empty list
        for (int i = 2; i < 10; i++) {
            list.addBack(i*10);
            assertEquals(i*10, list.get(i));
        }
    }

    @Test
    void set() {
        // initially empty
        assertTrue(list.isEmpty());

        list.addFront(150);
        list.set(0, 210); // empty list
        assertEquals(1, list.size());
        assertEquals(210, list.get(0));

        list.addBack(200);
        list.set(1, 220); // nearly empty list
        assertEquals(2, list.size());
        assertEquals(220, list.get(1));

        // non-empty list
        for (int i = 2; i < 10; i++) {
            list.addBack(i*20); //add elements at the end of the list
            list.set(i, i*30);  // modify the just added element
            assertEquals(i*30, list.get(i));
        }
    }

    @Test
    void removeFront() {
        assertThrows(NoSuchElementException.class, list::removeFront);

        list.addBack(150);
        assertEquals(150, list.removeFront()); // empty list
        assertEquals(0, list.size());

        list.addBack(210); // nearly empty list
        list.addBack(220);
        assertEquals(210, list.removeFront());
        assertEquals(1, list.size());
        assertEquals(220, list.get(0));

        list.removeFront(); // remove the existing item 220
        assertEquals(0, list.size()); // after removeFront(), size should be 0

        // non-empty list
        for(int i = 0; i < 8; i++) {
            list.addBack(i * 50);  // Add elements to the list
        }
        assertEquals(8, list.size()); // Check if 8 items were added

        for(int i = 0; i < 8; i++) {
            assertEquals(i * 50, list.removeFront()); // Check each item
        }
    }

    @Test
    void removeBack() {
        assertThrows(NoSuchElementException.class, list::removeBack);

        list.addBack(150);
        assertEquals(150, list.removeBack()); // empty list
        assertEquals(0, list.size());

        list.addBack(250); // near empty list
        list.addBack(260);
        assertEquals(260, list.removeBack());
        assertEquals(1, list.size());
        assertEquals(250, list.get(0));

        // non-empty list
        for(int i = 0; i < 8; i++) {
            list.addBack(i * 40 + 300);
        }
        assertEquals(580, list.removeBack());
    }

    @Test
    public void removeItem() {
        // trouble setting this up
    }

    @Test
    public void testRemoveAtIndex() {
        // trouble setting this up
    }

    @Test
    void contains() {
        assertFalse(list.contains(70));

        list.addBack(70); // empty list
        assertTrue(list.contains(70));

        list.addBack(200); // nearly empty list
        assertTrue(list.contains(200));

        // non-empty list
        for(int i = 2; i < 10; i++) {
            list.addBack(i * 75);
        }
        assertTrue(list.contains(600)); // check contains for non-empty list
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());

        list.addBack(70); // Empty list
        assertFalse(list.isEmpty());

        list.addBack(200); // Nearly empty list
        assertFalse(list.isEmpty());

        list.remove(0);
        list.remove(0); // clear list / test again
        assertTrue(list.isEmpty());

    }

    @Test
    void size() {
        assertEquals(0, list.size());

        list.addBack(70); // Empty list
        assertEquals(1, list.size());

        list.addBack(200); // Nearly empty list
        assertEquals(2, list.size());

        // non-empty list
        for(int i = 2; i < 10; i++) {
            list.addBack(i * 75);
        }
        assertEquals(10, list.size());
    }

    @Test
    void iterator() {
        // trouble setting this up
    }
}