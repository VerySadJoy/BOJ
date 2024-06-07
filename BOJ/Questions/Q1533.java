//Question No: 1533
//Title: 길의 개수
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    static final int MOD = 1000003;
    static ArrayList<ArrayList<Long>> mat = new ArrayList<>();
    static int N, s, e, T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 50; i++) {
            ArrayList<Long> row = new ArrayList<>();
            for (int j = 0; j < 50; j++) {
                row.add(0L);
            }
            mat.add(row);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 5; j++) {
                mat.get(i * 5 + j).set(i * 5 + j - 1, 1L);
            }
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char tmp = line.charAt(j);
                if (tmp != '0') {
                    mat.get(i * 5).set(j * 5 + (tmp - '0') - 1, 1L);
                }
            }
        }

        ArrayList<ArrayList<Long>> res = dac(mat, T);
        System.out.println(res.get(5 * (s - 1)).get(5 * (e - 1)));
    }

    static ArrayList<ArrayList<Long>> multiply(ArrayList<ArrayList<Long>> a, ArrayList<ArrayList<Long>> b) {
        ArrayList<ArrayList<Long>> vec = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ArrayList<Long> row = new ArrayList<>();
            for (int j = 0; j < 50; j++) {
                row.add(0L);
            }
            vec.add(row);
        }

        for (int i = 0; i < 5 * N; i++) {
            for (int j = 0; j < 5 * N; j++) {
                for (int k = 0; k < 5 * N; k++) {
                    vec.get(i).set(j, (vec.get(i).get(j) + a.get(i).get(k) * b.get(k).get(j)) % MOD);
                }
            }
        }
        return vec;
    }

    static ArrayList<ArrayList<Long>> dac(ArrayList<ArrayList<Long>> a, int n) {
        if (n == 1) {
            return a;
        }
        ArrayList<ArrayList<Long>> ret = dac(a, n / 2);
        ret = multiply(ret, ret);
        if (n % 2 == 1) {
            ret = multiply(ret, a);
        }
        return ret;
    }
}
