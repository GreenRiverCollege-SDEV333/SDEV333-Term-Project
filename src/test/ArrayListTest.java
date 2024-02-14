package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    void addFront()
    {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }

    }

    @Test
    void addBack()
    {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        for (int i = 1; i < 10; i++)
        {
            array.addBack(i);
            assertEquals(array.get(array.size() - 1), i);
        }

    }

    @Test
    void add()
    {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();
        for (int i = 1; i < 10; i++)
        {
            array.add(i, i+1);
            assertEquals(array.get(i), i+1);
        }

    }

    @Test
    void removeFront() {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        array.addFront(0);
        array.addFront(1);
        array.removeFront();
        assertEquals(array.size(), 1);


    }

    @Test
    void removeBack() {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        array.addFront(0);
        array.addFront(7);
        array.removeBack();
        assertEquals(array.size(), 1);
    }

    @Test
    void remove() {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        array.addFront(1);
        array.addFront(2);
        array.addFront(3);
        array.remove(1);
        assertEquals(array.size(), 2);

    }

    @Test
    void get()
    {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }
    }

    @Test
    void contains() {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        assertFalse(array.contains(4));

        array.addFront(3);
        assertTrue(array.contains(3));
        assertFalse(array.contains(7));

    }

    @Test
    void indexOf()
    {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        array.addFront(1);
        array.indexOf(1);
    }

    @Test
    void size()
    {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        for (int i = 1; i < 10; i++)
        {
            array.addBack(i);
            assertEquals(array.size(), i);
        }
    }
    @Test
    void isEmpty() {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();

        assertTrue(array.isEmpty());

        for (int i = 0; i < 10; i++)
        {
            array.addBack(i);
            assertFalse(array.isEmpty());
        }
    }


    @Test
    void clear()
    {
        lists.ArrayList<Integer> array = new lists.ArrayList<>();
        //not sure how to test

        for (int i = 0; i < 10; i++)
        {
            array.addBack(i);

        }
        array.clear();
    }

}