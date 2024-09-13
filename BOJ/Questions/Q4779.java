//Question No: 4779
//Title: 칸토어 집합
//Tier: Silver III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int power;
    static StringBuilder result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        while ((input = bufferedReader.readLine()) != null) {
            power = Integer.parseInt(input);
            result = new StringBuilder();
            int length = (int) Math.pow(3, power);

            for (int i = 0; i < length; i++) {
                result.append("-");
            }
            
            generateCantorSet(0, length);
            System.out.println(result);
        }
    }

    public static void generateCantorSet(int startIndex, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;

        for (int i = startIndex + newSize; i < startIndex + 2 * newSize; i++) {
            result.setCharAt(i, ' ');
        }

        generateCantorSet(startIndex, newSize);
        generateCantorSet(startIndex + 2 * newSize, newSize);
    }
}