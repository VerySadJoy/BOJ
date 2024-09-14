//Question No: 18251
//Title: 내 생각에 A번인 단순 dfs 문제가 이 대회에서 E번이 되어버린 건에 관하여 (Easy)
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int calculateK(int number) {
        int k = 1;
        while ((number /= 2) != 1) {
            k++;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 17);
        int totalNodes = Integer.parseInt(reader.readLine()) + 1;
        int depthLevels = calculateK(totalNodes);
        int[] values = new int[totalNodes];
        ArrayList<Integer>[] nodeDepths = new ArrayList[depthLevels];

        for (int i = 0; i < depthLevels; i++) {
            nodeDepths[i] = new ArrayList<>(1 << i);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, totalNodes / 2});
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            nodeDepths[currentNode[0]].add(currentNode[1]);
            values[currentNode[1]] = Integer.parseInt(tokenizer.nextToken());

            if (currentNode[0] == depthLevels - 1) continue;

            queue.add(new int[]{currentNode[0] + 1, currentNode[1] - (1 << (depthLevels - 2 - currentNode[0]))});
            queue.add(new int[]{currentNode[0] + 1, currentNode[1] + (1 << (depthLevels - 2 - currentNode[0]))});
        }

        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < depthLevels; i++) {
            for (int j = i; j < depthLevels; j++) {
                HashSet<Integer> selectedNodes = new HashSet<>();
                for (int depth = i; depth <= j; depth++) {
                    ArrayList<Integer> depthList = nodeDepths[depth];
                    for (int node : depthList) {
                        selectedNodes.add(node);
                    }
                }

                long currentSum = 0;
                for (int x = 1; x < totalNodes; x++) {
                    if (!selectedNodes.contains(x)) continue;
                    currentSum += values[x];
                    if (currentSum > maxSum) maxSum = currentSum;
                    if (currentSum < 0) {
                        currentSum = 0;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}