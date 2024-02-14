import abstractDataTypes.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test Class for ArrayIntList
 * @author tobygoetz
 * @version 1.0
 */
public class LinkedIntListTest<E> {
    private LinkedList<E> testLinkedList = new LinkedList<>();
    private E[] genericArray = (E[]) new Object[]{
            "Test", 1, 'a', Math.random(), 1L, (byte) 0x00, 7, 8, 9, 10, "Eleven", "Twelve"};
    private static final int ITERATIONS = 15;
    private Exception exception;

    protected void setException(Exception exception) {
        this.exception = exception;
    }

    /**
     * Test adds Integer values to the front when empty, almost empty,
     * not empty and when buffer is larger than intial size of 10 is
     * surpassed.
     */
    @Test
    public void addFrontTest() {
        assertEquals(0, testLinkedList.size());
        for (int i = 0; i < genericArray.length; i++) {
            testLinkedList.addFront(genericArray[i]);
            // Index 0 changes everytime addFront is called
            assertEquals(genericArray[i], testLinkedList.get(0));
        }
    }

    /**
     * Test adds Integer values to the back when empty, almost empty,
     * not empty and when buffer is larger than intial size of 10 is
     * surpassed.
     */
    @Test
    public void addBackTest() {
        assertEquals(0, testLinkedList.size());
        for (int i = 0; i < genericArray.length; i++) {
            testLinkedList.addBack(genericArray[i]);
            // Index 0 changes everytime addFront is called
            assertEquals(genericArray[i], testLinkedList.get(testLinkedList.size() - 1));
        }
    }

    /**
     * Test adds Integer values at specific index when empty, almost
     * empty,not empty and when buffer is larger than intial size of
     * 10 is surpassed.
     */
    @Test
    public void addTest()
    {
        // Adds Index at i incrementing
        for (int i = 0; i < ITERATIONS; i++) {
            testLinkedList.add(i, (E) (Integer) i);
            assertEquals(i, testLinkedList.get(i));
        }

        // Adds Index at i decrementing
        for (int i = ITERATIONS; i >= 0; i--) {
            testLinkedList.add(i, (E) (Integer) i);
            assertEquals(i, testLinkedList.get(i));
        }


        //IndexOutOfBoundsException is thrown if -1 is called
        setException(assertThrows(
                IndexOutOfBoundsException.class,
                () -> testLinkedList.add(-1, (E)(Integer) ITERATIONS)));

        //IndexOutOfBoundsException is thrown if index larger than
        // the amount of indices is called
        setException(assertThrows(
                IndexOutOfBoundsException.class,
                () -> testLinkedList.add(testLinkedList.size() + 1, (E)(Integer)ITERATIONS)));
    }

