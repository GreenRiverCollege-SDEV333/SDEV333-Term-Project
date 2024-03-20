import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addFront() {
        LinkedList<String> empty = new LinkedList<>();
        //with an empty list
        empty.addFront("1");
        assertEquals("1",empty.get(0));

        //with a one element
        empty.addFront("4");
        assertEquals("4",empty.get(0));

        //with multiple elements
        empty.addFront("5");
        assertEquals("5",empty.get(0));
        assertEquals("1",empty.get(2));
    }

    @Test
    void addBack() {
        LinkedList<String> empty = new LinkedList<>();
        // With an empty list
        empty.addBack("2");
        assertEquals("2", empty.get(0));

        // With one element
        empty.addBack("10");
        assertEquals("10", empty.get(1));

        // With two elements
        empty.addBack("15");
        assertEquals("15", empty.get(2));

        // Make sure the other elements are still there
        assertEquals("2", empty.get(0));
        assertEquals("10", empty.get(1));
    }

    @Test
    void add() {
        LinkedList<String> empty = new LinkedList<>();

        // With an empty list
        empty.add(4, "20");
        assertEquals("20", empty.get(0));

        // With one element
        empty.add(1, "40");
        assertEquals("40", empty.get(1));

        // With two elements
        empty.add(1, "4");
        assertEquals("4", empty.get(1));

        // With more elements
        empty.add(1, "20");
        assertEquals("20", empty.get(1));

        // Testing shifting
        assertEquals("4", empty.get(2));

        // Testing when there are a lot of elements
        empty.add(3, "55");
        assertEquals("55", empty.get(3));

    }

    @Test
    void get() {
        LinkedList<String> empty = new LinkedList<>();

        // Testing errors with index positions
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.get(100);} );
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.get(-2);} );

        empty.addBack("1");
        empty.addBack("2");
        empty.addBack("3");

        // [1, 2, 3]
        assertEquals("3", empty.get(2));

        // Two element testing
        empty.add(8, "20");
        assertEquals("1", empty.get(0));
    }

    @Test
    void set() {
        LinkedList<String> empty = new LinkedList<>();

        // Testing errors with index positions
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.get(100);} );
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.get(-2);} );

        empty.addBack("one");
        empty.addBack("two");
        empty.addBack("three");
        empty.set(1, "newSet");
        assertEquals("newSet", empty.get(1));
    }

    @Test
    void removeFront() {
        // With one element
        LinkedList<String> empty = new LinkedList<>();
        empty.addBack("1");
        empty.addBack("2");
        // 1,2
        empty.removeFront();
        // 2
        assertEquals("2", empty.get(0));

        // With multiple elements
        empty.addBack("3");
        empty.addBack("4");
        // 2,3,4
        empty.removeFront();
        // 3,4
        assertEquals("3", empty.get(0));
    }

    @Test
    void removeBack() {
        LinkedList<String> empty = new LinkedList<>();

        // With one element
        empty.addBack("1");
        empty.addBack("2");
        // 1, 2
        empty.removeBack();
        // 1
        assertEquals("1", empty.get(0));

        // With multiple elements
        empty.addBack("3");
        empty.addBack("4");
        // 1, 3, 4
        empty.removeBack();
        // 1, 3
        assertEquals("1", empty.get(0));
        assertEquals("3", empty.get(1));
    }

    @Test
    void remove() {
        // Testing error throwing
        LinkedList<String> empty = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.remove(100);} );
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.remove(-1);} );

        // Removing at the start
        empty.addBack("1");
        empty.addBack("2");
        empty.addBack("3");
        empty.addBack("4");

        //removing at the start
        empty.remove("1");
        assertEquals("2", empty.get(0));

        //removing at the end
        empty.remove("4");
        assertEquals("3", empty.get(1));

    }

    @Test
    void testRemove() {
        // Testing error throwing
        LinkedList<String> empty = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.remove(100);} );
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.remove(-1);} );

        // Removing at the start
        empty.addBack("1");
        empty.addBack("2");
        empty.addBack("3");
        empty.addBack("4");
        // 1,2,3,4

        // Remove element at index 0
        // 2,3,4
        // Testing return value
        assertEquals("1", empty.remove(0));

        // Testing new index at the front
        assertEquals("2", empty.get(0));
        // 2,3,4

        // Remove element at index 2
        // 2,3
        assertEquals("4", empty.remove(2));

        // Testing newly formed list
        assertEquals("2",empty.get(0));
        assertEquals("3",empty.get(1));

        empty.addBack("4");
        empty.addBack("5");
        // 2,3,4,5

        // Remove element at index 2
        // 2,3,5
        assertEquals("4",empty.remove(2));

        // Testing new list
        assertEquals("2",empty.get(0));
        assertEquals("3",empty.get(1));
        assertEquals("5",empty.get(2));
    }

    @Test
    void contains() {
        LinkedList<String> empty = new LinkedList<>();

        // Test with an empty list
        assertEquals(false, empty.contains("5"));

        // Test with one element list
        empty.addBack("1");
        // 1
        assertEquals(true, empty.contains("1"));
        assertEquals(false, empty.contains("100"));

        // Test with two elements on the list (last on list)
        empty.addBack("4");
        // 1,4
        assertEquals(true, empty.contains("4"));
        assertEquals(false, empty.contains("199"));

        empty.addBack("99");
        assertEquals(false, empty.contains("100"));
        assertEquals(true, empty.contains("4"));
    }

    @Test
    void isEmpty() {
        LinkedList<String> empty = new LinkedList<>();

        //an empty list
        assertTrue(empty.isEmpty());

        empty.addBack("10");
        //non-empty list
        assertFalse(empty.isEmpty());
    }

    @Test
    void size() {
        LinkedList<String> empty = new LinkedList<>();

        // Empty list
        assertEquals(0, empty.size());

        // One element
        empty.addBack("1");
        assertEquals(1, empty.size());

        // Two elements
        empty.addBack("2");
        assertEquals(2, empty.size());

        // Many elements
        empty.addBack("3");
        empty.addBack("4");
        empty.addBack("5");
        assertEquals(5, empty.size());
    }

    @Test
    void iterator() {
        LinkedList<String> empty = new LinkedList<>();

        Iterator<String> iterator = empty.iterator();
        //empty
        assertFalse(iterator.hasNext());


        empty.addBack("1");
        empty.addBack("2");
        empty.addBack("3");
        empty.addBack("4");
        empty.addBack("5");

        assertTrue(iterator.hasNext());
        assertEquals("1", iterator.next());
        assertEquals("2", iterator.next());
    }
}