//Question No: 2262
//Title: 토너먼트 만들기
//Tier: Gold IV
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numElements = scanner.nextInt();
        ArrayList<Integer> elements = new ArrayList<>(numElements);

        for (int i = 0; i < numElements; i++) {
            elements.add(scanner.nextInt());
        }

        int totalSum = 0;

        while (elements.size() > 1) {
            int maxIndex = elements.indexOf(Collections.max(elements));
            int leftNeighbor = (maxIndex - 1 >= 0) ? elements.get(maxIndex - 1) : 0;
            int rightNeighbor = (maxIndex + 1 < elements.size()) ? elements.get(maxIndex + 1) : 0;

            totalSum += elements.get(maxIndex) - Math.max(leftNeighbor, rightNeighbor);

            elements.remove(maxIndex);
        }

        System.out.println(totalSum);
    }
}
