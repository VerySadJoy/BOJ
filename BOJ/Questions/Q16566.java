//Question No: 16566
//Title: 카드 게임
//Tier: Platinum V
import java.io.*;
import java.util.*;
public class Main {
    static int[] g;
    static int find(int x){
        if (g[x] == x) return x;
        return g[x] = find(g[x]);
    }
    static boolean union(int x, int y){
        int a = find(x);
        int b = find(y);
        if (a == b) return false;
        else if (a > b)
            g[b] = a;
        else
            g[a] = b;
        return true;
    }
    static int binarySearch(int[] arr, int num){
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (num >= arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        g = new int[M + 1];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
            g[i] = i;
        }
        g[M] = M;
        Arrays.sort(arr);
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++){
            int num = Integer.parseInt(token.nextToken());
            int index = binarySearch(arr, num);
            index = find(index);
            sb.append(arr[index] + "\n");
            union(index, index + 1);
        }
        System.out.print(sb);
    }
}

