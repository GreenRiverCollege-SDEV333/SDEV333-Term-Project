import static org.junit.jupiter.api.Assertions.*;
/*
 *   Ryder Dettloff
 *   Tests for IntList Review; ArrayList methods
 */
class ArrayListTest {
    ArrayList<Integer> myArray = new ArrayList<>();

    ArrayList<Integer> myArrayFilled = listFiller();

    /*
    helper to fill array with numbers that increment by 3
     */
    public ArrayList<Integer> listFiller() {
        ArrayList<Integer> myArray = new ArrayList<>();
        for (int i = 0; i <= 10 - 1; i++) {
            myArray.addFront(i + 1);
        }
        return myArray;
    }

    @org.junit.jupiter.api.Test
    void testAddFront() {
        assertTrue(myArray.isEmpty());
        myArray.addFront(9);
        assertEquals(9,myArray.get(0));
        assertEquals(10, myArrayFilled.get(0));
        myArrayFilled.addFront(16);
        assertEquals(16, myArrayFilled.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        assertTrue(myArray.isEmpty());
        myArray.addBack(9);
        assertEquals(9,myArray.get(myArray.size()-1));
        assertEquals(10, myArrayFilled.get(0));
        myArrayFilled.addBack(16);
        assertEquals(16, myArrayFilled.get(myArrayFilled.size()-1));
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        assertTrue(myArray.isEmpty());
        myArray.add(0,22);
        assertEquals(22,myArray.get(0));
        assertEquals(10, myArrayFilled.get(0));
        myArrayFilled.add(2,25);
        assertEquals(25, myArrayFilled.get(2));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        assertFalse(myArrayFilled.isEmpty());
        assertEquals(10,myArrayFilled.get(0));
        myArrayFilled.removeFront();
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        assertFalse(myArrayFilled.isEmpty());
        assertEquals(1,myArrayFilled.get(myArrayFilled.size()-1));
        myArrayFilled.removeBack();
    }

    @org.junit.jupiter.api.Test
    void remove() {
        assertFalse(myArrayFilled.isEmpty());
        assertEquals(10,myArrayFilled.get(0));
        myArrayFilled.remove(2);
        assertEquals(7,myArrayFilled.get(2));
    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayList<Integer> myArray = new ArrayList<>();
        myArray.addFront(1);
        myArray.addFront(2);
        myArray.addFront(3);
        assertEquals(3, myArray.get(0));
        assertEquals(2, myArray.get(1));
        assertEquals(1, myArray.get(2));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        ArrayList<Integer> myArray = new ArrayList<>();
        myArray.addFront(1);
        myArray.addFront(2);
        myArray.addFront(3);
        assertFalse(myArray.contains(5));
        assertTrue(myArray.contains(1));
    }


    @org.junit.jupiter.api.Test
    void isEmpty() {
        ArrayList<Integer> myArray = new ArrayList<>();
        assertTrue(myArray.isEmpty());
        myArray.addFront(1);
        assertFalse(myArray.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        ArrayList<Integer> myArray = new ArrayList<>();
        assertEquals(0, myArray.size());
        myArray.addFront(1);
        myArray.addFront(2);
        myArray.addFront(3);
        assertEquals(3, myArray.size());
    }
}