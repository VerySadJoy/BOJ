//Question No: 3683
//Title: 고양이와 개
//Tier: Platinum II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final List<Integer>[] graph = new ArrayList[555];
    private static final int[][] arr = new int[555][3];
    private static int[] match;
    private static int[] visited;

    private static void initialize() {
        for (int i = 0; i < 555; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] row : arr) {
            Arrays.fill(row, 0);
        }
        Arrays.fill(match, -1);
    }

    private static int parseStringToInt(String s) {
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            result = result * 10 + s.charAt(i) - '0';
        }
        return result;
    }

    private static boolean depthFirstSearch(int v) {
        visited[v] = 1;
        for (int u : graph[v]) {
            if (visited[u] == 1) continue;
            visited[u] = 1;
            if (match[u] == -1 || depthFirstSearch(match[u])) {
                match[u] = v;
                return true;
            }
        }
        return false;
    }

    private static void solve(BufferedReader br) throws IOException {
        initialize();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cats = Integer.parseInt(st.nextToken());
        int dogs = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            if (first.charAt(0) == 'C') {
                arr[i][2] = 0;
            } else {
                arr[i][2] = 1;
                String temp = first;
                first = second;
                second = temp;
            }
            arr[i][0] = parseStringToInt(first);
            arr[i][1] = parseStringToInt(second);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (arr[i][2] == arr[j][2]) continue;
                if (arr[i][0] == arr[j][0] || arr[i][1] == arr[j][1]) {
                    if (arr[i][2] == 0) graph[i].add(j);
                    else graph[j].add(i);
                }
            }
        }

        int matches = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i][2] == 0) {
                Arrays.fill(visited, 0);
                if (depthFirstSearch(i)) {
                    matches++;
                }
            }
        }
        System.out.println(n - matches);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        match = new int[555];
        visited = new int[555];
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            solve(br);
        }
    }
}
