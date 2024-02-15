import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// unit test for:
// collection is empty (has size 0)
// nearly empty (has size of 1)
// and not empty

class ArrayListTest
{

    @org.junit.jupiter.api.Test
    void addFront()
    {
        ArrayList arrayList = new ArrayList<>();
        arrayList.addFront(0);
        assertEquals("{ 0 null null null null null null null null null }", arrayList.toString());
        arrayList.addFront(1);
        assertEquals("{ 1 0 null null null null null null null null }", arrayList.toString());
        arrayList.addFront(2);
        assertEquals("{ 2 1 0 null null null null null null null }", arrayList.toString());
        arrayList.addFront(3);
        assertEquals("{ 3 2 1 0 null null null null null null }", arrayList.toString());
    }

    @Test
    void addBack()
    {
        ArrayList arrayList = new ArrayList<>();
        arrayList.addBack(0);
        assertEquals("{ 0 null null null null null null null null null }", arrayList.toString());
        arrayList.addBack(1);
        assertEquals("{ 0 1 null null null null null null null null }", arrayList.toString());
        arrayList.addBack(2);
        assertEquals("{ 0 1 2 null null null null null null null }", arrayList.toString());
        arrayList.addBack(3);
        assertEquals("{ 0 1 2 3 null null null null null null }", arrayList.toString());
    }

    @org.junit.jupiter.api.Test
    void add()
    {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(0,0);
        assertEquals("{ 0 null null null null null null null null null }", arrayList.toString());
        arrayList.add(1,1);
        assertEquals("{ 0 1 null null null null null null null null }", arrayList.toString());
        arrayList.add(2,2);
        assertEquals("{ 0 1 2 null null null null null null null }", arrayList.toString());
        arrayList.add(3,3);
        assertEquals("{ 0 1 2 3 null null null null null null }", arrayList.toString());
        arrayList.add(4,4);
        assertEquals("{ 0 1 2 3 4 null null null null null }", arrayList.toString());
        arrayList.add(3,-99);
        assertEquals("{ 0 1 2 -99 3 4 null null null null }", arrayList.toString());
        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(12,99));
        assertEquals("Index out of bounds!", exception1.getMessage());
        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(-12,99));
        assertEquals("Index out of bounds!", exception2.getMessage());
    }

    @org.junit.jupiter.api.Test
    void get()
    {
        ArrayList arrayList = new ArrayList<>();

        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(99));
        assertEquals("Index out of bounds!", exception1.getMessage());

        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-99));
        assertEquals("Index out of bounds!", exception2.getMessage());

        arrayList.addBack(1);
        assertTrue((int) arrayList.get(0) == 1);

        int[] intArray = {2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        assertTrue((int) arrayList.get(6) == 7);
    }

    @org.junit.jupiter.api.Test
    void set()
    {
        ArrayList arrayList = new ArrayList<>();

        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(90,99));
        assertEquals("Index out of bounds!", exception1.getMessage());

        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(-90,99));
        assertEquals("Index out of bounds!", exception2.getMessage());

        int[] intArray = {0,1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        arrayList.set(4,99);
        assertEquals("{ 0 1 2 3 99 5 6 7 8 9 }", arrayList.toString());
    }

    @org.junit.jupiter.api.Test
    void removeFront()
    {
        ArrayList arrayList = new ArrayList<>();

        arrayList.removeFront();
        assertTrue(arrayList.removeFront() == null);

        int[] intArray = {0,1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        assertTrue((int) arrayList.removeFront() == 0);
    }

    @org.junit.jupiter.api.Test
    void removeBack()
    {
        ArrayList arrayList = new ArrayList<>();

        arrayList.removeBack();
        assertTrue(arrayList.removeBack() == null);

        int[] intArray = {0,1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        assertTrue((int) arrayList.removeBack() == 9);
    }

    @org.junit.jupiter.api.Test
    void remove()
    {
        ArrayList arrayList = new ArrayList<>();

        assertTrue(arrayList.remove(5) == null);

        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(11));
        assertEquals("Index out of bounds!", exception1.getMessage());

        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(-3));
        assertEquals("Index out of bounds!", exception2.getMessage());

        arrayList.addFront(0);

        assertTrue((int) arrayList.remove(0) == 0);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        assertTrue((int) arrayList.remove(0) == 1);
    }

    @org.junit.jupiter.api.Test
    void contains()
    {
        ArrayList arrayList = new ArrayList<>();
        assertTrue(arrayList.contains(4) == false);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        assertTrue(arrayList.contains(4) == true);
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        ArrayList arrayList = new ArrayList<>();
        assertTrue(arrayList.isEmpty() == true);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        assertTrue(arrayList.isEmpty() == false);
    }

    @org.junit.jupiter.api.Test
    void size()
    {
        ArrayList arrayList = new ArrayList<>();
        assertTrue(arrayList.size() == 0);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        assertTrue(arrayList.size() == 9);
    }

    @org.junit.jupiter.api.Test
    void iterator()
    {
        ArrayList arrayList = new ArrayList<>();

        assertTrue(arrayList.iterator().hasNext() == false);

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        assertTrue(arrayList.iterator().hasNext() == true);
    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
        ArrayList arrayList = new ArrayList<>();

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        for(int thisInt : intArray){
            arrayList.addBack(thisInt);
        }

        assertEquals("{ 1 2 3 4 5 6 7 8 9 null }", arrayList.toString());
    }
}