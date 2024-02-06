import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest<T> {
    ArrayList<T> testList = new ArrayList<T>();

    @Test
    void addFront() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testList.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "Index cannot be outside the size of the array.";
            assertEquals(expected, e.getMessage());
        }
        Integer one = 1;
        Integer two = 2;
        String three = "three";
        assertEquals(0, testList.size());
        testList.addFront((T)one);
        assertEquals(1, testList.get(0));
        testList.addFront((T)two);
        assertEquals(2, testList.get(0));
        testList.addFront((T)three);
        assertEquals("three", testList.get(0));
        assertEquals(3, testList.size());
    }

    @Test
    void addBack() {
        assertEquals(0, testList.size());
        testList.addBack((T)new Integer(2));
        assertEquals(2, testList.get(testList.size() - 1));
        testList.addBack((T) "777");
        assertEquals("777", testList.get(testList.size() - 1));
        assertEquals(2, testList.size());
    }

    @Test
    void add() {

        //catches an attempt to add a value outside the size of the array
        try {
            testList.add(-1,(T)"1");
            fail();
        } catch (Exception e) {
            final String expected = "Index ouf of bounds. NOPE!";
            assertEquals(expected, e.getMessage());
        }
        assertEquals(0, testList.size());
        testList.addFront((T)new Integer(3));
        for(int i = 0; i < 7; i++) {
            testList.add(i, (T)new Integer((i+1)*2));
        }
        assertEquals(2, testList.get(0));
        testList.add(7,(T)new Integer(66));
        assertEquals(66, testList.get(7));
        assertEquals(9, testList.size());
        testList.add(8,(T)"Found");
        assertEquals("Found", testList.get(8));
        assertEquals(3, testList.get(9));
        assertEquals(10, testList.size());
    }

    @Test
    void get() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testList.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "Index cannot be outside the size of the array.";
            assertEquals(expected, e.getMessage());
        }
        for(int i = 0; i < 5; i++){
            testList.addFront((T)Integer.valueOf(i));
        }
        assertEquals(4, testList.get(0));
        assertEquals(3, testList.get(1));
        assertEquals(2, testList.get(2));
        assertEquals(1, testList.get(3));
        assertEquals(0, testList.get(4));
        testList.addBack((T)"First Value");
        assertEquals("First Value", testList.get(testList.size()-1));
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

    @Test
    void testToString() {
    }
}