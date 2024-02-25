import java.util.Iterator;
import java.util.NoSuchElementException;
import interfaces.Stack;

/**
 * Ryder Dettloff
 * LinkedStack Data Structure
 * @param <E>
 */

public class LinkedStack<E> implements Stack<E>
{
    //node fields
    private Node head;
    private int size;

    //Node class
    private class Node
    {
        E data;
        Node nextNode;
    }
    /**
     * Add an item to the stack.
     * time complexity: O(N)(Constant) simple operations
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        //creat new head node
        head = new Node();
        //assign head to prev node
        Node prev = head;
        //assign heads data to new item
        head.data = item;
        //set heads next node to previous
        head.nextNode = prev;
        //increment size
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * time complexity: O(N)(Constant) simple operations
     * @return the item that was removed
     */
    @Override
    public E pop()     {
        if(isEmpty()) {
            //check if stack is empty
            throw new IllegalStateException("The stack is empty");
        }
        //assign heads data to item
        E item = head.data;
        //set head to the heads next node
        head = head.nextNode;
        //decrement size
        size--;
        //return item
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * time complexity: O(N)(Constant) simple operations (finding head of stack)
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        //throw exception if stack is empty
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty, cannot peek()");
        }
        //finds and returns the top of the stack
        return head.data;
    }
    /**
     * Checks to see if the stack is empty.
     * time complexity: O(N)(Constant) comparing size to 0
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        //compare size to 0 and return boolean value
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     * time complexity: O(N)(Constant) returning size variable
     * @return the number of items in the stack
     */
    @Override
    public int size() {
        //return size variable
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<E>{
    // returns ture if iteration has no more elements
    private Node current = head;
    public boolean hasNext() {
        return current != null;
    }
    // returns next element in the iteration

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        //goes to the next node in the stack and returns it
        E item = current.data;
        current = current.nextNode;
        return item;
    }
}
}
