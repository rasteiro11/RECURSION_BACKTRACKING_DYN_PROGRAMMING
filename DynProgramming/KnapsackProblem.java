/**
 * KnapsackProblem
 */
public class KnapsackProblem {

    // total numbers of items
    private int n;

    // this is the M capacity of the knapsack
    private int capacity;

    // dynamic programming table (2dimensional array)
    private int[][] S;
    private int[] weights;
    private int[] values;

    public KnapsackProblem(int n, int capacity, int[] weights, int[] values) {
        this.n = n;
        this.capacity = capacity;
        this.weights = weights;
        this.values = values;
    }

    public void solve() {

        // initialize
        // time complexity: O(n*M)
        for (int i = 1; i < n + 1; i++) {
            for (int w = 1; w < capacity + 1; w++) {
                // weather to take item 'i' or not
                int notTakingItem = S[i - 1][w];
                int takingItem = 0;

                if (weights[i] <= w) {
                    takingItem = values[i] + S[i - 1][w - weights[i]];
                }

                // memoization - we store the sub-results in an array
                S[i][w] = Math.max(takingItem, notTakingItem);

            }
        }
    }

    public int solveRecursion(int m, int[] w, int[] v, int n) {
        // base case
        if (m == 0 || n == 0) {
            return 0;
        }

        // the given item can NOT fit in the knapsack
        if (w[n - 1] > m) {
            return solveRecursion(m, w, v, n - 1);
        } else {
            // given item can fit into the knapsack so we have two options (include,
            // exclude)
            int included = v[n - 1] + solveRecursion(m - w[n - 1], w, v, n - 1);
            int excluded = solveRecursion(m, w, v, n - 1);
            return Math.max(included, excluded);

        }
    }

    public void showResults() {
        System.out.println("Total Benefit: " + S[n][capacity]);
        for (int i = n, w = capacity; i > 0; i++) {

            if (S[i][w] != 0 && S[i][w] != S[i - 1][w]) {
                System.out.println("We take item: #" + i);
                w = w - weights[i];
            }
        }

    }

}
