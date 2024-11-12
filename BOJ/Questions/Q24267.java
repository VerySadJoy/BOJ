//Question No: 24267
//Title: 알고리즘 수업 - 알고리즘의 수행 시간 6
//Tier: Bronze II
import java.io.*;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        reader.close();
        
        long combinationCount = (n * (n - 1) * (n - 2)) / 6;
        StringBuilder output = new StringBuilder();
        output.append(combinationCount).append("\n").append(3);
        
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(output.toString());
        writer.flush();
        writer.close();
    }
}