//Question No: 1002
//Title: 터렛
//Tier: Silver III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCaseCount = scanner.nextInt();
        
        for (int i = 0; i < testCaseCount; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int radius1 = scanner.nextInt();
            
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int radius2 = scanner.nextInt();
            
            System.out.println(determineIntersectionCount(x1, y1, radius1, x2, y2, radius2));
        }
    }
    
    private static int determineIntersectionCount(int x1, int y1, int radius1, int x2, int y2, int radius2) {
        double distanceBetweenCenters = calculateDistance(x1, y1, x2, y2);
        int radiusSum = radius1 + radius2;
        int radiusDiff = Math.abs(radius1 - radius2);
        
        if (distanceBetweenCenters == 0 && radius1 == radius2) {
            return -1;
        } else if (distanceBetweenCenters < radiusDiff || distanceBetweenCenters > radiusSum) {
            return 0;
        } else if (distanceBetweenCenters == radiusDiff || distanceBetweenCenters == radiusSum) {
            return 1;
        } else {
            return 2;
        }
    }
    
    private static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
