//Question No: 11719
//Title: 그대로 출력하기 2
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            System.out.println(inputLine);
        }
    }
}