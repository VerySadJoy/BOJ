//Question No: 13360
//Title: Game Rank
//Tier: Silver III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String matchSequence = scanner.nextLine().trim();
        int rank = 25;
        int stars = 0;
        int winStreak = 0;

        int[] starsNeeded = new int[26];
        for (int i = 21; i <= 25; i++) starsNeeded[i] = 2;
        for (int i = 16; i <= 20; i++) starsNeeded[i] = 3;
        for (int i = 11; i <= 15; i++) starsNeeded[i] = 4;
        for (int i = 1; i <= 10; i++) starsNeeded[i] = 5;

        for (char game : matchSequence.toCharArray()) {
            if (game == 'W') {
                winStreak++;
                stars++;
                
                if (rank >= 6 && rank <= 25 && winStreak >= 3) {
                    stars++;
                }

                if (stars > starsNeeded[rank]) {
                    stars -= starsNeeded[rank];
                    rank--;
                    if (rank == 0) {
                        System.out.println("Legend");
                        return;
                    }
                }
            } else {
                winStreak = 0;
                if (rank <= 20) {
                    if (stars > 0) {
                        stars--;
                    } else {
                        if (rank < 20) {
                            rank++;
                            stars = starsNeeded[rank] - 1;
                        }
                    }
                }
            }
        }
        System.out.println(rank);
        scanner.close();
    }
}
