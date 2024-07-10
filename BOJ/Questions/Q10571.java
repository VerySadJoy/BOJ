//Question No: 10571
//Title: 다이아몬드
//Tier: Silver I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Diamond {
    double weight;
    double clarity;

    Diamond(double weight, double clarity) {
        this.weight = weight;
        this.clarity = clarity;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            Diamond[] diamonds = new Diamond[n];
            int[] dp = new int[n];
            int maxLength = -1;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                double weight = Double.parseDouble(st.nextToken());
                double clarity = Double.parseDouble(st.nextToken());
                diamonds[i] = new Diamond(weight, clarity);
            }

            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (diamonds[i].weight > diamonds[j].weight && diamonds[i].clarity < diamonds[j].clarity) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }

            System.out.println(maxLength);
        }
    }
}
