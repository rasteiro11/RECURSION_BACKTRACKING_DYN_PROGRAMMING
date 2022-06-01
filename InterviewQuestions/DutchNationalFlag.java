import java.util.Arrays;

/**
 * DutchNationalFlag
 */
public class DutchNationalFlag {

    // this will contain the values (0, 1 and 2)
    private int[] nums;

    public DutchNationalFlag(int[] nums) {
        this.nums = nums;
    }

    public void solve() {
        int i = 0;
        int j = 0;
        int pivot = 1;
        int k = nums.length - 1;

        // it has O(N) linear running time
        while (j <= k) {
            // when item has index j = 0
            if (nums[j] < pivot) {
                swap(i, j);
                j++;
                i++;
                // item is 2
            } else if (nums[j] > pivot) {
                swap(k, j);
                k--;
                // item is 1
            } else {
                j++;
            }
        }

    }

    private void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void showResult() {
        for (int i : nums)
            System.out.println(i);
    }
}
