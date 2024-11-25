//Question No: 12789
//Title: 도키도키 간식드리미
//Tier: Silver III
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int studentCount = Integer.parseInt(reader.readLine());
        int[] studentOrder = new int[studentCount];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < studentCount; i++) {
            studentOrder[i] = Integer.parseInt(tokenizer.nextToken());
        }

        reader.close();
        writer.write(determineOrder(studentOrder));
        writer.flush();
        writer.close();
    }

    static String determineOrder(int[] order) {
        int currentOrder = 1;
        Stack<Integer> tempStack = new Stack<>();

        for (int student : order) {
            if (student == currentOrder) {
                currentOrder++;
            } else {
                while (!tempStack.isEmpty() && tempStack.peek() == currentOrder) {
                    tempStack.pop();
                    currentOrder++;
                }
                tempStack.push(student);
            }
        }

        while (!tempStack.isEmpty() && tempStack.peek() == currentOrder) {
            tempStack.pop();
            currentOrder++;
        }

        return tempStack.isEmpty() ? "Nice" : "Sad";
    }
}