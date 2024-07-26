//Question No: 5575
//Title: 타임 카드
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) {
            int startHour = scanner.nextInt();
            int startMinute = scanner.nextInt();
            int startSecond = scanner.nextInt();
            int endHour = scanner.nextInt();
            int endMinute = scanner.nextInt();
            int endSecond = scanner.nextInt();
            
            int startTimeInSeconds = (startHour * 3600) + (startMinute * 60) + startSecond;
            int endTimeInSeconds = (endHour * 3600) + (endMinute * 60) + endSecond;
            int durationInSeconds = endTimeInSeconds - startTimeInSeconds;
            
            int hours = durationInSeconds / 3600;
            int minutes = (durationInSeconds % 3600) / 60;
            int seconds = (durationInSeconds % 3600) % 60;
            
            System.out.println(hours + " " + minutes + " " + seconds);
        }
    }
}