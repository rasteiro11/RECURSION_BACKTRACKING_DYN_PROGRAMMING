/**
 * LinearSearch
 */
public class LinearSearch {

    public int find(int[] container, int item) {
        for (int i = 0; i < container.length; i++) {
            if (container[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int recursiveFind(int[] container, int item, int index) {
        if (index == container.length) {
            return -1;
        }

        if (container[index] == item) {
            return index;
        }

        return recursiveFind(container, item, index + 1);
    }
}
