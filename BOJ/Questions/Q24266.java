//Question No: 24266
//Title: 알고리즘 수업 - 알고리즘의 수행 시간 5
//Tier: Bronze III
import java.io.*;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(reader.readLine());
        reader.close();
        
        StringBuilder output = new StringBuilder();
        output.append(n * n * n).append("\n").append(3);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(output.toString());
        bw.flush();
        bw.close();
    }
}