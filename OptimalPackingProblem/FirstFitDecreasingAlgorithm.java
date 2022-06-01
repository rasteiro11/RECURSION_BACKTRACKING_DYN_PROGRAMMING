import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FirstFitDecreasingAlgorithm
 */
public class FirstFitDecreasingAlgorithm {

    private List<Bin> bins;
    private List<Integer> items;

    private int binCapacity;
    private int binCounter = 1;

    public FirstFitDecreasingAlgorithm(List<Integer> items, int binCapacity) {
        this.binCapacity = binCapacity;
        this.items = items;
        this.bins = new ArrayList<>(items.size());
    }

    public void solve() {

        // sort the items in descending order
        Collections.sort(items, Collections.reverseOrder());

        if (items.get(0) > binCapacity) {
            System.out.println("No feasible solution...");
            return;
        }

        // frist bin!!!
        bins.add(new Bin(binCounter, binCapacity));

        for (Integer item : items) {
            // track weather we have put the item into a bin or not
            boolean isOk = false;
            int currentBin = 0;
            while (!isOk) {
                // item does not fit in last bin -> try a new bin
                if (currentBin == bins.size()) {
                    Bin newBin = new Bin(++binCounter, binCapacity);
                    newBin.put(item);
                    bins.add(newBin);
                    isOk = true;
                    // current item fits in the given bin
                } else if (bins.get(currentBin).put(item)) {
                    isOk = true;
                } else {
                    // trying the next bin
                    currentBin++;
                }
            }
        }

    }

    public void showResults() {
        for (Bin bin : bins)
            System.out.println(bin);
    }

}
