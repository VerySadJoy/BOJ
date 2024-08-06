//Question No: 2525
//Title: 오븐 시계
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int addedMinutes = scanner.nextInt();

        hour += addedMinutes / 60;
        minute += addedMinutes % 60;
        
        if (minute >= 60) {
            hour += 1;
            minute -= 60;
        }
        if (hour >= 24) {
            hour -= 24;
        }
        
        System.out.println(hour + " " + minute);
    }
}