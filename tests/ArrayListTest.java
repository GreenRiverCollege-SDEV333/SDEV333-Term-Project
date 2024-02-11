import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    ArrayList<Integer> emptyList = new ArrayList<>();
    ArrayList<Integer> singleItemList = fillList(1);
    ArrayList<Integer> multiItemList = fillList(10);

    public ArrayList<Integer> fillList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i <= size - 1; i++) {
            list.addBack(i + 1);
        }
        return list;
    }


    @org.junit.jupiter.api.Test
    void addFront() {
        assertTrue(emptyList.isEmpty());
        emptyList.addFront(30);
        assertEquals(30, emptyList.get(0));

        assertEquals(1, singleItemList.get(0));
        singleItemList.addFront(30);
        assertEquals(30, singleItemList.get(0));

        assertEquals(1, multiItemList.get(0));
        multiItemList.addFront(30);
        assertEquals(30, multiItemList.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        assertTrue(emptyList.isEmpty());
        emptyList.addBack(30);
        assertEquals(30, emptyList.get(emptyList.size() - 1));

        assertEquals(1, singleItemList.get(singleItemList.size() - 1));
        singleItemList.addBack(30);
        assertEquals(30, singleItemList.get(singleItemList.size() - 1));

        assertEquals(10, multiItemList.get(multiItemList.size() - 1));
        multiItemList.addBack(30);
        assertEquals(30, multiItemList.get(multiItemList.size() - 1));
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertTrue(emptyList.isEmpty());
        emptyList.add(0,30);
        assertEquals(30, emptyList.get(0));

        assertFalse(singleItemList.contains(21));
        singleItemList.add(0, 21);
        assertEquals(21, singleItemList.get(0));

        assertEquals(6, multiItemList.get(5));
        multiItemList.add(5,30);
        assertEquals(30, multiItemList.get(5));

    }

    @org.junit.jupiter.api.Test
    void get() {
        // Unsure how to test for indexOutOfBounds exception
        assertEquals(1, singleItemList.get(0));
        assertEquals(4, multiItemList.get(3));
    }

    @org.junit.jupiter.api.Test
    void set() {
        // Unsure how to test for indexOutOfBounds exception

        assertFalse(singleItemList.contains(35));
        singleItemList.set(0, 35);
        assertEquals(35, singleItemList.get(0));

        assertFalse(multiItemList.contains(21));
        multiItemList.set(5, 21);
        assertEquals(21, multiItemList.get(5));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        // Unsure how to test for indexOutOfBounds exception
        assertEquals(1, singleItemList.removeFront());
        assertEquals(1, multiItemList.removeFront());
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        // Unsure how to test for indexOutOfBounds exception
        assertEquals(1, singleItemList.removeBack());
        assertEquals(10, multiItemList.removeBack());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        // Unsure how to test for indexOutOfBounds exception
        assertEquals(1, singleItemList.remove(0));
        assertEquals(7, multiItemList.remove(6));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        assertFalse(emptyList.contains(2));
        assertTrue(singleItemList.contains(1));
        assertTrue(multiItemList.contains(6));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(singleItemList.isEmpty());
        assertFalse(multiItemList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0, emptyList.size());
        assertEquals(1, singleItemList.size());
        assertEquals(10, multiItemList.size());
    }
}