import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>{

    // Node class
    private class Node {
        E data;
        Node next;
    }

    // fields
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Runtime analysis: Worst case scenario, this would run at constant time
     * since in every case, you only change the head reference to the new Node.
     * There is no need to visit every Node.
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        Node newOne = new Node();
        newOne.data = item;
        if(head == null)
        {
            // the list is currently empty
            newOne.next = null;
            head = newOne;
            size++;
            return;
        }
        // the list currently has some nodes in it
        newOne.next = head;
        head = newOne;
        size++;
    }

    /**
     * Runtime analysis: Worst case scenario, this would run at O(n) or linear time
     * because you have to visit every Node to reach the back of the LinkedList
     * and then assign a new Node to the back.
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node newOne = new Node();
        newOne.data = item;
        if(head == null)
        {
            // the list is currently empty
            newOne.next = null;
            head = newOne;
            size++;
            return;
        }
        // the list currently has some nodes in it
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = newOne;
        size++;
    }

    /**
     * Runtime analysis: Worst case scenario, this would be O(n), as in the worst case scenario,
     * the index being added to could be the last index, meaning we would have to traverse the
     * entire LinkedList to add the new Node. Best case scenario, it would be constant time, as
     * the user could ask to put the new Node at index 0, meaning no iterating is required.
     * @param i the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
// throw exception if index given is out of bounds
        if(i > size || i < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        if(head == null)
        {
            head = new Node();
            head.data = item;
            head.next = null;
            size++;
            return;
        }
        // current Node to keep track of index
        Node current = head;
        // create a new Node
        Node theNewOne = new Node();
        // set the new Nodes value
        theNewOne.data = item;
        // check if index is at the front of the LinkedList
        if(i == 0)
        {
            theNewOne.next = head;
            head = theNewOne;
            size++;
            return;
        }
        // check if index is at the end of the LinkedList
        if(i == size())
        {
            // loop to end of the list
            while(current.next != null)
            {
                current = current.next;
            }
            // add the new Node
            current.next = theNewOne;
            size++;
            return;
        }
        // else, for loop that stops one before new indexed Node
        for (int j = 0; j < i-1; j++) {
            current = current.next;
        }
        // save the old Node from that index, so we can move it forward one space
        Node nodeAfterAdded = current.next;
        // put the new Node in current.next position
        current.next = theNewOne;
        // move current forward one
        current = current.next;
        // set the previous index Node forward one index position (e.g. index 3 Node would now become index 4)
        current.next = nodeAfterAdded;
        size++;
    }

    /**
     * Runtime analysis: Worst case scenario, this would be O(n) runtime because
     * you might have to go to the end of the LinkedList to find an item, or
     * not find the item at all.
     * @param i the index where the item should be retrieved
     * @return
     */
    @Override
    public E get(int i) {
        if(i >= size || i < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        Node current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Runtime analysis: Worst case scenario, this would be O(n) runtime.
     * This is because the item you are wanting to set could be at
     * the end of the list, or not there at all, meaning you
     * iterate through each item in the LinkedList.
     * @param i the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if(i > size || i < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        Node current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        current.data = item;
    }

    /**
     * Runtime analysis: This will always be constant time because
     * removing the front Node does not vary. You simply move the head Node
     * reference forward and that is it.
     * @return
     */
    @Override
    public E removeFront() {
        if(size() > 0)
        {
            E returnedItem = head.data;
            head = head.next;
            size--;
            return returnedItem;
        }
        return null;
    }

    /**
     * Runtime analysis: Worst case scenario, and best case scenario,
     * this runs at O(n). This is because you always have to loop
     * until you reach the end of the list to remove the last Node.
     * @return
     */
    @Override
    public E removeBack() {
        E returnedItem;
        if(size <= 1)
        {
            returnedItem = head.data;
            head = null;
            size --;
            return returnedItem;
        }
        Node current = head;
        for (int i = 0; i < size()-2; i++) {
            current = current.next;
        }
        returnedItem = current.next.data;
        current.next = null;
        size--;
        return returnedItem;
    }

    /**
     * Runtime analysis: Worst case scenario, this would be O(n).
     * That is because you could iterate through the whole list
     * only to find the item does not exist within the LinkedList.
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        if(!contains(item))
        {
            throw new NoSuchElementException("Item does not exist!");
        }
        Node current = head;
        if(current.data.equals(item))
        {
            head = head.next;
            return;
        }
        while(current.next != null)
        {
            if(current.next.data.equals(item))
            {
                current.next = current.next.next;
            }
        }
    }

    @Override
    public E remove(int i) {
        // check if index is invalid
        if(i >= size() || i < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        E dataToBeRemoved;
        if(i == 0)
        {
            dataToBeRemoved = head.data;
            head.data = null;
            head = head.next;
            size--;
            return dataToBeRemoved;
        }
        // current Node to iterate through LinkedList
        Node current = head;
        // loop until one Node before our index
        for (int j = 0; j < i-1; i++) {
            current = current.next;
        }
        // save our value that will be removed
        dataToBeRemoved = current.next.data;
        // check if there are two Nodes ahead for easy shifting
        if(size()-i > 1)
        {
            // move current.next an additional space forward
            current.next = current.next.next;
            size--;
            return dataToBeRemoved;
        }
        // else, remove the next Node (there are no Nodes ahead of our index)
        current.next = null;
        size--;
        return dataToBeRemoved;
    }

    @Override
    public boolean contains(E item) {
        Node current = head;
        while(current != null)
        {
            if(current.data.equals(item))
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Runtime analysis: This will always run in constant time because
     * there is no variation based on size of the LinkedList.
     * This is a simple 1 line return statement.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Runtime analysis: This will always run in constant time
     * because there is no variation based on size of the LinkedList.
     * This is a simple 1 line return statement to return the size
     * of the LinkedList.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
