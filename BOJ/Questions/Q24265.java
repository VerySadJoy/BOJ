//Question No: 24265
//Title: 알고리즘 수업 - 알고리즘의 수행 시간 4
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        
        StringBuilder output = new StringBuilder();
        output.append((n * (n - 1)) / 2).append("\n").append(2);
        
        System.out.println(output);
    }
}