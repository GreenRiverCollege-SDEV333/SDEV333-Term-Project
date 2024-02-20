import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class LinkedListTest {
    @Test
    void addFront() {

        LinkedList<Integer> linked = new LinkedList<>();
        linked.addFront(5);

        int expected = 5;
        int actual = linked.get(0);
        Assertions.assertEquals(expected, actual);

        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.addFront("test1");
        oneElement.addFront("test2");

        String expectedOneElement = "test2";
        String actualOneElement = oneElement.get(0);
        Assertions.assertEquals(expectedOneElement, actualOneElement);

        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.addFront(6.6);
        tenElement.addFront(4.6);
        tenElement.addFront(3.6);
        tenElement.addFront(39.8);
        tenElement.addFront(45.7);
        tenElement.addFront(3.0);
        tenElement.addFront(4.7);
        tenElement.addFront(12.12);
        tenElement.addFront(43.1);
        tenElement.addFront(1.1);

        Double tenElementsExpected = 1.1;
        Double tenElementsActual = tenElement.get(0);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);


    }

    @Test
    void addBack() {

        LinkedList<Integer> linked = new LinkedList<>();
        linked.addBack(5);

        int expected = 5;
        int actual = linked.get(0);
        Assertions.assertEquals(expected, actual);

        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.addBack("test1");
        oneElement.addBack("test2");

        String expectedOneElement = "test2";
        String actualOneElement = oneElement.get(1);
        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.addFront(6.6);
        tenElement.addFront(4.6);
        tenElement.addFront(3.6);
        tenElement.addFront(39.8);
        tenElement.addFront(45.7);
        tenElement.addFront(3.0);
        tenElement.addFront(4.7);
        tenElement.addFront(12.12);
        tenElement.addFront(43.1);
        tenElement.addFront(1.1);

        Double tenElementsExpected = 6.6;
        Double tenElementsActual = tenElement.get(9);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);
    }

    @Test
    void add() {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.add(0, 5);

        int expected = 5;
        int actual = linked.get(0);
        Assertions.assertEquals(expected, actual);

        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0, "test1");
        oneElement.add(1, "test2");

        String expectedOneElement = "test2";
        String actualOneElement = oneElement.get(1);
        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0, 1.1);
        tenElement.add(1, 1.2);
        tenElement.add(2, 1.3);
        tenElement.add(3, 1.4);
        tenElement.add(4, 1.5);
        tenElement.add(5, 1.6);
        tenElement.add(6, 1.7);
        tenElement.add(7, 1.8);
        tenElement.add(8, 1.9);
        tenElement.add(9, 2.0);


        Double tenElementsExpected = 1.5;
        Double tenElementsActual = tenElement.get(4);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);
    }

    @Test
    void get() {

        LinkedList<Integer> linked = new LinkedList<>();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Integer actual = linked.get(0);
            Assertions.assertNull(actual);
        });


        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0, "test1");
        oneElement.add(1, "test2");
        oneElement.get(0);

        String expectedOneElement = "test1";
        String actualOneElement = oneElement.get(0);
        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0, 1.1);
        tenElement.add(1, 1.2);
        tenElement.add(2, 1.3);
        tenElement.add(3, 1.4);
        tenElement.add(4, 1.5);
        tenElement.add(5, 1.6);
        tenElement.add(6, 1.7);
        tenElement.add(7, 1.8);
        tenElement.add(8, 1.9);
        tenElement.add(9, 2.0);


        Double tenElementsExpected = 1.5;
        Double tenElementsActual = tenElement.get(4);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);
    }

    @Test
    void set() {


        LinkedList<Integer> linked = new LinkedList<>();
        linked.set(0,5);

        int expected = 5;
        int actual = linked.get(0);
        Assertions.assertEquals(expected, actual);

        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0,"test1");
        oneElement.set(1,"test2");

        String expectedOneElement = "test1";
        String actualOneElement = oneElement.get(0);
        Assertions.assertEquals(expectedOneElement, actualOneElement);

        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.addFront(6.6);
        tenElement.addFront(4.6);
        tenElement.addFront(3.6);
        tenElement.addFront(39.8);
        tenElement.addFront(45.7);
        tenElement.addFront(3.0);
        tenElement.addFront(4.7);
        tenElement.addFront(12.12);
        tenElement.addFront(43.1);
        tenElement.addFront(1.1);
        tenElement.set(3,99.9);

        Double tenElementsExpected = 99.9;
        Double tenElementsActual = tenElement.get(3);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);

    }

    @Test
    void removeFront() {

        LinkedList<Integer> linked = new LinkedList<>();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Integer actual = linked.removeFront();
            Assertions.assertNull(actual);
        });


        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0, "test1");

        String expectedOneElement = "test1";
        String actualOneElement = oneElement.get(0);
        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0, 1.1);
        tenElement.add(1, 1.2);
        tenElement.add(2, 1.3);
        tenElement.add(3, 1.4);
        tenElement.add(4, 1.5);
        tenElement.add(5, 1.6);
        tenElement.add(6, 1.7);
        tenElement.add(7, 1.8);
        tenElement.add(8, 1.9);
        tenElement.add(9, 2.0);
        tenElement.removeFront();


        Double tenElementsExpected = 1.2;
        Double tenElementsActual = tenElement.get(0);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);
    }

    @Test
    void removeBack() {

        LinkedList<Integer> linked = new LinkedList<>();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Integer actual = linked.removeBack();
            Assertions.assertNull(actual);
        });


        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0, "test1");
        oneElement.add(1, "test2");
        oneElement.removeBack();

        String expectedOneElement = "test1";
        String actualOneElement = oneElement.get(0);
        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0, 1.1);
        tenElement.add(1, 1.2);
        tenElement.add(2, 1.3);
        tenElement.add(3, 1.4);
        tenElement.add(4, 1.5);
        tenElement.add(5, 1.6);
        tenElement.add(6, 1.7);
        tenElement.add(7, 1.8);
        tenElement.add(8, 1.9);
        tenElement.add(9, 2.0);
        tenElement.removeBack();


        Double tenElementsExpected = 1.9;
        Double tenElementsActual = tenElement.get(8);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);
    }

    @Test
    void remove() {
        LinkedList<Integer> linked = new LinkedList<>();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Integer actual = linked.remove(0);
            Assertions.assertNull(actual);
        });


        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0, "test1");
        oneElement.add(1, "test2");


        String expectedOneElement = "test1";
        String actualOneElement = oneElement.remove(0);
        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0, 1.1);
        tenElement.add(1, 1.2);
        tenElement.add(2, 1.3);
        tenElement.add(3, 1.4);
        tenElement.add(4, 1.5);
        tenElement.add(5, 1.6);
        tenElement.add(6, 1.7);
        tenElement.add(7, 1.8);
        tenElement.add(8, 1.9);
        tenElement.add(9, 2.0);


        Double tenElementsExpected = 1.4;
        Double tenElementsActual = tenElement.remove(3);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);
    }

    @Test
    void testRemove() {
        LinkedList<Integer> linked = new LinkedList<>();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Integer actual = linked.remove(9);
            Assertions.assertNull(actual);
        });


        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0, "test1");
        oneElement.add(1, "test2");
        oneElement.remove("test1");

        String expectedOneElement = "test1";
        String actualOneElement = oneElement.get(0);
        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0, 1.1);
        tenElement.add(1, 1.2);
        tenElement.add(2, 1.3);
        tenElement.add(3, 1.4);
        tenElement.add(4, 1.5);
        tenElement.add(5, 1.6);
        tenElement.add(6, 1.7);
        tenElement.add(7, 1.8);
        tenElement.add(8, 1.9);
        tenElement.add(9, 2.0);
        tenElement.remove(1.5);


        Double tenElementsExpected = 1.6;
        Double tenElementsActual = tenElement.get(4);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);
    }

    @Test
    void contains() {
        LinkedList<Integer> linked = new LinkedList<>();


        boolean expected = false;
        boolean actual = linked.contains(5);
        Assertions.assertEquals(expected, actual);


        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0, "test1");
        oneElement.add(1, "test2");


        boolean expectedOneElement = false;
        boolean actualOneElement = oneElement.contains("other");

        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0, 1.1);
        tenElement.add(1, 1.2);
        tenElement.add(2, 1.3);
        tenElement.add(3, 1.4);
        tenElement.add(4, 1.5);
        tenElement.add(5, 1.6);
        tenElement.add(6, 1.7);
        tenElement.add(7, 1.8);
        tenElement.add(8, 1.9);
        tenElement.add(9, 2.0);


        boolean tenElementsExpected = true;
        boolean tenElementsActual = tenElement.contains(1.7);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);

    }

    @Test
    void isEmpty() {
        LinkedList<Integer> linked = new LinkedList<>();


        boolean expected = false;
        boolean actual = linked.contains(5);
        Assertions.assertEquals(expected, actual);


        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0, "test1");


        boolean expectedOneElement = false;
        boolean actualOneElement = oneElement.contains("other");

        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0, 1.1);
        tenElement.add(1, 1.2);
        tenElement.add(2, 1.3);
        tenElement.add(3, 1.4);
        tenElement.add(4, 1.5);
        tenElement.add(5, 1.6);
        tenElement.add(6, 1.7);
        tenElement.add(7, 1.8);
        tenElement.add(8, 1.9);
        tenElement.add(9, 2.0);


        boolean tenElementsExpected = true;
        boolean tenElementsActual = tenElement.contains(1.7);

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);
    }

    @Test
    void size() {
        LinkedList<Integer> linked = new LinkedList<>();

        int expected = 0;
        int actual = linked.size();
        Assertions.assertEquals(expected, actual);


        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0, "test1");


        int expectedOneElement = 1;
        int  actualOneElement = oneElement.size();

        Assertions.assertEquals(expectedOneElement, actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0, 1.1);
        tenElement.add(1, 1.2);
        tenElement.add(2, 1.3);
        tenElement.add(3, 1.4);
        tenElement.add(4, 1.5);
        tenElement.add(5, 1.6);
        tenElement.add(6, 1.7);
        tenElement.add(7, 1.8);
        tenElement.add(8, 1.9);
        tenElement.add(9, 2.0);


        int tenElementsExpected = 10;
        int tenElementsActual = tenElement.size();

        Assertions.assertEquals(tenElementsExpected, tenElementsActual);
    }
}