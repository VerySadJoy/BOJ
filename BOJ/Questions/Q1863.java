//Question No: 1863
//Title: 스카이라인 쉬운거
//Tier: Gold IV
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Stack<Axis> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String[] temp = sc.nextLine().split(" ");
            Axis currentAxis = new Axis(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));

            while (!stack.isEmpty() && stack.peek().y > currentAxis.y) {
                Axis deleted = stack.pop();
                if (!stack.isEmpty() && stack.peek().y == deleted.y) continue;
                if (deleted.y == 0) continue;
                answer++;
            }
            stack.add(currentAxis);
        }

        while (!stack.isEmpty()) {
            Axis temp = stack.pop();
            if (!stack.isEmpty() && stack.peek().y == temp.y) continue;
            if (temp.y == 0) continue;
            answer++;
        }

        System.out.println(answer);
    }
}

class Axis {
    int x;
    int y;

    public Axis(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Axis [x=" + x + ", y=" + y + "]";
    }
}
