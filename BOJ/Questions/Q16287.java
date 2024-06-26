//Question No: 16287
//Title: Parcel
//Tier: Platinum V
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetWeight = scanner.nextInt();
        int numItems = scanner.nextInt();
        int[] weights = new int[numItems];

        for (int i = 0; i < numItems; i++) {
            weights[i] = scanner.nextInt();
        }

        HashMap<Integer, int[]> weightPairs = new HashMap<>();

        for (int i = 0; i < numItems; i++) {
            for (int j = i + 1; j < numItems; j++) {
                int sum = weights[i] + weights[j];
                if (sum >= targetWeight) continue;
                
                if (!weightPairs.containsKey(sum)) {
                    weightPairs.put(sum, new int[]{i, j});
                }
            }
        }

        boolean found = false;

        for (int i = 0; i < numItems; i++) {
            for (int j = i + 1; j < numItems; j++) {
                int remainingWeight = targetWeight - (weights[i] + weights[j]);
                if (weights[i] + weights[j] < targetWeight && remainingWeight >= 2) {
                    if (weightPairs.containsKey(remainingWeight)) {
                        int[] indices = weightPairs.get(remainingWeight);
                        if (i != indices[0] && j != indices[1] && j != indices[0] && i != indices[1]) {
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (found) break;
        }

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
