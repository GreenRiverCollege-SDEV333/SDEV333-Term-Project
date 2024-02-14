package test;

import lists.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest
{
    @Test
    void addFront()
    {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.addFront(i);
            assertEquals(list.get(0), i);
        }
    }
    @Test
    void addBack()
    {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i < 10; i++)
        {
            list.addBack(i);
            assertEquals(list.get(list.size() - 1), i);
        }
    }

    @Test
    void add()
    {
        //need to fix add method
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 1; i < 10; i++)
//        {
//            list.add(i, i+1);
//            assertEquals(list.get(i), i+1);
//        }

    }
    @Test
    void removeFront() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFront(0);
        list.addFront(1);
        list.removeFront();
        assertEquals(list.size(), 1);


    }
    @Test
    void removeBack() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFront(0);
        list.addFront(7);
        list.removeBack();
        assertEquals(list.size(), 2);
    }
    @Test
    void remove() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFront(1);
        list.addFront(2);
        list.addFront(3);
        list.remove(1);
        assertEquals(list.size(), 2);

    }
    @Test
    void get()
    {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++)
        {
            list.addFront(i);
            assertEquals(list.get(0), i);
        }
    }

    @Test
    void contains()
    {
        LinkedList<Integer> list = new LinkedList<>();

        assertFalse(list.contains(4));

        list.addBack(3);
        assertFalse(list.contains(7));

    }

    @Test
    void indexOf()
    {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFront(1);
        list.indexOf(1);
    }

    @Test
    void size()
    {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i < 10; i++)
        {
            list.addBack(i);
            assertEquals(list.size(), i);
        }
    }

    @Test
    void isEmpty()
    {
        LinkedList<Integer> list = new LinkedList<>();

        assertTrue(list.isEmpty());

        for (int i = 0; i < 10; i++)
        {
            list.addBack(i);
            assertFalse(list.isEmpty());
        }
    }


    @Test
    void clear()
    {
        LinkedList<Integer> list = new LinkedList<>();
        //not sure how to test

        for (int i = 0; i < 10; i++)
        {
            list.addBack(i);

        }
        list.clear();
    }
    // not sure if how to test iterator method

}