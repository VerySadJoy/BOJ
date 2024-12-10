//Question No: 14676
//Title: 영우는 사기꾼?
//Tier: Gold III
import java.io.*;
import java.util.*;

public class Main {
    static int buildings, dependencies, commands;
    static int[] inDegree, buildCount;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Set<Integer>> blocked = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        buildings = Integer.parseInt(tokenizer.nextToken());
        dependencies = Integer.parseInt(tokenizer.nextToken());
        commands = Integer.parseInt(tokenizer.nextToken());

        inDegree = new int[buildings + 1];
        buildCount = new int[buildings + 1];

        for (int i = 0; i <= buildings; i++) {
            graph.add(new ArrayList<>());
            blocked.add(new HashSet<>());
        }

        for (int i = 0; i < dependencies; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            graph.get(from).add(to);
            inDegree[to]++;
        }

        for (int i = 0; i < commands; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int action = Integer.parseInt(tokenizer.nextToken());
            int building = Integer.parseInt(tokenizer.nextToken());

            if ((action == 1 && inDegree[building] > 0) || 
                (action == 2 && buildCount[building] == 0)) {
                System.out.println("Lier!");
                return;
            }

            if (action == 1) {
                buildCount[building]++;
                for (int next : graph.get(building)) {
                    if (blocked.get(next).add(building) && inDegree[next] > 0) {
                        inDegree[next]--;
                    }
                }
            } else {
                buildCount[building]--;
                if (buildCount[building] == 0) {
                    for (int next : graph.get(building)) {
                        blocked.get(next).clear();
                        inDegree[next]++;
                    }
                }
            }
        }
        System.out.println("King-God-Emperor");
    }
}