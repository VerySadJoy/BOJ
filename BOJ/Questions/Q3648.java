//Question No: 3648
//Title: 아이돌
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {

    private static int contestantCount, judgesCount, nodeCount;
    private static ArrayList<Integer>[] adjList;
    private static int[] visitedOrder, sccLabel;
    private static boolean[] visited;
    private static Stack<Integer> stack;
    private static int order = 1, sccOrder = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        while (true) {
            String input = reader.readLine();
            if (input == null)
                break;
            tokenizer = new StringTokenizer(input, " ");

            contestantCount = Integer.parseInt(tokenizer.nextToken());
            judgesCount = Integer.parseInt(tokenizer.nextToken());
            nodeCount = (contestantCount * 2 + 1) * 2;

            visitedOrder = new int[nodeCount];
            sccLabel = new int[nodeCount];
            visited = new boolean[nodeCount];
            stack = new Stack<>();
            order = sccOrder = 1;

            adjList = new ArrayList[nodeCount];
            for (int i = 0; i < nodeCount; i++) {
                adjList[i] = new ArrayList<>();
            }
            adjList[validate(-1)].add(1);

            for (int i = 0; i < judgesCount; i++) {
                tokenizer = new StringTokenizer(reader.readLine(), " ");
                int u = Integer.parseInt(tokenizer.nextToken());
                int v = Integer.parseInt(tokenizer.nextToken());

                adjList[validate(-u)].add(validate(v));
                adjList[validate(-v)].add(validate(u));
            }

            for (int i = 1; i < nodeCount; i++) {
                if (!visited[i]) {
                    findSCC(i);
                }
            }

            writer.write(solve2SAT());
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    private static int validate(int n) {
        return (0 < n && n < contestantCount + 1) ? n : -n + contestantCount;
    }

    private static String solve2SAT() {
        for (int i = 1; i < contestantCount + 1; i++) {
            if (sccLabel[i] == sccLabel[i + contestantCount]) return "no\n";
        }
        return "yes\n";
    }

    private static int findSCC(int currentNode) {
        int minOrder = visitedOrder[currentNode] = order++;
        stack.push(currentNode);

        for (int nextNode : adjList[currentNode]) {
            if (visitedOrder[nextNode] == 0) {
                minOrder = Math.min(minOrder, findSCC(nextNode));
            } else if (!visited[nextNode]) {
                minOrder = Math.min(minOrder, visitedOrder[nextNode]);
            }
        }

        if (minOrder == visitedOrder[currentNode]) {
            int temp;
            while (true) {
                temp = stack.pop();
                sccLabel[temp] = sccOrder;
                visited[temp] = true;
                if (temp == currentNode) break;
            }
            sccOrder++;
        }

        return minOrder;
    }
}
