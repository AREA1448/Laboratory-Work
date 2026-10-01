public class Main {

    // A. O(1) — константна складність (без циклу)
    public static long[] functionA(long n) {
        long steps = 1;
        long sum = n * (n + 1) / 2;
        return new long[]{sum, steps};
    }

    // L. O(log n) — логарифмічна складність (розподіл навпіл)
    public static long functionL(long n) {
        long steps = 0;
        long j = n;
        while (j > 1) {
            steps++;
            j = j / 2; // цілочисельне ділення
        }
        return steps;
    }

    // B. O(n) — лінійна складність (один цикл)
    public static long[] functionB(long n) {
        long steps = 0;
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            steps++;
            sum += i;
        }
        return new long[]{sum, steps};
    }

    // D. O(n log n) — лінійно-логарифмічна складність (вкладений цикл ділення)
    public static long functionD(long n) {
        long steps = 0;
        for (long i = 1; i <= n; i++) {
            long j = n;
            while (j > 1) {
                steps++;
                j = j / 2;
            }
        }
        return steps;
    }

    // C. O(n²) — квадратична складність (два вкладені цикли)
    public static long functionC(long n) {
        long steps = 0;
        for (long i = 1; i <= n; i++) {
            for (long k = 1; k <= n; k++) {
                steps++;
            }
        }
        return steps;
    }

    // E. O(2ⁿ) — експоненціальна складність (без рекурсії)
    public static long functionE(long n) {
        long steps = 0;
        long limit = 1;
        for (long i = 1; i <= n; i++) {
            limit = limit * 2; // limit стає 2ⁿ
        }
        for (long k = 1; k <= limit; k++) {
            steps++;
        }
        return steps;
    }

    // F. O(n!) — факторіальна складність (без рекурсії)
    public static long functionF(long n) {
        long steps = 0;
        long limit = 1;
        for (long i = 1; i <= n; i++) {
            limit = limit * i; // limit стає n!
        }
        for (long k = 1; k <= limit; k++) {
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println("=== ТАБЛИЦЯ 1. ПОЛІНОМІАЛЬНИЙ РЯД ===");
        long[] nsPoly = {100, 200, 400, 800, 1600, 3200};
        System.out.printf("%-6s | %-7s | %-10s | %-7s | %-13s | %-11s\n", "n", "A O(1)", "L O(log n)", "B O(n)", "D O(n log n)", "C O(n²)");
        System.out.println("-------------------------------------------------------------------------");
        for (long n : nsPoly) {
            long[] resA = functionA(n);
            long resL = functionL(n);
            long[] resB = functionB(n);
            long resD = functionD(n);
            long resC = functionC(n);
            System.out.printf("%-6d | %-7d | %-10d | %-7d | %-13d | %-11d\n", n, resA[1], resL, resB[1], resD, resC);
        }

        System.out.println("\n=== ТАБЛИЦЯ 2. ЕКСПАНЕНТА І ФАКТОРІАЛ ===");
        long[] nsE = {8, 10, 12, 14, 16, 18};
        long[] nsF = {4, 5, 6, 7, 8, 9};
        
        System.out.println("Частина 1: Експонента O(2ⁿ)");
        System.out.printf("%-6s | %-10s\n", "n", "E ≈ 2ⁿ");
        System.out.println("-------------------");
        for (long n : nsE) {
            System.out.printf("%-6d | %-10d\n", n, functionE(n));
        }

        System.out.println("\nЧастина 2: Факторіал O(n!)");
        System.out.printf("%-6s | %-10s\n", "n", "F ≈ n!");
        System.out.println("-------------------");
        for (long n : nsF) {
            System.out.printf("%-6d | %-10d\n", n, functionF(n));
        }
    }
}
