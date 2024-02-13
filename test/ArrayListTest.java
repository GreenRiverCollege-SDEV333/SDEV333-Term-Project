import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void autoResize() {
        ArrayList<String> t = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            t.addBack(String.format("test%d", i));
        }

        // should be 110ish?
        assertTrue(t.getArraySize() > 100);

//        var iter = t.iterator();
//        while (iter.hasNext()) {
//            t.removeBack();
//        }

        for (var i: t)
            t.removeFront();

        var arraySize = t.getArraySize();
        var actual = t.size();


        System.out.println(arraySize + " " + actual);
        // the array should have shrunk
        assertTrue(t.getArraySize() < 100);
    }

    @Test
    void add() {
        ArrayList<String> t = new ArrayList<>();

        assertTrue(t.isEmpty());

        // test add back functionality
        t.add(0 , "test");
        assertEquals(t.size(),1);
        assertEquals(t.get(0), "test");

        // test add front functionality
        t.add(0, "test2");
        assertEquals(t.size(), 2);
        assertEquals(t.get(0), "test2");

        // test add center functionality
        t.add(1, "test3");
        assertEquals(t.size(), 3);
        assertEquals(t.get(1), "test3");
    }
    
    @Test
    void addFront() {
        ArrayList<String> t = new ArrayList<>();

        t.addFront("test");
        assertEquals(t.size(), 1);

        t.addFront("test2");
        assertEquals(t.size(), 2);
        assertEquals(t.get(0), "test2");
                
    }

    @Test
    void addBack() {
        ArrayList<String> t = new ArrayList<>();
        t.addBack("test");
        t.addBack("test2");
        t.addBack("test3");

        assertEquals(t.get(0), "test");
        assertEquals(t.get(2), "test3");

    }
    
    @Test
    void get() {
        ArrayList<String> t = new ArrayList<>();
        
        t.addBack("1");
        t.addBack("2");
        t.addBack("3");
        t.addBack("4");
        
        // inside array
        assertEquals("3", t.get(2));
        
        // case: beginning of array
        assertEquals("1", t.get(0));
        
        // case: end of array
        assertEquals("4", t.get(3));
        
    }

    @Test
    void set() {
        ArrayList<String> t = new ArrayList<>();
        
        t.addBack("test");
        t.addBack("test");
        t.addBack("test");
        t.addBack("test");

        // case: inner array
        t.set(1, "set");
        assertEquals("set", t.get(1));

        // case: beginning of array
        t.set(0, "set2");
        assertEquals("set2", t.get(0));

        // case: end of array
        t.set(3, "set3");
        assertEquals("set3", t.get(3));
    }

    @Test
    void removeFront() {
        ArrayList<String> t = new ArrayList<>();

        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");


        var retval = t.removeFront();
        assertEquals(retval, "test1");

        retval = t.removeFront();
        assertEquals(retval, "test2");
    }

    @Test
    void removeBack() {
        ArrayList<String> t = new ArrayList<>();

        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");

        var retval = t.removeBack();
        assertEquals(retval, "test4");

        retval = t.removeBack();
        assertEquals(retval, "test3");
    }

    @Test
    void removeByIndex() {
        ArrayList<String> t = new ArrayList<>();

        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");

        // test remove inner index
        var retval = t.remove(1);
        assertEquals(retval, "test2");

        // test remove final index
        retval = t.remove(t.size()-1);
        assertEquals(retval, "test4");

        // test remove beginning index
        retval = t.remove(0);
        assertEquals(retval, "test1");
    }

    @Test
    void removeByElement() {
        ArrayList<String> t = new ArrayList<>();

        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");

        // test removing element that does not exist
        t.remove("test5");
        assertEquals(t.size(), 4);

        // test removing element that exists
        t.remove("test2");
        assertEquals(t.size(), 3);

    }

    @Test
    void contains() {
        ArrayList<String> t = new ArrayList<>();
        
        t.addBack("");
        t.addBack("test");
        t.addBack("toast");
        
        assertTrue(t.contains("test"));
        
        assertFalse(t.contains("test2"));
        
    }

    @Test
    void isEmpty() {
        ArrayList<String> t = new ArrayList<>();
        
        assertTrue(t.isEmpty());
        
        t.addBack("");
        assertFalse(t.isEmpty());
        
        t.removeBack();
        assertTrue(t.isEmpty());
        
    }

    @Test
    void size() {
        ArrayList<String> t = new ArrayList<>();
        
        assertTrue(t.isEmpty());
        
        t.addBack("test");
        assertTrue(t.size() == 1);
        
        t.removeBack();
        assertTrue(t.isEmpty());
        
    }

    @Test
    void iterator() {
        ArrayList<String> t = new ArrayList<>();
        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");

        for (var i : t) {
            assertTrue(t.contains(i));
        }
    }
    
}