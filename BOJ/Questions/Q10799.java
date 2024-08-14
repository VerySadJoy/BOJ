//Question No: 10799
//Title: 쇠막대기
//Tier: Silver II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pipeSequence = br.readLine();
        Stack<Character> pipeStack = new Stack<>();
        int totalPipes = 0;
        for(int i = 0; i < pipeSequence.length(); i++) {
            if (pipeSequence.charAt(i) == '(') {
                pipeStack.push('(');
            } else if (pipeSequence.charAt(i) == ')') {
                pipeStack.pop();
                if (pipeSequence.charAt(i - 1) == '(') {
                    totalPipes += pipeStack.size();
                } else {
                    totalPipes++;
                }
            }
        }
        System.out.println(totalPipes);
    }
}