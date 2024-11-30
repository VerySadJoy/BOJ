//Question No: 20920
//Title: 영단어 암기는 괴로워
//Tier: Silver III
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int wordCount = Integer.parseInt(token.nextToken());
        int minWordLength = Integer.parseInt(token.nextToken());
        
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        
        for (int i = 0; i < wordCount; i++) {
            String word = reader.readLine();
            if (word.length() >= minWordLength) {
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        List<String> sortedWords = new ArrayList<>(wordFrequencyMap.keySet());
        sortedWords.sort((word1, word2) -> {
            int frequencyComparison = Integer.compare(wordFrequencyMap.get(word2), wordFrequencyMap.get(word1));
            if (frequencyComparison != 0) return frequencyComparison;
            
            int lengthComparison = Integer.compare(word2.length(), word1.length());
            if (lengthComparison != 0) return lengthComparison;
            
            return word1.compareTo(word2);
        });
        
        StringBuilder result = new StringBuilder();
        for (String word : sortedWords) {
            result.append(word).append("\n");
        }
        System.out.print(result);
    }
}