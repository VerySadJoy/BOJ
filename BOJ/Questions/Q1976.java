//Question No: 1976
//Title: 여행 가자
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int cityCount = Integer.parseInt(reader.readLine());
        int planCount = Integer.parseInt(reader.readLine());

        parent = new int[cityCount + 1];
        for (int i = 1; i <= cityCount; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= cityCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= cityCount; j++) {
                if (Integer.parseInt(tokenizer.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int startParent = find(Integer.parseInt(tokenizer.nextToken()));
        for (int i = 1; i < planCount; i++) {
            if (startParent != find(Integer.parseInt(tokenizer.nextToken()))) {
                writer.write("NO\n");
                writer.flush();
                writer.close();
                reader.close();
                return;
            }
        }

        writer.write("YES\n");
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

    public static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            if (root1 < root2) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
            }
        }
    }
}