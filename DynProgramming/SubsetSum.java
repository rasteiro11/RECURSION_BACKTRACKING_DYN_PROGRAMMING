/**
 * SubsetSum
 */
public class SubsetSum {

    private boolean[][] S;
    private int[] nums;
    private int m;

    public SubsetSum(int[] nums, int m) {
        this.m = m;
        this.nums = nums;
        this.S = new boolean[nums.length + 1][m + 1];
    }

    public void solve() {
        // first row is FALSE by default
        // no need for a loop

        // first column contains TRUE values
        // if 'm' is 0 then we can make the empty subset to make sum 0
        for (int i = 0; i <= nums.length; i++) {
            S[i][0] = true;
        }

        // we consider all the N+1 rows and M+1 columns
        for (int rowIndex = 1; rowIndex < nums.length + 1; rowIndex++) {
            for (int colIndex = 1; colIndex < m + 1; colIndex++) {
                // if the column
                if (colIndex < nums[rowIndex - 1]) {
                    S[rowIndex][colIndex] = S[rowIndex - 1][colIndex];
                } else {
                    if (S[rowIndex - 1][colIndex]) {
                        // we do not include the given item
                        S[rowIndex][colIndex] = S[rowIndex - 1][colIndex];
                    } else {
                        // we include the item with rowIndex
                        S[rowIndex][colIndex] = S[rowIndex - 1][colIndex - nums[rowIndex - 1]];
                    }
                }
            }

        }

    }

    public void showResult() {
        System.out.println("There is a feasible solution: " + S[nums.length][m]);
        if (!S[nums.length][m])
            return;
        int colIndex = this.m;
        int rowIndex = this.nums.length;

        while (rowIndex > 0 || colIndex > 0) {
            if (S[rowIndex][colIndex] == S[rowIndex - 1][colIndex]) {
                rowIndex--;
            } else {
                System.out.println("We take item: " + nums[rowIndex - 1]);
                colIndex = colIndex - nums[rowIndex - 1];
                rowIndex--;
            }
        }

    }

}
