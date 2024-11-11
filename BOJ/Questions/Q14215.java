//Question No: 14215
//Title: 세 막대
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());

        int sideA = Integer.parseInt(tokens.nextToken());
        int sideB = Integer.parseInt(tokens.nextToken());
        int sideC = Integer.parseInt(tokens.nextToken());

        int largestSide = 0;
        if (sideA > sideB) {
            largestSide = (sideB > sideC) ? sideA : Math.max(sideA, sideC);
        } else {
            largestSide = Math.max(sideB, sideC);
        }

        int perimeter = sideA + sideB + sideC;
        if (perimeter - largestSide > largestSide) {
            System.out.println(perimeter);
        } else {
            System.out.print((perimeter - largestSide) * 2 - 1);
        }

        reader.close();
    }
}