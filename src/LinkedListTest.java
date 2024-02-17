import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> myLinkedList = new LinkedList<>();

    public LinkedList<Integer> myFilledLinkedList = fillListWithNumbers();

/*
^^^^^
helper method to create a full linkedlist of 10 nodes
 */
    private LinkedList<Integer> fillListWithNumbers() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.addFront(i);
        }
        return list;
    }
    @Test
    void addFront() {
        assertTrue(myLinkedList.isEmpty());
        myLinkedList.addFront(9);
        assertEquals(9, myLinkedList.get(0));
        assertEquals(10, myFilledLinkedList.get(0));
        myFilledLinkedList.addFront(16);
        assertEquals(16, myFilledLinkedList.get(0));
    }

    @Test
    void addBack() {
    }

    @Test
    void add() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeBack() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }
}