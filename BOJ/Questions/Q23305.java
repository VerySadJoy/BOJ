//Question No: 23305
//Title: 수강변경
//Tier: Silver IV
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfElements = readInput();
        int[] frequencyArray = new int[1000001];
        
        for (int i = 0; i < numberOfElements; i++) {
            frequencyArray[readInput()]++;
        }

        int unmatchedCount = 0;
        while (numberOfElements-- > 0) {
            int currentValue = readInput();
            if (frequencyArray[currentValue] > 0) {
                frequencyArray[currentValue]--;
            } else {
                unmatchedCount++;
            }
        }

        writer.write(String.valueOf(unmatchedCount));
        writer.flush();
    }

    private static int readInput() throws IOException {
        int character, number = System.in.read() & 15;
        while ((character = System.in.read()) > 32) {
            number = (number << 3) + (number << 1) + (character & 15);
        }
        return number;
    }
}