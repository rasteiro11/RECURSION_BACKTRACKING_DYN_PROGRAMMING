import java.util.HashMap;
import java.util.Map;

/**
 * App
 */
public class App {

    public static void main(String[] args) {

        // Map<Integer, Integer> table = new HashMap<>();
        // table.put(0, 1);
        // table.put(1, 1);

        // Algorithm algo = new Algorithm();
        // System.out.println(algo.fibbonachiRecursion(12));
        // System.out.println(algo.fibbonachiMemoization(12, table));
        // System.out.println(algo.fibonacciTabulation(12, table));
        //

        // int numOfItems = 4;
        // int capacityOfKnapsack = 7;

        // int[] weightOfItems = { 0, 1, 3, 4, 5 };
        // int[] profitOfItems = { 0, 1, 4, 5, 7 };

        // KnapsackProblem problem = new KnapsackProblem(numOfItems, capacityOfKnapsack,
        // weightOfItems, profitOfItems);
        // problem.solve();
        // problem.showResults();

        // int n = 5;
        // int[] pieces = { 0, 2, 5, 7, 3, 20 };
        // RodCutting problem = new RodCutting(n, pieces);
        // problem.solve();
        // problem.show();

        int[] numbers = { 1, 7, 4, 3, 6, 5, 9, 11 };
        int m = 43;
        SubsetSum problem = new SubsetSum(numbers, m);
        problem.solve();
        problem.showResult();

    }
}
