//Question No: 18769
//Title: 그리드 네트워크
//Tier: Gold IV
import java.util.*;

public class Main {
    static class Info {
        int start, end, cost;

        Info(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int T, R, C;
    static ArrayList<Info> edge;
    static int[] parent;
    static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        while (T-- > 0) {
            R = scanner.nextInt();
            C = scanner.nextInt();
            init();
            
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C - 1; j++) {
                    int cost = scanner.nextInt();
                    int start = (i * C) + j;
                    int end = (i * C) + j + 1;
                    edge.add(new Info(start, end, cost));
                }
            }

            for (int i = 0; i < R - 1; i++) {
                for (int j = 0; j < C; j++) {
                    int cost = scanner.nextInt();
                    int start = (i * C) + j;
                    int end = ((i + 1) * C) + j;
                    edge.add(new Info(start, end, cost));
                }
            }

            Collections.sort(edge, new Comparator<Info>() {
                @Override
                public int compare(Info a, Info b) {
                    return a.cost - b.cost;
                }
            });

            settings();
            findAnswer();
        }
    }

    static void init() {
        parent = new int[R * C];
        for (int i = 0; i < R * C; i++) {
            parent[i] = i;
        }
        edge = new ArrayList<>();
        answer = 0;
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    static void settings() {
        for (Info info : edge) {
            int start = info.start;
            int end = info.end;
            int cost = info.cost;
            if (find(start) != find(end)) {
                union(start, end);
                answer += cost;
            }
        }
    }

    static void findAnswer() {
        System.out.println(answer);
    }
}
