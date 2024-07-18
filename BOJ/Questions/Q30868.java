//Question No: 30868
//Title: 개표
//Tier: Bronze IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N / 5; i++) {
                sb.append("++++ ");
            }
            for (int i = 0; i < N % 5; i++) {
                sb.append('|');
            }
            sb.append('\n');

            System.out.print(sb.toString());
        }
    }
}
