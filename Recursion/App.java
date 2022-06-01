/**
 * App
 */
public class App {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        BinarySearch search = new BinarySearch();
        System.out.println(search.find(nums, 5, 0, nums.length - 1));
    }
}
