//Question No: 4811
//Title: 알약
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[][] pillCombinations = new double[31][31];
        for (int halfPills = 1; halfPills <= 30; halfPills++) {
            pillCombinations[0][halfPills] = 1;
        }

        for (int wholePills = 1; wholePills <= 30; wholePills++) {
            for (int halfPills = 0; halfPills < 30; halfPills++) {
                if (halfPills == 0) {
                    pillCombinations[wholePills][halfPills] = pillCombinations[wholePills - 1][halfPills + 1];
                } else {
                    pillCombinations[wholePills][halfPills] = pillCombinations[wholePills][halfPills - 1]
                            + pillCombinations[wholePills - 1][halfPills + 1];
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (true) {
            int pills = Integer.parseInt(reader.readLine());
            if (pills == 0) break;
            result.append(String.format("%.0f", pillCombinations[pills][0])).append('\n');
        }

        System.out.print(result);
    }
}