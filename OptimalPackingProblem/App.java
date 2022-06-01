import java.util.Arrays;
import java.util.List;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(5, 5, 5);
        int binCapacity = 5;
        FirstFitDecreasingAlgorithm algo = new FirstFitDecreasingAlgorithm(items, binCapacity);
    }
}
