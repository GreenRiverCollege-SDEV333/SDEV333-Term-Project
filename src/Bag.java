/**
 * Bag API
 */
public interface Bag<E> extends Iterable<E> {
    /**
     * Add an item to the bag.
     * @param item the item to be added
     */
    void add(E item);

    /**
     * Checks to see if the bag is emtpy
     * @return true if the bag is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns a count of the number of items in the bag.
     * @return the number of items in the bag
     */
    int size();
}
