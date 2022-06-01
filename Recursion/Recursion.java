/**
 * Recursion
 */
public class Recursion {

    public void head(int n) {
        if (n == 0)
            return;
        head(n - 1);
        System.out.println("The value of n=" + n);
    }

    public void tail(int n) {
        if (n == 0)
            return;
        System.out.println("The value of n=" + n);
        tail(n - 1);
    }
}
