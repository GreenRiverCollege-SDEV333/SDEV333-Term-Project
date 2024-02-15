/**
 * Bag: Container API
 * @param <E>> class / data type of the items in the bag
 */
public interface Bag<E> extends Iterable<E>
{
    /**
     * Adds item to the bag
     * @param beingAdded the item to be added
     */
    void add(E beingAdded);

    /**
     * Checks to see if the bag is empty
     * @return true if bag is empty, false if otherwise
     */
    boolean isEmpty();

    /**
     * Returns a count of the number of items in the bag
     * @return the number of items in the bag
     */
    int size();
}
