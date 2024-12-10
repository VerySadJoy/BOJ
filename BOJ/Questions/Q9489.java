//Question No: 9489
//Title: 사촌
//Tier: Gold IV
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokenizer;

    static int N, K, kIndex;
    static int[] array, parent;

    public static void main(String[] args) throws IOException {
        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            K = Integer.parseInt(tokenizer.nextToken());

            if (N == 0 && K == 0) break;

            array = new int[N + 1];
            parent = new int[N + 1];
            
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 1; i <= N; i++) {
                array[i] = Integer.parseInt(tokenizer.nextToken());
                if (array[i] == K) kIndex = i;
            }

            solution();
        }
    }

    static void solution() {
        int answer = 0;
        parent[0] = -1;
        parent[1] = 0;

        int index = 1;
        for (int i = 2; i <= N; i++) {
            parent[i] = index;
            if (i < N && array[i + 1] != array[i] + 1) index++;
        }

        for (int i = 1; i <= N; i++) {
            if (parent[parent[i]] == parent[parent[kIndex]] && parent[i] != parent[kIndex]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}