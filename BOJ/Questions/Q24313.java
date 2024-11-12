//Question No: 24313
//Title: 알고리즘 수업 - 점근적 표기 1
//Tier: Silver V
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int a1 = Integer.parseInt(token.nextToken());
        int a0 = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(reader.readLine());
        int n0 = Integer.parseInt(reader.readLine());
        reader.close();

        writer.write((a1 * n0 + a0 <= c * n0 && c >= a1) ? "1" : "0");
        writer.flush();
        writer.close();
    }
}