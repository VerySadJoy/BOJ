//Question No: 3295
//Title: 단방향 링크 네트워크
//Tier: Platinum II
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int numNodes = Integer.parseInt(st.nextToken());
            int numEdges = Integer.parseInt(st.nextToken());

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < numNodes; i++) {
                adjList.add(new ArrayList<>());
            }
            int[] match = new int[numNodes];
            Arrays.fill(match, -1);

            for (int i = 0; i < numEdges; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList.get(from).add(to);
            }

            boolean[] visited = new boolean[numNodes];
            long answer = 0;

            for (int node = 0; node < numNodes; node++) {
                Arrays.fill(visited, false);
                if (canMatch(node, adjList, match, visited)) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    private static boolean canMatch(int node, List<List<Integer>> adjList, int[] match, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (match[neighbor] == -1 || (!visited[match[neighbor]] && canMatch(match[neighbor], adjList, match, visited))) {
                match[neighbor] = node;
                return true;
            }
        }
        return false;
    }
}
