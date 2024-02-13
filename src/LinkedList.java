import java.util.Iterator;

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

    @Override
    public E removeFront() {
        return null;
    }

    @Override
    public E removeBack() {
        return null;
    }

    @Override
    public void remove(E item) {

    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public boolean contains(E item) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
