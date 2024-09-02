//Question No: 11051
//Title: 이항 계수 2
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static final int MODULO = 10007;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[][] triangle = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) { 
            for(int j = 0; j <= i; j++) { 
                if(i == j || j == 0) {
                    triangle[i][j] = 1; 
                } else {
                    triangle[i][j] = (triangle[i - 1][j - 1] + triangle[i - 1][j]) % MODULO; 
                }
            }
        }
        System.out.println(triangle[n][k]);
    }
}