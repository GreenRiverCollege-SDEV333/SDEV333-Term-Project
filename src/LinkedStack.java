import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import interfaces.Stack;

import interfaces.Stack;

public class LinkedStack<E> implements Stack<E>
{
    //fields
    private Node head;
    private int size;

    //Node constructor
    private class Node
    {
        E item;
        Node nextNode;
    }
    /**
     * Add an item to the stack.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {

    }

    /**
     * Removes the most recently added item from the stack.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        return null;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek()
    {
        //throw exception if stack is empty
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is empty, cannot peek()");
        }
        //finds and returns the top of the stack
        return head.item;
    }
    /**
     * Checks to see if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * @return the number of items in the stack
     */
    @Override
    public int size() {
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
        E item = current.item;
        current = current.nextNode;
        return item;
    }
}
}
