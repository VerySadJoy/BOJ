//Question No: 1193
//Title: 분수찾기
//Tier: Silver V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(reader.readLine());

        int diagonalCount = 1;
        int previousSum = 0;

        while (true) {
            if (inputNumber <= previousSum + diagonalCount) {
                if (diagonalCount % 2 == 1) {
                    int numerator = diagonalCount - (inputNumber - previousSum - 1);
                    int denominator = inputNumber - previousSum;
                    System.out.print(numerator + "/" + denominator);
                } else {
                    int numerator = inputNumber - previousSum;
                    int denominator = diagonalCount - (inputNumber - previousSum - 1);
                    System.out.print(numerator + "/" + denominator);
                }
                break;
            } else {
                previousSum += diagonalCount;
                diagonalCount++;
            }
        }
    }
}