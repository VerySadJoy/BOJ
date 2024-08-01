//Question No: 6615
//Title: 콜라츠 추측
//Tier: Silver III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Long, Integer> stepsMap = new HashMap<>();
    static StringBuilder resultBuilder = new StringBuilder();

    static int stepsA, stepsB;
    static long meetingPoint;

    private static void calculateSteps(long number) {
        int steps = 0;
        while (true) {
            Integer previousSteps = stepsMap.put(number, steps);
            if (previousSteps != null) {
                stepsA = previousSteps;
                stepsB = steps;
                meetingPoint = number;
                return;
            }
            if (number == 1) return;
            number = (number % 2 == 0) ? number / 2 : number * 3 + 1;
            steps++;
        }
    }

    static void processNumbers(long numA, long numB) {
        stepsMap.clear();
        calculateSteps(numA);
        calculateSteps(numB);
        resultBuilder.append(numA).append(" needs ").append(stepsA)
                .append(" steps, ").append(numB).append(" needs ")
                .append(stepsB).append(" steps, they meet at ")
                .append(meetingPoint).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        long numberA, numberB;
        while (true) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            numberA = Long.parseLong(tokenizer.nextToken());
            numberB = Long.parseLong(tokenizer.nextToken());
            if (numberA == 0) break;
            processNumbers(numberA, numberB);
        }
        reader.close();
        System.out.print(resultBuilder);
    }
}