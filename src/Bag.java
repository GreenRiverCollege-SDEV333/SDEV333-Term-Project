/**
 * Bag interface
 *
 * @param <E> datatype
 * @author  Huy Nguyen
 * @version 1.0
 */
public interface Bag<E> extends Iterable<E> {
    /**
     * Add an item into the bag
     *
     * @param item added
     */
    void add (E item);

    /**
     * check to see if the structure is empty
     * @return boolean if it is empty or not
     */
    boolean isEmpty();

    /**
     * return the size of the data structure
     * @return the size
     */
    int size();
}
