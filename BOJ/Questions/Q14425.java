//Question No: 14425
//Title: 문자열 집합
//Tier: Silver IV
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int totalWords = Integer.parseInt(tokenizer.nextToken());
        int testWords = Integer.parseInt(tokenizer.nextToken());
        
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < totalWords; i++) {
            wordMap.put(reader.readLine(), 0);
        }
        
        int matchingCount = 0;
        for (int i = 0; i < testWords; i++) {
            if (wordMap.containsKey(reader.readLine())) matchingCount++;
        }
        
        System.out.print(matchingCount);
    }
}