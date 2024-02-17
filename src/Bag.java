import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public interface Bag<E> extends Iterable<E>
{
    /**
     * add an item to the bag
     * @param item the item that will be added
     */
    void add(E item);

    /**
     * check if the bag is empty
     * @return true or false
     */
    boolean isEmpty();

    /**
     * check the size of the bag
     * @return the size as an int
     */
    int size();
}
