//Question No: 2450
//Title: 모양 정돈
//Tier: Gold II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static final int LIMIT = 100005;
    static int totalElements, result = LIMIT * 2;
    static int[] array = new int[LIMIT], sortedArray = new int[LIMIT];
    static int[] count = new int[4], order = new int[4], checked = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        totalElements = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < totalElements; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
            count[array[i]]++;
        }

        performDFS(1);
        System.out.println(result);
    }

    static int calculateSwaps() {
        int index = 0;
        int[][] positions = new int[4][4];
        int swaps1 = 0, swaps2 = 0;

        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < count[order[i]]; j++) {
                sortedArray[index++] = order[i];
            }
        }

        for (int i = 0; i < totalElements; i++) {
            positions[sortedArray[i]][array[i]]++;
        }

        for (int i = 1; i < 3; i++) {
            for (int j = i + 1; j <= 3; j++) {
                int minSwaps = Math.min(positions[i][j], positions[j][i]);
                swaps1 += minSwaps;
                swaps2 += positions[i][j] + positions[j][i] - (minSwaps * 2);
            }
        }

        return swaps1 + (swaps2 / 3) * 2;
    }

    static void performDFS(int step) {
        if (step > 3) {
            result = Math.min(result, calculateSwaps());
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (checked[i] == 1) continue;
            checked[i] = 1;
            order[step] = i;
            performDFS(step + 1);
            checked[i] = 0;
        }
    }
}