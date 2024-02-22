/**
 * Abstract LinkedList implementation
 *
 * @author Lillian Nelson
 * @version 1.0
 */
package lists;
import java.util.*;

public class LinkedList<E> implements List<Integer>
{
    // Define the node
    private class Node {
        int data;
        Node next;
    }

    // Set up the head
    private Node head;

    // set up a size field
    private int size;

    // add a constructor
    public void LinkedIntList() {
        head = null;
        size = 0;
    }

    /**
     * inserts the specified value at the front of the list
     * Shifts the value currently at the front of the list and any
     * subsequent values to the right.
     * O(1) constant time in the worst case because
     * regardless of size, operations are the same
     *
     * @param value value to be inserted
     */
    public void addFront(int value) {
        //set up a new Node
        Node theNewOne = new Node();
        theNewOne.data = value;

        if (head == null) {
            // the list is currently empty
            head = theNewOne;
        }
        else {
            // the list currently has some nodes in it
            theNewOne.next = head;
            head = theNewOne;
        }

        size++;

    }

    /**
     * inserts the specified value at the back of the list (at index size()-1).
     * O(1) constant time in the worst case because
     * regardless of size, operations are the same
     * @param value value to be inserted
     */
    public void addBack(int value)
    {
        Node theNewOne = new Node();
        theNewOne.data = value;
        // set a marker
        Node current = head;
        if (head == null) {
            head = theNewOne;
        }
        else {
            // Move to the end
            while(current.next != null) {
                current = current.next;
            }
            current.next = theNewOne;
        }
        size++;

    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     * O(1) constant time in the worst case because
     * regardless of size, operations are the same
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, int value)
    {
        if (index == 0)
        {
            head = new Node();
            head.data = value;

        }else
        {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
            {
                current = current.next;
            }
            current.next = new Node();
            current.next.data = value;
            size++;
        }
    }

    /**
     * Removes the value located at the front of the list
     * Shifts any subsequent values to the left.
     * O(1) constant time in the worst case because
     * regardless of size, operations are the same
     * @return
     */
    public Integer removeFront()
    {
        if (!isEmpty())
        {
            head = head.next;
            size--;
        }

        return null;
    }

    /**
     * Removes the value located at the back of the list
     * 0(n) linear time in the worst case because
     * of the time to loop through array
     *
     * @return
     */
    public Integer removeBack()
    {
        Node beforeLast = head;
        while (beforeLast.next.next != null)
        {
            beforeLast = beforeLast.next;
        }
        beforeLast.next = null;
        return null;
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     * 0(n) linear time in the worst case because
     * of the time to loop through array
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Integer remove(int index)
    {
        if (index == 0)
        {
            head = head.next;
        }
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
            {
                current = current.next;

            }
            Node next = current.next.next;
            current.next = next;
            size--;
        }
        return 0;
    }

    /**
     * Returns the value at the specified position in the list.
     * 0(n) linear time in the worst case because
     * of the time to loop through array
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Integer get(int index)
    {
        Node current = head;
        for (int i = 0; i < index; i++)
        {
            current = current.next;

        }
        return current.data;
    }

    /**
     * Returns true if this list contains the specified value.
     * 0(n) linear time in the worst case because
     * of the time to loop through array
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    public boolean contains(int value)
    {
        if (head == null)
        {
            return false;
        }
        else
        {
            Node current = head;

            while (current.next != null)
            {
                if (current.data == value)
                {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     * 0(n) linear time in the worst case because
     * of the time to loop through array
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    public int indexOf(int value)
    {
        if (head == null)
        {
            return -1;
        }else
        {
            Node current = head;
            int index = 0;

            while (current != null)
            {
                if (current.data == value)
                {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
    }

    /**
     * Returns the size variable
     * 0(1) or constant in the worst case because
     * No matter the size of list the operations are the same
     *
     * @return the size of list
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Returns true if this list contains no values.
     * 0(1) or constant in the worst case because
     * No matter the size of list the operations are the same
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     * 0(1) or constant in the worst case because
     * No matter the size of list the operations are the same
     *
     */
    @Override
    public void clear()
    {
        size = 0;
        head = null;
    }

    /**
     * Returns an iterator over elements of type E
     * 0(1) or constant in the worst case because
     * No matter the size of list the operations are the same
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return new SinglyLinkedIterator();
    }

    // helper class/type that defined how iterator works
    private class SinglyLinkedIterator implements Iterator<Integer>
    {
        // private fields
        private Node current;

        public SinglyLinkedIterator() {
            current = head;
        }

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext()
        {
            if (current != null) {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next()
        {
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go too!");
            }
            else {
                int item = current.data;
                current = current.next;
                return item;
            }
        }
    }


    //java added these or made the call abstract was have a lot of frustration getting the tests going

    public int indexOf(Object o)
    {
        return 0;
    }

    public int lastIndexOf(Object o)
    {
        return 0;
    }

    public ListIterator<Integer> listIterator()
    {
        return null;
    }

    public ListIterator<Integer> listIterator(int index)
    {
        return null;
    }

    public List<Integer> subList(int fromIndex, int toIndex)
    {
        return null;
    }

    public Integer set(int index, Integer element)
    {
        return null;
    }

    public void add(int index, Integer element)
    {

    }

    public Object[] toArray()
    {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a)
    {
        return null;
    }

    public boolean add(Integer integer)
    {
        return false;
    }
    @Override
    public boolean contains(Object o)
    {
        return false;
    }

    public boolean remove(Object o)
    {
        return false;
    }

    public boolean containsAll(Collection<?> c)
    {
        return false;
    }

    public boolean addAll(Collection<? extends Integer> c)
    {
        return false;
    }

    public boolean addAll(int index, Collection<? extends Integer> c)
    {
        return false;
    }

    public boolean removeAll(Collection<?> c)
    {
        return false;
    }

    public boolean retainAll(Collection<?> c)
    {
        return false;
    }

}
