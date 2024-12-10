//Question No: 9372
//Title: 상근이의 여행
//Tier: Silver IV
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine());

        while (testCases-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int nodes = Integer.parseInt(tokenizer.nextToken());
            int edges = Integer.parseInt(tokenizer.nextToken());

            for (int i = 0; i < edges; i++) {
                reader.readLine();
            }

            result.append(nodes - 1).append("\n");
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}