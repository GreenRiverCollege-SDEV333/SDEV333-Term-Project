import java.util.Iterator;

public class LinkedList<E> implements List<E> {
    // define  what a node is
    private class Node {
        E data;
        Node next;

        @Override
        public String toString() {
            return data +
                    ", " + next;
        }
    }

    // set up the head
    private Node head;

    // set up the size field
    private int size;

    // add a constructor to initialize the fields
    public LinkedList() {
        head = null;

        size = 0;
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        //set up new node
        Node theNewOne = new Node();
        theNewOne.data = item;

        if (head == null) {
            //this list is currently empty
            head = theNewOne;
            size++;
        } else {
            //this list currently has some nodes in it
            theNewOne.next = head;
            //everything from the right gets saved to the left
            head = theNewOne;
            size++;
        }
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node theNewOne = new Node();
        theNewOne.data = item;
        if (size == 0) {
            head = theNewOne;
            size++;
        } else {
            // keeps track of where you are in the list
            Node temp = head;
            // if temp. next is not null
            while (temp.next != null) {
                // then iterate through the list
                temp = temp.next;
            }
            // if temp.next is null then theNewOne is temp.next
            temp.next = theNewOne;
            size++;
        }
    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        Node theNewOne = new Node();
        theNewOne.data = item;
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if (size == 0) {
                head = theNewOne;
            } else {
                Node prev = null;
                Node temp = head;
                for (int j = 0; j < i; j++) {
                    prev = temp;
                    temp = temp.next;
                }
                theNewOne.next = temp;
                if (prev == null) {
                    head = theNewOne;
                } else {
                    prev.next = theNewOne;
                }
            }
            size++;
        }
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        Node temp;
        E result = null;
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            temp = head;
            for (int j = 0; j < size; j++) {
                // then iterate through the list
                if (j == i) {
                    result = temp.data;
                } else {
                    temp = temp.next;
                }
            }
        }
        return result;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     * @return
     */
    @Override
    public E set(int i, E item) {
        Node theNewOne = new Node();
        theNewOne.data = item;
        if (i > size) {
            throw new IndexOutOfBoundsException();
        } else {
            if (size == 0) {
                head = theNewOne;
            } else {
                Node temp = head;
                for (int j = 0; j < size; j++) {
                    if (j == i) {
                        temp.data = theNewOne.data;
                    } else {
                        temp = temp.next;
                    }

                }

            }
        }
        size++;
        return null;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        E removed = (E) head;
        if (head == null) {
            //this list is currently empty
            System.out.println("this list is empty");
        } else {
            //this list currently has some nodes in it
            head = head.next;
            //everything from the right gets saved to the left
            size--;
        }
        return removed;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = null;
        if (head == null) {
            //this list is currently empty
            System.out.println("this list is empty");
        } else {
            // keeps track of where you are in the list
            temp = head;
            // if temp. next .next is not null
            while (temp.next != null) {
                // then iterate through the list
                temp = temp.next;
            }
            // if temp.next is null then theNewOne is temp.next
            size--;
        }
        return (E) temp;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        Node prev = null;
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(item)) {
                prev = temp;
                temp = temp.next;
            }
        }
        if (prev == null) {
            head = temp.next;
        } else {
            prev.next = temp.next;
        }
        size--;
    }

    /**
     * Remove item at a specified index.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = null;
        Node temp = head;
        for (int j = 0; j < i; j++) {
            prev = temp;
            temp = temp.next;
        }
        if (prev == null) {
            head = temp.next;
        } else {
            prev.next = temp.next;
        }
        size--;
        return temp.data;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        Node temp = head;
        // if temp. next is not null
        while (temp != null) {
            // then iterate through the list
            if (temp.data.equals(item)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
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
    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<E> {

        // private int i;   // index of the item I am on in the arraylist
        private Node current;

        public LinkedIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.data;
            current = current.next;
            return item;
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" + head +
                ", size=" + size +
                '}';
    }


}