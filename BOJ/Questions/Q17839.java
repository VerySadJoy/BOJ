//Question No: 17839
//Title: Baba is Rabbit
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {
    private static int index = 1;
    private static Map<String, Integer> nameToIndex = new HashMap<>();
    private static String[] indexToName = new String[200001];
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited = new boolean[200001];
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfRelations = Integer.parseInt(reader.readLine());

        for (int i = 0; i <= 200000; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < numberOfRelations; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String personA = tokenizer.nextToken();
            tokenizer.nextToken();
            String personB = tokenizer.nextToken();

            int indexA = getIndex(personA);
            int indexB = getIndex(personB);

            graph.get(indexA).add(indexB);
        }

        if (!nameToIndex.containsKey("Baba")) {
            return;
        }

        performBreadthFirstSearch();

        Collections.sort(result);
        for (String name : result) {
            System.out.println(name);
        }
    }

    private static int getIndex(String name) {
        if (!nameToIndex.containsKey(name)) {
            nameToIndex.put(name, index);
            indexToName[index] = name;
            return index++;
        }
        return nameToIndex.get(name);
    }

    private static void performBreadthFirstSearch() {
        Queue<Integer> queue = new LinkedList<>();
        int startNode = nameToIndex.get("Baba");
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    result.add(indexToName[neighbor]);
                    queue.add(neighbor);
                }
            }
        }
    }
}