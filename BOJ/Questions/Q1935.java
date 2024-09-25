//Question No: 1935
//Title: 후위 표기식2
//Tier: Silver III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String expression = reader.readLine();

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(reader.readLine());
        }

        Stack<Double> operands = new Stack<>();
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            char ch = expression.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                operands.push((double) values[ch - 'A']);
            } else {
                double operand1 = operands.pop();
                double operand2 = operands.pop();
                double result = 0.0;
                switch (ch) {
                    case '+':
                        result = operand2 + operand1;
                        break;
                    case '-':
                        result = operand2 - operand1;
                        break;
                    case '*':
                        result = operand2 * operand1;
                        break;
                    case '/':
                        result = operand2 / operand1;
                        break;
                }
                operands.push(result);
            }
        }
        System.out.printf("%.2f", operands.pop());
    }
}