//Question No: 3977
//Title: 축구 전술
//Tier: Platinum IV
import java.io.*;
import java.util.*;

public class Main {
    static int sccTotal, num;
    static ArrayList<Integer>[] edges;
    static int[] order, sccArr;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            if (t != 0) {
                reader.readLine();
            }

            tokenizer = new StringTokenizer(reader.readLine());
            int nodes = Integer.parseInt(tokenizer.nextToken());
            int edgesCount = Integer.parseInt(tokenizer.nextToken());

            edges = new ArrayList[nodes + 1];
            for (int i = 0; i <= nodes; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < edgesCount; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int from = Integer.parseInt(tokenizer.nextToken());
                int to = Integer.parseInt(tokenizer.nextToken());
                edges[from].add(to);
            }

            sccArr = new int[nodes + 1];
            order = new int[nodes + 1];
            visited = new boolean[nodes + 1];
            sccTotal = num = 0;
            stack = new Stack<>();

            for (int i = 0; i < nodes; i++) {
                if (order[i] == 0) {
                    computeSCC(i);
                }
            }

            int[] indegree = new int[sccTotal];
            for (int i = 0; i < nodes; i++) {
                for (int neighbor : edges[i]) {
                    if (sccArr[neighbor] != sccArr[i]) {
                        indegree[sccArr[neighbor]]++;
                    }
                }
            }

            int count = 0, targetSCC = 0;
            for (int i = 0; i < sccTotal; i++) {
                if (indegree[i] == 0) {
                    targetSCC = i;
                    count++;
                }
            }

            if (count > 1) {
                writer.write("Confused\n");
            } else {
                for (int i = 0; i < nodes; i++) {
                    if (sccArr[i] == targetSCC) {
                        writer.write(i + "\n");
                    }
                }
            }
            writer.write("\n");
        }

        writer.flush();
    }

    private static int computeSCC(int index) {
        order[index] = ++num;
        stack.push(index);
        int root = order[index];

        for (int neighbor : edges[index]) {
            if (order[neighbor] == 0) {
                root = Math.min(root, computeSCC(neighbor));
            } else if (!visited[neighbor]) {
                root = Math.min(root, order[neighbor]);
            }
        }

        if (root == order[index]) {
            while (true) {
                int top = stack.pop();
                sccArr[top] = sccTotal;
                visited[top] = true;
                if (top == index) {
                    break;
                }
            }
            sccTotal++;
        }
        return root;
    }
}