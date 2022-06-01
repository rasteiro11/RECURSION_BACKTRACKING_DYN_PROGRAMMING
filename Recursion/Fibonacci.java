/**
 * Fibonacci
 */
public class Fibonacci {

    public int head(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return head(n - 1) + head(n - 2);
    }

    public int tail(int n, int a, int b) {
        if (n == 0)
            return a;
        if (n == 1)
            return b;

        return tail(n - 1, b, a + b);

    }
}
