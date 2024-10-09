//Question No: 19538
//Title: 루머
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int totalNodes, initialRumorSpreaders;
    static ArrayList<Integer>[] adjacencyList;
    static Queue<Integer> rumorQueue;
    static int[] rumorTimes;
    static int[] neighborCount;

    public static void main(String[] args) throws Exception {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder resultBuilder = new StringBuilder();

        totalNodes = Integer.parseInt(inputReader.readLine());
        adjacencyList = new ArrayList[totalNodes + 1];
        rumorTimes = new int[totalNodes + 1];
        neighborCount = new int[totalNodes + 1];

        for (int i = 1; i <= totalNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
            rumorTimes[i] = -1;
        }

        for (int i = 1; i <= totalNodes; i++) {
            tokenizer = new StringTokenizer(inputReader.readLine());
            while (true) {
                int neighbor = Integer.parseInt(tokenizer.nextToken());
                if (neighbor == 0) break;
                adjacencyList[i].add(neighbor);
            }
        }

        initialRumorSpreaders = Integer.parseInt(inputReader.readLine());
        rumorQueue = new LinkedList<>();
        tokenizer = new StringTokenizer(inputReader.readLine());

        for (int i = 0; i < initialRumorSpreaders; i++) {
            int node = Integer.parseInt(tokenizer.nextToken());
            rumorTimes[node] = 0;
            rumorQueue.add(node);
        }

        spreadRumor();

        for (int i = 1; i <= totalNodes; i++) {
            resultBuilder.append(rumorTimes[i]);
            if (i != totalNodes) resultBuilder.append(" ");
        }
        System.out.printf("%s", resultBuilder.toString());
    }

    public static void spreadRumor() {
        while (!rumorQueue.isEmpty()) {
            int currentNode = rumorQueue.poll();

            for (int nextNode : adjacencyList[currentNode]) {
                neighborCount[nextNode]++;
                if (rumorTimes[nextNode] == -1 && (adjacencyList[nextNode].size() + 1) / 2 <= neighborCount[nextNode]) {
                    rumorQueue.add(nextNode);
                    rumorTimes[nextNode] = rumorTimes[currentNode] + 1;
                }
            }
        }
    }
}