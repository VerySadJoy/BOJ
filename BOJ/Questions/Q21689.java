//Question No: 21869
//Title: Maximum Bishop
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        
        if (n > 1) {
            result.append(2 * n - 2).append("\n");
        } else {
            result.append(1).append("\n");
        }
        
        for (int i = 1; i <= n; i++) {
            result.append(i).append(" 1\n");
            if (i > 1 && i < n) {
                result.append(i).append(" ").append(n).append("\n");
            }
        }
        
        System.out.print(result.toString());
    }
}