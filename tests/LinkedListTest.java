import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.addFront("Banana");
        assertEquals("Banana", list.get(0));
        assertEquals(1, list.size());
        list.addFront("Orange");
        assertEquals("Orange", list.get(0));
        assertEquals("Banana", list.get(1));
        assertEquals(2, list.size());
        list.addFront("Apple");
        list.addFront("Pear");
        list.addFront("Grapefruit");
        list.addFront("Grape");
        list.addFront("Lemon");
        list.addFront("Lime");
        list.addFront("Melon");
        assertEquals("Melon", list.get(0));
        assertEquals("Banana", list.get(list.size()-1));
        assertEquals(9, list.size());
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.addBack("Banana");
        assertEquals("Banana", list.get(list.size()-1));
        assertEquals(1, list.size());
        list.addBack("Orange");
        assertEquals("Orange", list.get(list.size()-1));
        assertEquals("Banana", list.get(0));
        assertEquals(2, list.size());
        list.addBack("Apple");
        list.addBack("Pear");
        list.addBack("Grapefruit");
        list.addBack("Grape");
        list.addBack("Lemon");
        list.addBack("Lime");
        list.addBack("Melon");
        assertEquals("Melon", list.get(list.size()-1));
        assertEquals("Banana", list.get(0));
        assertEquals(9, list.size());
    }

    @org.junit.jupiter.api.Test
    void add() {
        LinkedList<String> list = new LinkedList<>();
        list.add(0, "Banana");
        assertEquals(1, list.size());
        assertEquals("Banana", list.get(0));
        list.add(1, "Orange");
        assertEquals(2, list.size());
        assertEquals("Orange", list.get(1));
        list.add(0, "Pear");
        list.add(3, "Pineapple");
        list.add(4, "Kiwi");
        list.add(5, "Plum");
        list.add(6, "Peach");
        list.add(7, "Apple");
        list.add(8, "Grape");
        assertEquals(9, list.size());
        assertEquals("Pear", list.get(0));
        assertEquals("Banana", list.get(1));
        assertEquals("Orange", list.get(2));
        assertEquals("Plum", list.get(5));
        assertEquals("Peach", list.get(6));
        assertEquals("Apple", list.get(7));
        assertEquals("Grape", list.get(8));
    }

    @org.junit.jupiter.api.Test
    void get() {
        LinkedList<String> list = new LinkedList<>();
        list.addBack("Banana");
        assertEquals("Banana", list.get(0));
        list.addBack("Apple");
        list.addBack("Pear");
        list.addBack("Peach");
        list.addBack("Pineapple");
        list.addBack("Orange");
        assertEquals("Orange", list.get(list.size()-1));
        list.removeBack();
        assertEquals("Pineapple", list.get(list.size()-1));
        assertEquals("Apple", list.get(1));
        assertEquals("Pear", list.get(2));
    }

    @org.junit.jupiter.api.Test
    void set() {
        LinkedList<String> list = new LinkedList<>();
        list.addBack("Pear");
        assertEquals("Pear", list.get(0));
        list.set(0, "Peach");
        assertEquals("Peach", list.get(0));
        list.addBack("Pear");
        list.addBack("Apple");
        list.addBack("Plum");
        list.addBack("Kiwi");
        list.addBack("Orange");
        list.addBack("Pickle");
        list.addBack("Cucumber");
        assertEquals("Kiwi", list.get(4));
        list.set(4, "Pizza");
        assertEquals("Pizza", list.get(4));
        assertEquals("Pickle", list.get(6));
        list.set(6, "Coca Cola");
        assertEquals("Coca Cola", list.get(6));
        assertEquals("Cucumber", list.get(7));
        list.set(7, "Coconut");
        assertEquals("Coconut", list.get(7));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(null, list.removeFront());
        list.add(0, "Banana");
        assertEquals("Banana", list.get(0));
        assertEquals(1, list.size());
        assertEquals("Banana", list.removeFront());
        list.add(0, "Pear");
        list.add(1, "Plum");
        assertEquals("Pear", list.removeFront());
        list.addBack("Peach");
        list.addBack("Orange");
        list.addBack("Pineapple");
        list.addBack("Kiwi");
        list.addBack("Pizza");
        list.addBack("Brownie");
        list.addBack("Pickle");
        list.addBack("Cucumber");
        assertEquals("Plum", list.removeFront());
        assertEquals("Peach", list.removeFront());
        assertEquals("Orange", list.removeFront());
        assertEquals("Pineapple", list.removeFront());
        assertEquals("Kiwi", list.removeFront());
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(null, list.removeBack());
        list.addBack("Peach");
        assertEquals("Peach", list.removeBack());
        list.addBack("Pear");
        list.addBack("Plum");
        assertEquals("Plum", list.removeBack());
        list.addBack("Pineapple");
        list.addBack("Pizza");
        list.addBack("Pickle");
        list.addBack("Crackers");
        list.addBack("Brownie");
        list.addBack("Cheese");
        list.addBack("Asparagus");
        assertEquals("Asparagus", list.removeBack());
        assertEquals("Cheese", list.removeBack());
        assertEquals("Brownie", list.removeBack());
        assertEquals("Crackers", list.removeBack());
        assertEquals("Pickle", list.removeBack());
    }

    @org.junit.jupiter.api.Test
    void removeIndex() { // removes based on index given
        LinkedList<String> list = new LinkedList<>();
        list.addBack("Banana");
        assertEquals("Banana", list.remove(0));
        assertEquals(0, list.size());
        list.addBack("Peach");
        list.addBack("Pear");
        list.addBack("Pineapple");
        assertEquals("Pear", list.remove(1));
        list.addBack("Pizza");
        list.addBack("Pickle");
        list.addBack("Cucumber");
        list.addBack("Apple");
        list.addBack("Orange");
        assertEquals("Pickle", list.remove(3));
        assertEquals("Orange", list.remove(5));
        assertEquals("Apple", list.remove(4));
    }

    @org.junit.jupiter.api.Test
    void removeItem() { // removes based on item given
        LinkedList<String> list = new LinkedList<>();
        list.addBack("Banana");
        list.remove("Banana");
        assertEquals(0, list.size());
        list.addBack("Banana");
        list.addBack("Peach");
        list.addBack("Orange");
        list.addBack("Pear");
        list.addBack("Banana");
        list.addBack("Pineapple");
        list.addBack("Carrot");
        list.addBack("Bread");
        assertEquals("Banana", list.get(0));
        list.remove("Banana");
        assertEquals("Peach", list.get(0));
        assertEquals("Banana", list.get(3));
        assertEquals("Pineapple", list.get(4));
        assertEquals("Carrot", list.get(5));
        assertEquals("Bread", list.get(list.size()-1));
        list.remove("Bread");
        assertEquals("Carrot", list.get(list.size()-1));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(false, list.contains(""));
        assertEquals(false, list.contains("Banana"));
        assertEquals(false, list.contains("Orange"));
        list.addBack("Banana");
        assertEquals(true, list.contains("Banana"));
        list.addBack("Orange");
        assertEquals(true, list.contains("Orange"));
        list.addBack("Pineapple");
        list.addBack("Lemon");
        list.addBack("Lime");
        list.addBack("Peach");
        list.addBack("Pear");
        list.addBack("Apple");
        list.addBack("Kiwi");
        assertEquals(true, list.contains("Lime"));
        assertEquals(true, list.contains("Peach"));
        assertEquals(true, list.contains("Kiwi"));
        assertEquals(true, list.contains("Pear"));
        assertEquals(true, list.contains("Pineapple"));
        assertEquals(false, list.contains("Kumquat"));
        assertEquals(false, list.contains("Pizza"));
        list.remove("Pineapple");
        assertEquals(false, list.contains("Pineapple"));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(true, list.isEmpty());
        list.addBack("Apple");
        assertEquals(false, list.isEmpty());
        list.addBack("Banana");
        assertEquals(false, list.isEmpty());
        list.addBack("Orange");
        list.addBack("Pear");
        list.addBack("Cucumber");
        list.addBack("Pizza");
        list.addBack("Brownies");
        list.addBack("Salad");
        list.addBack("Eggs");
        assertEquals(false, list.isEmpty());
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
            i--;
        }
        assertEquals(true, list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.addBack("Banana");
        assertEquals(1, list.size());
        list.addBack("Orange");
        list.addBack("Grape");
        list.addBack("Pear");
        list.addBack("Apple");
        list.addBack("Melon");
        list.addBack("Passion fruit");
        assertEquals(7, list.size());
        list.remove("Melon");
        assertEquals(6, list.size());
        list.remove("Pear");
        assertEquals(5, list.size());
        list.remove("Banana");
        assertEquals(4, list.size());
    }
}