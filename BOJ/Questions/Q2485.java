//Question No: 2485
//Title: 가로수
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int treeCount = Integer.parseInt(reader.readLine());
        int[] treePositions = new int[treeCount];

        for (int i = 0; i < treeCount; i++) {
            treePositions[i] = Integer.parseInt(reader.readLine());
        }
        reader.close();

        int gcdValue = 0;
        for (int i = 0; i < treeCount - 1; i++) {
            int spacing = treePositions[i + 1] - treePositions[i];
            gcdValue = calculateGCD(spacing, gcdValue);
        }

        int additionalTrees = (treePositions[treeCount - 1] - treePositions[0]) / gcdValue + 1 - treeCount;
        writer.write(String.valueOf(additionalTrees));
        writer.flush();
        writer.close();
    }

    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}