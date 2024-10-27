//Question No: 1013
//Title: Contact
//Tier: Gold V
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = "(100+1+|01)+";
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            if (input.matches(pattern)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}