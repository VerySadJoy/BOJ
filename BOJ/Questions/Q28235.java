//Question No: 28235
//Title: 코드마스터 2023
//Tier: Bronze V
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String chant = scanner.nextLine();

        if (chant.equals("SONGDO")) {
            System.out.println("HIGHSCHOOL");
        } else if (chant.equals("CODE")) {
            System.out.println("MASTER");
        } else if (chant.equals("2023")) {
            System.out.println("0611");
        } else if (chant.equals("ALGORITHM")) {
            System.out.println("CONTEST");
        }
    }
}