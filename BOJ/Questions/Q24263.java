//Question No: 24263
//Title: 알고리즘 수업 - 알고리즘의 수행 시간 2
//Tier: Bronze IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();
        
        StringBuilder sb = new StringBuilder();
        sb.append(n).append("\n").append(1);

        System.out.println(sb);
    }
}