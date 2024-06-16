//Question No: 5670
//Title: 휴대폰 자판
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        public void insert(String word) {
            TrieNode current = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                current.children.putIfAbsent(ch, new TrieNode());
                current = current.children.get(ch);
                if (i == word.length() - 1) {
                    current.isEndOfWord = true;
                }
            }
        }

        public int countValidPrefixes(String word) {
            TrieNode current = this;
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.children.get(ch);
                if (i == 0 || current.isEndOfWord || current.children.size() > 1) {
                    count++;
                }
                current = node;
            }
            return count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            try {
                int numWords = Integer.parseInt(line);
                List<String> words = new ArrayList<>();
                TrieNode trie = new TrieNode();

                for (int i = 0; i < numWords; i++) {
                    String word = br.readLine();
                    words.add(word);
                    trie.insert(word);
                }

                double totalModule = 0;
                for (String word : words) {
                    totalModule += trie.countValidPrefixes(word);
                }

                double averageModule = totalModule / numWords;
                System.out.println(String.format("%.2f", averageModule));
            } catch (NumberFormatException e) {
                return;
            }
        }
    }
}
