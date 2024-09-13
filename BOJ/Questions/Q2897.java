//Question No: 2897
//Title: 몬스터 트럭
//Tier: Bronze I
import java.util.Scanner;

public class Main {

    static int[] countArray = new int[5];

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            String[] grid = new String[rows];
            
            for (int i = 0; i < rows; i++) {
                grid[i] = scanner.next();
            }
            
            for (int i = 0; i < rows - 1; i++) {
                for (int j = 0; j < cols - 1; j++) {
                    int dotCount = 0;
                    int wallCount = 0;
                    
                    if (grid[i].charAt(j) != '#' && grid[i + 1].charAt(j) != '#' && grid[i].charAt(j + 1) != '#' && grid[i + 1].charAt(j + 1) != '#') {
                        if (grid[i].charAt(j) == '.') {
                            dotCount++;
                        } else if (grid[i].charAt(j) == 'X') {
                            wallCount++;
                        }
                        
                        if (grid[i + 1].charAt(j) == '.') {
                            dotCount++;
                        } else if (grid[i + 1].charAt(j) == 'X') {
                            wallCount++;
                        }
                        
                        if (grid[i].charAt(j + 1) == '.') {
                            dotCount++;
                        } else if (grid[i].charAt(j + 1) == 'X') {
                            wallCount++;
                        }
                        
                        if (grid[i + 1].charAt(j + 1) == '.') {
                            dotCount++;
                        } else if (grid[i + 1].charAt(j + 1) == 'X') {
                            wallCount++;
                        }
                    }
                    
                    if (dotCount == 4) {
                        countArray[0]++;
                    } else if (wallCount == 1) {
                        countArray[1]++;
                    } else if (wallCount == 2) {
                        countArray[2]++;
                    } else if (wallCount == 3) {
                        countArray[3]++;
                    } else if (wallCount == 4) {
                        countArray[4]++;
                    }
                }
            }
            
            for (int count : countArray) {
                System.out.println(count);
            }
        }
    }
}