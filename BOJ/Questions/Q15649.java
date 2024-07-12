//Question No: 15649
//Title: N과 M (1)
//Tier: Silver III
import java.util.Scanner;

public class Main {

    public static int[] sequence;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        sequence = new int[M];
        visited = new boolean[N];
        
        generateSequences(N, M, 0);
    }

    public static void generateSequences(int N, int M, int depth) {
        if (depth == M) {
            for (int value : sequence) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i + 1;
                generateSequences(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
