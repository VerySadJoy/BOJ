//Question No: 13300
//Title: 방 배정
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numberOfStudents = Integer.parseInt(tokenizer.nextToken());
        int roomCapacity = Integer.parseInt(tokenizer.nextToken());
        int[][] rooms = new int[2][7];
        int roomCount = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int gender = Integer.parseInt(tokenizer.nextToken());
            int grade = Integer.parseInt(tokenizer.nextToken());
            rooms[gender][grade]++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                roomCount += rooms[i][j] / roomCapacity;
                if (rooms[i][j] % roomCapacity != 0) {
                    roomCount++;
                }
            }
        }
        System.out.print(roomCount);
    }
}