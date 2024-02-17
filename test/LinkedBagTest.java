import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBagTest {

    @Test
    void add() {
        Bag<String> bag = new LinkedBag<>();

        assertTrue(bag.isEmpty());

        bag.add("item");
        assertEquals(1,bag.size());

        bag.add("item");
        assertEquals(2,bag.size());

    }

    @Test
    void isEmpty() {
        Bag<String> bag = new LinkedBag<>();

        assertTrue(bag.isEmpty());

        bag.add("item");
        assertFalse(bag.isEmpty());
    }

    @Test
    void size() {
        Bag<String> bag = new LinkedBag<>();

        assertEquals(0,bag.size());

        bag.add("item");
        assertEquals(1,bag.size());

        bag.add("item2");
        assertEquals(2,bag.size());
    }

    @Test
    void iterator() {
        Bag<String> bag = new LinkedBag<>();

        bag.add("1");
        bag.add("2");
        bag.add("3");

        Iterator<String> it = bag.iterator();

        var n = it.next();
        assertEquals("1", n);

        n = it.next();
        assertEquals("2", n);

        n = it.next();
        assertEquals("3", n);

        assertThrows(NoSuchElementException.class, it::next);


    }
}