import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    @Test
    void enqueue() {
        LinkedQueue<String> queue = new LinkedQueue<>();

        assertEquals(0, queue.size());

        queue.enqueue("");
        assertEquals(1, queue.size());

        queue.enqueue("");
        assertEquals(2, queue.size());

        queue.enqueue("");
        assertEquals(3, queue.size());
    }

    @Test
    void dequeue() {
        LinkedQueue<String> queue = new LinkedQueue<>();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");

        var n = queue.dequeue();
        assertEquals("1", n);
        assertEquals(3, queue.size());

        n = queue.dequeue();
        assertEquals("2", n);
        assertEquals(2, queue.size());

        n = queue.dequeue();
        assertEquals("3", n);
        assertEquals(1, queue.size());

        n = queue.dequeue();
        assertEquals("4", n);
        assertEquals(0, queue.size());

    }

    @Test
    void isEmpty() {
        LinkedQueue<String> queue = new LinkedQueue<>();

        assertTrue(queue.isEmpty());

        queue.enqueue("");
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void size() {
        LinkedQueue<String> queue = new LinkedQueue<>();

        assertEquals(0, queue.size());

        queue.enqueue("");
        assertEquals(1, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());

    }

    @Test
    void iterator() {
        assertThrows( NoSuchElementException.class, () -> {
            LinkedQueue<String> queue = new LinkedQueue<>();
            var it = queue.iterator();
            it.next();
        });
    }
}