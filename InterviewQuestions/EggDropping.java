/**
 * EggDropping
 */
public class EggDropping {

    // dynamic programming table to store the values for the subproblems
    // dpTable[i][j] represents the minimum number of drops with i eggs and j floors
    private int[][] dpTable = new int[Constants.NUM_OF_EGGS + 1][Constants.NUM_OF_FLOORS + 1];

    public int solve() {
        // first column values are 1
        dpTable[0][0] = 1;
        dpTable[1][0] = 1;

        // the first columns is initialized with 1s: of course if we have just 1 egg
        // then checking n floors
        // requires n ergg drops (linear search basically)
        for (int i = 0; i <= Constants.NUM_OF_FLOORS; i++) {
            dpTable[1][i] = i;
        }

        // i is the index for the eggs - j is the index for the floors
        for (int n = 2; n <= Constants.NUM_OF_EGGS; n++) {
            for (int m = 1; m <= Constants.NUM_OF_FLOORS; m++) {
                dpTable[n][m] = Integer.MAX_VALUE;
                // check the dropping egg from 1 to the current floor j
                // NOTE: WE CAN REUSE THE SUBSOLUTIONS FROM THE TABLE !!!
                for (int x = 1; x <= m; x++) {
                    // we have to use the formula + use max for the worst case scenario
                    int maxDrops = 1 + Math.max(dpTable[n - 1][x - 1], dpTable[n][m - x]);
                    // this is taking the minimum (because we are after the minimum number of eegg
                    // drops)
                    if (maxDrops < dpTable[n][m]) {
                        dpTable[n][m] = maxDrops;
                    }

                }
            }
        }

        // the last item in the table contains the minimum number of eggs
        return dpTable[Constants.NUM_OF_EGGS][Constants.NUM_OF_FLOORS];
    }

}
