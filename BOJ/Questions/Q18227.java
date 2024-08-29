//Question No: 18227
//Title: 성대나라의 물탱크
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int nodeCount = 0;
    static int[] startTimes, endTimes, depths;
    static boolean[] visited;
    static List<Integer>[] adjacencyList;
    static StringBuilder resultBuilder = new StringBuilder();

    static void dfs(int currentNode, int depth) {
        visited[currentNode] = true;
        startTimes[currentNode] = ++nodeCount;
        depths[currentNode] = depth;
        for (int neighbor : adjacencyList[currentNode]) {
            if (!visited[neighbor]) {
                dfs(neighbor, depth + 1);
            }
        }
        endTimes[currentNode] = nodeCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numberOfNodes = Integer.parseInt(tokenizer.nextToken());
        int rootNode = Integer.parseInt(tokenizer.nextToken());
        startTimes = new int[numberOfNodes + 1];
        endTimes = new int[numberOfNodes + 1];
        depths = new int[numberOfNodes + 1];
        visited = new boolean[numberOfNodes + 1];
        adjacencyList = new ArrayList[numberOfNodes + 1];
        SegmentTree segmentTree = new SegmentTree(numberOfNodes);
        
        for (int i = 1; i <= numberOfNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < numberOfNodes; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            adjacencyList[x].add(y);
            adjacencyList[y].add(x);
        }
        
        dfs(rootNode, 1);
        
        int numberOfQueries = Integer.parseInt(reader.readLine());
        for (int q = 0; q < numberOfQueries; q++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int operation = Integer.parseInt(tokenizer.nextToken());
            int node = Integer.parseInt(tokenizer.nextToken());
            if (operation == 1) {
                segmentTree.update(1, 1, numberOfNodes, startTimes[node]);
            } else {
                long queryResult = (long) segmentTree.query(1, 1, numberOfNodes, startTimes[node], endTimes[node]) * depths[node];
                resultBuilder.append(queryResult).append('\n');
            }
        }
        
        System.out.print(resultBuilder);
    }
}

class SegmentTree {
    int[] segmentTree;

    SegmentTree(int numberOfNodes) {
        segmentTree = new int[(numberOfNodes + 1) * 4];
    }

    int update(int index, int start, int end, int position) {
        if (end < position || position < start) {
            return segmentTree[index];
        }
        if (start == end) {
            return segmentTree[index] += 1;
        }
        int mid = (start + end) >> 1;
        return segmentTree[index] = update(index << 1, start, mid, position) + update(index << 1 | 1, mid + 1, end, position);
    }

    int query(int index, int start, int end, int queryStart, int queryEnd) {
        if (queryEnd < start || end < queryStart) {
            return 0;
        }
        if (queryStart <= start && end <= queryEnd) {
            return segmentTree[index];
        }
        int mid = (start + end) >> 1;
        return query(index << 1, start, mid, queryStart, queryEnd) + query(index << 1 | 1, mid + 1, end, queryStart, queryEnd);
    }
}