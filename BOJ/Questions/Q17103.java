//Question No: 17103
//Title: 골드바흐 파티션
//Tier: Silver II
import java.io.*;

public class Main {
    static final int MAX = 1000000;
    static boolean[] isNotPrime = new boolean[MAX + 1];

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        generatePrimes();

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int number = Integer.parseInt(reader.readLine());
            int partitionCount = countGoldbachPartitions(number);

            writer.write(partitionCount + "\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    private static void generatePrimes() {
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    private static int countGoldbachPartitions(int number) {
        if (number % 2 != 0 || number <= 2) {
            return 0;
        }

        int partitionCount = 0;
        for (int i = 2; i <= number / 2; i++) {
            if (!isNotPrime[i] && !isNotPrime[number - i]) {
                partitionCount++;
            }
        }
        return partitionCount;
    }
}