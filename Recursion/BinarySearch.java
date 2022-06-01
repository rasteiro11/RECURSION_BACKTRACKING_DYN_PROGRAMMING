/**
 * BinarySearch
 */
public class BinarySearch {
    public int find(int[] container, int item, int left, int right) {
        // this is a search miss
        if (right < left)
            return -1;

        int middle_index = (left + right) / 2;

        // we find the item we are looking for
        if (container[middle_index] == item)
            return middle_index;

        // greater than the middle item
        if (container[middle_index] < item) {
            // item isn greater than the middle item
            // we can discard the left sub array
            return find(container, item, middle_index + 1, right);
        } else {
            // item is smaller than the middle item
            // we can discard the right sub array
            return find(container, item, left, middle_index - 1);
        }

    }
}
