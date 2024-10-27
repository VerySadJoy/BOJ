//Question No: 17828
//Title: 문자열 화폐
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputValues = reader.readLine().split(" ");

        int length = Integer.parseInt(inputValues[0]);
        int targetSum = Integer.parseInt(inputValues[1]);
        char[] resultArray = new char[length];

        for (int i = 0; i < length; i++) {
            resultArray[i] = 'A';
        }

        if (length > targetSum || 26 * length < targetSum) {
            System.out.println("!");
        } else {
            targetSum -= length;
            for (int i = length - 1; i >= 0; i--) {
                int increment = Math.min(targetSum, 25);
                resultArray[i] += increment;
                targetSum -= increment;
            }

            System.out.println(resultArray);
        }
    }
}