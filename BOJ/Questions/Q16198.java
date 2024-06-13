//Question No: 16198
//Title: 에너지 모으기
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static List<Integer> numList;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }

        dfs(n, 0);
        System.out.println(max);
    }

    public static void dfs(int length, int sum) {
        if (length == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < length - 1; i++) {
            int energy = numList.get(i - 1) * numList.get(i + 1);
            int removedMarble = numList.remove(i);
            dfs(length - 1, sum + energy);
            numList.add(i, removedMarble);
        }
    }
}
