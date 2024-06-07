//Question No: 1725
//Title: 히스토그램
//Tier: Platinum V
import java.io.*;
import java.util.Stack;

public class Main {

    static int numBuildings;
    static int[] buildingHeights;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numBuildings = Integer.parseInt(reader.readLine());
        buildingHeights = new int[numBuildings + 2];
        for (int i = 1; i < numBuildings + 1; i++) {
            buildingHeights[i] = Integer.parseInt(reader.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxArea = 0;
        for (int i = 1; i < numBuildings + 2; i++) {
            while (!stack.isEmpty()) {
                int topIndex = stack.peek();
                if (buildingHeights[topIndex] <= buildingHeights[i]) break;
                stack.pop();
                maxArea = Math.max(maxArea, buildingHeights[topIndex] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        System.out.println(maxArea);
    }
}
