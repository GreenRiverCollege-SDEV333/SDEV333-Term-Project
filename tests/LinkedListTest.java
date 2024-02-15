import org.junit.jupiter.api.Test;

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
            testLinkedList.addFront(FILLER_ITEM);
        }
    }

    @Test
    void addFront() {
    }

    @Test
    void addBack() {
    }

    @Test
    void add() {
    }

    @Test
    void get() {
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
        testLinkedList.addFront(TEST_ITEM);

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