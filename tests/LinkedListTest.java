import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    /**
     * Create LinkedList at start for testing
     */
    private final LinkedList<Integer> testLinkedList = new LinkedList<>();

    /**
     * The first index in list is 0
     */
    private final int FIRST_INDEX = 0;

    /**
     * The item returned by methods if item not found
     */
    private final int INVALID_INDEX = -1;

    /**
     * The standard filler item added to container prior to testing method
     */
    private final int FILLER_ITEM = 5;

    /**
     * The standard item used to test methods
     */
    private final int TEST_ITEM = 20;

    /**
     * Adds ten items to list for testing
     */
    private void addMultipleItems() {
        // add 10 items to list
        for(int i = 0; i < 10; i++) {
            testLinkedList.addBack(FILLER_ITEM);
        }
    }

    @Test
    void addFront_hasItem_addedSuccessfully() {
        // add initial item
        testLinkedList.addBack(FILLER_ITEM);

        // add test value
        testLinkedList.addFront(TEST_ITEM);

        // ensure expected value is at index 0
        assertEquals(TEST_ITEM, testLinkedList.get(FIRST_INDEX));
    }

    @Test
    void addFront_hasMultipleItems_addedSuccessfully() {
        // add several initial values
        addMultipleItems();

        // add test value
        testLinkedList.addFront(TEST_ITEM);

        // ensure expected value is at index 0
        assertEquals(TEST_ITEM, testLinkedList.get(FIRST_INDEX));
    }

    @Test
    void addFront_empty_addedSuccessfully() {
        // make test value new head
        testLinkedList.addFront(TEST_ITEM);

        // ensure expected value is at index 0
        assertEquals(TEST_ITEM, testLinkedList.get(FIRST_INDEX));
    }

    @Test
    void addBack_hasItem_addedSuccessfully() {
        // add initial value
        testLinkedList.addFront(FILLER_ITEM);

        // add test value
        testLinkedList.addBack(TEST_ITEM);

        // ensure expected value is at end of list
        assertEquals(TEST_ITEM, testLinkedList.get(testLinkedList.size() -1));
    }

    @Test
    void addBack_hasMultipleItems_addedSuccessfully() {
        // add several initial values
        addMultipleItems();

        // add test value
        testLinkedList.addBack(TEST_ITEM);

        // ensure expected value is at end of list
        assertEquals(TEST_ITEM, testLinkedList.get(testLinkedList.size() -1));
    }

    @Test
    void addBack_empty_addedSuccessfully() {
        // make test value new tail
        testLinkedList.addBack(TEST_ITEM);

        // ensure expected value is at end of list
        assertEquals(TEST_ITEM, testLinkedList.get(testLinkedList.size() -1));
    }

    @Test
    void add() {
    }

    @Test
    void get_hasItem_returnsItem() {
        // add expected item to list
        testLinkedList.addFront(TEST_ITEM);

        // attempt to retrieve expected value
        assertEquals(TEST_ITEM, testLinkedList.get(FIRST_INDEX));
    }

    @Test
    void get_hasMultipleItems_returnsItem() {
        // add several initial items
        addMultipleItems();

        // add item to retrieve
        testLinkedList.addBack(TEST_ITEM);

        // attempt to retrieve expected item at final index
        assertEquals(TEST_ITEM, testLinkedList.get(testLinkedList.size() - 1));
    }

    @Test
    void get_listEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to get value from empty list
            testLinkedList.get(FIRST_INDEX);
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
            testLinkedList.get(INVALID_INDEX);
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
            testLinkedList.get(FIRST_INDEX + 1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void set() {
    }

    @Test
    void removeFront_hasItem_removedSuccessfully() {
        // add value to remove
        testLinkedList.addFront(TEST_ITEM);

        // attempt to remove value from list
        assertEquals(TEST_ITEM, testLinkedList.removeFront());

        // ensure list is now empty
        assertTrue(testLinkedList.isEmpty());
    }

    @Test
    void removeFront_hasMultipleItems_removedSuccessfully() {
        // add several initial values
        addMultipleItems();

        // add value to remove
        testLinkedList.addFront(TEST_ITEM);

        // attempt to remove front value from list
        testLinkedList.removeFront();

        // ensure value was removed from list
        assertNotEquals(TEST_ITEM, testLinkedList.get(FIRST_INDEX));
        assertFalse(testLinkedList.contains(TEST_ITEM));
        assertEquals(10, testLinkedList.size());
    }

    @Test
    void removeFront_empty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove nonexistent item
            testLinkedList.removeFront();
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeBack_hasItem_removedSuccessfully() {
        // add item to remove
        testLinkedList.addBack(TEST_ITEM);

        // attempt to remove item from list
        testLinkedList.removeFront();

        // ensure list is now empty
        assertTrue(testLinkedList.isEmpty());
    }

    @Test
    void removeBack_hasMultipleItems_removedSuccessfully() {
        // add several initial items
        addMultipleItems();

        // add item to remove
        testLinkedList.addBack(TEST_ITEM);

        // attempt to remove front item from list
        testLinkedList.removeBack();

        // ensure item was removed from list
        assertNotEquals(TEST_ITEM, testLinkedList.get(testLinkedList.size() - 1));
        assertFalse(testLinkedList.contains(TEST_ITEM));
        assertEquals(10, testLinkedList.size());
    }

    @Test
    void removeBack_empty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove nonexistent item
            testLinkedList.removeBack();
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeItem() {
    }

    @Test
    void removeIndex() {
    }

    @Test
    void contains_itemExists_returnsTrue() {
        // add several initial items
        addMultipleItems();

        // add item to check for
        testLinkedList.addBack(TEST_ITEM);

        // check if item is in list
        assertTrue(testLinkedList.contains(TEST_ITEM));
    }

    @Test
    void contains_itemNotExists_returnsFalse() {
        // add several initial items
        addMultipleItems();

        // check if item is in buffer
        assertFalse(testLinkedList.contains(TEST_ITEM));
    }

    @Test
    void contains_empty_returnsFalse() {
        assertFalse(testLinkedList.contains(TEST_ITEM));
    }

    @Test
    void isEmpty_hasItem_returnsFalse() {
        // add item so the list is not empty
        testLinkedList.addFront(FILLER_ITEM);

        assertFalse(testLinkedList.isEmpty());
    }

    @Test
    void isEmpty_hasMultipleItems_returnsFalse() {
        // add items so list is not empty
        addMultipleItems();

        // check if list is empty
        assertFalse(testLinkedList.isEmpty());
    }

    @Test
    void isEmpty_empty_returnsTrue() {
        // check if list is empty
        assertTrue(testLinkedList.isEmpty());
    }

    @Test
    void size_hasItem_returnsSize() {
        // add item so list is not empty
        testLinkedList.addFront(FILLER_ITEM);

        assertEquals(1, testLinkedList.size());
    }

    @Test
    void size_hasMultipleItems_returnsSize() {
        // add items so the list is not empty
        addMultipleItems();

        assertEquals(10, testLinkedList.size());
    }

    @Test
    void size_empty_returnsSize() {
        assertEquals(0, testLinkedList.size());
    }
}