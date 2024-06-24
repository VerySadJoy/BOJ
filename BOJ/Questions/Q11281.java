//Question No: 11281
//Title: 2-SAT - 4
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    static int numVariables, sccCount, dfsIndex;
    static ArrayList<ArrayList<Integer>> graph, sccList;
    static int[] discoveryTime, sccId, assignment;
    static boolean[] isVisited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        numVariables = Integer.parseInt(tokenizer.nextToken());
        int numClauses = Integer.parseInt(tokenizer.nextToken());

        discoveryTime = new int[2 * numVariables + 1];
        sccId = new int[2 * numVariables + 1];
        isVisited = new boolean[2 * numVariables + 1];
        stack = new Stack<>();
        dfsIndex = 0;
        sccCount = 0;
        assignment = new int[2 * numVariables + 1];
        Arrays.fill(assignment, -1);

        graph = new ArrayList<>();
        sccList = new ArrayList<>();
        for (int i = 0; i < 2 * numVariables + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (numClauses-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());

            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            graph.get(getIndex(-u)).add(getIndex(v));
            graph.get(getIndex(-v)).add(getIndex(u));
        }

        for (int i = 1; i < 2 * numVariables + 1; i++) {
            if (!isVisited[i]) {
                findSCCs(i);
            }
        }

        boolean isSatisfiable = true;
        for (int i = 1; i <= numVariables; i++) {
            if (sccId[i] == sccId[i + numVariables]) {
                isSatisfiable = false;
                break;
            }
        }

        writer.write(isSatisfiable ? "1\n" : "0\n");
        if (isSatisfiable) {
            writer.write(getAssignment() + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    private static int getIndex(int variable) {
        return (0 < variable && variable <= numVariables) ? variable : -variable + numVariables;
    }

    private static String getAssignment() {
        for (int i = sccCount - 1; i >= 0; i--) {
            for (int variable : sccList.get(i)) {
                int absVariable = Math.abs(getIndex(variable));
                if (assignment[absVariable] == -1) {
                    assignment[absVariable] = variable > numVariables ? 1 : 0;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= numVariables; i++) {
            result.append(assignment[i]).append(' ');
        }
        return result.toString();
    }

    private static int findSCCs(int node) {
        discoveryTime[node] = ++dfsIndex;
        stack.push(node);

        int root = discoveryTime[node];
        for (int neighbor : graph.get(node)) {
            if (discoveryTime[neighbor] == 0) {
                root = Math.min(root, findSCCs(neighbor));
            } else if (!isVisited[neighbor]) {
                root = Math.min(root, discoveryTime[neighbor]);
            }
        }

        if (root == discoveryTime[node]) {
            ArrayList<Integer> scc = new ArrayList<>();
            while (!stack.isEmpty()) {
                int top = stack.pop();
                scc.add(top);
                isVisited[top] = true;
                sccId[top] = sccCount;

                if (top == node) {
                    break;
                }
            }
            sccCount++;
            sccList.add(scc);
        }
        return root;
    }
}
