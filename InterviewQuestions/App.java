/**
 * App
 */
public class App {
    public static void main(String[] args) {

        // Palindrome problem = new Palindrome();
        // System.out.println(problem.solve("madam"));

        // IntegerReversion problem = new IntegerReversion();
        // System.out.println(problem.reverse(1234));

        // EggDropping problem = new EggDropping();
        // System.out.println(problem.solve());

        // int[] arr = { 2, 3, 4, 2, 3 };
        // DuplicatesInArray repeatedProblem = new DuplicatesInArray();
        // repeatedProblem.solve(arr);

        // Anagram problem = new Anagram();
        // System.out.println(problem.solve("adam".toCharArray(),
        // "mada".toCharArray()));

        // int[] nums = { 1, -2, 3, 4, -5, 8 };
        // LargestSumSubarray problem = new LargestSumSubarray();
        // System.out.println(problem.solve(nums));

        // int[] nums = { 2, 2, 1, 1, 0, 0, 1, 1 };
        // DutchNationalFlag problem = new DutchNationalFlag(nums);
        // problem.solve();
        // problem.showResult();

        int[] height = { 2, 1, 3, 1, 4 };
        TrappedRainProblem problem = new TrappedRainProblem();
        System.out.println(problem.solve(height));

    }
}
