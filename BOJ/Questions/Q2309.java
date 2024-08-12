//Question No: 2309
//Title: 일곱 난쟁이
//Tier: Bronze I
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> dwarfs = new ArrayList<>();
    static List<Integer> selectedDwarfs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            dwarfs.add(scanner.nextInt());
        }
        findDwarfs(0, 0);
    }

    public static void findDwarfs(int depth, int start) {
        if (depth == 7) {
            int sum = selectedDwarfs.stream().mapToInt(Integer::intValue).sum();
            if (sum == 100) {
                selectedDwarfs.stream().sorted().forEach(System.out::println);
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < dwarfs.size(); i++) {
            selectedDwarfs.add(dwarfs.get(i));
            findDwarfs(depth + 1, i + 1);
            selectedDwarfs.remove(selectedDwarfs.size() - 1);
        }
    }
}