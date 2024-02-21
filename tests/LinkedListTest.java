import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest
{
    private LinkedList<Double> emptyList;
    private LinkedList<String> oneItemList;
    private LinkedList<Integer> fullList;
    public void createLinkedLists()
    {
        // empty list
        emptyList = new LinkedList<>();

        // one item list
        oneItemList = new LinkedList<>();
        oneItemList.addFront("wonder");

        // full list
        fullList = new LinkedList<>();
        fullList.addFront(45);
        fullList.add(1,4);
        fullList.add(2,6);
        fullList.add(3,35);
        fullList.add(4,67);
        fullList.add(5,80);
        fullList.add(6,91);
        fullList.add(7,24);
        fullList.addBack(30);
    }

    @Test
    void addFront()
    {
      createLinkedLists();

      double addToEmpty = 27.5;
      String addToOne = "wow";
      int addToFull = 1;

      emptyList.addFront(addToEmpty);
      oneItemList.addFront(addToOne);
      fullList.addFront(addToFull);

      assertEquals(27.5, emptyList.get(0));
      assertEquals("wow", oneItemList.get(0));
      assertEquals(1, fullList.get(0));
    }

    @Test
    void addBack()
    {
        createLinkedLists();

        double addToEmpty = 27.5;
        String addToOne = "wow";
        int addToFull = 1;

        emptyList.addBack(addToEmpty);
        oneItemList.addBack(addToOne);
        fullList.addBack(addToFull);

        assertEquals(27.5, emptyList.get(emptyList.size() - 1));
        assertEquals("wow", oneItemList.get(oneItemList.size() - 1));
        assertEquals(1, fullList.get(fullList.size() - 1));
    }

    @Test
    void add()
    {
        createLinkedLists();

        double addToEmpty = 31.5;
        String addToOne = "cool";
        int addToFull = 5;

        // adding item to empty list with
        // an index over 0 will give an IndexOutOfBoundsException
//        emptyList.add(2, 31.5);

        emptyList.add(0, addToEmpty);
        oneItemList.add(1, addToOne);
        fullList.add(4, addToFull);

        assertEquals(addToEmpty, emptyList.get(0));
        assertEquals(addToOne, oneItemList.get(1));
        assertEquals(addToFull, fullList.get(4));

    }

    @Test
    void get()
    {
        createLinkedLists();

        // throws a NoSuchElementException
        // emptyList.get();

        assertEquals("wonder", oneItemList.get(0));
        assertEquals(67, fullList.get(4));
    }

    @Test
    void set()
    {
        createLinkedLists();

        // throws a NoSuchElementException
        // emptyList.set();

        oneItemList.set(0, "juice");
        fullList.set(3, 43);

        assertEquals("juice", oneItemList.get(0));
        assertEquals(43, fullList.get(3));
    }

    @Test
    void removeFront()
    {
        createLinkedLists();

        // throws a NoSuchElementException
        // emptyList.removeFront();

        assertEquals("wonder",oneItemList.removeFront());
        assertEquals(45, fullList.removeFront());
    }

    @Test
    void removeBack()
    {
        createLinkedLists();
        // throws a NoSuchElementException
        // emptyList.removeBack();

        assertEquals("wonder", oneItemList.removeBack());
        assertEquals(30, fullList.removeBack());
    }

    @Test
    void remove()
    {
        createLinkedLists();
        // throws a NoSuchElementException
        // emptyList.remove();

        String removeFromOneList = "wonder";

        oneItemList.remove(removeFromOneList);
        assertEquals("wonder", removeFromOneList);

        Integer removeFromFullList = 24;
        fullList.remove(removeFromFullList);
        assertEquals(24, removeFromFullList);
    }

    @Test
    void testRemove()
    {
        createLinkedLists();

        // throws a NoSuchElementException
        // emptyList.testRemove();

        String removedFromOneList = "wonder";
        int removedFromFullList = 35;

        assertEquals(removedFromOneList, oneItemList.remove(0));
        assertEquals(removedFromFullList, fullList.remove(3));
    }

    @Test
    void contains()
    {
        createLinkedLists();

        // throws a NoSuchElementException
        // emptyList.testRemove();

        // true
        assertTrue(oneItemList.contains("wonder"));
        assertTrue(fullList.contains(67));

        // false
        assertFalse(oneItemList.contains("free"));
        assertFalse(fullList.contains(100));
    }

    @Test
    void isEmpty()
    {
        createLinkedLists();

        assertTrue(emptyList.isEmpty());
        assertFalse(oneItemList.isEmpty());
        assertFalse(fullList.isEmpty());
    }

    @Test
    void size()
    {
        createLinkedLists();

        assertEquals(0, emptyList.size());
        assertEquals(1, oneItemList.size());
        assertEquals(9, fullList.size());
    }
}