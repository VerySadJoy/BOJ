//Question No: 24724
//Title: 현대모비스와 함께하는 부품 관리
//Tier: Bronze III
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println("Material Management " + i);
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
            }

            System.out.println("Classification ---- End!");
        }
    }
}