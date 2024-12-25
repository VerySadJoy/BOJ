//Question No: 4196
//Title: 도미노
//Tier: Platinum IV
import java.io.*;
import java.util.*;

public class Main {
    static int size, num;
    static ArrayList<Integer>[] graph;
    static int[] order, sccArr;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int testCases = Integer.parseInt(reader.readLine());

        while (testCases-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());

            int nodes = Integer.parseInt(tokenizer.nextToken());
            int edges = Integer.parseInt(tokenizer.nextToken());

            graph = new ArrayList[nodes + 1];
            for (int i = 0; i <= nodes; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < edges; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int from = Integer.parseInt(tokenizer.nextToken());
                int to = Integer.parseInt(tokenizer.nextToken());
                graph[from].add(to);
            }

            sccArr = new int[nodes + 1];
            order = new int[nodes + 1];
            visited = new boolean[nodes + 1];
            size = num = 0;
            stack = new Stack<>();

            for (int i = 1; i <= nodes; i++) {
                if (order[i] == 0) {
                    computeSCC(i);
                }
            }

            boolean[] hasIndegree = new boolean[size];

            for (int i = 1; i <= nodes; i++) {
                for (int neighbor : graph[i]) {
                    if (sccArr[neighbor] != sccArr[i]) {
                        hasIndegree[sccArr[neighbor]] = true;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < size; i++) {
                if (!hasIndegree[i]) {
                    count++;
                }
            }
            writer.write(count + "\n");
        }
        writer.flush();
    }

    private static int computeSCC(int node) {
        order[node] = ++num;
        stack.push(node);
        int root = order[node];

        for (int neighbor : graph[node]) {
            if (order[neighbor] == 0) {
                root = Math.min(root, computeSCC(neighbor));
            } else if (!visited[neighbor]) {
                root = Math.min(root, order[neighbor]);
            }
        }

        if (root == order[node]) {
            while (true) {
                int top = stack.pop();
                sccArr[top] = size;
                visited[top] = true;
                if (top == node) {
                    break;
                }
            }
            size++;
        }
        return root;
    }
}