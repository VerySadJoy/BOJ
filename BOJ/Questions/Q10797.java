//Question No: 10797
//Title: 10부제
//Tier: Bronze IV
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int targetNumber = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int occurrenceCount = 0;
        
        while (tokenizer.hasMoreTokens()) {
            if (targetNumber == Integer.parseInt(tokenizer.nextToken())) {
                occurrenceCount++;
            }
        }
        
        System.out.print(occurrenceCount);
    }
}