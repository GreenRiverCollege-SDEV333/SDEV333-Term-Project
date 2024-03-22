import org.junit.jupiter.api.Test;
import java.util.Iterator;


import static org.junit.jupiter.api.Assertions.*;

// test class for ArrayList
public class test {
    @Test
    public void testAddBackGetArray() {
        // to check adding elements to back and getting them
        ArrayList<Integer> list = new ArrayList<>();//instance
        list.addBack(1);// adding 1 to list
        list.addBack(2);//
        list.addBack(3);
        assertEquals(3, list.size());//
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

    }

    //test case to check adding elemets to the front and removing them
    @Test
    public void testAddFrontRemoveArray() {
        ArrayList<String> list = new ArrayList<>();
        list.addFront("pink");
        list.addFront("red");

        assertEquals(2, list.size());// lis should be 2
        assertEquals("red", list.removeFront());
        assertEquals(1, list.size());
        assertEquals("pink", list.get(0));
    }

    // check removing an elements by index
    @Test
    public void TestRemoveByIndexArray() {
        ArrayList<Character> list = new ArrayList<>();
        //add to list
        list.addBack('a');
        list.addBack('b');
        list.addBack('c');

        assertEquals('b', list.remove(1));// At index 1 it is "b"
        assertEquals(2, list.size());
        assertFalse(list.contains('b'));

    }

    //check if the list is empty
    @Test
    public void testISEmptyArray() {
        ArrayList<Double> list = new ArrayList<>();
        assertTrue(list.isEmpty());
        list.addBack(3.14);// addd to list
        assertFalse(list.isEmpty());
        list.removeBack();
        assertTrue(list.isEmpty());
    }


    @Test
    public void testIteratorArray() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());

    }





    //LinkedList

    // test for adding an item to front of empty list
        @Test
        public void testAddFrontEmptyLinkedList() {
            LinkedListt<Integer> list = new LinkedListt<>();// empty linked list
            list.addFront(1);// add front
            assertEquals(1, list.size());
            assertEquals(Integer.valueOf(1), list.get(0));
        }

//adding to the back of list
        @Test
        public void testAddBackGetLinkedList() {
            LinkedListt<Integer> list = new LinkedListt<>();
            list.addBack(1);// add back
            list.addBack(2);
            list.addBack(3);
            assertEquals(3, list.size());//updated
            assertEquals(Integer.valueOf(1), list.get(0));// check if done correctly
            assertEquals(Integer.valueOf(2), list.get(1));
            assertEquals(Integer.valueOf(3), list.get(2));

        }

        //test for adding an item to front and then remove
        @Test
    public void testAddFrontRemoveLinkedList(){
        LinkedListt<String>list= new LinkedListt<>();
        list.addFront("apple");// add front
        list.addFront("mango");
        assertEquals(2, list.size());// check
        assertEquals("mango",list.removeFront());// remove first
        assertEquals(1,list.size());// updated?
        assertEquals("apple",list.get(0));
        }

        //remove by index
        @Test
    public void testRemovedByIndexLinkedList(){
        LinkedListt<Character>list=new LinkedListt<>();//
        list.addBack('a');//add back
        list.addBack('b');
        list.addBack('c');
        assertEquals(Character.valueOf('b'), list.remove(1));// remove by index
        assertEquals(2, list.size());
        assertFalse(list.contains('b'));
        }
        //to check if linked list empty
        @Test
    public void testIsEmptyLinkedList(){
        LinkedListt<Double>list=new LinkedListt<>();
        assertTrue(list.isEmpty());
        list.addBack(3.14);
        }
        @Test
    public void testIteratorLinkedList(){
        LinkedListt<Integer>list=new LinkedListt<>();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        Iterator<Integer>iterator=list.iterator();// iterator for list
        assertTrue(iterator.hasNext());// check for next
        assertEquals(Integer.valueOf(1),iterator.next());// if correct
            assertTrue(iterator.hasNext());// check for next
            assertEquals(Integer.valueOf(2),iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(Integer.valueOf(3),iterator.next());
            assertFalse(iterator.hasNext());
        }
    }
