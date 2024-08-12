//Question No: 11407
//Title: 책 구매하기 3
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    static final int INFINITY = 1_000_000_000;
    static List<List<Integer>> adjacencyList;
    static int[][] capacityMatrix, flowMatrix, costMatrix;
    static int totalFlow, totalCost;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        
        tokenizer = new StringTokenizer(reader.readLine());
        int numOfNodes = Integer.parseInt(tokenizer.nextToken());
        int numOfEdges = Integer.parseInt(tokenizer.nextToken());

        int totalVertices = numOfNodes + numOfEdges + 2;
        int source = 0;
        int sink = totalVertices - 1;

        adjacencyList = new ArrayList<>();
        for(int i = 0; i < totalVertices; i++)
            adjacencyList.add(new ArrayList<>());
        capacityMatrix = new int[totalVertices][totalVertices];
        flowMatrix = new int[totalVertices][totalVertices];
        costMatrix = new int[totalVertices][totalVertices];

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 1; i <= numOfNodes; i++) {
            int nodeCapacity = Integer.parseInt(tokenizer.nextToken());
            capacityMatrix[i][sink] = nodeCapacity;
            adjacencyList.get(i).add(sink);
            adjacencyList.get(sink).add(i);
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = numOfNodes + 1; i < sink; i++) {
            int edgeCapacity = Integer.parseInt(tokenizer.nextToken());
            capacityMatrix[source][i] = edgeCapacity;
            adjacencyList.get(source).add(i);
            adjacencyList.get(i).add(source);
        }

        for(int i = numOfNodes + 1; i < sink; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 1; j <= numOfNodes; j++) {
                int edgeCapacity = Integer.parseInt(tokenizer.nextToken());
                capacityMatrix[i][j] = edgeCapacity;
                adjacencyList.get(i).add(j);
                adjacencyList.get(j).add(i);
            }
        }

        for(int i = numOfNodes + 1; i < sink; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 1; j <= numOfNodes; j++) {
                int edgeCost = Integer.parseInt(tokenizer.nextToken());
                costMatrix[i][j] = edgeCost;
                costMatrix[j][i] = -costMatrix[i][j];
            }
        }

        minCostMaxFlow(source, sink, totalVertices);

        System.out.println(totalFlow + "\n" + totalCost);
    }

    static void minCostMaxFlow(int source, int sink, int totalVertices) {
        int[] previousNode = new int[totalVertices];
        int[] distance = new int[totalVertices];

        while(true) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[totalVertices];
            Arrays.fill(previousNode, -1);
            Arrays.fill(distance, INFINITY);
            queue.offer(source);
            distance[source] = 0;
            visited[source] = true;

            while(!queue.isEmpty()){
                int currentNode = queue.poll();
                visited[currentNode] = false;

                for(int nextNode : adjacencyList.get(currentNode)){
                    if(distance[nextNode] <= distance[currentNode] + costMatrix[currentNode][nextNode])
                        continue;
                    if(capacityMatrix[currentNode][nextNode] <= flowMatrix[currentNode][nextNode])
                        continue;
                    distance[nextNode] = distance[currentNode] + costMatrix[currentNode][nextNode];
                    previousNode[nextNode] = currentNode;
                    if(!visited[nextNode]) {
                        queue.offer(nextNode);
                        visited[nextNode] = true;
                    }
                }
            }
            if(previousNode[sink] == -1)
                break;

            int maxFlow = INFINITY;
            for(int i = sink; i != source; i = previousNode[i])
                maxFlow = Math.min(maxFlow, capacityMatrix[previousNode[i]][i] - flowMatrix[previousNode[i]][i]);
            for(int i = sink; i != source; i = previousNode[i]) {
                totalCost += maxFlow * costMatrix[previousNode[i]][i];
                flowMatrix[previousNode[i]][i] += maxFlow;
                flowMatrix[i][previousNode[i]] -= maxFlow;
            }
            totalFlow += maxFlow;
        }
    }
}