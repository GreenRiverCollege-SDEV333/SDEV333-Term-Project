/**
 *  (collection of unordered items)  Bag API
 * @param <E> class / data type of the items in the bag
 */
public interface Bag <E> extends Iterable<E> {
    /**
    * Add an item to the bag
    * @param item the item to be added
    */
    void add(E item);

    /**
     * Checks if the bag is empty or not
     * @return true if the bag is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the bag
     * @return the number of items in the bag
     */
    int size();


}
