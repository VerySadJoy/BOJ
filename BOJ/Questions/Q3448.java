//Question No: 3448
//Title: 문자 인식
//Tier: Bronze I
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int R = 0, A = 0;
            String line;
            boolean endOfCase = false;

            while (!endOfCase) {
                line = br.readLine();
                if (line == null || line.isEmpty()) {
                    endOfCase = true;
                } else {
                    for (char c : line.toCharArray()) {
                        A++;
                        if (c != '#') {
                            R++;
                        }
                    }
                }
            }

            double accuracy = (A > 0) ? (R / (double) A) * 100 : 0;
            accuracy = Math.round(accuracy * 10) / 10.0;

            if (accuracy % 1 == 0) {
                sb.append(String.format("Efficiency ratio is %.0f%%.\n", accuracy));
            } else {
                sb.append(String.format("Efficiency ratio is %.1f%%.\n", accuracy));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}