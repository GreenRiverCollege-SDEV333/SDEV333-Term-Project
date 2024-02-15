import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {


    @Test
    void addFront() {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }


    }

    @Test
    void addBack() {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            array.addBack(i);
            assertEquals(array.get(array.size()-1), i);
        }

    }

    @Test
    void add() {
        ArrayList<Integer> array = new ArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> array.add(0, 8));

        for (int i = 1; i < 20; i++) {
            array.add(i, i+1);
            assertEquals(array.get(i), i+1);
        }

    }

    @Test
    void removeFront() {
        ArrayList<Integer> array = new ArrayList<>();

        array.removeFront();
        assertEquals(array.size(), 0);

        array.addFront(6);
        array.removeFront();
        assertEquals(array.size(), 0);

        array.addFront(0);
        array.addFront(9);
        array.removeFront();
        assertEquals(array.size(), 1);

        array.addFront(0);
        array.addFront(9);
        array.removeFront();
        assertEquals(array.size(), 2);

    }

    @Test
    void removeBack() {
        ArrayList<Integer> array = new ArrayList<>();

        array.removeBack();
        assertEquals(array.size(), 0);

        array.addFront(6);
        array.removeBack();
        assertEquals(array.size(), 0);

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(array.size(), 1);

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(array.size(), 2);

    }

    @Test
    void removeItem() {
        ArrayList<String> array = new ArrayList<>();

        array.addFront("test1");
        array.remove("test1");
        assertEquals(array.size(), 0);

        array.addFront("test2");
        array.addFront("test3");
        array.remove("test3");
        assertEquals(array.size(), 1);

        array.addFront("test4");
        array.addFront("test5");
        array.remove("test4");
        assertEquals(array.size(), 2);
    }


    @Test
    void removeIndex() {
        ArrayList<String> array = new ArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(0));

        array.addFront("test1");
        array.remove(0);
        assertEquals(array.size(), 0);

        array.addFront("test2");
        array.addFront("test3");
        array.remove(1);
        assertEquals(array.size(), 1);

        array.addFront("test4");
        array.addFront("test5");
        array.remove(2);
        assertEquals(array.size(), 2);
    }


    @Test
    void get() {
        ArrayList<Integer> array = new ArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));

        for (int i = 0; i < 20; i++) {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }
    }

    @Test
    void set() {
        ArrayList<Integer> array = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> array.set(0, 3));
        array.addFront(1);

        for (int i = 1; i < 10; i++) {
            array.addFront(i);
        }

        array.set(4, 7);
        assertEquals(7, array.get(4));


    }

    @Test
    void contains() {
        ArrayList<Integer> array = new ArrayList<>();


        assertFalse(array.contains(4));

        array.addFront(3);
        assertTrue(array.contains(3));
        assertFalse(array.contains(9));


        array.addFront(8);
        assertTrue(array.contains(3));
        assertFalse(array.contains(0));

        for (int i = 0; i < 4; i++) {
            array.addFront(i);
        }
        assertTrue(array.contains(2));
        assertFalse(array.contains(100));
    }

    @Test
    void isEmpty() {
        ArrayList<Integer> array = new ArrayList<>();

        assertTrue(array.isEmpty());

        for (int i = 0; i < 20; i++) {
            array.addBack(i);
            assertFalse(array.isEmpty());
        }
    }

    @Test
    void size() {
        ArrayList<Integer> array = new ArrayList<>();

        assertEquals(array.size(), 0);

        for (int i = 1; i < 20; i++) {
            array.addBack(i);
            assertEquals(array.size(), i);
        }
    }


}
