import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// unit test for:
// collection is empty (has size 0)
// nearly empty (has size of 1)
// and not empty

class LinkedListTest
{

    @org.junit.jupiter.api.Test
    void addFront()
    {
        LinkedList arrayList = new LinkedList<>();
        arrayList.addFront(0);
        assertEquals("{ 0 }", arrayList.toString());
        arrayList.addFront(1);
        assertEquals("{ 1 0 }", arrayList.toString());
        arrayList.addFront(2);
        assertEquals("{ 2 1 0 }", arrayList.toString());
        arrayList.addFront(3);
        assertEquals("{ 3 2 1 0 }", arrayList.toString());
    }

    @Test
    void addBack()
    {
        LinkedList arrayList = new LinkedList<>();
        arrayList.addBack(0);
        assertEquals("{ 0 }", arrayList.toString());
        arrayList.addBack(1);
        assertEquals("{ 0 1 }", arrayList.toString());
        arrayList.addBack(2);
        assertEquals("{ 0 1 2 }", arrayList.toString());
        arrayList.addBack(3);
        assertEquals("{ 0 1 2 3 }", arrayList.toString());
    }

    @org.junit.jupiter.api.Test
    void add()
    {
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(0,0);
        assertEquals("{ 0 }", linkedList.toString());
        linkedList.add(1,1);
        assertEquals("{ 0 1 }", linkedList.toString());
        linkedList.add(2,2);
        assertEquals("{ 0 1 2 }", linkedList.toString());
        linkedList.add(3,3);
        assertEquals("{ 0 1 2 3 }", linkedList.toString());
        linkedList.add(4,4);
        assertEquals("{ 0 1 2 3 4 }", linkedList.toString());
        linkedList.add(3,-99);
        assertEquals("{ 0 1 2 -99 3 4 }", linkedList.toString());
        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(12,99));
        assertEquals("Index out of bounds!", exception1.getMessage());
        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-12,99));
        assertEquals("Index out of bounds!", exception2.getMessage());
    }

    @org.junit.jupiter.api.Test
    void get()
    {
        LinkedList linkedList = new LinkedList<>();

        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(99));
        assertEquals("Index out of bounds!", exception1.getMessage());

        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-99));
        assertEquals("Index out of bounds!", exception2.getMessage());

        linkedList.addBack(1);
        assertTrue((int) linkedList.get(0) == 1);

        int[] intArray = {2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        assertTrue((int) linkedList.get(6) == 7);
    }

    @org.junit.jupiter.api.Test
    void set()
    {
        LinkedList linkedList = new LinkedList<>();

        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(90,99));
        assertEquals("Index out of bounds!", exception1.getMessage());

        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(-90,99));
        assertEquals("Index out of bounds!", exception2.getMessage());

        int[] intArray = {0,1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        linkedList.set(4,99);
        assertEquals("{ 0 1 2 3 99 5 6 7 8 9 }", linkedList.toString());
    }

    @org.junit.jupiter.api.Test
    void removeFront()
    {
        LinkedList linkedList = new LinkedList<>();

        linkedList.removeFront();
        assertTrue(linkedList.removeFront() == null);

        int[] intArray = {0,1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        assertTrue((int) linkedList.removeFront() == 0);
    }

    @org.junit.jupiter.api.Test
    void removeBack()
    {
        LinkedList linkedList = new LinkedList<>();

        int[] intArray = {0,1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        assertTrue((int) linkedList.removeBack() == 9);
    }

    @org.junit.jupiter.api.Test
    void remove()
    {
        LinkedList linkedList = new LinkedList<>();

        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(11));
        assertEquals("Index out of bounds!", exception1.getMessage());

        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-3));
        assertEquals("Index out of bounds!", exception2.getMessage());

        linkedList.addFront(0);

        assertTrue((int) linkedList.remove(0) == 0);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        assertTrue((int) linkedList.remove(0) == 1);
    }

    @org.junit.jupiter.api.Test
    void contains()
    {
        LinkedList linkedList = new LinkedList<>();
        assertTrue(linkedList.contains(4) == false);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        assertTrue(linkedList.contains(4) == true);
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        LinkedList linkedList = new LinkedList<>();
        assertTrue(linkedList.isEmpty() == true);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        assertTrue(linkedList.isEmpty() == false);
    }

    @org.junit.jupiter.api.Test
    void size()
    {
        LinkedList linkedList = new LinkedList<>();
        assertTrue(linkedList.size() == 0);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        assertTrue(linkedList.size() == 9);
    }

    @org.junit.jupiter.api.Test
    void iterator()
    {
        LinkedList linkedList = new LinkedList<>();

        assertTrue(linkedList.iterator().hasNext() == false);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        assertTrue(linkedList.iterator().hasNext() == true);
    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
        LinkedList linkedList = new LinkedList<>();

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            linkedList.addBack(thisInt);
        }

        assertEquals("{ 1 2 3 4 5 6 7 8 9 }", linkedList.toString());
    }
}