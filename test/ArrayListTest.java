import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest<E> {

    ArrayList<E> testCase = new ArrayList<>();

    @org.junit.jupiter.api.Test
    void addFront() {

        Integer one = 1;
        Double two = 2.3;
        String three = "three";
        assertEquals(0, testCase.size());
        testCase.addFront((E) one);
        assertEquals(1, testCase.get(0));
        testCase.addFront((E) two);
        assertEquals(2.3, testCase.get(0));
        testCase.addFront((E) three);
        assertEquals("three", testCase.get(0));
        assertEquals(3, testCase.size());
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        Integer a = 10;
        Double b = 2.31;
        String c = "hello";
        assertEquals(0, testCase.size());
        //( )
        testCase.addBack((E) a);
        assertEquals(10, testCase.get(0));
        //(10)
        testCase.addBack((E) b);
        assertEquals(2.31, testCase.get(1));
        //(10, 2.31)
        testCase.addBack((E) c);
        //(10, 2.31, hello)
        assertEquals("hello", testCase.get(2));
    }

    @org.junit.jupiter.api.Test
    void add() {
        Integer a = 100;
        Double b = 10.31;
        String c = "SDEV";

        assertEquals(0, testCase.size());
        testCase.add(0, (E) a);
        testCase.add(1, (E) a);
        testCase.add(2, (E) b);
        testCase.add(3, (E) c);
        testCase.add(2, (E) c);
        testCase.add(1, (E) c);
        // (100, SDEV , 100, SDEV ,10.31, SDEV)
        assertEquals(100, testCase.get(0));
        assertEquals("SDEV", testCase.get(1));
        assertEquals(100, testCase.get(2));
        assertEquals("SDEV", testCase.get(3));
        assertEquals("SDEV", testCase.get(5));
        assertEquals(10.31, testCase.get(4));
    }

    @org.junit.jupiter.api.Test
    void get() {
        Integer a = 10;
        Double b = 2.31;
        String c = "hello";

        assertEquals(0, testCase.size());
        testCase.add(0, (E) a);
        testCase.add(1, (E) b);
        testCase.add(2, (E) c);
        //(10, 2.31, hello)
        assertEquals(10, testCase.get(0));
        assertEquals(2.31, testCase.get(1));
        assertEquals("hello", testCase.get(2));
    }

    @org.junit.jupiter.api.Test
    void set() {
        Integer a = 100;
        Double b = 10.31;
        String c = "SDEV";

        testCase.add(0, (E) a);
        testCase.add(1, (E) a);
        //(100, 100)
        assertEquals(100, testCase.get(0));
        assertEquals(100, testCase.get(1));
        testCase.set(0, (E) b);
        testCase.set(1, (E) b);
        //(10.31, 10.31)
        assertEquals(10.31, testCase.get(0));
        assertEquals(10.31, testCase.get(1));
        testCase.set(0, (E) a);
        testCase.set(1, (E) c);
        //(100, SDEV)
        assertEquals(100, testCase.get(0));
        assertEquals("SDEV", testCase.get(1));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        Integer a = 100;
        Double b = 10.31;
        String c = "SDEV";

        assertEquals(0, testCase.size());
        testCase.add(0, (E) a);
        testCase.add(1, (E) a);
        testCase.add(2, (E) b);
        testCase.add(3, (E) c);
        testCase.add(2, (E) c);
        testCase.add(1, (E) c);
        // (100, SDEV , 100, SDEV ,10.31, SDEV)
        testCase.removeFront();
        testCase.removeFront();
        // ( 100, SDEV ,10.31, SDEV)
        assertEquals(100, testCase.get(0));
        assertEquals("SDEV", testCase.get(1));
        assertEquals(10.31, testCase.get(2));
        assertEquals("SDEV", testCase.get(3));
        testCase.removeFront();
        testCase.removeFront();
        // (10.31, SDEV)
        assertEquals(10.31, testCase.get(0));
        assertEquals("SDEV", testCase.get(1));

    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        Integer a = 100;
        Double b = 10.31;
        String c = "SDEV";
        assertEquals(0, testCase.size());
        testCase.add(0, (E) a);
        testCase.add(1, (E) a);
        testCase.add(2, (E) b);
        testCase.add(3, (E) c);
        testCase.add(2, (E) c);
        testCase.add(1, (E) c);
        // (100, SDEV , 100, SDEV ,10.31, SDEV)
        testCase.removeBack();
        assertEquals(6, testCase.size());
        testCase.removeBack();
        testCase.removeBack();
        testCase.removeBack();
        // (100, SDEV , 100)
        assertEquals(3, testCase.size());
        assertEquals(100, testCase.get(0));
        testCase.removeBack();
        testCase.removeBack();
        testCase.removeBack();
        //list is empty
        assertEquals(null, testCase.get(0));

    }

    @org.junit.jupiter.api.Test
    void remove() {
        Integer a = 100;
        Double b = 10.31;
        String c = "SDEV";
        testCase.addBack((E) a);
        testCase.addBack((E) b);
        testCase.addBack((E) c);
        // (100, 10.31, SDEV)
        testCase.remove((E) a);
        // (10.31, SDEV)
        assertFalse(testCase.contains((E) a));
        assertEquals(2, testCase.size());
    }


    @org.junit.jupiter.api.Test
    void testRemove() {
        Integer a = 100;
        Double b = 10.31;
        String c = "SDEV";
        testCase.addBack((E) a);
        testCase.addBack((E) b);
        testCase.addBack((E) c);
        // (100, 10.31, SDEV)
        testCase.remove(1);//remove 10.31
        // (100, SDEV)
        assertFalse(testCase.contains((E) b));
        assertEquals(2, testCase.size());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        Integer a = 100;
        Double b = 10.31;
        String c = "SDEV";
        testCase.addBack((E) a);
        testCase.addBack((E) b);
        testCase.addBack((E) c);
        testCase.remove((E) a);
        testCase.remove((E) c);
        testCase.remove((E) b);
        assertFalse(testCase.contains((E) a));
        assertFalse(testCase.contains((E) b));
        assertFalse(testCase.contains((E) c));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Integer a = 100;
        assertTrue(testCase.isEmpty());
        testCase.addFront((E) a);
        assertFalse(testCase.isEmpty());
        assertEquals(1, testCase.size());
        testCase.removeFront();
        assertTrue(testCase.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        Integer a = 100;
        assertEquals(0, testCase.size());
        testCase.addFront((E) a);
        testCase.addFront((E) a);
        testCase.addFront((E) a);
        assertEquals(3, testCase.size());
        testCase.addFront((E) a);
        testCase.addFront((E) a);
        testCase.addFront((E) a);
        assertEquals(6, testCase.size());

    }
}

