//Question No: 3665
//Title: 최종 순위
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int time = 1; time <= T; time++) {
            int N = Integer.parseInt(reader.readLine());
            int[] inDegree = new int[N + 1];
            int[] array = new int[N + 1];

            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 1; i <= N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 1; i <= N; i++) {
                int from = array[i];
                for (int j = i + 1; j <= N; j++) {
                    list.get(from).add(array[j]);
                    inDegree[array[j]]++;
                }
            }

            int M = Integer.parseInt(reader.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(reader.readLine());
                int front = Integer.parseInt(st.nextToken());
                int back = Integer.parseInt(st.nextToken());

                if (list.get(front).contains(back)) {
                    list.get(front).remove((Integer) back);
                    list.get(back).add(front);
                    inDegree[front]++;
                    inDegree[back]--;
                } else {
                    list.get(back).remove((Integer) front);
                    list.get(front).add(back);
                    inDegree[back]++;
                    inDegree[front]--;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            StringBuilder resultBuilder = new StringBuilder();
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    cnt++;
                    queue.add(i);
                }
            }

            if (cnt > 1) {
                output.append("?\n");
                continue;
            }

            boolean isFinished = false;
            for (int i = 1; i <= N; i++) {
                if (queue.isEmpty()) {
                    output.append("IMPOSSIBLE\n");
                    isFinished = true;
                    break;
                }

                int from = queue.poll();
                resultBuilder.append(from).append(" ");

                for (int to : list.get(from)) {
                    inDegree[to]--;
                    if (inDegree[to] == 0) {
                        queue.add(to);
                    }
                }
            }

            if (!isFinished) {
                output.append(resultBuilder.toString().trim()).append("\n");
            }
        }

        System.out.print(output);
    }
}