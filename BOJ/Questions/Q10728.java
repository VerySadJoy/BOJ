//Question No: 10728
//Title: XOR삼형제 1
//Tier: Silver I
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int maxSize = 0;
            List<Integer> result = new ArrayList<>();

            for (int i = 1; i < (1 << n); i++) {
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset.add(j + 1);
                    }
                }
                if (isValid(subset)) {
                    if (subset.size() > maxSize) {
                        maxSize = subset.size();
                        result.clear();
                        result.addAll(subset);
                    }
                }
            }

            System.out.println(result.size());
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(List<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            for (int j = i + 1; j < subset.size(); j++) {
                for (int k = j + 1; k < subset.size(); k++) {
                    if ((subset.get(i) ^ subset.get(j) ^ subset.get(k)) == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
