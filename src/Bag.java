/**
 *  This interface is meant to represent an abstract version of what a Bag data structure should look like.
 *  @author Jared Eller
 *  @verison 1.0
 *  @date 2/20/24
 *  Bag (Unordered add, no removal) API
 *  @param <E> class/data type of items in the bag
 */
public interface Bag<E> extends Iterable<E>
{
    /**
     * Add an item to the bag.
     * @param item the item to be added
     */
    void add(E item);

    /**
     * Checks to see if the bag is empty.
     * @return true if the bag is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns a count of the number of items in the bag.
     * @return the number of items in the bag
     */
    int size();
}
