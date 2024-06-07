//Question No: 28702
//Title: FizzBuzz
//Tier: Bronze I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        
        if (Character.isDigit(c.charAt(0))) {
            int x = Integer.parseInt(c) + 1;
            if (x % 3 == 0) {
                if (x % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else {
                    System.out.println("Fizz");
                }
            } else if (x % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(x);
            }
        } else if (Character.isDigit(b.charAt(0))) {
            int x = Integer.parseInt(b) + 2;
            if (x % 3 == 0) {
                if (x % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else {
                    System.out.println("Fizz");
                }
            } else if (x % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(x);
            }
        } else if (Character.isDigit(a.charAt(0))) {
            int x = Integer.parseInt(a) + 3;
            if (x % 3 == 0) {
                if (x % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else {
                    System.out.println("Fizz");
                }
            } else if (x % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(x);
            }
        }
        
        sc.close();
    }
}
