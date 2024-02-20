import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Iterator;

public class ArrayListTests {
    @Test
    public void testAddFrontEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addFront(5);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(5), list.get(0));
    }

    @Test
    public void testAddFrontNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addFront(5);
        list.addFront(10);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(Integer.valueOf(5), list.get(1));
    }

    @Test
    public void testAddFrontNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        list.addFront(100);
        assertEquals(11, list.size());
        assertEquals(Integer.valueOf(100), list.get(0));
    }

    @Test
    public void testAddBackEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(5), list.get(0));
    }

    @Test
    public void testAddBackNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        list.addBack(10);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(5), list.get(0));
        assertEquals(Integer.valueOf(10), list.get(1));
    }

    @Test
    public void testAddBackNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        list.addBack(100);
        assertEquals(11, list.size());
        assertEquals(Integer.valueOf(0), list.get(0));
        assertEquals(Integer.valueOf(100), list.get(10));
    }

    @Test
    public void testAddEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 5);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(5), list.get(0));
    }

    @Test
    public void testAddNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 5);
        list.add(1, 10);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(5), list.get(0));
        assertEquals(Integer.valueOf(10), list.get(1));
    }

    @Test
    public void testAddNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        list.add(5, 100);
        assertEquals(11, list.size());
        assertEquals(Integer.valueOf(100), list.get(5));
        assertEquals(Integer.valueOf(5), list.get(6));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexOutOfBounds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1, 5);
    }

    @Test
    public void testGetNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        assertEquals(Integer.valueOf(5), list.get(0));
    }

    @Test
    public void testGetNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        assertEquals(Integer.valueOf(5), list.get(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBounds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        list.get(1);
    }

    @Test
    public void testSetNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        list.set(0, 10);
        assertEquals(Integer.valueOf(10), list.get(0));
    }

    @Test
    public void testSetNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        list.set(5, 100);
        assertEquals(Integer.valueOf(100), list.get(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexOutOfBounds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.set(1, 5);
    }

    @Test
    public void testRemoveFrontNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        assertEquals(Integer.valueOf(5), list.removeFront());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveFrontNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        assertEquals(Integer.valueOf(0), list.removeFront());
        assertEquals(9, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    public void testRemoveBackNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        assertEquals(Integer.valueOf(5), list.removeBack());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveBackNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        assertEquals(Integer.valueOf(9), list.removeBack());
        assertEquals(9, list.size());
    }

    @Test
    public void testRemoveEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.remove(Integer.valueOf(5));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        list.remove(Integer.valueOf(5));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        list.remove(Integer.valueOf(5));
        assertEquals(9, list.size());
        assertFalse(list.contains(5));
    }

    @Test
    public void testRemoveIndexNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        assertEquals(Integer.valueOf(5), list.remove(0));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveIndexNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        assertEquals(Integer.valueOf(5), list.remove(5));
        assertEquals(9, list.size());
        assertFalse(list.contains(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBounds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        list.remove(1);
    }

    @Test
    public void testContainsEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        assertFalse(list.contains(5));
    }

    @Test
    public void testContainsNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        assertTrue(list.contains(5));
    }

    @Test
    public void testContainsNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        assertTrue(list.contains(5));
    }

    @Test
    public void testIsEmptyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSizeEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void testSizeNearlyEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(5);
        assertEquals(1, list.size());
    }

    @Test
    public void testSizeNonEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        assertEquals(10, list.size());
    }

    @Test
    public void testIterator() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }

        Iterator<Integer> iterator = list.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            assertEquals(Integer.valueOf(count), iterator.next());
            count++;
        }
    }
}
