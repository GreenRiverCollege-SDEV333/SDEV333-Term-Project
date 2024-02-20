import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTests {
    @Test
    public void testAddFrontEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        assertEquals(Integer.valueOf(5), list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testAddFrontNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        list.addFront(10);
        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(Integer.valueOf(5), list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testAddBackEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addBack(5);
        assertEquals(Integer.valueOf(5), list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testAddBackNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addBack(5);
        list.addBack(10);
        assertEquals(Integer.valueOf(5), list.get(0));
        assertEquals(Integer.valueOf(10), list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testGetEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        assertNull(list.get(0));
    }

    @Test
    public void testGetNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        list.addFront(10);
        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(Integer.valueOf(5), list.get(1));
    }

    @Test
    public void testSetEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        list.set(0, 10);
        assertEquals(Integer.valueOf(10), list.get(0));
    }

    @Test
    public void testSetNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        list.addFront(10);
        list.set(1, 20);
        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(Integer.valueOf(20), list.get(1));
    }

    @Test
    public void testRemoveFrontEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        assertNull(list.removeFront());
    }

    @Test
    public void testRemoveFrontNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        list.addFront(10);
        assertEquals(Integer.valueOf(10), list.removeFront());
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveBackEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        assertNull(list.removeBack());
    }

    @Test
    public void testRemoveBackNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        list.addFront(10);
        assertEquals(Integer.valueOf(5), list.removeBack());
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        assertNull(list.remove(0));
    }

    @Test
    public void testRemoveNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        list.addFront(10);
        assertEquals(Integer.valueOf(5), list.remove(1));
        assertEquals(1, list.size());
    }

    @Test
    public void testContainsEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        assertFalse(list.contains(5));
    }

    @Test
    public void testContainsNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        list.addFront(10);
        assertTrue(list.contains(5));
    }

    @Test
    public void testIsEmptyEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSizeEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void testSizeNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(5);
        list.addFront(10);
        assertEquals(2, list.size());
    }
}
