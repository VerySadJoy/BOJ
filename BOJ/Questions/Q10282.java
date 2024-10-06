//Question No: 10282
//Title: 해킹
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Computer implements Comparable<Computer> {
    int dependentComputer;
    int infectionTime;

    public Computer(int dependentComputer, int infectionTime) {
        this.dependentComputer = dependentComputer;
        this.infectionTime = infectionTime;
    }

    @Override
    public int compareTo(Computer other) {
        return this.infectionTime - other.infectionTime;
    }
}

public class Main {

    static final int INFINITY = Integer.MAX_VALUE;

    static ArrayList<Computer>[] dependenciesList;
    static int[] minimumTime;
    static boolean[] visitedComputers;

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(inputReader.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());

            int numberOfComputers = Integer.parseInt(tokenizer.nextToken());
            int numberOfDependencies = Integer.parseInt(tokenizer.nextToken());
            int hackedComputer = Integer.parseInt(tokenizer.nextToken());

            dependenciesList = new ArrayList[numberOfComputers + 1];
            minimumTime = new int[numberOfComputers + 1];
            visitedComputers = new boolean[numberOfComputers + 1];

            for (int i = 1; i <= numberOfComputers; i++) {
                minimumTime[i] = INFINITY;
                dependenciesList[i] = new ArrayList<>();
            }

            for (int i = 0; i < numberOfDependencies; i++) {
                tokenizer = new StringTokenizer(inputReader.readLine());

                int dependent = Integer.parseInt(tokenizer.nextToken());
                int source = Integer.parseInt(tokenizer.nextToken());
                int time = Integer.parseInt(tokenizer.nextToken());

                dependenciesList[source].add(new Computer(dependent, time));
            }

            runDijkstra(hackedComputer);

            int infectedComputers = 0;
            int totalTime = 0;

            for (int i = 1; i <= numberOfComputers; i++) {
                if (minimumTime[i] != INFINITY) {
                    infectedComputers++;
                    totalTime = Math.max(totalTime, minimumTime[i]);
                }
            }

            System.out.println(infectedComputers + " " + totalTime);
        }
    }

    public static void runDijkstra(int startComputer) {
        PriorityQueue<Computer> priorityQueue = new PriorityQueue<>();

        minimumTime[startComputer] = 0;
        priorityQueue.offer(new Computer(startComputer, 0));

        while (!priorityQueue.isEmpty()) {
            int currentComputer = priorityQueue.poll().dependentComputer;

            if (!visitedComputers[currentComputer]) {
                visitedComputers[currentComputer] = true;

                for (Computer nextComputer : dependenciesList[currentComputer]) {
                    if (minimumTime[nextComputer.dependentComputer] > minimumTime[currentComputer] + nextComputer.infectionTime) {
                        minimumTime[nextComputer.dependentComputer] = minimumTime[currentComputer] + nextComputer.infectionTime;
                        priorityQueue.add(new Computer(nextComputer.dependentComputer, minimumTime[nextComputer.dependentComputer]));
                    }
                }
            }
        }
    }
}