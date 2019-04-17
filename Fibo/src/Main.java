public class Main {

    public static void main(String[] args) {

        int var = 39; // <40

        long startTime = System.currentTimeMillis();

        int res = fib(var);
        System.out.println("Mode 1, res = " + res);

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");


        startTime = System.currentTimeMillis();

        int res1 = fib_rec(var);
        System.out.println("Mode 2 (stupid), res = " + res1);

        endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");


    }

    private static int fib(int n) {
        if (n == 0) return 0;
        else if (n > 0) return fibHelper((n - 1), 0, 1);
        else return fibHelper((n + 1), 0, 1);
    }

    static private int fibHelper(int term, int prev, int cur) {
        if (term == 0) return cur;
        else if (term > 0) return fibHelper((term - 1), (cur), (prev + cur));
        else return fibHelper((term + 1), (cur), (prev - cur));
    }

    private static int fib_rec(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n > 0) return  fib_rec(n - 1) + fib_rec(n - 2);
        else return fib_rec(n + 2) - fib_rec(n + 1);
    }
}
