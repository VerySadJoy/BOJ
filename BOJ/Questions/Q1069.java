//Question No: 1069
//Title: 집으로
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
        int xCoordinate = Integer.parseInt(tokenizer.nextToken());
        int yCoordinate = Integer.parseInt(tokenizer.nextToken());
        int jumpDistance = Integer.parseInt(tokenizer.nextToken());
        int jumpTime = Integer.parseInt(tokenizer.nextToken());
        inputReader.close();

        double distance = Math.sqrt(xCoordinate * xCoordinate + yCoordinate * yCoordinate);
        double walkTime, jumpAndWalkTime, jumpOneMoreTime;

        walkTime = distance;
        if (distance >= jumpDistance) {
            int jumpCount = (int) (distance / jumpDistance);
            jumpAndWalkTime = (jumpTime * jumpCount) + (distance - (jumpDistance * jumpCount));
            jumpOneMoreTime = jumpTime * (jumpCount + 1);
        } else {
            jumpAndWalkTime = jumpTime + (jumpDistance - distance);
            jumpOneMoreTime = jumpTime * 2;
        }

        System.out.println(Math.min(walkTime, Math.min(jumpAndWalkTime, jumpOneMoreTime)));
    }
}