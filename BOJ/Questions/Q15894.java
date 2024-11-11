//Question No: 15894
//Title: 수학은 체육과목 입니다
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long schoolCount = Long.parseLong(reader.readLine());
        System.out.print(4 * schoolCount);
    }
}