    /**
     * Tests if values at specific index have been set when empty,
     * almost empty,not empty and when buffer is larger than intial
     * size of 10 is surpassed. Tests exceptions when attempting to
     * set index that is out of range.
     * */
    @Test
    public void setTest() {

        assertTrue(testLinkedList.isEmpty());

        //IndexOutOfBoundsException is thrown if -1 is called
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testLinkedList.set(-1, (E) (Integer) ITERATIONS);
                });

        //IndexOutOfBoundsException is thrown if index larger than size of ArrayList is requested
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testLinkedList.set(testLinkedList.size() + 1, (E) (Integer) ITERATIONS);
                });

        //reassign values
        this.fillArray();
        assertFalse(testLinkedList.isEmpty());
        for (int i = 0; i < genericArray.length; i++) {
            testLinkedList.set(i, (E)(Integer) ITERATIONS);
            assertEquals(ITERATIONS, testLinkedList.get(i));
        }
    }

    /**
     * Test removes Integer values from the front of ArrayIntList when
     * empty, almost empty and not empty
     */
    @Test
    public void removeFrontTest() {
        assertEquals(0, testLinkedList.size());

        //test with empty array
        testLinkedList.removeFront();
        setException(assertThrows(
                IndexOutOfBoundsException.class, () -> testLinkedList.get(0)));
        assertTrue(testLinkedList.isEmpty());

        //test with 1 value in array
        testLinkedList.addFront((E)(Integer) ITERATIONS);
        testLinkedList.removeFront();
        assertTrue(testLinkedList.isEmpty());

        /* Check that next index value is now equal to index 0
           after the first index is removed */

        this.fillArray();
        for (int i = 0; i < genericArray.length; i++) {
            if (testLinkedList.size() > 1) {
                E nextIndex = testLinkedList.get(1);
                testLinkedList.removeFront();
                assertEquals(nextIndex, testLinkedList.get(0));
            } else {
                testLinkedList.removeFront();
                assertTrue(testLinkedList.isEmpty());
            }
        }
    }

    /**
     * Test removes Integer values from the front of ArrayIntList when
     * empty, almost empty and not empty
     */
    @Test
    public void removeBackTest()
    {
        assertEquals(0, testLinkedList.size());
        assertNull(testLinkedList.removeBack());

        //test with empty array
        testLinkedList.removeBack();
        setException(assertThrows(
                IndexOutOfBoundsException.class, () -> testLinkedList.get(0)));
        assertTrue(testLinkedList.isEmpty());

        //test with 1 value in array
        testLinkedList.addFront((E)(Integer) ITERATIONS);
        testLinkedList.removeBack();
        assertTrue(testLinkedList.isEmpty());

        /* Check that next index value is now equal to index 0
           after the first index is removed */
        this.fillArray();
        this.fillArray();
        for (int i = 0; i < genericArray.length; i++) {
            E removedValue = testLinkedList.get(testLinkedList.size() - 1);
            assertEquals(removedValue, testLinkedList.removeBack());
        }
    }

    /**
     * Test removes genericArray values at specific index when empty, almost
     * empty,not empty and when buffer is larger than intial size of
     * 10 is surpassed.
     */
    @Test
    public void removeIndexTest()
    {
        //test with empty array
        assertTrue(testLinkedList.isEmpty());
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testLinkedList.remove(0);
                });

        //test with index greater than size of array
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testLinkedList.remove(1);
                });

        //reassign values
        this.fillArray();
        assertFalse(testLinkedList.isEmpty());

        //test with index greater than size of array
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testLinkedList.remove(testLinkedList.size());
                });

        for (int i = 0; i < genericArray.length - 1; i++) {
            E valueAfterRemoved = testLinkedList.get(1);
            testLinkedList.remove(0);
            assertEquals(valueAfterRemoved, testLinkedList.get(0));
        }
    }

    /**
     * Test removes genericArray values if present when empty, almost
     * empty,not empty and when buffer is larger than intial size of
     * 10 is surpassed.
     */
    @Test
    public void removeItemTest() {

        assertTrue(testLinkedList.isEmpty());

        //reassign values at back to maintain order of genericArray
        for (int i = 0; i < genericArray.length; i++) {
            testLinkedList.addBack(genericArray[i]);
        }
        assertFalse(testLinkedList.isEmpty());

        for (int i = 0; i < genericArray.length; i++) {
            E valueRemoved = testLinkedList.get(i);
            testLinkedList.remove(genericArray[i]);
            testLinkedList.addFront((E)(Integer) ITERATIONS);
            assertFalse(testLinkedList.contains(valueRemoved));
        }
    }

    /**
     * Test get method returns for empty, almost empty
     * and exception throw due to Index out of bounds
     */
    @Test
    public void getTest() {
        assertEquals(0, testLinkedList.size());

        //test with empty array
        setException(assertThrows(
                IndexOutOfBoundsException.class, () -> testLinkedList.get(0)));
        assertTrue(testLinkedList.isEmpty());

        //test with index greater than size of array
        //test with empty array
        setException(assertThrows(
                IndexOutOfBoundsException.class, () -> testLinkedList.get(1)));
        assertTrue(testLinkedList.isEmpty());

        //reassign values at back to maintain order of genericArray
        for (int i = 0; i < genericArray.length; i++) {
            testLinkedList.addBack(genericArray[i]);
        }
        assertFalse(testLinkedList.isEmpty());

        //test the return values of get()
        for (int i = 0; i < genericArray.length; i++) {
            assertEquals(genericArray[i], testLinkedList.get(i));
        }
    }

    /**
     * Test contains() for non-existent values, existing values,
     * against empty list
     */
    @Test
    public void containsTest()
    {
        //Test if empty
        assertEquals(0, testLinkedList.size());
        assertFalse(testLinkedList.contains((E)(Integer) ITERATIONS));

        //Test if value 1 exists
        testLinkedList.add(0, (E)(Integer) 1);
        assertTrue(testLinkedList.contains((E)(Integer) 1));

        //test if Iterations exists
        this.fillArray();
        testLinkedList.set(0, (E)(Integer) ITERATIONS);
        assertTrue(testLinkedList.contains((E)(Integer) ITERATIONS));

        //test if number does not exist
        assertFalse(testLinkedList.contains((E)(Integer) 80085));
    }

    /**
     * Test isEmpty() for no values, some values,
     * against empty list
     */
    @Test
    public void isEmptyTest()
    {
        //test against empty array
        assertEquals(0, testLinkedList.size());

        //test against non-empty array
        this.fillArray();
        assertFalse(testLinkedList.isEmpty());
    }

    /**
     * Test size() for no values, some values,
     * against empty list
     */
    @Test
    public void sizeTest() {
        //saftey check
        assertEquals(0, testLinkedList.size());

        //test against non-empty array
        for (int i = 0; i < ITERATIONS; i++) {
            testLinkedList.addBack((E)(Integer) i);
            assertEquals(i + 1, testLinkedList.size());
        }
    }

    /*
     * Helper method to fill the array in this class
     */
    private void fillArray()
    {
        //reassign values
        for (int i = 0; i < genericArray.length; i++) {
            testLinkedList.addFront(genericArray[i]);
            assertEquals(genericArray[i], testLinkedList.get(0));
        }
    }
}
