import org.junit.jupiter.api.*;
import part_1.ArrayList;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest<E>
{
    //instantiate lists and fields for global scope visibility
    ArrayList<E> emptyList = new ArrayList<>();
    ArrayList<E> oneItemList = new ArrayList<>();
    ArrayList<E> fullList = new ArrayList<>();
    //use Strings to test objects <E>
    String first = "20";
    String second = "30";
    String third = "40";

    @BeforeEach
    void setUp()
    {
        //put correct amount of objects in list
        for(int i = 0; i < 10; i++)
        {
            String num = Integer.toString(i);

            if(i < 1)
            {
                oneItemList.addFront((E) num);
                fullList.add(i, (E) num);
            }
            else
            {
                fullList.add(i, (E) num);
            }
        }
    }

    @Test
    void testAddFront()
    {
        emptyList.addFront((E) first);
        assertEquals(1, emptyList.size());
        assertEquals(first, emptyList.get(0));

        oneItemList.addFront((E) second);
        assertEquals(2, oneItemList.size());
        assertEquals(second, oneItemList.get(0));
        assertEquals("0", oneItemList.get(1));

        fullList.addFront((E) third);
        assertEquals(11, fullList.size());
        assertEquals(third, fullList.get(0));
    }

    @Test
    void testAddBack()
    {
        emptyList.addBack((E) first);
        assertEquals(1, emptyList.size());
        assertEquals(first, emptyList.get(0));

        oneItemList.addBack((E) second);
        assertEquals(2, oneItemList.size());
        assertEquals(second, oneItemList.get(1));

        fullList.addBack((E) third);
        assertEquals(11, fullList.size());
        assertEquals(third, fullList.get(10));
    }

    @Test
    void testAdd()
    {
        emptyList.add(0, (E) first);
        assertEquals(1, emptyList.size());
        assertEquals(first, emptyList.get(0));

        oneItemList.add(1, (E) second);
        assertEquals(2, oneItemList.size());
        assertEquals(second, oneItemList.get(1));

        fullList.add(5, (E) third);
        assertEquals(11, fullList.size());
        assertEquals(third, fullList.get(5));
    }

    @Test
    void testGet()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0));
        assertEquals("0", oneItemList.get(0));
        assertEquals("4", fullList.get(4));
    }

    @Test
    void testSet()
    {
        assertThrows(NoSuchElementException.class, () -> emptyList.removeBack());

        oneItemList.set(0, (E) first);
        assertEquals(first, oneItemList.get(0));

        fullList.set(3, (E) second);
        assertEquals(second, fullList.get(3));
    }

    @Test
    void testRemoveFront()
    {
        assertThrows(NoSuchElementException.class, () -> emptyList.removeFront());

        assertEquals("0", oneItemList.removeFront());
        assertEquals(0, oneItemList.size());

        assertEquals("0", fullList.removeFront());
        assertEquals(9, fullList.size());
    }

    @Test
    void testRemoveBack()
    {
        assertThrows(NoSuchElementException.class, () -> emptyList.removeBack());

        assertEquals("0", oneItemList.removeBack());
        assertEquals(0, oneItemList.size());

        assertEquals("9", fullList.removeBack());
        assertEquals(9, fullList.size());
    }

    @Test
    void testRemoveIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(0));

        assertEquals("0", oneItemList.remove(0));
        assertFalse(oneItemList.contains((E) first));

        assertEquals("1", fullList.remove(1));
        assertFalse(fullList.contains((E) "1"));
    }

    @Test
    void testRemoveItem()
    {
        //remove(int i)
        assertThrows(IllegalArgumentException.class, () -> emptyList.remove((E) "0"));

        oneItemList.remove((E) "0");
        assertFalse(oneItemList.contains((E) first));

        fullList.remove((E) "1");
        assertFalse(fullList.contains((E) "1"));
    }

    @Test
    void testContains()
    {
        assertFalse(emptyList.contains((E) "0"));

        assertTrue(oneItemList.contains((E) "0"));
        assertFalse(oneItemList.contains((E) "15"));

        assertTrue(fullList.contains((E) "3"));
        assertFalse(fullList.contains((E) "100"));
    }

    @Test
    void testIsEmpty()
    {
        assertTrue(emptyList.isEmpty());
        assertFalse(oneItemList.isEmpty());
        assertFalse(fullList.isEmpty());
    }

    @Test
    void testSize()
    {
        assertEquals(0, emptyList.size());
        assertEquals(1, oneItemList.size());
        assertEquals(10, fullList.size());
    }
}
