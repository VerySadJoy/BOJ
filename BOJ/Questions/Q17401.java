//Question No: 17401
//Title: 일하는 세포
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cycleTime, numNodes, totalDuration, INF = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        cycleTime = Integer.parseInt(tokenizer.nextToken());
        numNodes = Integer.parseInt(tokenizer.nextToken());
        totalDuration = Integer.parseInt(tokenizer.nextToken());
        int numCycles = totalDuration / cycleTime;
        int[][] cycleMatrix = new int[numNodes][numNodes];
        int[][] resultMatrix = new int[numNodes][numNodes];
        int[][] remainingMatrix = new int[numNodes][numNodes];
        int[][][] binMatrices = new int[31][numNodes][numNodes];

        for (int i = 0; i < numNodes; i++) remainingMatrix[i][i] = resultMatrix[i][i] = cycleMatrix[i][i] = 1;

        for (int t = 0; t < cycleTime; t++) {
            int numEdges = Integer.parseInt(reader.readLine());
            int[][] edgeMatrix = new int[numNodes][numNodes];
            for (int i = 0; i < numEdges; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int startNode = Integer.parseInt(tokenizer.nextToken());
                int endNode = Integer.parseInt(tokenizer.nextToken());
                int edgeCount = Integer.parseInt(tokenizer.nextToken());
                edgeMatrix[startNode - 1][endNode - 1] = edgeCount;
            }
            if (t < totalDuration % cycleTime) remainingMatrix = multiplyMatrices(remainingMatrix, edgeMatrix);
            cycleMatrix = multiplyMatrices(cycleMatrix, edgeMatrix);
        }
        binMatrices[0] = cycleMatrix;

        for (int i = 1; i < 31; i++) binMatrices[i] = (cycleMatrix = multiplyMatrices(cycleMatrix, cycleMatrix)).clone();

        for (int i = 30; i >= 0 && numCycles != 0; i--) {
            if (numCycles < (1 << i)) continue;
            numCycles -= 1 << i;
            resultMatrix = multiplyMatrices(resultMatrix, binMatrices[i]);
        }
        resultMatrix = multiplyMatrices(resultMatrix, remainingMatrix);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) result.append(resultMatrix[i][j]).append(" ");
            result.append("\n");
        }
        System.out.print(result);
    }

    static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[numNodes][numNodes];
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                for (int k = 0; k < numNodes; k++) {
                    result[i][j] += ((long) matrix1[i][k] * matrix2[k][j]) % INF;
                    result[i][j] %= INF;
                }
            }
        }
        return result;
    }
}
