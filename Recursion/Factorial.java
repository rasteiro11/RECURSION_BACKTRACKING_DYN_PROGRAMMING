/**
 * Factorial
 */
public class Factorial {

    public int head(int n) {
        if (n == 1)
            return 1;
        return n * head(n - 1);
    }

    public int tail(int n, int acc) {
        if (n == 1)
            return acc;
        return tail(n - 1, n * acc);
    }

}
