//Question No: 25186
//Title: INFP 두람
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        long[] distances = new long[count];
        long totalSum = 0;

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            distances[i] = Long.parseLong(input[i]);
            totalSum += distances[i];
        }

        if (count == 1 && distances[0] == 1) {
            System.out.println("Happy");
            return;
        }

        boolean isHappy = true;
        for (int i = 0; i < count; i++) {
            if (totalSum - distances[i] < distances[i]) {
                isHappy = false;
                break;
            }
        }

        System.out.println(isHappy ? "Happy" : "Unhappy");
    }
}