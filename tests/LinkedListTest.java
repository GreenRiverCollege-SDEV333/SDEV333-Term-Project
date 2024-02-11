import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList<Integer> emptyList = new LinkedList<>();
    LinkedList<Integer> singleItem = fillList(1);
    LinkedList<Integer> multiItem = fillList(10);

    public LinkedList<Integer> fillList(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = num; i > 0; i--) {
            list.addFront(i);
        }
        return list;
    }

    @Test
    void addFront() {
        assertEquals(0, emptyList.size());
        emptyList.addFront(27);
        assertEquals(27, emptyList.get(0));

        assertEquals(1, singleItem.get(0));
        singleItem.addFront(21);
        assertEquals(21, singleItem.get(0));

        assertEquals(1, multiItem.get(0));
        multiItem.addFront(30);
        assertEquals(30, multiItem.get(0));
    }

    @Test
    void addBack() {
        assertEquals(0, emptyList.size());
        emptyList.addBack(27);
        assertEquals(27, emptyList.get(emptyList.size() - 1));

        assertEquals(1, singleItem.get(0));
        singleItem.addBack(21);
        assertEquals(21, singleItem.get(singleItem.size() - 1));

        assertEquals(10, multiItem.get(multiItem.size() - 1));
        multiItem.addBack(30);
        assertEquals(30, multiItem.get(multiItem.size() - 1));
    }

    @Test
    void add() {
        assertEquals(0, emptyList.size());
        emptyList.add(0, 27);
        assertEquals(27, emptyList.get(0));

        assertEquals(1, singleItem.get(0));
        singleItem.add(0, 21);
        assertEquals(21, singleItem.get(0));

        assertEquals(10, multiItem.get(multiItem.size() - 1));
        multiItem.add(7,30);
        assertEquals(30, multiItem.get(7));
    }

    @Test
    void get() {
        assertEquals(1, singleItem.get(0));

        assertEquals(5, multiItem.get(4));
    }

    @Test
    void set() {
        assertEquals(1, singleItem.get(0));
        singleItem.set(0, 20);
        assertEquals(20, singleItem.get(0));

        assertEquals(5, multiItem.get(4));
        multiItem.set(4, 67);
        assertEquals(67, multiItem.get(4));
    }

    @Test
    void removeFront() {
        assertEquals(1, singleItem.get(0));
        assertEquals(1, singleItem.size());
        assertEquals(1, singleItem.removeFront());
        assertEquals(0, singleItem.size());

        assertEquals(1, multiItem.get(0));
        assertEquals(10, multiItem.size());
        assertEquals(1, multiItem.removeFront());
        assertEquals(9, multiItem.size());

    }

    @Test
    void removeBack() {
        assertEquals(1, singleItem.get(0));
        assertEquals(1, singleItem.removeBack());

        assertEquals(10, multiItem.get(multiItem.size() - 1));
        assertEquals(10, multiItem.removeBack());
    }

    @Test
    void removeItem() {
        Integer val = new Integer(1);
        Integer val2 = new Integer(7);

        assertTrue(singleItem.contains(1));
        singleItem.remove(val);
        assertEquals(0, singleItem.size());
        assertFalse(singleItem.contains(1));

        assertTrue(multiItem.contains(7));
        multiItem.remove(val2);
        assertFalse(multiItem.contains(7));
    }

    @Test
    void removeIndex() {
        assertTrue(singleItem.contains(1));
        singleItem.remove(0);
        assertEquals(0, singleItem.size());
        assertFalse(singleItem.contains(1));

        assertTrue(multiItem.contains(7));
        multiItem.remove(6);
        assertFalse(multiItem.contains(7));
    }

    @Test
    void contains() {
        assertFalse(emptyList.contains(20));
        assertTrue(singleItem.contains(1));
        assertTrue(multiItem.contains(7));
    }

    @Test
    void isEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(singleItem.isEmpty());
        assertFalse(multiItem.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, emptyList.size());
        assertEquals(1, singleItem.size());
        assertEquals(10, multiItem.size());
    }
}