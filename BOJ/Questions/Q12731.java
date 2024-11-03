//Question No: 12731
//Title: 열차 시간표(Small)
//Tier: Gold V
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public int calculateSingleTrainTrips(PriorityQueue<Integer> arrivalTimes, PriorityQueue<Integer> departureTimes) {
        int singleTrainCount = 0;
        while (!arrivalTimes.isEmpty() && !departureTimes.isEmpty()) {
            if (arrivalTimes.peek() <= departureTimes.peek()) {
                singleTrainCount++;
                arrivalTimes.poll();
                departureTimes.poll();
            } else {
                departureTimes.poll();
            }
        }
        return singleTrainCount;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();

        int caseCount = Integer.parseInt(reader.readLine());
        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            int turnaroundTime = Integer.parseInt(reader.readLine());

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int tripCountAtoB = Integer.parseInt(tokenizer.nextToken());
            int tripCountBtoA = Integer.parseInt(tokenizer.nextToken());

            PriorityQueue<Integer> aDepartureTimes = new PriorityQueue<>();
            PriorityQueue<Integer> aArrivalTimes = new PriorityQueue<>();
            PriorityQueue<Integer> bDepartureTimes = new PriorityQueue<>();
            PriorityQueue<Integer> bArrivalTimes = new PriorityQueue<>();

            for (int tripIndex = 0; tripIndex < tripCountAtoB + tripCountBtoA; tripIndex++) {
                tokenizer = new StringTokenizer(reader.readLine());
                String[] departureTime = tokenizer.nextToken().split(":");
                String[] arrivalTime = tokenizer.nextToken().split(":");

                int departureMinutes = Integer.parseInt(departureTime[0]) * 60 + Integer.parseInt(departureTime[1]);
                int arrivalMinutes = Integer.parseInt(arrivalTime[0]) * 60 + Integer.parseInt(arrivalTime[1]);

                if (tripIndex < tripCountAtoB) {
                    aDepartureTimes.add(departureMinutes);
                    aArrivalTimes.add(arrivalMinutes + turnaroundTime);
                } else {
                    bDepartureTimes.add(departureMinutes);
                    bArrivalTimes.add(arrivalMinutes + turnaroundTime);
                }
            }

            int trainsRequiredAtoB = main.calculateSingleTrainTrips(aArrivalTimes, bDepartureTimes);
            int trainsRequiredBtoA = main.calculateSingleTrainTrips(bArrivalTimes, aDepartureTimes);

            tripCountAtoB -= trainsRequiredBtoA;
            tripCountBtoA -= trainsRequiredAtoB;
            if (tripCountAtoB < 0) tripCountAtoB = 0;
            if (tripCountBtoA < 0) tripCountBtoA = 0;

            output.append("Case #").append(caseIndex).append(": ").append(tripCountAtoB).append(" ").append(tripCountBtoA).append("\n");
        }

        writer.write(output.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}