//Question No: 17214
//Title: 다항 함수의 적분
//Tier: Gold IV
import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String equation = reader.readLine();
        StringBuilder answer = new StringBuilder();

        int start = 0, end = 0;

        if (equation.charAt(0) == '+' || equation.charAt(0) == '-') {
            answer.append(equation.charAt(0));
            start = 1;
            end = 1;
        }

        if (equation.startsWith("0", start)) {
            System.out.println("W");
            return;
        }

        while (end < equation.length()) {
            if (equation.charAt(end) == '+' || equation.charAt(end) == '-') {
                answer.append(integrate(equation.substring(start, end)));
                answer.append(equation.charAt(end));
                start = end + 1;
            }
            end++;
        }

        answer.append(integrate(equation.substring(start))).append("+W");
        System.out.println(answer.toString());
    }

    private static String integrate(String term) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : term.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int coefficientEnd = term.lastIndexOf('x');
        String coefficientStr = coefficientEnd == -1 ? term : term.substring(0, coefficientEnd);
        int coefficient = coefficientStr.isEmpty() ? 1 : Integer.parseInt(coefficientStr);

        int xPower = counter.getOrDefault('x', 0);
        int newCoefficient = coefficient / (xPower + 1);

        StringBuilder result = new StringBuilder();
        if (newCoefficient != 1) {
            result.append(newCoefficient);
        }
        result.append("x".repeat(xPower + 1));
        return result.toString();
    }
}