import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ArrayListTest {
    /**
     * Create ArrayList at start for testing
     */
    private final ArrayList<Integer> testArrayIntList = new ArrayList<>();

    /**
     * The default max capacity of buffer, at creation
     */
    private final int DEFAULT_BUFFER_LENGTH = 10;

    /**
     * The first index in buffer is 0
     */
    private final int FIRST_INDEX = 0;

    /**
     * The item returned by methods if item not found
     */
    private final int INVALID_INDEX = -1;

    /**
     * The standard filler item added to buffer prior to testing method
     */
    private final int FILLER_ITEM = 5;

    /**
     * The standard item used to test methods
     */
    private final int TEST_ITEM = 20;

    @Test
    void addFront_bufferContainsOneItem_addedSuccessfully() {
        // add initial item
        testArrayIntList.addBack(FILLER_ITEM);

        // add expected item to front
        testArrayIntList.addFront(TEST_ITEM);

        // ensure expected item is at index 0
        assertEquals(TEST_ITEM, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void addFront_bufferContainsMultipleItems_addedSuccessfully() {
        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // add expected item to front
        testArrayIntList.addFront(TEST_ITEM);

        // ensure expected item is at index 0
        assertEquals(TEST_ITEM, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void addFront_bufferEmpty_addedSuccessfully() {
        testArrayIntList.addFront(TEST_ITEM);

        // ensure expected item is at index 0
        assertEquals(TEST_ITEM, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void addFront_bufferFull_addedSuccessfully() {
        // add 10 items to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addBack(FILLER_ITEM);
        }

        // add 11th item to front
        testArrayIntList.addFront(TEST_ITEM);

        // ensure expected item is at index 0
        assertEquals(TEST_ITEM, testArrayIntList.get(FIRST_INDEX));

    }

    @Test
    void addBack_bufferContainsOneItem_addedSuccessfully() {
        // add initial item
        testArrayIntList.addFront(FILLER_ITEM);

        // add expected item to back
        testArrayIntList.addBack(TEST_ITEM);

        // ensure expected item is at final index
        assertEquals(TEST_ITEM, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void addBack_bufferContainsMultipleItems_addedSuccessfully() {
        // add several initial items
        testArrayIntList.addFront(FILLER_ITEM);
        testArrayIntList.addFront(FILLER_ITEM);
        testArrayIntList.addFront(FILLER_ITEM);

        // add expected item to back
        testArrayIntList.addBack(TEST_ITEM);

        // ensure expected item is at final index
        assertEquals(TEST_ITEM, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void addBack_bufferEmpty_addedSuccessfully() {
        testArrayIntList.addBack(TEST_ITEM);

        // ensure the expected item is at final index
        assertEquals(TEST_ITEM, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void addBack_bufferFull_addedSuccessfully() {
        // add 10 items to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addFront(FILLER_ITEM);
        }

        // add 11th item to back
        testArrayIntList.addBack(TEST_ITEM);

        // ensure expected item is at final index
        assertEquals(TEST_ITEM, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void add_bufferContainsOneItem_addedSuccessfully() {
        // add initial item
        testArrayIntList.addBack(FILLER_ITEM);

        // add expected item to buffer
        testArrayIntList.add(1, TEST_ITEM);

        // ensure expected item is at final index
        assertEquals(TEST_ITEM, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void add_bufferContainsMultipleItems_addedSuccessfully() {
        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // add expected item somewhere in buffer
        testArrayIntList.add(2, TEST_ITEM);

        // ensure expected item is at middle index
        assertEquals(TEST_ITEM, testArrayIntList.get(2));
    }

    @Test
    void add_bufferEmpty_addedSuccessfully() {
        testArrayIntList.add(0, TEST_ITEM);

        // ensure the expected item is at final index
        assertEquals(TEST_ITEM, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void add_bufferFull_addedSuccessfully() {
        // add 10 items to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addBack(FILLER_ITEM);
        }

        // add 11th item to buffer
        testArrayIntList.add(2, TEST_ITEM);

        // ensure expected item is at final index
        assertEquals(TEST_ITEM, testArrayIntList.get(2));
    }

    @Test
    void add_invalidIndexNegative_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to add item at invalid index
            testArrayIntList.add(-1, TEST_ITEM);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void add_invalidIndexMoreThanSize_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to add item at invalid index
            testArrayIntList.add(1, TEST_ITEM);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void get_bufferContainsOneItem_returnsitem() {
        // add expected item to buffer
        testArrayIntList.addFront(TEST_ITEM);

        // attempt to retrieve expected item
        assertEquals(TEST_ITEM, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void get_bufferContainsMultipleItems_returnsitem() {
        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // add item to retrieve
        testArrayIntList.addBack(TEST_ITEM);

        // attempt to retrieve expected item
        assertEquals(TEST_ITEM, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void get_bufferEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to get item from empty buffer
            testArrayIntList.get(FIRST_INDEX);
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void get_invalidIndexNegative_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to get item from invalid index
            testArrayIntList.get(-1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void get_invalidIndexMoreThanSize_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to get item from invalid index
            testArrayIntList.get(1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void set_bufferContainsOneItem_setItemAtIndex() {
        // add initial item to buffer
        testArrayIntList.addFront(FILLER_ITEM);

        // replace item at that index
        testArrayIntList.set(FIRST_INDEX, TEST_ITEM);

        // attempt to retrieve expected item
        assertEquals(TEST_ITEM, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void set_bufferContainsMultipleItems_setItemAtIndex() {
        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // replace item at second index
        testArrayIntList.set(2, TEST_ITEM);

        // attempt to retrieve expected item
        assertEquals(TEST_ITEM, testArrayIntList.get(2));
    }

    @Test
    void set_bufferEmpty_setItemAtIndex() {
        // add item to index 0 of empty buffer
        testArrayIntList.set(FIRST_INDEX, TEST_ITEM);

        // check if exception was thrown
        assertEquals(TEST_ITEM, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void set_invalidIndexNegative_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to set item at invalid index
            testArrayIntList.set(-1, TEST_ITEM);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void set_invalidIndexMoreThanSize_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to set item at invalid index
            testArrayIntList.set(1, TEST_ITEM);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeBack() {
    }

    @Test
    void removeItem() {
    }

    @Test
    void removeIndex() {
    }

    @Test
    void contains() {
    }
    @Test
    void isEmpty_bufferContainsOneItem_returnsFalse() {
        // add item so the buffer is not empty
        testArrayIntList.addFront(FILLER_ITEM);

        assertFalse(testArrayIntList.isEmpty());
    }

    @Test
    void isEmpty_bufferContainsMultipleValues_returnsFalse() {
        // add items so the buffer is not empty
        testArrayIntList.addFront(FILLER_ITEM);
        testArrayIntList.addFront(FILLER_ITEM);
        testArrayIntList.addFront(FILLER_ITEM);

        // check if buffer is empty
        assertFalse(testArrayIntList.isEmpty());
    }

    @Test
    void isEmpty_bufferFull_returnsFalse() {
        // add 10 items to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addBack(FILLER_ITEM);
        }

        // check if buffer is empty
        assertFalse(testArrayIntList.isEmpty());
    }

    @Test
    void isEmpty_bufferEmpty_returnsTrue() {
        // check if buffer is empty
        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void size_bufferContainsOneItem_returnsSize() {
        // add item so the buffer is not empty
        testArrayIntList.addFront(FILLER_ITEM);

        assertEquals(1, testArrayIntList.size());
    }

    @Test
    void size_bufferContainsMultipleItems_returnsSize() {
        // add items so the buffer is not empty
        testArrayIntList.addFront(FILLER_ITEM);
        testArrayIntList.addFront(FILLER_ITEM);
        testArrayIntList.addFront(FILLER_ITEM);

        assertEquals(3, testArrayIntList.size());
    }

    @Test
    void size_bufferEmpty_returnsSize() {
        assertEquals(0, testArrayIntList.size());
    }

    @Test
    void size_bufferFull_returnsSize() {
        // add 10 items to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addBack(FILLER_ITEM);
        }

        assertEquals(DEFAULT_BUFFER_LENGTH, testArrayIntList.size());
    }
}