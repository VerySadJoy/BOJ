//Question No: 26266
//Title: 비즈네르 암호 해독
//Tier: Silver I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String plaintext = scanner.next();
        String password = scanner.next();

        int length = plaintext.length();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; ++i) {
            int diff = ((password.charAt(i) - plaintext.charAt(i) + 26) % 26);
            if (diff == 0) {
                result.append('Z');
            } else {
                result.append((char) (diff + 64));
            }
        }

        String encodedString = result.toString();

        for (int i = 1; i <= length / 2; ++i) {
            if (length % i != 0) {
                continue;
            }

            String repeatStr = encodedString.substring(0, i);
            StringBuilder repeated = new StringBuilder(length);

            while (repeated.length() != length) {
                repeated.append(repeatStr);
            }

            if (repeated.toString().equals(encodedString)) {
                System.out.println(repeatStr);
                return;
            }
        }

        System.out.println(encodedString);
    }
}