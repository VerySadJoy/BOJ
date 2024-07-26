//Question No: 5619
//Title: 세 번째
//Tier: Silver II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(reader.readLine().trim()));
        }

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int lenA = String.valueOf(a).length();
                int lenB = String.valueOf(b).length();
                if (lenA != lenB) {
                    return Integer.compare(lenA, lenB);
                } else {
                    return Integer.compare(a, b);
                }
            }
        });

        if (numbers.size() > 3) {
            numbers = numbers.subList(0, 4);
        }

        List<Integer> check = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                int num1 = numbers.get(i);
                int num2 = numbers.get(j);
                check.add(Integer.parseInt("" + num1 + num2));
                check.add(Integer.parseInt("" + num2 + num1));
            }
        }

        Collections.sort(check);
        System.out.println(check.get(2));
    }
}