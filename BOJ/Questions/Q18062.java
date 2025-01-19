//Question No: 18062
//Title: Insertion Order
//Tier: Gold I
import java.util.*;

public class Main {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = 1;

        for (int t = 0, n, m; t < T && scanner.hasNextInt(); ++t) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            int cap = 1;
            for (int i = 0; i < m; ++i) {
                cap = Math.min(cap << 1, n + 1);
            }

            if (m > n || cap < n + 1) {
                System.out.println("impossible");
            } else {
                List<Integer> solution = new ArrayList<>();

                class Solver {
                    void go(int b, int c, int h) {
                        if (c == 0) return;
                        int x = 1;
                        for (int i = 1; i < h && x < c; ++i) {
                            x = Math.min(x << 1, c);
                        }
                        --x;
                        solution.add(b + x);
                        go(b, x, h - 1);
                        go(b + x + 1, c - x - 1, h - 1);
                    }
                }

                new Solver().go(1, n, m);

                for (int i = 0; i < solution.size(); ++i) {
                    if (i > 0) System.out.print(" ");
                    System.out.print(solution.get(i));
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}