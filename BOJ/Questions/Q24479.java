//Question No: 24479
//Title: 알고리즘 수업 - 깊이 우선 탐색 1
//Tier: Silver II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer;
    static StringBuilder outputBuilder = new StringBuilder();
    
    static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
    static int[] visitOrder;
    static int visitCount;

    public static void main(String[] args) throws IOException {

        tokenizer = new StringTokenizer(inputReader.readLine());

        int totalVertices = Integer.parseInt(tokenizer.nextToken());
        int totalEdges = Integer.parseInt(tokenizer.nextToken());
        int startVertex = Integer.parseInt(tokenizer.nextToken());

        visitOrder = new int[totalVertices + 1];

        for(int i = 0; i < totalVertices + 1; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int i = 0; i < totalEdges; i++) {
            tokenizer = new StringTokenizer(inputReader.readLine());
            int vertexFrom = Integer.parseInt(tokenizer.nextToken());
            int vertexTo = Integer.parseInt(tokenizer.nextToken());

            adjacencyList.get(vertexFrom).add(vertexTo);
            adjacencyList.get(vertexTo).add(vertexFrom);
        }
		
        for(int i = 1; i < adjacencyList.size(); i++) {
            Collections.sort(adjacencyList.get(i));
        }

        visitCount = 1;
        
        dfs(startVertex);

        for(int i = 1; i < visitOrder.length; i++) {
            outputBuilder.append(visitOrder[i]).append("\n");
        }
        System.out.println(outputBuilder);
    }
    
    private static void dfs(int vertex) {
        visitOrder[vertex] = visitCount;

        for(int i = 0; i < adjacencyList.get(vertex).size(); i++) {
            int nextVertex = adjacencyList.get(vertex).get(i);
                
            if(visitOrder[nextVertex] == 0){
                visitCount++;
                dfs(nextVertex);
            }
        }
    }
}