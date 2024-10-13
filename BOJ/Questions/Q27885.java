//Question No: 27885
//Title: 가희와 열리지 않는 건널목
//Tier: Bronze I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int SECONDS_IN_DAY = 86400;

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int carCount = Integer.parseInt(tokenizer.nextToken());
        int humanCount = Integer.parseInt(tokenizer.nextToken());

        ArrayList<Integer> timeList = new ArrayList<>();
        for (int i = 0; i < carCount + humanCount; i++) {
            String[] timeParts = reader.readLine().split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            int seconds = Integer.parseInt(timeParts[2]);
            timeList.add(hours * 3600 + minutes * 60 + seconds);
        }
        
        Collections.sort(timeList);

        int previousTime = -40;
        int totalPassingTime = 0;

        for (int currentTime : timeList) {
            int passingTime = (currentTime - previousTime >= 40) ? 40 : currentTime - previousTime;
            totalPassingTime += passingTime;
            previousTime = currentTime;
        }

        System.out.println(SECONDS_IN_DAY - totalPassingTime);
    }
}