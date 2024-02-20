public interface Bag<Item> extends Iterable<Item>  {
    Item Bag();
    void add(Item item);
    boolean isEmpty();
    int size();
}
