import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> empty;
    private LinkedList<Integer> one;
    private LinkedList<Integer> half;
    private LinkedList<Integer> full;

    @BeforeEach
    void setUp(){

        empty = new LinkedList<>();

        one = new LinkedList<>();
        one.addFront(10);

        half = new LinkedList<>();
        for(int i = 1; i <= 5 ; i++){
            half.addBack(i * 2);
        }

        full = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            full.addBack(i + 1);
        }
    }



    @Test
    void addFront() {
        empty.addFront(12);
        assertEquals(1, empty.size());
        assertEquals(12, empty.get(0));

        one.addFront(12);
        assertEquals(2, one.size());
        assertEquals(12, one.get(0));

        half.addFront(12);
        assertEquals(6, half.size());
        assertEquals(12, half.get(0));

        full.addFront(12);
        assertEquals(11, full.size());
        assertEquals(12, full.get(0));
    }

    @Test
    void addBack() {
        empty.addBack(33);
        assertEquals(1, empty.size());
        assertEquals(33, empty.get(empty.size() - 1));

        one.addBack(33);
        assertEquals(2, one.size());
        assertEquals(33, one.get(one.size() - 1));

        half.addBack(33);
        assertEquals(6, half.size());
        assertEquals(33, half.get(half.size() - 1));

        full.addBack(33);
        assertEquals(11, full.size());
        assertEquals(33, full.get(full.size() - 1));
    }

    @Test
    void add() {
        int index = 3;
        int value = 50;

        assertThrows(IndexOutOfBoundsException.class, () -> {
            empty.add(index, value);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            one.add(index, value);
        });

        half.add(index, value);
        assertEquals(6, half.size());
        assertEquals(value, half.get(index));

        full.add(index, value);
        assertEquals(11, full.size());
        assertEquals(value, full.get(index));

    }

    @Test
    void set() {
        int index = 4;
        int value = 13;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            empty.set(index, value);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            one.set(index, value);
        });

        half.set(index, value);
        assertEquals(value, half.get(index));

        full.set(index, value);
        assertEquals(value, full.get(index));



    }

    @Test
    void get() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            empty.get(6);
        });
        assertEquals(10, one.get(0));
        assertEquals(8, half.get(3));
        assertEquals(6, full.get(5));
    }

    @Test
    void removeFront() {

        one.removeFront();
        assertEquals(0, one.size());

        half.removeFront();
        assertEquals(4, half.get(0));
        assertEquals(4, half.size());

        full.removeFront();
        assertEquals(2, full.get(0));
        assertEquals(9, full.size());

    }

    @Test
    void removeBack() {
        assertThrows(NoSuchElementException.class, () -> {
            empty.removeBack();
        });

        assertEquals(10, one.removeBack());
        assertEquals(0, one.size());

        // Test removing from a list with more than one element
        assertEquals(10, half.removeBack());
        assertEquals(4, half.size());

        // Test removing from a full list
        assertEquals(10, full.removeBack());
        assertEquals(9, full.size());
    }

    @Test
    void remove() {
        int index = 2;

        assertThrows(IndexOutOfBoundsException.class, () -> {
            empty.remove(index);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            one.remove(index);
        });

        half.remove(index);
        assertEquals(4, half.size());
        assertEquals((index + 2) * 2, half.get(index));

        full.remove(index);
        assertEquals(9, full.size());
        assertEquals(index + 2, full.get(index));
    }

    @Test
    void contains() {
        int value = 4;
        assertFalse(empty.contains(value));
        assertFalse(one.contains(value));
        assertTrue(half.contains(value));
        assertTrue(full.contains(value));
    }

    @Test
    void isEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(one.isEmpty());
        assertFalse(half.isEmpty());
        assertFalse(full.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, empty.size());
        assertEquals(1, one.size());
        assertEquals(5, half.size());
        assertEquals(10, full.size());
    }

}