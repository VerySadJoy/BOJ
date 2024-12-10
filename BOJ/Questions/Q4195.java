//Question No: 4195
//Title: 친구 네트워크
//Tier: Gold II
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] level;

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        while (testCases-- > 0) {
            int friendCount = Integer.parseInt(reader.readLine());
            parent = new int[friendCount * 2];
            level = new int[friendCount * 2];

            for (int i = 0; i < friendCount * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            int index = 0;
            Map<String, Integer> nameMap = new HashMap<>();

            for (int i = 0; i < friendCount; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                String friend1 = tokenizer.nextToken();
                String friend2 = tokenizer.nextToken();

                if (!nameMap.containsKey(friend1)) {
                    nameMap.put(friend1, index++);
                }

                if (!nameMap.containsKey(friend2)) {
                    nameMap.put(friend2, index++);
                }

                result.append(union(nameMap.get(friend1), nameMap.get(friend2))).append("\n");
            }
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public static int union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            parent[root2] = root1;
            level[root1] += level[root2];
            level[root2] = 1;
        }

        return level[root1];
    }
}