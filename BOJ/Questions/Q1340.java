//Question No: 1340
//Title: 연도 진행바
//Tier: Silver V
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int year = Integer.parseInt(input[2]);
        boolean isLeapYear = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));

        String month = input[0];
        int monthIndex = getMonthIndex(month);

        int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (isLeapYear) {
            daysInMonth[2] = 29;
        }

        int day = Integer.parseInt(input[1].replace(",", ""));
        int totalDays = calculateTotalDays(monthIndex, daysInMonth) + day;

        String[] time = input[3].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int totalMinutes = convertToMinutes(totalDays - 1, hour, minute);

        int minutesInYear = isLeapYear ? 366 * 24 * 60 : 365 * 24 * 60;
        double percentage = (double) totalMinutes * 100 / minutesInYear;

        System.out.printf("%0.9f\n", percentage);
    }

    private static int getMonthIndex(String month) {
        switch (month) {
            case "January": return 1;
            case "February": return 2;
            case "March": return 3;
            case "April": return 4;
            case "May": return 5;
            case "June": return 6;
            case "July": return 7;
            case "August": return 8;
            case "September": return 9;
            case "October": return 10;
            case "November": return 11;
            case "December": return 12;
            default: return 0;
        }
    }

    private static int calculateTotalDays(int monthIndex, int[] daysInMonth) {
        int totalDays = 0;
        for (int i = 1; i < monthIndex; i++) {
            totalDays += daysInMonth[i];
        }
        return totalDays;
    }

    private static int convertToMinutes(int days, int hour, int minute) {
        return days * 24 * 60 + hour * 60 + minute;
    }
}
