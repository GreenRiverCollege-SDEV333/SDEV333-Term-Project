import abstractDataTypes.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for ArrayIntList
 * @author tobygoetz
 * @version 1.0
 */
public class ArrayListTest<E> {
    private ArrayList<E> testArrayList = new ArrayList<>((E[]) new Object[]{});
    private E[] genericArray = (E[]) new Object[]{
            "Test", 1, 'a', Math.random(), 1L, (byte) 0x00, 7, 8, 9, 10, "Eleven", "Twelve"};
    private Exception exception;
    private static final int ITERATIONS = 15;

    /**
     * Test adds genericArray values to the front when empty, almost empty,
     * not empty and when buffer is larger than the initial size of 10 is
     * surpassed.
     */
    @Test
    public void addFrontTest()
    {
        for (int i = 0; i < genericArray.length; i++) {
            testArrayList.addFront(genericArray[i]);
            assertEquals(genericArray[i], testArrayList.get(0));
        }
    }

    /**
     * Test adds genericArray values to the back when empty, almost empty,
     * not empty and when buffer is larger than initial size of 10 is
     * surpassed.
     */
    @Test
    public void addBackTest()
    {
        for (int i = 0; i < genericArray.length; i++) {
            testArrayList.addBack(genericArray[i]);
            // Index 0 changes everytime addFront is called
            assertEquals(genericArray[i], testArrayList.get(testArrayList.size() - 1));
        }
    }

