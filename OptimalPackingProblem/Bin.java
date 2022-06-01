import java.util.ArrayList;
import java.util.List;

/**
 * Bin
 */
public class Bin {

    private int id;
    // capacity - maximum units we can store
    private int capacity;
    // actualSize - so the units of items we already store
    private int actualSize;
    private List<Integer> items;

    public Bin(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public boolean put(Integer item) {

        // the item does not fit into the bin
        if (actualSize + item > capacity)
            return false;

        // add the item to the bin
        items.add(item);
        actualSize += item;

        return true;
    }

    @Override
    public String toString() {
        String contentOfBin = "Items in bin #" + this.id + ": ";
        for (Integer item : this.items) {
            contentOfBin += item + " ";
        }
        return contentOfBin;
    }

}
