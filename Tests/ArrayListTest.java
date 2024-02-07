import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest<T> {
    ArrayList<T> testList = new ArrayList<>();

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
        testList.addBack((T)(Integer)2);
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
        testList.addFront((T)(Integer)3);
        for(int i = 0; i < 7; i++) {
            testList.add(i, (T)(Integer)((i+1)*2));
        }
        assertEquals(2, testList.get(0));
        testList.add(7,(T)(Integer)66);
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
            testList.addFront((T)(Integer)i);
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
        for(int i=0; i<4; i++) {
            testList.addFront((T)(Integer)i);
        }
        assertEquals(0, testList.get(3));
        testList.set(3, (T)(Integer)1);
        assertEquals(1, testList.get(3));
        try {
            testList.set(7, (T)(Integer)99);
            fail();
        } catch (Exception e) {
            final String expected = "Index cannot be outside the size of the array.";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void removeFront() {
        testList.addFront((T)"First Added");
        testList.addBack((T)"Second Value");
        assertEquals("First Added", testList.get(0));
        assertEquals("First Added", testList.removeFront());
        assertEquals("Second Value", testList.get(0));
    }

    @Test
    void removeBack() {
        testList.addFront((T)"First Added");
        testList.addBack((T)"Second Value");
        assertEquals("First Added", testList.get(0));
        assertEquals("Second Value", testList.get(1));
        assertEquals("Second Value", testList.removeBack());
        assertEquals("First Added", testList.get(0));
    }

    @Test
    void remove() {
        testList.addFront((T)"First Added");
        testList.addBack((T)"Second Value");
        testList.add(1, (T)"Middle Value");
        assertEquals(3, testList.size());
        testList.remove((T)"Middle Value");
        assertEquals(2, testList.size());
        assertEquals("Second Value", testList.get(1));
        assertEquals("[First Added, Second Value]", testList.toString());
    }

    @Test
    void testRemove() {
        try {
            testList.remove(7);
            fail();
        } catch (Exception e) {
            final String expected = "Index out of bounds at position "+7;
            assertEquals(expected, e.getMessage());
        }
        testList.addFront((T)"First Added");
        testList.addBack((T)"Second Value");
        testList.add(1, (T)"Middle Value");
        assertEquals(3, testList.size());
        assertEquals("Second Value", testList.remove(2));
        assertEquals(2, testList.size());
        assertEquals("[First Added, Middle Value]", testList.toString());
    }

    @Test
    void contains() {
        testList.addFront((T)"First Added");
        testList.addBack((T)"Second Value");
        testList.add(1, (T)"Middle Value");
        assertTrue(testList.contains((T)"Second Value"));
        assertFalse(testList.contains((T)"Last Value"));
    }

    @Test
    void isEmpty() {
        assertTrue(testList.isEmpty());
        testList.addFront((T)"First Added");
        assertFalse(testList.isEmpty());
        testList.remove((T)"First Added");
        assertTrue(testList.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, testList.size());
        testList.addFront((T)(Character)'x');
        assertEquals(1, testList.size());
    }

    @Test
    void testToString() {
        testList.addFront((T)"This is a String ");
        testList.addBack((T)(Integer)7);
        assertEquals("[This is a String , 7]", testList.toString());
    }
}