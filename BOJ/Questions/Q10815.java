//Question No: 10815
//Title: 숫자 카드
//Tier: Silver V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer cardTokens = new StringTokenizer(reader.readLine());
        HashSet<Integer> cardSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            cardSet.add(Integer.parseInt(cardTokens.nextToken()));
        }

        int m = Integer.parseInt(reader.readLine());
        StringTokenizer checkTokens = new StringTokenizer(reader.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int check = Integer.parseInt(checkTokens.nextToken());
            if (cardSet.contains(check)) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }

        System.out.println(result.toString().trim());
    }
}