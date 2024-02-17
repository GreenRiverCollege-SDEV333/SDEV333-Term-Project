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
        Assertions.assertEquals(expectedOneElement,actualOneElement);

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

        Assertions.assertEquals(tenElementsExpected,tenElementsActual);


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
        Assertions.assertEquals(expectedOneElement,actualOneElement);


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

        Assertions.assertEquals(tenElementsExpected,tenElementsActual);
    }

    @Test
    void add() {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.add(0,5);

        int expected = 5;
        int actual = linked.get(0);
        Assertions.assertEquals(expected, actual);

        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0,"test1");
        oneElement.add(1,"test2");

        String expectedOneElement = "test2";
        String actualOneElement = oneElement.get(1);
        Assertions.assertEquals(expectedOneElement,actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0,1.1);
        tenElement.add(1,1.2);
        tenElement.add(2,1.3);
        tenElement.add(3,1.4);
        tenElement.add(4,1.5);
        tenElement.add(5,1.6);
        tenElement.add(6,1.7);
        tenElement.add(7,1.8);
        tenElement.add(8,1.9);
        tenElement.add(9,2.0);


        Double tenElementsExpected = 1.5;
        Double tenElementsActual = tenElement.get(4);

        Assertions.assertEquals(tenElementsExpected,tenElementsActual);
    }

    @Test
    void get() {

        LinkedList<Integer> linked = new LinkedList<>();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Integer expected = null;
            Integer actual = linked.get(0);
            Assertions.assertEquals(expected, actual);
        });


        LinkedList<String> oneElement = new LinkedList<>();
        oneElement.add(0,"test1");
        oneElement.add(1,"test2");
        oneElement.get(0);

        String expectedOneElement = "test1";
        String actualOneElement = oneElement.get(0);
        Assertions.assertEquals(expectedOneElement,actualOneElement);


        LinkedList<Double> tenElement = new LinkedList<>();
        tenElement.add(0,1.1);
        tenElement.add(1,1.2);
        tenElement.add(2,1.3);
        tenElement.add(3,1.4);
        tenElement.add(4,1.5);
        tenElement.add(5,1.6);
        tenElement.add(6,1.7);
        tenElement.add(7,1.8);
        tenElement.add(8,1.9);
        tenElement.add(9,2.0);


        Double tenElementsExpected = 1.5;
        Double tenElementsActual = tenElement.get(4);

        Assertions.assertEquals(tenElementsExpected,tenElementsActual);
    }

    @Test
    void set() {
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeBack() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }

    @Test
    void iterator() {
    }
}