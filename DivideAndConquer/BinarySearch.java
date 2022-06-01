/**
 * BinarySearch
 */
public class BinarySearch {

    public int find(int[] container, int item, int left, int right) {
        // search miss
        if (right < left)
            return -1;

        int middleIndex = (left + right) / 2;

        // we find the item we are looking for
        if (container[middleIndex] == item)
            return middleIndex;

        // we have to check that the item we are looking for is smaller or greater than
        // the midde_item
        if (container[middleIndex] < item) {
            // we can discard the left sub-array
            return find(container, item, middleIndex + 1, right);
        } else {
            // item is smaller than the middle item
            // we can discard the right sub-array)
            return find(container, item, left, middleIndex - 1);
        }
    }
}
