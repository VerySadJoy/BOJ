//Question No: 1977
//Title: 완전제곱수
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lowerBound = Integer.parseInt(reader.readLine());
        int upperBound = Integer.parseInt(reader.readLine());
        int minimumPerfectSquare = Integer.MAX_VALUE;
        int sumOfPerfectSquares = 0;

        for (int i = 1; i * i <= upperBound; i++) {
            int square = i * i;
            if (square >= lowerBound && square <= upperBound) {
                minimumPerfectSquare = Math.min(square, minimumPerfectSquare);
                sumOfPerfectSquares += square;
            }
        }

        if (sumOfPerfectSquares == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sumOfPerfectSquares);
            System.out.println(minimumPerfectSquare);
        }
    }
}