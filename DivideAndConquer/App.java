import java.util.Arrays;
import java.util.List;

/**
 * App
 */
public class App {
    public static void main(String[] args) {

        // int[] nums = { 5, -1, 0, 7, 2, 3, 2, 1, 0, 1, 2 };
        // MergeSort sort = new MergeSort(nums);
        // sort.sort();
        // sort.showArray();

        List<Point> points = Arrays.asList(new Point(2.5, 3), new Point(3, 3), new Point(1, 1), new Point(1, 2),
                new Point(2, 1), new Point(2, 2));
        Algorithm a = new Algorithm(points);
        System.out.println(a.solveProblem());
    }

}
