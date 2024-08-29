//Question No: 10867
//Title: 중복 빼고 정렬하기
//Tier: Silver V
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();

        HashSet<Integer> uniqueNumbers = new HashSet<>();

        for (int i = 0; i < numberOfElements; i++) {
            uniqueNumbers.add(scanner.nextInt());
        }

        ArrayList<Integer> sortedList = new ArrayList<>(uniqueNumbers);
        Collections.sort(sortedList);

        StringBuilder resultBuilder = new StringBuilder();
        for (int number : sortedList) {
            resultBuilder.append(number).append(" ");
        }
        System.out.println(resultBuilder.toString());
    }
}