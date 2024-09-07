//Question No: 18232
//Title: 텔레포트 정거장
//Tier: Silver II
import java.util.*;

public class Main {
    static int numLocations, numTeleports, start, end;
    static List<List<Integer>> teleport;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numLocations = scanner.nextInt();
        numTeleports = scanner.nextInt();
        start = scanner.nextInt();
        end = scanner.nextInt();

        teleport = new ArrayList<>();
        for (int i = 0; i <= numLocations; i++) {
            teleport.add(new ArrayList<>());
        }

        visited = new boolean[numLocations + 1];

        for (int i = 0; i < numTeleports; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            teleport.get(x).add(y);
            teleport.get(y).add(x);
        }

        System.out.println(bfs(start));
    }

    public static int bfs(int startPoint) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPoint, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPosition = current[0];
            int currentDistance = current[1];

            if (currentPosition == end) {
                return currentDistance;
            }

            if (1 <= currentPosition && currentPosition <= numLocations) {
                if (!visited[currentPosition]) {
                    visited[currentPosition] = true;
                    queue.add(new int[]{currentPosition + 1, currentDistance + 1});
                    queue.add(new int[]{currentPosition - 1, currentDistance + 1});

                    if (!teleport.get(currentPosition).isEmpty()) {
                        for (int tele : teleport.get(currentPosition)) {
                            queue.add(new int[]{tele, currentDistance + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}