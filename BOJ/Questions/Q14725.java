//Question No: 14725
//Title: 개미굴
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();

        TrieNode() { }

        public void insert(String path) {
            TrieNode currentNode = this;
            String[] directories = path.split(",");
            for (String dir : directories) {
                currentNode.children.putIfAbsent(dir, new TrieNode());
                currentNode = currentNode.children.get(dir);
            }
        }

        public void print(TrieNode currentNode, int depth) {
            if (currentNode.children != null) {
                List<String> keys = new ArrayList<>(currentNode.children.keySet());
                Collections.sort(keys);
                for (String key : keys) {
                    for (int i = 0; i < depth; i++) {
                        System.out.print("--");
                    }
                    System.out.println(key);
                    print(currentNode.children.get(key), depth + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        TrieNode trie = new TrieNode();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            int k = Integer.parseInt(input[0]);

            StringBuilder pathBuilder = new StringBuilder();
            for (int j = 1; j <= k; j++) {
                pathBuilder.append(input[j]).append(",");
            }
            
            trie.insert(pathBuilder.toString());
        }
        
        trie.print(trie, 0);
    }
}
