import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

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
        
        t.set(1, "set");
        
        assertEquals("set", t.get(1));
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
        assertEquals(retval, "test1");
    }

    @Test
    void removeBack() {
        ArrayList<String> t = new ArrayList<>();

        t.addBack("test1");
        t.addBack("test2");
        t.addBack("test3");
        t.addBack("test4");


    }

    @Test
    void remove() {
        ArrayList<String> t = new ArrayList<>();

        //

    }

    @Test
    void testRemove() {
        ArrayList<String> t = new ArrayList<>();
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
    
}