import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest<E> {
    private ArrayList<Integer> fullList = new ArrayList<>();
    private ArrayList<String> oneList = new ArrayList<>();
    private ArrayList<E> emptyList = new ArrayList<>();
    String A = "1";
    @BeforeEach
    void setUp(){
        oneList.addFront("A");
        for (int i = 10; i > 0; i--) {
            fullList.addFront(i-1);
        }
    }
    @Test
    void addFront() {
        emptyList.addFront((E)A);
        assertEquals((E)"1",emptyList.get(0));
        emptyList.addFront((E) "B");
        assertEquals((E) "1", emptyList.get(1));
        assertEquals((E)"B",emptyList.get(0));

        oneList.addFront("A");
        assertEquals("A",oneList.get(0));

        fullList.addFront(10);
        assertEquals(10, fullList.get(0));
        fullList.addFront(11);
        fullList.addFront(12);
        assertEquals(12,fullList.get(0));
        assertEquals(11,fullList.get(1));

    }

    @Test
    void addBack() {
        emptyList.addBack((E)A);
        assertEquals((E)"1",emptyList.get(0));
        emptyList.addBack((E) "B");
        assertEquals((E) "B", emptyList.get(1));
        assertEquals((E)"1",emptyList.get(0));

        oneList.addBack("A");
        assertEquals("A",oneList.get(1));

        fullList.addBack(10);
        assertEquals(10, fullList.get(10));
        fullList.addBack(11);
        fullList.addBack(12);
        assertEquals(12,fullList.get(12));
        assertEquals(11,fullList.get(11));
    }

    @Test
    void add() {
        emptyList.add(0,(E)A);
        assertEquals((E)"1",emptyList.get(0));
        emptyList.add(1, (E) "B");
        assertEquals((E) "B", emptyList.get(1));
        assertEquals((E)"1",emptyList.get(0));

        //oneList.add(2,("A"));
        //assertEquals("A",oneList.get(2));// index is higher than size
        oneList.add(1,"A");
        assertEquals("A",oneList.get(1));

        fullList.add(2,10);
        assertEquals(10, fullList.get(2));
        fullList.add(10,10);
        fullList.add(12,12);
        assertEquals(12,fullList.get(12));
        assertEquals(10,fullList.get(10));
    }

    @Test
    void get() {
    }

    @Test
    void set() {
        emptyList.addFront((E)A);
        assertEquals((E)"1",emptyList.get(0));
        emptyList.set(0,(E) "B");
        assertEquals((E)"B",emptyList.get(0));
        emptyList.addFront((E) "C");
        emptyList.set(0,(E)"A");
        assertEquals((E) "A", emptyList.get(0));

        oneList.set(0, "B");
        assertEquals("B",oneList.get(0));
        oneList.addFront("C");
        oneList.set(0, "A");
        assertEquals("A",oneList.get(0));
        oneList.set(1, "B");
        assertEquals( "B", oneList.get(1));

        fullList.set(0, 1);
        assertEquals(1,fullList.get(0));
    }

    @Test
    void removeFront() {
       // emptyList.removeFront();//throws "Array is empty, nothing to remove
        emptyList.addFront((E) "C");
        emptyList.addFront((E) "B");
        emptyList.removeFront();
        assertEquals((E)"C",emptyList.get(0));

        oneList.addFront( "C");
        oneList.addFront( "B");
        oneList.removeFront();
        assertEquals("C",oneList.get(0));

        fullList.removeFront();
        assertEquals(1, fullList.get(0));
        fullList.add(9,9);
        fullList.add(10,10);
        fullList.removeFront();
        assertEquals(2,fullList.get(0));
        assertEquals(10,fullList.get(9));
    }

    @Test
    void removeBack() {
        // emptyList.removeFront();//throws "Array is empty, nothing to remove
        emptyList.addFront((E) "C");
        emptyList.addFront((E) "B");
        emptyList.removeBack();
        assertEquals((E)"B",emptyList.get(0));

        oneList.addFront( "C");
        oneList.addFront( "B");
        oneList.removeBack();
        assertEquals("B",oneList.get(0));

        fullList.removeBack();
        assertEquals(9, fullList.size());
        fullList.add(9,9);
        fullList.add(10,10);
        fullList.removeBack();
        assertEquals(9,fullList.get(9));
        assertEquals(0,fullList.get(0));
    }

    @Test
    void remove() {
        // emptyList.remove();//throws "Array is empty, nothing to remove
        emptyList.addFront((E) "C");
        emptyList.addFront((E) "B");
        emptyList.remove((E)"B");
        assertEquals((E)"C",emptyList.get(0));

        oneList.remove("A");
        assertEquals(0,oneList.size());
        oneList.addFront( "C");
        oneList.addFront( "B");
        oneList.remove("B");
        assertEquals("C",oneList.get(0));

        fullList.remove(1);
        assertEquals(9, fullList.size());
        assertEquals(2,fullList.get(1));
        fullList.add(9,9);
        fullList.add(10,10);
        fullList.remove(9);
        assertEquals(10,fullList.get(9));
        assertEquals(0,fullList.get(0));

    }

    @Test
    void testRemove() {
        // emptyList.remove(0);//throws "Array is empty, nothing to remove
        emptyList.addFront((E) "C");
        emptyList.addFront((E) "B");
        emptyList.remove((E)"B");
        assertEquals((E)"C",emptyList.get(0));
        emptyList.addFront((E) "C");
        emptyList.addFront((E) "B");
        emptyList.remove(0);
        assertEquals((E)"C",emptyList.get(0));

        oneList.remove(0);
        assertEquals(0,oneList.size());
        oneList.addFront( "C");
        oneList.addFront( "B");
        oneList.remove(1);
        assertEquals(1,oneList.size());
        assertEquals("B",oneList.get(0));

        fullList.remove( 9);
        assertEquals(9, fullList.size());
        assertEquals(1,fullList.get(1));
       // assertEquals(9,fullList.get(9));//"Index is higher than size, node where 9 used to be
        fullList.add(9,9);
        fullList.add(10,10);
        fullList.remove(9);
        assertEquals(10,fullList.get(9));
        assertEquals(0,fullList.get(0));
    }

    @Test
    void contains() {
        assertFalse(emptyList.contains((E) "C"));
        emptyList.addFront((E) "B");
        assertEquals((E)"B",emptyList.get(0));
        assertTrue(emptyList.contains((E)"B"));
        emptyList.addFront((E) "C");
        emptyList.addFront((E) "D");
        emptyList.remove(0);
        assertFalse(emptyList.contains((E)"D"));
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }
}