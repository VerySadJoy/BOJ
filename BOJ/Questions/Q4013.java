//Question No: 4013
//Title: ATM
//Tier: Platinum II
import java.util.*;
import java.io.*;

public class Main {
    static boolean[] finished, isRes;
    static int n, m, index, sccIndex, start, max;
    static int[] discover, sccNum, atm, totalAtm, dp;
    static ArrayList<ArrayList<Integer>> list, sccList;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        list = new ArrayList<>();
        atm = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            list.get(edge[0]).add(edge[1]);
        }

        for (int i = 1; i <= n; i++) {
            atm[i] = Integer.parseInt(reader.readLine());
        }

        input = reader.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        isRes = new boolean[n + 1];
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(e -> isRes[e] = true);

        findScc();
        setSccInfo();
        sccBfs();

        for (int i = 1; i <= n; i++) {
            if (isRes[i]) {
                max = Math.max(max, dp[sccNum[i]]);
            }
        }
        System.out.println(max);
    }

    private static void sccBfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sccNum[start]);
        dp[sccNum[start]] = totalAtm[sccNum[start]];

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer next : sccList.get(current)) {
                if (dp[next] < dp[current] + totalAtm[next]) {
                    dp[next] = dp[current] + totalAtm[next];
                    queue.add(next);
                }
            }
        }
    }

    private static void setSccInfo() {
        totalAtm = new int[sccIndex + 1];
        sccList = new ArrayList<>();
        dp = new int[sccIndex + 1];
        for (int i = 0; i <= sccIndex; i++) {
            sccList.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            totalAtm[sccNum[i]] += atm[i];
            for (Integer next : list.get(i)) {
                if (sccNum[i] != sccNum[next]) {
                    sccList.get(sccNum[i]).add(sccNum[next]);
                }
            }
        }
    }

    private static void findScc() {
        index = 0;
        discover = new int[n + 1];
        finished = new boolean[n + 1];
        stack = new Stack<>();
        sccIndex = 0;
        sccNum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (discover[i] == 0) {
                dfs(i);
            }
        }
    }

    private static int dfs(int current) {
        discover[current] = ++index;
        stack.push(current);

        int parent = discover[current];
        for (Integer next : list.get(current)) {
            if (discover[next] == 0) {
                parent = Math.min(dfs(next), parent);
            } else if (!finished[next]) {
                parent = Math.min(discover[next], parent);
            }
        }

        if (parent == discover[current]) {
            while (true) {
                int top = stack.pop();
                finished[top] = true;
                sccNum[top] = sccIndex + 1;
                if (top == current) {
                    break;
                }
            }
            sccIndex++;
        }
        return parent;
    }
}