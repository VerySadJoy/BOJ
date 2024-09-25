//Question No: 1956
//Title: 운동
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static final int INFINITY = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in)); 
            BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
            
            int totalVertices = Integer.parseInt(tokenizer.nextToken());
            int totalEdges = Integer.parseInt(tokenizer.nextToken());
            
            int[][] distanceMatrix = new int[totalVertices + 1][totalVertices + 1];
            
            for (int i = 1; i <= totalVertices; i++) {
                for (int j = 1; j <= totalVertices; j++) {
                    if (i != j) {
                        distanceMatrix[i][j] = INFINITY;
                    }
                }
            }
            
            for (int i = 0; i < totalEdges; i++) {
                tokenizer = new StringTokenizer(inputReader.readLine());
                int vertexFrom = Integer.parseInt(tokenizer.nextToken());
                int vertexTo = Integer.parseInt(tokenizer.nextToken());
                int weight = Integer.parseInt(tokenizer.nextToken());
                
                distanceMatrix[vertexFrom][vertexTo] = weight;
            }
            
            for (int k = 1; k <= totalVertices; k++) {
                for (int i = 1; i <= totalVertices; i++) {
                    for (int j = 1; j <= totalVertices; j++) {
                        if (i == j) {
                            continue;
                        }
                        
                        if (distanceMatrix[i][j] > distanceMatrix[i][k] + distanceMatrix[k][j]) {
                            distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                        }
                    }
                }
            }
            
            int minimumCycleLength = INFINITY;
            for (int i = 1; i <= totalVertices; i++) {
                for (int j = 1; j <= totalVertices; j++) {
                    if (i == j) {
                        continue;
                    }
                    
                    if (distanceMatrix[i][j] != INFINITY && distanceMatrix[j][i] != INFINITY) {
                        minimumCycleLength = Math.min(minimumCycleLength, distanceMatrix[i][j] + distanceMatrix[j][i]);
                    }
                }
            }
            
            minimumCycleLength = (minimumCycleLength == INFINITY) ? -1 : minimumCycleLength;
            
            outputWriter.write(minimumCycleLength + "\n");
            outputWriter.flush();
        }
    }
}