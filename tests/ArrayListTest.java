package tests;

        import abstractDataTypes.ArrayList;
        import interfaces.List;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test Class for ArrayIntList
 * @author tobygoetz
 * @version 1.0
 */
public class ArrayListTest {
    public List<String> empty = new ArrayList<>(new String[]{});
    public List<String> nearlyEmpty = new ArrayList<>(new String[]{"Toby"});
    public List<String> notEmpty = new ArrayList<>(new String[]{"Toby", "is", "cool", "!" });
    public List<String> full = new ArrayList<>(new String[]
            {"Toby", "is", "cool", "!", " ", "Or", "so", "he", "belives", "!" });

    public Exception exception;
    public static final int ITERATIONS = 15;

    /**
     * Test adds Integer values to the front when empty, almost empty,
     * not empty and when buffer is larger than intial size of 10 is
     * surpassed.
     */
//    @Test
//    public void addFrontTest() {
//        assertEquals(0, array.size());
//        for (int i = 0; i <= ITERATIONS; i++) {
//            array.addFront(i);
//            // Index 0 changes everytime addFront is called
//            assertEquals(i, array.get(0));
//        }
//    }
//
//    /**
//     * Test adds Integer values to the back when empty, almost empty,
//     * not empty and when buffer is larger than intial size of 10 is
//     * surpassed.
//     */
//    @Test
//    public void addBackTest() {
//        array.clear();
//        assertEquals(0, array.size());
//        for (int i = 0; i <= ITERATIONS; i++) {
//            array.addBack(i);
//            // Index 0 changes everytime addFront is called
//            assertEquals(i, array.get(array.size() - 1));
//        }
//    }
//
//    /**
//     * Test adds Integer values at specific index when empty, almost
//     * empty,not empty and when buffer is larger than intial size of
//     * 10 is surpassed.
//     */
//    @Test
//    public void addTest() {
//        array.clear();
//        assertEquals(0, array.size());
//        for (int i = 0; i <= ITERATIONS; i++) {
//            array.add(i, i);
//            // Index at i incrementing
//            assertEquals(i, array.get(i));
//        }
//
//        for (int i = ITERATIONS; i >= 0; i--) {
//            array.add(i, i);
//            // Index at i decrementing
//            assertEquals(i, array.get(i));
//        }
//
//        //IndexOutOfBoundsException is thrown if -1 is called
//        exception = assertThrows(
//                IndexOutOfBoundsException.class, () -> {
//                    array.add(-1, ITERATIONS);
//                });
//
//        //IndexOutOfBoundsException is thrown if index larger than
//        // the amount of indices is called
//        exception = assertThrows(
//                IndexOutOfBoundsException.class, () -> {
//                    array.add(array.size() + 1, ITERATIONS);
//                });
//    }
//
//    /**
//     * Test removes Integer values from the front of ArrayIntList when
//     * empty, almost empty and not empty
//     */
//    @Test
//    public void removeFrontTest() {
//        array.clear();
//        assertEquals(0, array.size());
//
//        //test with empty array
//        array.removeFront();
//        exception = assertThrows(
//                IndexOutOfBoundsException.class, () -> {
//                    array.get(0);
//                });
//        assertTrue(array.isEmpty());
//
//        //test with 1 value in array
//        array.addFront(ITERATIONS);
//        array.removeFront();
//        assertTrue(array.isEmpty());
//
//        for (int i = 0; i <= ITERATIONS; i++) {
//            array.add(i, i);
//        }
//        for (int i = 0; i < ITERATIONS; i++) {
//            int removedValue = array.get(1);
//            array.removeFront();
//            assertEquals(removedValue, array.get(0));
//        }
//    }
//
//    /**
//     * Test removes Integer values from the front of ArrayIntList when
//     * empty, almost empty and not empty
//     */
//    @Test
//    public void removeBackTest() {
//        array.clear();
//        assertEquals(0, array.size());
//
//        //test with empty array
//        array.removeBack();
//        exception = assertThrows(
//                IndexOutOfBoundsException.class, () -> {
//                    array.get(0);
//                });
//        assertTrue(array.isEmpty());
//
//        //test with 1 value in array
//        array.addFront(ITERATIONS);
//        array.removeBack();
//        assertTrue(array.isEmpty());
//
//        //Finish this for removed
////        for (int i = 0; i <= ITERATIONS; i++) {
////            array.add(i, i);
////        }
////        for (int i = 0; i < ITERATIONS; i++) {
////            int removedValue = array.get(1);
////            array.removeFront();
////            assertEquals(removedValue, array.get(0));
////        }
//    }
//
//    /**
//     * Test removes Integer values at specific index when empty, almost
//     * empty,not empty and when buffer is larger than intial size of
//     * 10 is surpassed.
//     */
//    @Test
//    public void removeTest() {
//        array.clear();
//        assertEquals(0, array.size());
//
//        //test with empty array
//        exception = assertThrows(
//                IndexOutOfBoundsException.class, () -> {
//                    array.get(0);
//                });
//        assertTrue(array.isEmpty());
//
//        //test with index higher than size of array
//        exception = assertThrows(
//                IndexOutOfBoundsException.class, () -> {
//                    array.get(array.size());
//                });
//        assertTrue(array.isEmpty());
//
//        //test with one value in array
//        array.addFront(0);
//        array.remove(0);
//        assertTrue(array.isEmpty());
//        assertEquals(0, array.size());
//
//        for (int i = 0; i <= ITERATIONS; i++) {
//            array.add(i, i);
//        }
//        for (int i = 0; i < ITERATIONS; i++) {
//            int removedValue = array.get(1);
//            array.remove(0);
//            assertEquals(removedValue, array.get(0));
//        }
//    }
//
//    /**
//     * Test get method returns for empty, almost empty
//     * and exception throw due to Index out of bounds
//     */
//    @Test
//    public void getTest() {
//        array.clear();
//        assertEquals(0, array.size());
//
//        //test with empty array
//        exception = assertThrows(
//                IndexOutOfBoundsException.class, () -> {
//                    array.get(0);
//                });
//        assertTrue(array.isEmpty());
//
//        //test with index greater than size of array
//        //test with empty array
//        exception = assertThrows(
//                IndexOutOfBoundsException.class, () -> {
//                    array.get(1);
//                });
//        assertTrue(array.isEmpty());
//
//        //reassign values
//        this.fillArray(array);
//
//        //test the return values of get()
//        for (int i = 0; i <= ITERATIONS; i++) {
//            int getValue = array.get(i);
//            assertEquals(getValue, array.get(i));
//        }
//    }
//
//    /**
//     * Test contains() for non-existent values, existing values,
//     * against empty list
//     */
//    @Test
//    public void containsTest() {
//        array.clear();
//        assertEquals(0, array.size());
//
//        //Test if empty
//        assertFalse(array.contains(ITERATIONS));
//
//        //Test if value 1 exists
//        array.add(0, 1);
//        assertTrue(array.contains(1));
//
//        //test if Iterations exists
//        this.fillArray(array);
//        assertTrue(array.contains(ITERATIONS));
//
//        //test if number does not exist
//        assertFalse(array.contains(80085));
//    }
//
//    /**
//     * Test IndexOf() for no values, some values,
//     * against empty list
//     */
//    @Test
//    public void IndexOfTest() {
//        //saftey check
//        array.clear();
//        assertEquals(0, array.size());
//
//        //test bounds of IndexOf()
//        assertEquals(-1, array.indexOf(-ITERATIONS));
//
//        //test if indices match value returns of all indices
//        System.out.println(array);
//        for (int i = 0; i < ITERATIONS; i++) {
//            array.addBack(i);
//        }
//        for (int i = 0; i < ITERATIONS; i++) {
//            array.addBack(i);
//            assertEquals(i, array.indexOf(i));
//        }
//    }
//
//    /**
//     * Test isEmpty() for no values, some values,
//     * against empty list
//     */
//    @Test
//    public void isEmptyTest() {
//        //saftey check
//        array.clear();
//        assertEquals(0, array.size());
//
//        //test against non-empty array
//        this.fillArray(array);
//        assertFalse(array.isEmpty());
//    }
//
//    /**
//     * Test size() for no values, some values,
//     * against empty list
//     */
//    @Test
//    public void sizeTest() {
//        //saftey check
//        array.clear();
//        assertEquals(0, array.size());
//
//        //test against non-empty array
//        for (int i = 0; i < ITERATIONS; i++) {
//            array.addBack(i);
//            assertEquals(i + 1, array.size());
//        }
//    }
//
//    /**
//     * Test clear() for no values, some values,
//     * against empty list
//     */
//    @Test
//    public void clearTest() {
//        //saftey check
//        array.clear();
//        assertEquals(0, array.size());
//
//        //test against non-empty array
//        this.fillArray(array);
//        array.clear();
//        assertEquals(0, array.size());
//    }
//
//    /**
//     * Helper method to fill the array in this class
//     * @param arr Field array
//     */
//    public void fillArray(ArrayIntList arr) {
//        //reassign values
//        for (int i = 0; i <= ITERATIONS; i++) {
//            array.addFront(i);
//            // Index 0 changes everytime addFront is called
//            assertEquals(i, array.get(0));
//        }
//    }
}
