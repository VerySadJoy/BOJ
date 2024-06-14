//Question No: 2618
//Title: 경찰차
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int numberOfEvents, numberOfCars;
    static int[][] dp = new int[1002][1002];
    static int[][] eventPositions = new int[1002][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        numberOfEvents = Integer.parseInt(br.readLine());
        numberOfCars = Integer.parseInt(br.readLine());

        for(int i = 1; i <= numberOfCars; i++) {
            st = new StringTokenizer(br.readLine());
            eventPositions[i][0] = Integer.parseInt(st.nextToken());
            eventPositions[i][1] = Integer.parseInt(st.nextToken());
        }

        sb.append(solve(1, 0, 0)).append("\n");

        int firstCarIdx = 0;
        int secondCarIdx = 0;
        for(int i = 1; i <= numberOfCars; i++) {
            int firstCarDistance = distance(1, firstCarIdx, i);

            if(dp[firstCarIdx][secondCarIdx] - firstCarDistance == dp[i][secondCarIdx]) {
                firstCarIdx = i;
                sb.append(1).append("\n");
            } else {
                secondCarIdx = i;
                sb.append(2).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int solve(int eventIdx, int firstCarIdx, int secondCarIdx) {
        if(eventIdx > numberOfCars) {
            return 0;
        }

        if(dp[firstCarIdx][secondCarIdx] != 0) {
            return dp[firstCarIdx][secondCarIdx];
        }

        int moveFirstCar = solve(eventIdx + 1, eventIdx, secondCarIdx) + distance(1, firstCarIdx, eventIdx);
        int moveSecondCar = solve(eventIdx + 1, firstCarIdx, eventIdx) + distance(2, secondCarIdx, eventIdx);

        return dp[firstCarIdx][secondCarIdx] = Math.min(moveFirstCar, moveSecondCar);
    }

    static int distance(int carType, int startIdx, int endIdx) {
        int[] startPosition = getStartPosition(carType, startIdx);
        return Math.abs(startPosition[0] - eventPositions[endIdx][0]) +
                Math.abs(startPosition[1] - eventPositions[endIdx][1]);
    }

    static int[] getStartPosition(int carType, int idx) {
        if(idx == 0) {
            if(carType == 1) {
                return new int[]{1, 1};
            }
            return new int[]{numberOfEvents, numberOfEvents};
        }
        return eventPositions[idx];
    }
}
