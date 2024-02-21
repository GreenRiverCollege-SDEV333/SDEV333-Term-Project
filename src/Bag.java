import java.util.Iterator;

public interface Bag<Item> extends Iterable<Item>
{
    void add(Item item);

    boolean isEmpty();

    int size();


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    Iterator<Item> iterator();
}
