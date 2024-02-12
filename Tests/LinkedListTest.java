import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest<E> {
    LinkedList<E> testList = new LinkedList<>();

    @Test
    void addFront() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testList.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        testList.addFront((E) "Three");
        assertEquals("Three", testList.get(0));
        testList.addFront((E) (Double) 3.14159);
        assertEquals(3.14159, testList.get(0));
        assertEquals(2, testList.size());
    }

    @Test
    void addBack() {
        testList.addBack((E) "4");
        testList.addBack((E) (Integer) 7);
        assertEquals(7, testList.get(testList.size() - 1));
    }

    @Test
    void add() {

        //catches an attempt to add a value outside the size of the array
        try {
            testList.add(77, (E) (Integer) 1);
            fail();
        } catch (Exception e) {
            final String expected = "Index out of bounds";
            assertEquals(expected, e.getMessage());
        }

        testList.addFront((E) (Integer) 3);
        for (int i = 0; i < 7; i++) {
            testList.add(i, (E) (Double) ((i + 1) * 2.1));
        }
        assertEquals(2.1, testList.get(0));
        assertSame(testList.get(7),3);
        testList.add(7, (E) (Integer) 66);
        assertEquals(66, testList.get(7));
    }

    @Test
    void get() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testList.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        for(int i = 0; i < 5; i++){
            testList.addFront((E)(Integer)i);
        }
        assertEquals(4, testList.get(0));
        assertEquals(3, testList.get(1));
        assertEquals(2, testList.get(2));
        assertEquals(1, testList.get(3));
        assertEquals(0, testList.get(4));
    }

    @Test
    void set() {
    }

    @Test
    void removeFront() {
        //catches empty array when an attempt to remove the value from the front of an empty array is made
        try {
            testList.removeFront();
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        testList.addFront((E)(Integer)3);
        testList.addFront((E)(Integer)4);
        testList.removeFront();
        assertEquals(3, testList.get(0));
    }

    @Test
    void removeBack() {
        //catches empty array when an attempt to remove the value from the back of an empty array is made
        try {
            testList.removeBack();
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        testList.addFront((E)(Integer)11);
        testList.addBack((E)(Integer)12);
        testList.removeBack();
        assertEquals(11, testList.get(testList.size() - 1));
    }

    @Test
    void remove() {
        //catches empty array when an attempt to remove an element from an empty array is made
        try {
            testList.remove(7);
            fail();
        } catch (Exception e) {
            final String expected = "Index out of bounds";
            assertEquals(expected, e.getMessage());
        }
        testList.addFront((E)(Integer)99);
        testList.remove(0);
        assertEquals(0, testList.size());

        for(int i = 0; i < 5; i++){
            testList.addFront((E)(Integer)i);
        }
        testList.remove(1);
        assertEquals(4, testList.get(0));
        assertEquals(2, testList.get(1));
        assertEquals(1, testList.get(2));
        assertEquals(0, testList.get(3));
    }

    @Test
    void testRemove() {
        assertFalse(testList.contains((E)(Integer)2));
        for(int i = 5; i < 10; i++){
            testList.addFront((E)(Integer)i);
        }
        assertTrue(testList.contains((E)(Integer)6));
        assertTrue(testList.contains((E)(Integer)8));
        assertFalse(testList.contains((E)(Integer)10));
        assertFalse(testList.contains((E)(Integer)(-10)));
    }

    @Test
    void contains() {
    }

    @Test
    void isEmpty() {
        assertTrue(testList.isEmpty());
        testList.addFront((E)(Integer)2);
        assertFalse(testList.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, testList.size());
        testList.addFront((E)(Integer)1);
        assertEquals(1, testList.size());
        for(int i = 0; i < 5; i++){
            testList.addFront((E)(Integer)i);
        }
        assertEquals(6, testList.size());
    }
}