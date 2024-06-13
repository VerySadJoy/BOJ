//Question No: 13116
//Title: 30번
//Tier: Silver IV
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ArrayList<Integer> powersOfTwoA = new ArrayList<>();
            ArrayList<Integer> powersOfTwoB = new ArrayList<>();
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            while (a > 0) {
                powersOfTwoA.add(a);
                a /= 2;
            }
            while (b > 0) {
                powersOfTwoB.add(b);
                b /= 2;
            }
            Collections.sort(powersOfTwoA);
            Collections.sort(powersOfTwoB);
            int answer = 1;
            for (int i = 0; i < powersOfTwoA.size(); i++)
                if (powersOfTwoA.get(i).equals(powersOfTwoB.get(i))) answer = powersOfTwoA.get(i);
            System.out.println(answer * 10);
        }
    }
}
