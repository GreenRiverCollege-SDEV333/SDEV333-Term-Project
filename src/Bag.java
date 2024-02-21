import java.util.Iterator;

/**
 * Bag interface (API / abstract data type)
 * @author Will Castillo
 * @param <Item> Class or data type of the items in the list.
 */
public interface Bag<Item> extends Iterable<Item>
{
    /**
     * Add an item.
     * @param item the item to be added
     */
    void add(Item item);

    /**
     * Checks if the bag is empty.
     * @return boolean - if the bag is empty
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the bag.
     * @return the count of the numbers of items
     */
    int size();

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    Iterator<Item> iterator();
}
