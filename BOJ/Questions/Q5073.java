//Question No: 5073
//Title: 삼각형과 세 변
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] sides = new int[3];
        
        while (true) {
            StringTokenizer tokens = new StringTokenizer(reader.readLine());
            sides[0] = Integer.parseInt(tokens.nextToken());
            sides[1] = Integer.parseInt(tokens.nextToken());
            sides[2] = Integer.parseInt(tokens.nextToken());

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) break;

            Arrays.sort(sides);

            if (sides[2] >= sides[0] + sides[1]) {
                System.out.println("Invalid");
            } else if (sides[0] == sides[1] && sides[1] == sides[2]) {
                System.out.println("Equilateral");
            } else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}