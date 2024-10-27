//Question No: 23303
//Title: 이 문제는 D2 입니다.
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String result;

        if (input.contains("D2") || input.contains("d2")) {
            result = "D2";
        } else {
            result = "unrated";
        }

        System.out.println(result);
    }
}