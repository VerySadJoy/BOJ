//Question No: 10101
//Title: 삼각형 외우기
//Tier: Bronze IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int angleA = Integer.parseInt(reader.readLine());
        int angleB = Integer.parseInt(reader.readLine());
        int angleC = Integer.parseInt(reader.readLine());
        
        int angleSum = angleA + angleB + angleC;
        
        if (angleSum != 180) {
            System.out.print("Error");
        } else if (angleA == 60 && angleB == 60 && angleC == 60) {
            System.out.print("Equilateral");
        } else if (angleA == angleB || angleB == angleC || angleC == angleA) {
            System.out.print("Isosceles");
        } else {
            System.out.print("Scalene");
        }
    }
}