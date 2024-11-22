//Question No: 16427
//Title: Time Limits
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numberOfJudges = Integer.parseInt(tokenizer.nextToken());
        int multiplier = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int maxTime = 1;

        while (numberOfJudges-- > 0) {
            int currentTime = Integer.parseInt(tokenizer.nextToken());
            maxTime = Math.max(maxTime, currentTime);
        }

        int result = (int) Math.ceil(maxTime * multiplier / 1000.0);
        writer.write(result + "\n");
        writer.flush();
        writer.close();
    }
}