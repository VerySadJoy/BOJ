//Question No: 14384
//Title: Revenge of the Pancakes (Large)
//Tier: Silver III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int minFlipsToSort(String S) {
        int flips = 0;
        char currentState = S.charAt(0);
        
        for (char pancake : S.toCharArray()) {
            if (pancake != currentState) {
                flips += 1;
                currentState = pancake;
            }
        }
        
        if (currentState == '-') {
            flips += 1;
        }
        
        return flips;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        
        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            String S = reader.readLine().trim();
            int minFlips = minFlipsToSort(S);
            System.out.println("Case #" + caseNumber + ": " + minFlips);
        }
    }
}
