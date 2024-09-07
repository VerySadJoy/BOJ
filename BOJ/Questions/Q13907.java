//Question No: 13907
//Title: 세금
//Tier: Platinum IV
import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int vertex;
    int weight;
    int citiesVisited;

    Node(int vertex, int weight, int citiesVisited) {
        this.vertex = vertex;
        this.weight = weight;
        this.citiesVisited = citiesVisited;
    }

    public int compareTo(Node other) {
        return this.weight - other.weight;
    }
}

public class Main {

    public static int[][] distance;
    public static int totalCities;
    public static int startCity;
    public static int destinationCity;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        totalCities = Integer.parseInt(input[0]);
        int numRoads = Integer.parseInt(input[1]);
        int taxIncreases = Integer.parseInt(input[2]);

        input = reader.readLine().split(" ");
        startCity = Integer.parseInt(input[0]);
        destinationCity = Integer.parseInt(input[1]);

        ArrayList<Node>[] adjacencyList = new ArrayList[totalCities + 1];
        distance = new int[totalCities + 1][totalCities];

        for (int i = 1; i <= totalCities; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numRoads; i++) {
            input = reader.readLine().split(" ");
            int city1 = Integer.parseInt(input[0]);
            int city2 = Integer.parseInt(input[1]);
            int roadWeight = Integer.parseInt(input[2]);
            adjacencyList[city1].add(new Node(city2, roadWeight, 0));
            adjacencyList[city2].add(new Node(city1, roadWeight, 0));
        }

        for (int i = 1; i <= totalCities; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Arrays.fill(distance[startCity], Integer.MAX_VALUE);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(startCity, 0, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (currentNode.citiesVisited + 1 == totalCities) {
                continue;
            }
            if (currentNode.weight > distance[currentNode.vertex][currentNode.citiesVisited]) {
                continue;
            }
            outerLoop:
            for (Node nextNode : adjacencyList[currentNode.vertex]) {
                for (int i = 1; i <= currentNode.citiesVisited; i++) {
                    if (distance[nextNode.vertex][i] < currentNode.weight + nextNode.weight) {
                        continue outerLoop;
                    }
                }
                if (distance[nextNode.vertex][currentNode.citiesVisited + 1] > currentNode.weight + nextNode.weight) {
                    distance[nextNode.vertex][currentNode.citiesVisited + 1] = currentNode.weight + nextNode.weight;
                    priorityQueue.add(new Node(nextNode.vertex, currentNode.weight + nextNode.weight, currentNode.citiesVisited + 1));
                }
            }
        }

        int initialResult = Integer.MAX_VALUE;
        for (int i = 1; i < totalCities; i++) {
            initialResult = Math.min(initialResult, distance[destinationCity][i]);
        }
        System.out.println(initialResult);

        for (int i = 0; i < taxIncreases; i++) {
            int taxIncrease = Integer.parseInt(reader.readLine());
            System.out.println(calculateTax(taxIncrease));
        }
    }

    public static int calculateTax(int tax) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < totalCities; i++) {
            if (distance[destinationCity][i] == Integer.MAX_VALUE) {
                continue;
            }
            distance[destinationCity][i] += i * tax;
            result = Math.min(result, distance[destinationCity][i]);
        }
        return result;
    }
}