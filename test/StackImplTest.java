import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {

    @Test
    void push() {
        StackImpl<String> stack = new StackImpl<>();

        assertEquals(stack.size(), 0);

        stack.push("1");
        assertEquals(stack.size(), 1);

        stack.push("1");
        assertEquals(stack.size(), 2);
    }

    @Test
    void pop() {
        StackImpl<String> stack = new StackImpl<>();

        stack.push("1");
        stack.push("2");

        assertEquals(2, stack.size());

        var n = stack.pop();
        assertEquals("2", n);
        assertEquals(1, stack.size());

        n = stack.pop();
        assertEquals("1", n);
        assertEquals(0, stack.size());

    }

    @Test
    void peek() {
        StackImpl<String> stack = new StackImpl<>();

        stack.push("1");
        stack.push("2");

        assertEquals(2, stack.size());

        // test peek top element
        var n = stack.peek();
        assertEquals("2", n);
        assertEquals(2, stack.size());

        // test popping stack and then peeking the next value
        stack.pop();
        n = stack.peek();
        assertEquals("1", n);
        assertEquals(1, stack.size());

    }

    @Test
    void isEmpty() {
        StackImpl<String> stack = new StackImpl<>();

        assertTrue(stack.isEmpty());

        stack.push("1");
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void size() {
        StackImpl<String> stack = new StackImpl<>();

        assertEquals(0, stack.size());

        stack.push("");
        assertEquals(1, stack.size());

        stack.push("");
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void iterator() {
        assertThrows( NoSuchElementException.class, () -> {
            StackImpl<String> stack = new StackImpl<>();
            var it = stack.iterator();
            it.next();
        });
    }
}