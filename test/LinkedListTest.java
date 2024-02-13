import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void add() {
        LinkedList<String> t = new LinkedList<>();

        assertTrue(t.isEmpty());

        // test add back functionality
        t.add(0 , "test");
        assertEquals(t.size(),1);
        assertEquals(t.get(0), "test");

        // test add front functionality
        t.add(0, "test2");
        assertEquals(t.size(), 2);
        assertEquals(t.get(0), "test2");

        // test add center functionality
        t.add(1, "test3");
        assertEquals(t.size(), 3);
        assertEquals(t.get(1), "test3");
    }

    @Test
    void addFront() {
        LinkedList<String> t = new LinkedList<>();

        t.addFront("test");
        assertEquals(t.size(), 1);

        t.addFront("test2");
        assertEquals(t.size(), 2);
        assertEquals(t.get(0), "test2");

    }

    @Test
    void addBack() {
        LinkedList<String> t = new LinkedList<>();
        t.addBack("test");
        t.addBack("test2");
        t.addBack("test3");

        assertEquals(t.get(0), "test");
        assertEquals(t.get(2), "test3");

    }

    @Test
    void get() {
        LinkedList<String> t = new LinkedList<>();

        t.addBack("1");
        t.addBack("2");
        t.addBack("3");
        t.addBack("4");

        // inside array
        assertEquals("3", t.get(2));

        // case: beginning of array
        assertEquals("1", t.get(0));

        // case: end of array
        assertEquals("4", t.get(3));

    }

    @Test
    void set() {
        LinkedList<String> t = new LinkedList<>();

        t.addBack("test");
        t.addBack("test");
        t.addBack("test");
        t.addBack("test");

        // case: inner array
        t.set(1, "set");
        assertEquals("set", t.get(1));

        // case: beginning of array
        t.set(0, "set2");
        assertEquals("set2", t.get(0));

        // case: end of array
        t.set(3, "set3");
        assertEquals("set3", t.get(3));
    }

    @Test
    void removeFront() {
        LinkedList<String> t = new LinkedList<>();

        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");


        var retval = t.removeFront();
        assertEquals(retval, "test1");

        retval = t.removeFront();
        assertEquals(retval, "test2");
    }

    @Test
    void removeBack() {
        LinkedList<String> t = new LinkedList<>();

        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");

        var retval = t.removeBack();
        assertEquals(retval, "test4");

        retval = t.removeBack();
        assertEquals(retval, "test3");
    }

    @Test
    void removeByIndex() {
        LinkedList<String> t = new LinkedList<>();

        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");

        // test remove inner index
        var retval = t.remove(1);
        assertEquals(retval, "test2");

        // test remove final index
        retval = t.remove(t.size()-1);
        assertEquals(retval, "test4");

        // test remove beginning index
        retval = t.remove(0);
        assertEquals(retval, "test1");
    }

    @Test
    void removeByElement() {
        LinkedList<String> t = new LinkedList<>();

        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");

        // test removing element that does not exist
        t.remove("test5");
        assertEquals(t.size(), 4);

        // test removing element that exists
        t.remove("test2");
        assertEquals(t.size(), 3);

    }

    @Test
    void contains() {
        LinkedList<String> t = new LinkedList<>();

        t.addBack("");
        t.addBack("test");
        t.addBack("toast");

        assertTrue(t.contains("test"));

        assertFalse(t.contains("test2"));

    }

    @Test
    void isEmpty() {
        LinkedList<String> t = new LinkedList<>();

        assertTrue(t.isEmpty());

        t.addBack("");
        assertFalse(t.isEmpty());

        t.removeBack();
        assertTrue(t.isEmpty());

    }

    @Test
    void size() {
        LinkedList<String> t = new LinkedList<>();

        assertTrue(t.isEmpty());

        t.addBack("test");
        assertTrue(t.size() == 1);

        t.removeBack();
        assertTrue(t.isEmpty());

    }

    @Test
    void iterator() {
        LinkedList<String> t = new LinkedList<>();
        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");

        for (var i : t) {
            assertTrue(t.contains(i));
        }
    }

}