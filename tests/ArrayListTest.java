import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest
{
    private ArrayList<String> emptyList;
    private ArrayList<String> oneItemList;
    private ArrayList<String> fullList;

    public void createLists()
    {
        //empty list
        emptyList = new ArrayList<>();

        //one item list
        oneItemList = new ArrayList<>();
        oneItemList.addFront("Yes");

        //full list
        fullList = new ArrayList<>();
        fullList.addFront("Yes");
        fullList.add(1, "Two");
        fullList.add(2, "No");
        fullList.add(3, "Maybe");
        fullList.add(4, "Why");
        fullList.add(5, "How");
        fullList.add(6, "Where");
        fullList.add(7, "Potentially");
        fullList.add(8, "Frame");
    }
    @Test
    void addFront()
    {
        createLists();
        emptyList.addFront("More");
        oneItemList.addFront("More");
        fullList.addFront("More");

        assertEquals("More", emptyList.get(0));
        assertEquals("More", oneItemList.get(0));
        assertEquals("More", fullList.get(0));
    }

    @Test
    void addBack()
    {
        createLists();
        emptyList.addBack("Back");
        oneItemList.addBack("Back");
        fullList.addBack("Back");

        assertEquals("Back", emptyList.get(emptyList.size() - 1));
        assertEquals("Back", oneItemList.get(oneItemList.size() - 1));
        assertEquals("Back", fullList.get(fullList.size() - 1));
    }

    @Test
    void add()
    {
        createLists();
        emptyList.add(2, "Try");
        oneItemList.add(2, "Try");
        fullList.add(2, "Try");

        assertEquals("Try", emptyList.get(2));
        assertEquals("Try", oneItemList.get(2));
        assertEquals("Try", fullList.get(2));
    }

    @Test
    void get()
    {
        createLists();

        // **** throws a NoSuchElementElementException ****
//        assertEquals(NoSuchElementException, emptyList.get(0));

        // **** throws a IndexOutOfBoundsException ****
//        assertEquals(IndexOutOfBoundsException, oneItemList.get(1));

        assertEquals("Yes", oneItemList.get(0));
        assertEquals("Yes", fullList.get(0));
    }

    @Test
    void set()
    {
        createLists();

        emptyList.set(4, "Fun");
        oneItemList.set(4, "Fun");
        fullList.set(4, "Fun");

        assertEquals("Fun", emptyList.get(4));
        assertEquals("Fun", oneItemList.get(4));
        assertEquals("Fun", fullList.get(4));
    }

    @Test
    void removeFront()
    {
        createLists();

        // **** throws a NoSuchElementElementException ****
//        assertEquals("Yes", emptyList.get(0));

        String removedElementOneItem = oneItemList.get(0);
        String removedElementFullList = fullList.get(0);

        assertEquals(removedElementOneItem, oneItemList.removeFront());
        assertEquals(removedElementFullList, fullList.removeFront());
    }

    @Test
    void removeBack()
    {
        createLists();

        String removedElementOneItem = oneItemList.get(oneItemList.size() - 1);
        String removedElementFullList = fullList.get(fullList.size() - 1);

//        ****  throws a NoSuchElementException ****
//        assertEquals(removedElementOneItem, oneItemList.removeBack());

        assertEquals(removedElementOneItem, oneItemList.removeBack());
        assertEquals(removedElementFullList, fullList.removeBack());
    }

    @Test
    void remove()
    {
        createLists();

        String elementToBeRemoved = "Yes";

        // **** throws NoSuchElementException ****
        // emptyList
        // assertEquals(NoSuchElementException, emptyList.get(0));

        // oneItemList
        // **** throws NoSuchElementException *** after method is
        // executed because it removes the element

//        oneItemList.remove(elementToBeRemoved);


        // full list
        fullList.remove(elementToBeRemoved);
        assertEquals("Two",fullList.get(0));
    }

    @Test
    void testRemove()
    {
        createLists();

        // **** throws IndexOutOfBoundsException ****
//        emptyList.remove(2);
//        oneItemList.remove(2);

        // oneItemList - remove the first item
        String itemRemoved = oneItemList.get(0);
        assertEquals(itemRemoved,oneItemList.remove(0));

        // full list
        String itemRemovedFullList = fullList.get(3);
        assertEquals(itemRemovedFullList, fullList.remove(3));
    }

    @Test
    void contains()
    {
        createLists();

        //exceptions

        // **** throws IndexOutOfBoundsException ****
//        emptyList.contains("No");

        // true
        assertTrue(oneItemList.contains("Yes"));
        assertTrue(fullList.contains("Potentially"));

        // false
        assertFalse(oneItemList.contains("Money"));
        assertFalse(fullList.contains("Money"));
    }

    @Test
    void isEmpty()
    {
        createLists();

        assertTrue(emptyList.isEmpty());
        assertFalse(oneItemList.isEmpty());
        assertFalse(fullList.isEmpty());
    }

    @Test
    void size()
    {
        createLists();

        assertEquals(0, emptyList.size());
        assertEquals(1, oneItemList.size());
        assertEquals(9, fullList.size());
    }
}