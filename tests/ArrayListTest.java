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
    void removeFront_bufferContainsOneItem_removedSuccessfully() {
        // add item to remove
        testArrayIntList.addFront(TEST_ITEM);

        // attempt to remove first item from buffer
        assertEquals(TEST_ITEM, testArrayIntList.removeFront());

        // ensure buffer is now empty
        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void removeFront_bufferContainsMultipleItems_removedSuccessfully() {
        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // add item to remove
        testArrayIntList.addFront(TEST_ITEM);

        // attempt to remove first item from buffer
        assertEquals(TEST_ITEM, testArrayIntList.removeFront());

        // ensure value was removed from buffer
        assertNotEquals(TEST_ITEM, testArrayIntList.get(FIRST_INDEX));
        assertEquals(3, testArrayIntList.size());
    }

    @Test
    void removeFront_bufferEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove item at index 0
            testArrayIntList.removeFront();
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeBack_bufferContainsOneItem_removedSuccessfully() {
        // add value to remove
        testArrayIntList.addFront(TEST_ITEM);

        // attempt to remove last value from buffer
        assertEquals(TEST_ITEM, testArrayIntList.removeBack());

        // ensure buffer is now empty
        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void removeBack_bufferContainsMultipleItems_removedSuccessfully() {
        // add several initial values
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // add value to remove
        testArrayIntList.addBack(TEST_ITEM);

        // attempt to remove back value from buffer
        assertEquals(TEST_ITEM, testArrayIntList.removeBack());

        // ensure value was removed from buffer
        assertNotEquals(TEST_ITEM, testArrayIntList.get(testArrayIntList.size()));
        assertEquals(3, testArrayIntList.size());
    }

    @Test
    void removeBack_bufferEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove value at index 0
            testArrayIntList.removeBack();
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeItem_bufferContainsOneItem_removedSuccessfully() {
        // add value to remove
        testArrayIntList.addBack(TEST_ITEM);

        // attempt to remove item from buffer
        testArrayIntList.remove((Integer) TEST_ITEM);

        // ensure buffer is now empty
        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void removeItem_bufferContainsMultipleItems_removedSuccessfully() {
        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // add item to remove
        testArrayIntList.add(2, TEST_ITEM);

        // attempt to remove item from buffer
        testArrayIntList.remove((Integer) TEST_ITEM);

        // ensure value was removed from buffer
        assertNotEquals(TEST_ITEM, testArrayIntList.get(2));
        assertEquals(3, testArrayIntList.size());
    }

    @Test
    void removeItem_bufferEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove item from empty buffer
            testArrayIntList.remove((Integer) TEST_ITEM);
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeItem_itemNotInBuffer_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        try {
            // attempt to remove nonexistent item from buffer
            testArrayIntList.remove((Integer) TEST_ITEM);
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeIndex_bufferContainsOneItem_removedSuccessfully() {
        // add value to remove
        testArrayIntList.addBack(TEST_ITEM);

        // attempt to remove item from buffer
        assertEquals(TEST_ITEM, testArrayIntList.remove(FIRST_INDEX));

        // ensure buffer is now empty
        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void removeIndex_bufferContainsMultipleItems_removedSuccessfully() {
        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // add item to remove
        testArrayIntList.add(2, TEST_ITEM);

        // attempt to remove item from buffer
        assertEquals(TEST_ITEM, testArrayIntList.remove(2));

        // ensure value was removed from buffer
        assertEquals(3, testArrayIntList.size());
    }

    @Test
    void removeIndex_bufferEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove item at index 0
            testArrayIntList.remove(FIRST_INDEX);
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeIndex_invalidIndexNegative_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove item at invalid index
            testArrayIntList.remove(-1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeIndex_invalidIndexMoreThanSize_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove item at invalid index
            testArrayIntList.remove(1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void contains_itemExists_returnsTrue() {
        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // add item to check for
        testArrayIntList.addBack(TEST_ITEM);

        // check if item is in buffer
        assertTrue(testArrayIntList.contains(TEST_ITEM));
    }

    @Test
    void contains_itemNotExists_returnsFalse() {
        // add several initial items
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);
        testArrayIntList.addBack(FILLER_ITEM);

        // check if item is in buffer
        assertFalse(testArrayIntList.contains(TEST_ITEM));
    }

    @Test
    void contains_bufferEmpty_returnsFalse() {
        assertFalse(testArrayIntList.contains(TEST_ITEM));
    }

    @Test
    void contains_bufferFullItemExists_returnsTrue() {
        // add 9 items to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH - 1; i++) {
            testArrayIntList.addBack(FILLER_ITEM);
        }

        // add test item as last value
        testArrayIntList.addBack(TEST_ITEM);

        // check if item is in buffer
        assertTrue(testArrayIntList.contains(TEST_ITEM));
    }

    @Test
    void isEmpty_bufferContainsOneItem_returnsFalse() {
        // add item so the buffer is not empty
        testArrayIntList.addFront(FILLER_ITEM);

        assertFalse(testArrayIntList.isEmpty());
    }

    @Test
    void isEmpty_bufferContainsMultipleItems_returnsFalse() {
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