//Question No: 2493
//Title: 탑
//Tier: Gold V
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower {
    int index;
    int height;

    Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        int towerCount = Integer.parseInt(reader.readLine());

        Stack<Tower> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= towerCount; i++) {
            int height = Integer.parseInt(tokenizer.nextToken());

            if (stack.isEmpty()) {
                result.append("0 ");
                stack.push(new Tower(i, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        result.append("0 ");
                        stack.push(new Tower(i, height));
                        break;
                    }

                    Tower top = stack.peek();

                    if (top.height > height) {
                        result.append(top.index).append(" ");
                        stack.push(new Tower(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        writer.write(result.toString() + "\n");
        writer.flush();
        writer.close();
        reader.close();
    }
}
