//Question No: 1717
//Title: 집합의 표현
//Tier: Gold V
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numberOfElements = Integer.parseInt(tokenizer.nextToken());
        int numberOfOperations = Integer.parseInt(tokenizer.nextToken());

        parent = new int[numberOfElements + 1];
        for (int i = 1; i <= numberOfElements; i++) {
            parent[i] = i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberOfOperations; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int operation = Integer.parseInt(tokenizer.nextToken());
            int element1 = Integer.parseInt(tokenizer.nextToken());
            int element2 = Integer.parseInt(tokenizer.nextToken());

            if (operation == 0) {
                union(element1, element2);
            } else if (operation == 1) {
                result.append((isSameParent(element1, element2) ? "YES" : "NO")).append("\n");
            }
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int find(int element) {
        if (element == parent[element]) {
            return element;
        }
        return parent[element] = find(parent[element]);
    }

    public static void union(int element1, int element2) {
        int root1 = find(element1);
        int root2 = find(element2);

        if (root1 != root2) {
            if (root1 < root2) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
            }
        }
    }

    public static boolean isSameParent(int element1, int element2) {
        return find(element1) == find(element2);
    }
}