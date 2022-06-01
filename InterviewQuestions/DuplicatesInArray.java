/**
 * DuplicatesInArray
 */
public class DuplicatesInArray {
    public void solve(int[] array) {
        // O(N)
        for (int i = 0; i < array.length; i++) {

            // if it is a positive number we have to flip
            if (array[Math.abs(array[i])] > 0) {
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            } else {
                System.out.println(Math.abs(array[i]) + " is a repetition!");
            }

        }
    }
}
