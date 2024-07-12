//Question No: 1017
//Title: 소수 쌍
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    private static final boolean[] IS_NOT_PRIME = eratosthenes();
    private static int[] leftSet;
    private static int[] rightSet;
    private static boolean[][] isConnected;
    private static boolean[] visited;
    private static int[] matched;
    private static int selected;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (numbers[0] % 2 != 0) {
            leftSet = Arrays.stream(numbers).filter(value -> value % 2 != 0).toArray();
            rightSet = Arrays.stream(numbers).filter(value -> value % 2 == 0).toArray();
        } else {
            leftSet = Arrays.stream(numbers).filter(value -> value % 2 == 0).toArray();
            rightSet = Arrays.stream(numbers).filter(value -> value % 2 != 0).toArray();
        }

        if (leftSet.length == rightSet.length) {
            isConnected = new boolean[leftSet.length][rightSet.length];

            for (int i = 1; i < leftSet.length; i++) {
                for (int j = 0; j < rightSet.length; j++) {
                    int sum = leftSet[i] + rightSet[j];
                    if (!IS_NOT_PRIME[sum]) {
                        isConnected[i][j] = true;
                    }
                }
            }

            LinkedList<Integer> possibleMatches = new LinkedList<>();
            for (int i = 0; i < count / 2; i++) {
                if (!IS_NOT_PRIME[leftSet[0] + rightSet[i]]) {
                    selected = i;
                    int size = findMaxMatching();
                    if (size == count / 2) {
                        possibleMatches.add(rightSet[selected]);
                    }
                }
            }

            if (possibleMatches.isEmpty()) {
                writer.write("-1");
            } else {
                possibleMatches.sort(Integer::compareTo);
                StringBuilder result = new StringBuilder();
                for (int match : possibleMatches) {
                    result.append(match).append(" ");
                }
                writer.write(result.toString().trim());
            }
        } else {
            writer.write("-1");
        }

        writer.newLine();
        writer.close();
        reader.close();
    }

    private static int findMaxMatching() {
        int size = 1;
        matched = new int[leftSet.length];
        Arrays.fill(matched, -1);

        for (int i = 1; i < leftSet.length; i++) {
            visited = new boolean[leftSet.length];
            if (dfs(i)) {
                size++;
            }
        }

        return size;
    }

    private static boolean dfs(int num) {
        if (!visited[num]) {
            visited[num] = true;
            for (int i = 0; i < rightSet.length; i++) {
                if (isConnected[num][i] && i != selected && !IS_NOT_PRIME[leftSet[num] + rightSet[i]]) {
                    if (matched[i] == -1 || dfs(matched[i])) {
                        matched[i] = num;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean[] eratosthenes() {
        boolean[] isNotPrime = new boolean[2000];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        int maxPrime = (int) Math.ceil(Math.sqrt(2000));
        for (int i = 2; i < maxPrime; i++) {
            if (!isNotPrime[i]) {
                for (int j = i + i; j < isNotPrime.length; j += i) {
                    if (!isNotPrime[j]) {
                        isNotPrime[j] = true;
                    }
                }
            }
        }

        return isNotPrime;
    }
}
