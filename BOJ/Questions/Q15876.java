//Question No: 15876
//Title: Binary Counting
//Tier: Silver V
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPeople = scanner.nextInt();
        int targetPerson = scanner.nextInt();

        int currentNumber = 0;
        int binarySize = 1;
        int currentTemp;
        int count = 0;
        int currentOrder = 1;
        int sequencePosition = 0;

        while (count != 5) {
            currentTemp = currentNumber;
            while (currentNumber / (int) Math.pow(2, binarySize) >= 1) {
                binarySize++;
            }

            int[] binaryRepresentation = new int[binarySize];

            for (int i = binarySize - 1; i >= 0; i--) {
                if (currentTemp % 2 == 1) {
                    binaryRepresentation[i] = 1;
                } else {
                    binaryRepresentation[i] = 0;
                }
                currentTemp /= 2;
            }

            for (int i = 0; i < binarySize; i++) {
                if (currentOrder == totalPeople * sequencePosition + targetPerson) {
                    System.out.print(binaryRepresentation[i] + " ");
                    count++;
                    if (count == 5) break;
                }
                if (currentOrder == sequencePosition * totalPeople + totalPeople) {
                    sequencePosition++;
                }
                currentOrder++;
            }

            currentNumber++;
        }

        scanner.close();
    }
}