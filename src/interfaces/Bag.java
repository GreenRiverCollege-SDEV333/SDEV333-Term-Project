package interfaces;

/**
 * interfaces.Bag (API / abstract data type)
 * @param <E>  Class or data type of the items in the list
 * @author unknown
 * @version 1.0
 */
public interface Bag<E> extends Iterable<E> {

    /**
     * Add item to the Bag
     * @param item the item to be added
     */
    void add(E item);
    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();
    /**
     * Provides a count of the number of items in the list.
     * @return number of items in the list
     */
    int size();

}
