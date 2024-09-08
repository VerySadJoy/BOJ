//Question No: 16367
//Title: TV Show Game
//Tier: Platinum II
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 10100;
    static int n, m;
    static int[] sccGroup;
    static List<Integer>[] adjList, reverseAdjList, sccList;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        sccGroup = new int[MAX];
        adjList = new ArrayList[MAX];
        reverseAdjList = new ArrayList[MAX];
        sccList = new ArrayList[MAX];
        visited = new boolean[MAX];
        stack = new Stack<>();

        for (int i = 1; i <= 2 * n; i++) {
            adjList[i] = new ArrayList<>();
            reverseAdjList[i] = new ArrayList<>();
            sccList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            char a = tokenizer.nextToken().charAt(0);
            int y = Integer.parseInt(tokenizer.nextToken());
            char b = tokenizer.nextToken().charAt(0);
            int z = Integer.parseInt(tokenizer.nextToken());
            char c = tokenizer.nextToken().charAt(0);

            if (a == 'B') x = negate(x);
            if (b == 'B') y = negate(y);
            if (c == 'B') z = negate(z);

            addEdges(x, y);
            addEdges(y, z);
            addEdges(z, x);
        }

        for (int i = 1; i <= 2 * n; i++) {
            if (!visited[i]) dfs(i);
        }

        int componentIndex = 0;
        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfsReverse(node, componentIndex++);
            }
        }

        boolean isValid = true;
        for (int i = 1; i <= n; i++) {
            if (sccGroup[i] == sccGroup[n + i]) {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            System.out.println("-1");
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                result.append(sccGroup[i] > sccGroup[n + i] ? 'R' : 'B');
            }
            System.out.println(result.toString());
        }
    }

    static int negate(int x) {
        if (x > n) return x - n;
        return x + n;
    }

    static void addEdges(int x, int y) {
        adjList[negate(x)].add(y);
        adjList[negate(y)].add(x);
        reverseAdjList[y].add(negate(x));
        reverseAdjList[x].add(negate(y));
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
        stack.push(node);
    }

    static void dfsReverse(int node, int componentIndex) {
        visited[node] = true;
        sccGroup[node] = componentIndex;
        for (int neighbor : reverseAdjList[node]) {
            if (!visited[neighbor]) {
                dfsReverse(neighbor, componentIndex);
            }
        }
    }
}