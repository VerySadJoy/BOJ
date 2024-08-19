//Question No: 13547
//Title: 수열과 쿼리 5
//Tier: Platinum II
import java.util.*;

public class Main {
    static class Query {
        int left, right, index;
        Query(int left, int right, int index) {
            this.left = left;
            this.right = right;
            this.index = index;
        }
    }

    static int n, m, sqrtN;
    static int[] arr, count;
    static List<Query> queries = new ArrayList<>();
    static int[] answer;
    static int distinctCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int left = scanner.nextInt() - 1;
            int right = scanner.nextInt() - 1;
            queries.add(new Query(left, right, i));
        }

        sqrtN = (int) Math.sqrt(n);
        count = new int[1000001];
        answer = new int[m];

        queries.sort((a, b) -> {
            if (a.left / sqrtN != b.left / sqrtN) {
                return Integer.compare(a.left / sqrtN, b.left / sqrtN);
            }
            return Integer.compare(a.right, b.right);
        });

        int currentLeft = queries.get(0).left;
        int currentRight = queries.get(0).right;

        for (int i = currentLeft; i <= currentRight; i++) {
            if (count[arr[i]] == 0) distinctCount++;
            count[arr[i]]++;
        }
        answer[queries.get(0).index] = distinctCount;

        for (int i = 1; i < m; i++) {
            int left = queries.get(i).left;
            int right = queries.get(i).right;

            while (left < currentLeft) {
                currentLeft--;
                if (count[arr[currentLeft]] == 0) distinctCount++;
                count[arr[currentLeft]]++;
            }

            while (left > currentLeft) {
                count[arr[currentLeft]]--;
                if (count[arr[currentLeft]] == 0) distinctCount--;
                currentLeft++;
            }

            while (right > currentRight) {
                currentRight++;
                if (count[arr[currentRight]] == 0) distinctCount++;
                count[arr[currentRight]]++;
            }

            while (right < currentRight) {
                count[arr[currentRight]]--;
                if (count[arr[currentRight]] == 0) distinctCount--;
                currentRight--;
            }

            answer[queries.get(i).index] = distinctCount;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
}