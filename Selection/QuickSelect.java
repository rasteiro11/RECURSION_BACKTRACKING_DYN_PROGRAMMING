import java.util.Random;

/**
 * QuickSelect
 */
public class QuickSelect {

    private int[] nums;

    public QuickSelect(int[] nums) {
        this.nums = nums;
    }

    private int select(int k) {
        return quickSelect(0, nums.length - 1, k - 1);
    }

    // this is the selection phase
    private int quickSelect(int firstIndex, int lastIndex, int k) {
        int pivotIndex = partition(firstIndex, lastIndex);
        // we can discard the left sub array so we have to
        // consider the items on the right
        if (pivotIndex < k) {
            return quickSelect(pivotIndex + 1, lastIndex, k);
        } else if (pivotIndex > k) {
            // we can discard the right sub array so we have to
            // consider the items on the left
            return quickSelect(firstIndex, pivotIndex - 1, k);

        }
        return nums[pivotIndex];

    }

    // THIS IS THE PARTITION PHASE
    private int partition(int firstIndex, int lastIndex) {
        // index of the random pivot
        int pivot = new Random().nextInt(firstIndex - lastIndex + 1) + firstIndex;

        // ISOLATE THE PIVOT VALUE
        swap(pivot, lastIndex);
        for (int i = firstIndex; i < lastIndex; i++) {
            if (nums[i] < nums[pivot]) {
                swap(i, firstIndex);
                firstIndex++;
            }
        }

        // GET THE PIVOT VALUE BACK IN PLACE
        swap(lastIndex, firstIndex);

        // this is the index of the pivot
        return firstIndex;
    }

    private void swap(int pivot, int lastIndex) {
        int temp = nums[pivot];
        nums[pivot] = nums[lastIndex];
        nums[lastIndex] = temp;
    }

}
