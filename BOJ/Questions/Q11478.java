//Question No: 11478
//Title: 서로 다른 부분 문자열의 개수
//Tier: Silver III
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputString = scanner.nextLine();
            Set<String> substringSet = new HashSet<>();
            
            for (int i = 0; i < inputString.length(); i++) {
                String temp = "";
                for (int j = i; j < inputString.length(); j++) {
                    temp += inputString.charAt(j);
                    substringSet.add(temp);
                }
            }
            
            System.out.println(substringSet.size());
        }
    }
}