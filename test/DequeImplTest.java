import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DequeImplTest {

    @Test
    void isEmpty() {
        DequeImpl<String> deque = new DequeImpl<>();

        assertTrue(deque.isEmpty());

        deque.pushLeft("");
        assertFalse(deque.isEmpty());

        deque.popLeft();
        assertTrue(deque.isEmpty());

    }

    @Test
    void size() {
        DequeImpl<String> deque = new DequeImpl<>();

        assertEquals(deque.size(), 0);

        deque.pushLeft("");
        assertEquals(deque.size(), 1);

        deque.popLeft();
        assertEquals(deque.size(), 0);

    }

    @Test
    void pushLeft() {
        DequeImpl<String> deque = new DequeImpl<>();

        // from a 0 sized deque
        deque.pushLeft("1");
        assertEquals(deque.size(), 1);

        // from a 1 sized deque
        deque.pushLeft("2");
        assertEquals(deque.size(), 2);

        // from a n>1 sized deque
        deque.pushLeft("3");
        assertEquals(deque.size(), 3);

    }

    @Test
    void pushRight() {
        DequeImpl<String> deque = new DequeImpl<>();

        // from a 0 sized deque
        deque.pushRight("1");
        assertEquals(deque.size(), 1);

        // from a 1 sized deque
        deque.pushRight("2");
        assertEquals(deque.size(), 2);

        // from a n>1 sized deque
        deque.pushRight("3");
        assertEquals(deque.size(), 3);
    }

    @Test
    void popLeft() {
        DequeImpl<String> deque = new DequeImpl<>();

        deque.pushLeft("1");
        // 1

        deque.pushLeft("2");
        // 2 1

        deque.pushLeft("3");
        // 3 2 1

        deque.pushRight("2");
        // 3 2 1 2

        deque.pushRight("1");
        // 3 2 1 2 1


        // n>1 sized deque
        var n = deque.popLeft();
        assertEquals("3", n);
        n = deque.popLeft();
        assertEquals("2", n);
        n = deque.popLeft();
        assertEquals("1", n);

        // 2 elements left, resulting in a 1 sized data structure
        n = deque.popLeft();
        assertEquals("2", n);
        assertEquals(1, deque.size());

        // 1 element left
        n = deque.popLeft();
        assertEquals("1", n);

        assertTrue(deque.isEmpty());

    }

    @Test
    void popRight() {
        DequeImpl<String> deque = new DequeImpl<>();

        deque.pushRight("1");
        // 1
        deque.pushRight("2");
        // 1 2
        deque.pushRight("3");
        // 1 2 3
        deque.pushLeft("2");
        // 2 1 2 3
        deque.pushLeft("1");
        // 1 2 1 2 3

        // n>1 sized deque
        var n = deque.popRight();
        assertEquals("3", n);
        n = deque.popRight();
        assertEquals("2", n);
        n = deque.popRight();
        assertEquals("1", n);

        // 2 elements left, resulting in a 1 sized data structure
        n = deque.popRight();
        assertEquals("2", n);
        assertEquals(1, deque.size());

        // 1 element left
        n = deque.popRight();
        assertEquals("1", n);

        assertTrue(deque.isEmpty());
    }

    @Test
    void iterator() {
        assertThrows( NoSuchElementException.class, () -> {
            DequeImpl<String> deque = new DequeImpl<>();
            var it = deque.iterator();
            it.next();
        });
    }
}