    /**
     * Test adds Integer values at specific index when empty, almost
     * empty,not empty and when buffer is larger than initial size of
     * 10 is surpassed.
     */
    @Test
    public void addTest()
    {
        // Adds Index at i incrementing
        for (int i = 0; i < ITERATIONS; i++) {
            testArrayList.add(i, (E) (Integer) i);
            assertEquals(i, testArrayList.get(i));
        }

        // Adds Index at i decrementing
        for (int i = ITERATIONS; i >= 0; i--) {
            testArrayList.add(i, (E) (Integer) i);
            assertEquals(i, testArrayList.get(i));
        }

        //IndexOutOfBoundsException is thrown if -1 is called
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testArrayList.add(-1, (E) (Integer) ITERATIONS);
                });

        //IndexOutOfBoundsException is thrown if index larger than size of ArrayList is requested
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testArrayList.add(testArrayList.size() + 1, (E) (Integer) ITERATIONS);
                });
    }

    /**
     * Tests if values at specific index have been set when empty,
     * almost empty,not empty and when buffer is larger than initial
     * size of 10 is surpassed. Tests exceptions when attempting to
     * set index that is out of range.
     * */
    @Test
    public void setTest() {

        assertTrue(testArrayList.isEmpty());

        //IndexOutOfBoundsException is thrown if -1 is called
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testArrayList.set(-1, (E) (Integer) ITERATIONS);
                });

        //IndexOutOfBoundsException is thrown if index larger than size of ArrayList is requested
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testArrayList.set(testArrayList.size() + 1, (E) (Integer) ITERATIONS);
                });

        //reassign values
        this.fillArray();
        assertFalse(testArrayList.isEmpty());
        for (int i = 0; i < genericArray.length; i++) {
            testArrayList.set(i, (E)(Integer) ITERATIONS);
            assertEquals(ITERATIONS, testArrayList.get(i));
        }
    }

    /**
     * Test removes Integer values from the front of ArrayIntList when
     * empty, almost empty and not empty. Asserts that null is returned
     * when removeFront() is called don an empty array.
     */
    @Test
    public void removeFrontTest()
    {
        //test that an empty array returns null when removeFront() is called
        testArrayList.removeFront();
        assertTrue(testArrayList.isEmpty());
        assertNull(testArrayList.removeFront());


        //test with 1 value in array
        testArrayList.addFront((E) (Integer) ITERATIONS);
        testArrayList.removeFront();
        assertTrue(testArrayList.isEmpty());

        //fill the Array
        for (int i = 0; i <= ITERATIONS; i++) {
            testArrayList.add(i, (E) (Integer) i);
        }
        for (int i = 0; i < ITERATIONS; i++) {
            E removedValue = testArrayList.get(1);
            testArrayList.removeFront();
            assertEquals(removedValue, testArrayList.get(0));
        }
    }

    /**
     * Test removes Integer values from the front of ArrayIntList when
     * empty, almost empty and not empty. Asserts that null is returned
     * when removeBack() is called don an empty array.
     */
    @Test
    public void removeBackTest()
    {
        //test with empty array
        assertTrue(testArrayList.isEmpty());
        assertNull(testArrayList.removeBack());

        //reassign values
        this.fillArray();
        for (int i = 0; i < genericArray.length; i++) {
            E removedValue = testArrayList.get(testArrayList.size() - 1);
            assertEquals(removedValue, testArrayList.removeBack());
        }
    }

    /**
     * Test removes genericArray values at specific index when empty, almost
     * empty,not empty and when buffer is larger than initial size of
     * 10 is surpassed.
     */
    @Test
    public void removeIndexTest()
    {
        //test with empty array
        assertTrue(testArrayList.isEmpty());
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testArrayList.remove(0);
                });

        //test with index greater than size of array
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testArrayList.remove(1);
                });

        //reassign values
        this.fillArray();
        assertFalse(testArrayList.isEmpty());

        //test with index greater than size of array
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testArrayList.remove(testArrayList.size());
                });

        for (int i = 0; i < genericArray.length - 1; i++) {
            E valueAfterRemoved = testArrayList.get(1);
            testArrayList.remove(0);
            assertEquals(valueAfterRemoved, testArrayList.get(0));
        }
    }

    /**
     * Test removes genericArray values if present when empty, almost
     * empty,not empty and when buffer is larger than initial size of
     * 10 is surpassed.
     */
    @Test
    public void removeItemTest() {

        assertTrue(testArrayList.isEmpty());

        //reassign values at back to maintain order of genericArray
        for (int i = 0; i < genericArray.length; i++) {
            testArrayList.addBack(genericArray[i]);
        }
        assertFalse(testArrayList.isEmpty());

        for (int i = 0; i < genericArray.length; i++) {
            E valueRemoved = testArrayList.get(i);
            testArrayList.remove(genericArray[i]);
            testArrayList.addFront((E)(Integer) ITERATIONS);
            assertFalse(testArrayList.contains(valueRemoved));
        }
    }

    /**
     * Test get method returns for empty, almost empty
     * and exception throw due to Index out of bounds
     */
    @Test
    public void getTest()
    {
        //test with empty array
        assertTrue(testArrayList.isEmpty());

        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testArrayList.get(0);
                });

        //test with index greater than size of array
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    testArrayList.get(1);
                });

        //reassign values at back to maintain order of genericArray
        for (int i = 0; i < genericArray.length; i++) {
            testArrayList.addBack(genericArray[i]);
        }
        assertFalse(testArrayList.isEmpty());

        //test the return values of get()
        for (int i = 0; i < genericArray.length; i++) {
            assertEquals(genericArray[i], testArrayList.get(i));
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
        assertTrue(testArrayList.isEmpty());
        assertFalse(testArrayList.contains(ITERATIONS));

        //Test if value 1 exists
        testArrayList.add(0, (E)(Integer) ITERATIONS);
        assertTrue(testArrayList.contains(ITERATIONS));

        //test if number does not exist
        assertFalse(testArrayList.contains(80085));
    }

    /**
     * Test isEmpty() against empty and non-empty ArrayList
     */
    @Test
    public void isEmptyTest()
    {
        //test against empty array
        assertTrue(testArrayList.isEmpty());

        //test against non-empty array
        this.fillArray();
        assertFalse(testArrayList.isEmpty());
    }

    /**
     * Test size() for no values, some values,
     * against empty list
     */
    @Test
    public void sizeTest()
    {
        //test against empty ArrayList
        assertTrue(testArrayList.isEmpty());
        assertEquals(0, testArrayList.size());

        //test against non-empty ArrayList
        for (int i = 0; i < ITERATIONS; i++) {
            testArrayList.addBack((E)(Integer) i);
            assertEquals(i + 1, testArrayList.size());
        }
    }

    /*
     * Helper method to fill the array in this class
     */
    private void fillArray()
    {
        //reassign values
        for (int i = 0; i < genericArray.length; i++) {
            testArrayList.addFront(genericArray[i]);
            assertEquals(genericArray[i], testArrayList.get(0));
        }
    }
}

