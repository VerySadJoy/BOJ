//Question No: 1004
//Title: 어린 왕자
//Tier: Silver III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < testCases; i++) {
            String baseInput = scanner.nextLine();
            
            int xStart = Integer.parseInt(baseInput.split(" ")[0]);
            int yStart = Integer.parseInt(baseInput.split(" ")[1]);
            int xEnd = Integer.parseInt(baseInput.split(" ")[2]);
            int yEnd = Integer.parseInt(baseInput.split(" ")[3]);
            
            int passThroughCount = 0;
            int planetCount = scanner.nextInt();
            scanner.nextLine();
            
            for (int j = 0; j < planetCount; j++) {
                String planetInput = scanner.nextLine();
                
                int planetX = Integer.parseInt(planetInput.split(" ")[0]);
                int planetY = Integer.parseInt(planetInput.split(" ")[1]);
                int planetRadius = Integer.parseInt(planetInput.split(" ")[2]);
                
                boolean isStartInside = isPointInsideCircle(xStart, yStart, planetX, planetY, planetRadius);
                boolean isEndInside = isPointInsideCircle(xEnd, yEnd, planetX, planetY, planetRadius);
                
                if (!(isStartInside && isEndInside) && (isStartInside || isEndInside)) {
                    passThroughCount++;
                }
            }
            
            System.out.println(passThroughCount);
        }
        
        scanner.close();
    }

    private static boolean isPointInsideCircle(int pointX, int pointY, int centerX, int centerY, int radius) {
        return Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2)) < radius;
    }
}