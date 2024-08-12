//Question No: 1924
//Title: 2007년
//Tier: Bronze I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int month = scanner.nextInt();
        int day = scanner.nextInt();

        for (int i = 1; i < month; i++) {
            day += daysOfMonth[i];
        }

        System.out.println(dayOfWeek[day % 7]);
    }
}