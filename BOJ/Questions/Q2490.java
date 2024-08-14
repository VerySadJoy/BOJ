//Question No: 2490
//Title: 윷놀이
//Tier: Bronze III
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] results = {"D", "C", "B", "A", "E"};
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            int total = 0;
            while (tokens.hasMoreTokens()) {
                total += Integer.parseInt(tokens.nextToken());
            }
            output.append(results[total]).append("\n");
        }
        System.out.print(output);
    }
}