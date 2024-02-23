import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest<E> {

    LinkedList<E> testCase = new LinkedList<>();

    @Test
    void addFront() {
        testCase.addFront((E) "Hello");
        assertEquals("Hello", testCase.get(0));
        testCase.addFront((E) "World");
        assertEquals("World", testCase.get(0));
        testCase.addFront((E) (Integer) 2);
        assertEquals(2, testCase.get(0));
    }

    @Test
    void addBack() {
        testCase.addBack((E) "Hello");
        assertEquals("Hello", testCase.get(testCase.size() - 1));
        testCase.addBack((E) "World");
        assertEquals("World", testCase.get(testCase.size() - 1));
        testCase.addBack((E) (Integer) 200);
        assertEquals(200, testCase.get(testCase.size() - 1));
    }

    @Test
    void add() {
        testCase.addFront((E) "Hello");
        testCase.addBack((E) "World");
        testCase.addBack((E) "!");
        //Hello, World, !
        testCase.add(1, (E) "LinkedListTest");
        assertEquals("LinkedListTest", testCase.get(1));
    }

    @Test
    void get() {
        testCase.addFront((E) "Hello");
        testCase.addBack((E) "World");
        testCase.addBack((E) "!");
        assertEquals("Hello", testCase.get(0));
        assertEquals("World", testCase.get(1));
        assertEquals("!", testCase.get(2));
    }

    @Test
    void set() {
        testCase.addFront((E) "Hello");
        testCase.addBack((E) "World");
        testCase.addBack((E) "!");
        testCase.set(1, (E) "Green");
        assertEquals("Hello", testCase.get(0));
        assertEquals("Green", testCase.get(1));
        assertEquals("!", testCase.get(2));
    }

    @Test
    void removeFront() {
        testCase.addFront((E) "Hello");
        testCase.addBack((E) "World");
        testCase.addBack((E) "!");
        testCase.removeFront();
        assertEquals("World", testCase.get(0));
        assertEquals("!", testCase.get(1));
    }

    @Test
    void removeBack() {
        testCase.addFront((E) "Hello");
        testCase.addBack((E) "World");
        testCase.addBack((E) "!");
        testCase.removeBack();
        testCase.removeBack();
        assertEquals("Hello", testCase.get(testCase.size() - 1));
    }

    @Test
    void remove() {
        testCase.addFront((E) "Hello");
        testCase.addBack((E) "World");
        testCase.addBack((E) "!");
        testCase.remove(0);
        testCase.remove(1);
        assertEquals("World", testCase.get(testCase.size() - 1));

    }

    @Test
    void testRemove() {
        assertFalse(testCase.contains((E) (Integer) 1));
        for (int i = 0; i <= 3; i++) {
            testCase.addFront((E) (Integer) i);
        }
        //1, 2, 3
        assertTrue(testCase.contains((E) (Integer) 1));
        assertTrue(testCase.contains((E) (Integer) 2));
        assertFalse(testCase.contains((E) (Integer) 5));
        testCase.remove((E) (Integer) 1);
        assertFalse(testCase.contains((E) (Integer) 1));
        assertTrue(testCase.contains((E) (Integer) 2));
    }

    @Test
    void contains() {
        for (int i = 0; i <= 3; i++) {
            testCase.addFront((E) (Integer) i);
        }
        assertTrue(testCase.contains((E) (Integer) 1));
        assertTrue(testCase.contains((E) (Integer) 2));
        assertFalse(testCase.contains((E) (Integer) 5));
    }

    @Test
    void isEmpty() {
        assertTrue(testCase.isEmpty());
        testCase.addFront((E) "123");
        assertFalse(testCase.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, testCase.size());

        testCase.addFront((E) "123");
        testCase.addFront((E) "123");
        testCase.addFront((E) "123");
        assertEquals(3, testCase.size());
    }

}