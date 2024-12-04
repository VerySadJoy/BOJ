//Question No: 2110
//Title: 공유기 설치
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static int[] housePositions;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int numberOfHouses = Integer.parseInt(tokenizer.nextToken());
        int numberOfRouters = Integer.parseInt(tokenizer.nextToken());
        
        housePositions = new int[numberOfHouses];
        
        for (int i = 0; i < numberOfHouses; i++) {
            housePositions[i] = Integer.parseInt(reader.readLine());
        }
        
        Arrays.sort(housePositions);
        
        int minDistance = 1;
        int maxDistance = housePositions[numberOfHouses - 1] - housePositions[0] + 1;
        
        while (minDistance < maxDistance) {
            int midDistance = (minDistance + maxDistance) / 2;
            
            if (calculateRouterCount(midDistance) < numberOfRouters) {
                maxDistance = midDistance;
            } else {
                minDistance = midDistance + 1;
            }
        }
        
        System.out.println(minDistance - 1);
    }
    
    private static int calculateRouterCount(int distance) {
        int routerCount = 1;
        int lastInstalledPosition = housePositions[0];
        
        for (int i = 1; i < housePositions.length; i++) {
            if (housePositions[i] - lastInstalledPosition >= distance) {
                routerCount++;
                lastInstalledPosition = housePositions[i];
            }
        }
        
        return routerCount;
    }
}