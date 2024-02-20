import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
        ArrayList list = new ArrayList();
        list.addFront(0);
        assertEquals(0,list.get(0));
        list.add(0,1);
        list.addFront(-1);
        assertEquals(-1,list.get(0));
        list.addFront(1);
        list.addFront(2);
        list.addFront(3);
        list.addFront(4);
        list.addFront(5);
        list.addFront(6);
        list.addFront(7);
        list.addFront(8);
        list.addFront(9);
        assertEquals(9,list.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        ArrayList list = new ArrayList();
        list.add(0,1);
        list.addFront(0);
        list.addFront(-1);
        list.addBack(2);
        assertEquals(2,list.get(list.size()-1));
        list.addBack(3);
        list.addBack(4);
        list.addBack(5);
        list.addBack(6);
        list.addBack(7);
        list.addBack(8);
        list.addBack(9);
        list.addBack(10);
        assertEquals(10,list.get(list.size()-1));
    }

    @org.junit.jupiter.api.Test
    void add() {
        ArrayList list = new ArrayList();
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.add(3,3);
        list.add(4,4);
        list.add(5,5);
        list.add(6,6);
        list.add(7,7);
        list.add(8,8);
        list.add(9,9);
        list.add(10,10);
        list.add(11,11);//resizes

        // list.add(-1,0);  //this should throw IndexOutOfBoundsException with note on "Index cannot be negative")
        assertEquals(0,list.get(0));
        assertEquals(10,list.get(10));
        assertEquals(11,list.get(11));
    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayList list = new ArrayList();
        //list.get(0);  //array is empty  throws IndexOutOfBoundsException: Index is higher than size
        list.add(0,0);
        assertEquals(0, list.get(0));
        list.add(1,1);
        list.add(2,2);
        list.add(3,3);
        list.add(4,4);
        list.add(5,5);
        list.add(6,6);
        list.add(7,7);
        list.add(8,8);
        list.add(9,9);
        list.add(10,10);
        list.add(11,11);
        assertEquals(1,list.get(1));
        assertEquals(11,list.get(11));
        //list.get(-1); //throws IndexOutOfBoundsException: Index cannot be negative
    }

    @org.junit.jupiter.api.Test
    void set() {
        ArrayList list = new ArrayList();
        list.add(0,0);
        assertEquals(0, list.get(0));
        list.set(0,1);
        assertEquals(1, list.get(0));
        list.add(1,1);
        list.add(2,2);
        list.add(3,3);
        list.add(4,4);
        list.add(5,5);
        list.add(6,6);
        list.add(7,7);
        list.add(8,8);
        list.add(9,9);
        list.add(10,10);
        list.add(11,11);
        list.set(11,100);
        assertEquals(100, list.get(11));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        ArrayList list = new ArrayList();
        // list.removeFront();   //array is empty, should throw IndexOutOfBoundsException("Array is empty, nothing to remove");
        list.add(0,0);
        list.removeFront();
        //test the removal of front from array with only 1 value, deletion makes array empty
        assertEquals(0,list.size());
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.removeFront();
        assertEquals(2,list.get(list.size()-1));
        assertEquals(1,list.get(0));
        list.add(2,3);
        list.add(3,4);
        list.add(4,5);
        list.removeFront();
        assertEquals(2,list.get(0));
        list.add(4,6);
        list.add(5,7);
        list.add(6,8);
        list.add(7,9);
        list.add(8,10);
        list.add(9,11);
        list.removeFront();
        assertEquals(3,list.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        ArrayList list = new ArrayList();
        //list.removeBack();   //array is empty, should throw IndexOutOfBoundsException("Array is empty, nothing to remove");
        list.add(0,0);
        list.removeBack();// remove only value in array, should have a size of 0 now.
        assertEquals(0,list.size());
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.removeBack();
        assertEquals(2, list.get(list.size()-1));
        assertEquals(2, list.removeBack());
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void size() {
        ArrayList list = new ArrayList();
        assertEquals(0, list.size());
        list.add(0,10);
        assertEquals(1,list.size());
        list.add(2,10);
        assertEquals(2,list.size());
        //list.removeFront();
        //assertEquals(1,list.size());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }
}