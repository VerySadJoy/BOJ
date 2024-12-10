//Question No: 25312
//Title: 200% Mixed Juice!
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int juiceCount = Integer.parseInt(tokenizer.nextToken());
        long targetVolume = Long.parseLong(tokenizer.nextToken());

        int[][] juices = new int[juiceCount][2];

        for (int i = 0; i < juiceCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            juices[i][0] = Integer.parseInt(tokenizer.nextToken());
            juices[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(juices, (a, b) -> 
            Double.compare((double) b[1] / b[0], (double) a[1] / a[0])
        );

        long totalVolume = 0;
        long numerator = 0, denominator = 1;

        for (int[] juice : juices) {
            if (totalVolume + juice[0] <= targetVolume) {
                totalVolume += juice[0];
                numerator += juice[1];
            } else {
                long remainingVolume = targetVolume - totalVolume;
                denominator = juice[0];
                numerator = numerator * denominator + juice[1] * remainingVolume;

                long gcd = gcd(numerator, denominator);
                numerator /= gcd;
                denominator /= gcd;
                break;
            }
        }

        System.out.println(numerator + "/" + denominator);
    }
}