//Question No: 13544
//Title: 수열과 쿼리 3
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] bit;
    private static int n;

    private static void update(int idx, int val) {
        while (idx <= n) {
            bit[idx].add(val);
            idx += idx & -idx;
        }
    }
    
    private static int getCountOfGreaterThan(ArrayList<Integer> list, int k) {
        int index = Collections.binarySearch(list, k + 1);
        if (index < 0) {
            index = -index - 1;
        }
        return list.size() - index;
    }

    private static int prefixSumOfCount(int idx, int k) {
        int count = 0;
        while (idx > 0) {
            count += getCountOfGreaterThan(bit[idx], k);
            idx -= idx & -idx;
        }
        return count;
    }

    private static int query(int i, int j, int k) {
        return prefixSumOfCount(j, k) - prefixSumOfCount(i - 1, k);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bit = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            bit[i] = new ArrayList<>();
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            update(i, Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(bit[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int lastAnswer = 0;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int i = a ^ lastAnswer;
            int j = b ^ lastAnswer;
            int k = c ^ lastAnswer;
            lastAnswer = query(i, j, k);
            sb.append(lastAnswer).append('\n');
        }
        System.out.print(sb);
    }
}