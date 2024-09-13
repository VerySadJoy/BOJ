//Question No: 5002
//Title: 도어맨
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxDifference = Integer.parseInt(reader.readLine());
        String input = reader.readLine();
        Queue<Character> waitingQueue = new LinkedList<>();
        int maleCount = 0;
        int femaleCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char person = input.charAt(i);

            if (!waitingQueue.isEmpty()) {
                char waitingPerson = waitingQueue.peek();

                if (waitingPerson == 'M') {
                    if (Math.abs((maleCount + 1) - femaleCount) <= maxDifference) {
                        maleCount++;
                        waitingQueue.poll();
                    }
                } else {
                    if (Math.abs(maleCount - (femaleCount + 1)) <= maxDifference) {
                        femaleCount++;
                        waitingQueue.poll();
                    }
                }
            }

            if (person == 'M') {
                if (Math.abs((maleCount + 1) - femaleCount) <= maxDifference) {
                    maleCount++;
                } else if (waitingQueue.isEmpty()) {
                    waitingQueue.add(person);
                } else {
                    break;
                }
            } else {
                if (Math.abs(maleCount - (femaleCount + 1)) <= maxDifference) {
                    femaleCount++;
                } else if (waitingQueue.isEmpty()) {
                    waitingQueue.add(person);
                } else {
                    break;
                }
            }
        }

        System.out.println(maleCount + femaleCount);
    }
}