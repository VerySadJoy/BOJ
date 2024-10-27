//Question No: 1034
//Title: 램프
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int rows = Integer.parseInt(tokenizer.nextToken());
        int columns = Integer.parseInt(tokenizer.nextToken());

        int[] offLampCount = new int[rows];
        String[] lampStates = new String[rows];

        for (int i = 0; i < rows; i++) {
            String rowState = reader.readLine();
            int offCount = 0;
            for (int j = 0; j < columns; j++) {
                if (rowState.charAt(j) == '0') {
                    offCount++;
                }
            }
            offLampCount[i] = offCount;
            lampStates[i] = rowState;
        }

        int switchPresses = Integer.parseInt(reader.readLine());
        int maxRowsOn = 0;

        for (int i = 0; i < rows; i++) {
            if (offLampCount[i] <= switchPresses && (switchPresses - offLampCount[i]) % 2 == 0) {
                int identicalRows = 1;
                for (int j = 0; j < rows; j++) {
                    if (i == j) continue;
                    if (lampStates[i].equals(lampStates[j])) {
                        identicalRows++;
                    }
                }
                maxRowsOn = Math.max(maxRowsOn, identicalRows);
            }
        }

        System.out.println(maxRowsOn);
    }
}