//Question No: 25314
//Title: 코딩은 체육과목 입니다
//Tier: Bronze V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(reader.readLine());
        int repeatCount = inputNumber / 4;

        for (int i = 0; i < repeatCount; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}