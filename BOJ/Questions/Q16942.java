//Question No: 16942
//Title: 문자열 접기
//Tier: Gold II
import java.io.*;

public class Main {

    static int max = 0;
    static boolean[] visit;
    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        visit = new boolean[input.length];

        for (int i = 0; i < input.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                recursion(i + 1, input[i], 1);
            }
        }
        System.out.println(max);
    }

    private static void recursion(int start, char target, int depth) {
        for (int i = start; i < input.length; i++) {
            if ((i - start) % 2 == 0 && input[i] == target && !visit[i]) {
                visit[i] = true;
                recursion(i + 1, target, depth + 1);
            }
        }
        max = Math.max(max, depth);
    }
}