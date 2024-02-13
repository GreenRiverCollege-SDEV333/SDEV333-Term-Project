/**
 * Bag API
 *
 * @param <E> class / datatype of items in the Bag.
 */
public interface Bag<E> extends Iterable<E> {

    /**
     * Adds an item to the bag.
     *
     * @param item the item to be added
     */
    void add(E item);

    /**
     * Checks if the Bag is empty.
     *
     * @return true if the bag is empty, otherwise returns false.
     */
    boolean isEmpty();

    /**
     * Keeps track of the current number of items stored within
     * the bag. Increments and decreases any time a value is
     * added/removed.
     *
     * @return current size of the bag.
     */
    int size();
}
