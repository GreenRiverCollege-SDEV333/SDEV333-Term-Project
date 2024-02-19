import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void addFront() {
        ArrayList<String> list = new ArrayList<>();
        assertEquals(0, list.size());
        list.addFront("Banana");
        assertEquals("Banana", list.get(0));
        assertEquals(1, list.size());
        list.addFront("Apple");
        assertEquals("Apple", list.get(0));
        assertEquals(2, list.size());
        list.addFront("Cucumber");
        list.addFront("Pickle");
        list.addFront("Kiwi");
        list.addFront("Pizza");
        list.addFront("Grape");
        list.addFront("Melon");
        list.addFront("Passion fruit");
        list.addFront("Brownie");
        assertEquals(10, list.size());
        assertEquals("Brownie", list.get(0));
        assertEquals("Passion fruit", list.get(1));
        assertEquals("Melon", list.get(2));
        assertEquals("Grape", list.get(3));
        assertEquals("Banana", list.get(list.size()-1));
    }

    @Test
    void addBack() {
        ArrayList<String> list = new ArrayList<>();
        assertEquals(0, list.size());
        list.addBack("Pickle");
        assertEquals(1, list.size());
        assertEquals("Pickle", list.get(list.size()-1));
        list.addBack("Cucumber");
        assertEquals(2, list.size());
        assertEquals("Cucumber", list.get(list.size()-1));
        list.addBack("Pear");
        list.addBack("Peach");
        list.addBack("Chicken");
        list.addBack("Lime");
        list.addBack("Lemon");
        list.addBack("Apple");
        list.addBack("Orange");
        list.addBack("Kiwi");
        assertEquals(10, list.size());
        assertEquals("Pear", list.get(2));
        assertEquals("Peach", list.get(3));
        assertEquals("Chicken", list.get(4));
        assertEquals("Lime", list.get(5));
        assertEquals("Lemon", list.get(6));
        assertEquals("Apple", list.get(7));
        assertEquals("Orange", list.get(8));
        assertEquals("Kiwi", list.get(9));
    }

    @Test
    void add() {
        ArrayList<String> list = new ArrayList<>();
        assertEquals(0, list.size());
        list.add(0, "Pickle");
        assertEquals(1, list.size());
        list.add(1, "Cucumber");
        assertEquals("Pickle", list.get(0));
        assertEquals("Cucumber", list.get(1));
        assertEquals(2, list.size());
        list.add(0, "Pear");
        list.add(1, "Peach");
        assertEquals("Pear", list.get(0));
        assertEquals("Peach", list.get(1));
        assertEquals("Pickle", list.get(2));
        assertEquals("Cucumber", list.get(3));
        list.add(4, "Pizza");
        list.add(5, "Pasta");
        list.add(6, "Chicken");
        list.add(7, "Kiwi");
        list.add(8, "Melon");
        list.add(9, "Lemon");
        assertEquals("Lemon", list.get(9));
        assertEquals("Melon", list.get(8));
        assertEquals("Kiwi", list.get(7));
        assertEquals("Chicken", list.get(6));
        assertEquals("Pasta", list.get(5));
        assertEquals("Pizza", list.get(4));
    }

    @Test
    void get() {
        ArrayList<String> list = new ArrayList<>();
        list.add(0, "Banana");
        assertEquals("Banana", list.get(0));
        list.add(1, "Kiwi");
        assertEquals("Kiwi", list.get(1));
        list.add(2, "Pear");
        list.add(3, "Peach");
        list.add(4, "Pizza");
        list.add(5, "Pasta");
        list.add(6, "Chicken");
        list.add(7, "Sandwich");
        list.add(8, "Pickle");
        list.add(9, "Cucumber");
        assertEquals("Pear", list.get(2));
        assertEquals("Peach", list.get(3));
        assertEquals("Pizza", list.get(4));
        assertEquals("Pasta", list.get(5));
        assertEquals("Chicken", list.get(6));
        assertEquals("Sandwich", list.get(7));
        assertEquals("Pickle", list.get(8));
        assertEquals("Cucumber", list.get(9));
        assertEquals("Banana", list.get(0));
        assertEquals("Kiwi", list.get(1));
    }

    @Test
    void set() {
        ArrayList<String> list = new ArrayList<>();
        list.add(0, "Pickle");
        assertEquals("Pickle", list.get(0));
        list.set(0, "Cucumber");
        assertEquals("Cucumber", list.get(0));
        list.add(1, "Peach");
        assertEquals("Peach", list.get(1));
        list.set(1, "Pear");
        assertEquals("Pear", list.get(1));
        list.add(2, "Pizza");
        list.add(3, "Pasta");
        list.add(4, "Chicken");
        list.add(5, "Cookie");
        list.add(6, "Cake");
        list.add(7, "Pie");
        list.add(8, "Sandwich");
        list.add(9, "Eggs");
        assertEquals("Eggs", list.get(9));
        list.set(9, "Hashbrowns");
        assertEquals("Hashbrowns", list.get(9));
    }

    @Test
    void removeFront() {
        ArrayList<String> list = new ArrayList<>();
        list.addFront("Banana");
        assertEquals(1, list.size());
        assertEquals("Banana", list.get(0));
        assertEquals("Banana", list.removeFront());
        assertEquals(0, list.size());
        list.addFront("Peach");
        list.addFront("Pear");
        assertEquals(2, list.size());
        assertEquals("Peach", list.get(1));
        assertEquals("Pear", list.get(0));
        assertEquals("Pear", list.removeFront());
        assertEquals("Peach", list.removeFront());
        list.addFront("Pizza");
        list.addFront("Brownie");
        list.addFront("Kiwi");
        list.addFront("Lime");
        list.addFront("Lemon");
        list.addFront("Pasta");
        list.addFront("Chicken");
        list.addFront("Rice");
        list.addFront("Cucumber");
        list.addFront("Pickle");
        assertEquals(10, list.size());
        assertEquals("Pickle", list.get(0));
        assertEquals("Pickle", list.removeFront());
        assertEquals("Cucumber", list.get(0));
        assertEquals("Cucumber", list.removeFront());
        assertEquals("Rice", list.get(0));
        assertEquals("Rice", list.removeFront());
        assertEquals("Chicken", list.get(0));
        assertEquals("Chicken", list.removeFront());
        assertEquals("Pasta", list.get(0));
        assertEquals("Pasta", list.removeFront());
        assertEquals(5, list.size());
    }

    @Test
    void removeBack() {
        ArrayList<String> list = new ArrayList<>();
        list.addBack("Banana");
        assertEquals(1, list.size());
        assertEquals("Banana", list.removeBack());
        list.addBack("Cookie");
        list.addBack("Cake");
        assertEquals("Cake", list.removeBack());
        assertEquals("Cookie", list.removeBack());
        list.addBack("Pizza");
        list.addBack("Brownie");
        list.addBack("Grilled Cheese");
        list.addBack("Apple");
        list.addBack("Kiwi");
        list.addBack("Orange");
        list.addBack("Peach");
        list.addBack("Pear");
        list.addBack("Lemon");
        list.addBack("Lime");
        assertEquals(10, list.size());
        assertEquals("Lime", list.get(list.size()-1));
        assertEquals("Lime", list.removeBack());
        assertEquals("Lemon", list.get(list.size()-1));
        assertEquals("Lemon", list.removeBack());
        assertEquals("Pear", list.get(list.size()-1));
        assertEquals("Pear", list.removeBack());
        assertEquals("Peach", list.get(list.size()-1));
        assertEquals("Peach", list.removeBack());
        assertEquals(6, list.size());
    }

    @Test
    void removeItem() {
        ArrayList<String> list = new ArrayList<>();
        list.addBack("Banana");
        list.addBack("Pizza");
        list.addBack("Kiwi");
        list.addBack("Apple");
        list.addBack("Orange");
        list.addBack("Pasta");
        list.addBack("Lemon");
        list.addBack("Lime");
        list.addBack("Peach");
        list.addBack("Pear");
        assertEquals(10, list.size());
        assertEquals("Pear", list.get(list.size()-1));
        list.remove("Pear");
        assertEquals("Peach", list.get(list.size()-1));
    }

    @Test
    void removeIndex() {
        ArrayList<String> list = new ArrayList<>();
        list.addFront("Banana");
        assertEquals("Banana", list.remove(0));
        list.addFront("Kiwi");
        list.addFront("Orange");
        assertEquals("Kiwi", list.remove(1));
        list.addFront("Apple");
        list.addFront("Pasta");
        list.addFront("Chicken");
        list.addFront("Cucumber");
        list.addFront("Pizza");
        list.addFront("Brownie");
        list.addFront("Cookie");
        list.addFront("Cake");
        list.addFront("Pie");
        assertEquals("Orange", list.get(list.size()-1));
        assertEquals("Orange", list.remove(list.size()-1));
        assertEquals("Apple", list.get(list.size()-1));
        assertEquals("Pizza", list.remove(4));
        assertEquals("Cucumber", list.get(4));
        assertEquals("Brownie", list.remove(3));
        assertEquals("Cucumber", list.get(3));
        assertEquals("Pie", list.remove(0));
        assertEquals("Cookie", list.remove(1));
    }

    @Test
    void contains() {
        ArrayList<String> list = new ArrayList<>();
        assertFalse(list.contains("Banana"));
        list.addFront("Banana");
        assertTrue(list.contains("Banana"));
        list.addFront("Kiwi");
        list.addFront("Watermelon");
        list.addFront("Cantaloupe");
        list.addFront("Apple");
        list.addFront("Orange");
        list.addFront("Passion fruit");
        assertFalse(list.contains("Pizza"));
        assertTrue(list.contains("Orange"));
        assertTrue(list.contains("Watermelon"));
        assertFalse(list.contains("Brownie"));
        assertFalse(list.contains("Pickle"));
        assertTrue(list.contains("Kiwi"));
        assertTrue(list.contains("Apple"));
    }

    @Test
    void isEmpty() {
        ArrayList<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());
        list.addFront("Banana");
        assertFalse(list.isEmpty());
        list.addFront("Kiwi");
        assertFalse(list.isEmpty());
        list.removeFront();
        list.removeFront();
        assertTrue(list.isEmpty());
    }

    @Test
    void size() {
        ArrayList<String> list = new ArrayList<>();
        assertEquals(0, list.size());
        list.addFront("Banana");
        assertEquals(1, list.size());
        list.addFront("Apple");
        list.addFront("Kumquat");
        list.addFront("Kiwi");
        list.addFront("Pizza");
        list.addFront("Brownie");
        list.addFront("Cracker");
        assertEquals(7, list.size());
        list.removeFront();
        assertEquals(6, list.size());
        list.removeFront();
        list.removeFront();
        list.removeFront();
        list.removeFront();
        assertEquals(2, list.size());
    }
}