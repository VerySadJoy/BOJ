//Question No: 11266
//Title: 단절점
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int order = 1;
    static int[] visitOrder;
    static boolean[] isArticulationPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int verticesCount = Integer.parseInt(st.nextToken());
        int edgesCount = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= verticesCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edgesCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from);
        }

        visitOrder = new int[verticesCount + 1];
        isArticulationPoint = new boolean[verticesCount + 1];

        for (int i = 1; i <= verticesCount; i++) {
            if (visitOrder[i] == 0) {
                findArticulationPoints(i, true, adjacencyList);
            }
        }

        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= verticesCount; i++) {
            if (isArticulationPoint[i]) {
                count++;
            }
        }
        result.append(count).append("\n");

        for (int i = 1; i <= verticesCount; i++) {
            if (isArticulationPoint[i]) {
                result.append(i).append(" ");
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findArticulationPoints(int vertex, boolean isRoot, ArrayList<ArrayList<Integer>> adjacencyList) {
        visitOrder[vertex] = order++;
        int earliestVisit = visitOrder[vertex];
        int childrenCount = 0;

        for (int neighbor : adjacencyList.get(vertex)) {
            if (visitOrder[neighbor] == 0) {
                childrenCount++;
                int lowestVisit = findArticulationPoints(neighbor, false, adjacencyList);
                if (!isRoot && lowestVisit >= visitOrder[vertex]) {
                    isArticulationPoint[vertex] = true;
                }
                earliestVisit = Math.min(earliestVisit, lowestVisit);
            } else {
                earliestVisit = Math.min(earliestVisit, visitOrder[neighbor]);
            }
        }

        if (isRoot && childrenCount >= 2) {
            isArticulationPoint[vertex] = true;
        }

        return earliestVisit;
    }
}
