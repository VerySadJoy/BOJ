//Question No: 1671
//Title: 상어의 저녁식사
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {

    static class Shark {
        int size;
        int speed;
        int intelligence;

        public Shark(int size, int speed, int intelligence) {
            this.size = size;
            this.speed = speed;
            this.intelligence = intelligence;
        }
    }

    static int numberOfSharks;
    static List<Integer>[] sharkPredatorGraph;
    static int[] preyMatch;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numberOfSharks = Integer.parseInt(reader.readLine());
        
        Shark[] sharks = new Shark[numberOfSharks + 1];
        sharkPredatorGraph = new ArrayList[numberOfSharks + 1];

        for (int i = 1; i <= numberOfSharks; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int size = Integer.parseInt(tokenizer.nextToken());
            int speed = Integer.parseInt(tokenizer.nextToken());
            int intelligence = Integer.parseInt(tokenizer.nextToken());
            sharks[i] = new Shark(size, speed, intelligence);
            sharkPredatorGraph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= numberOfSharks; i++) {
            for (int j = 1; j <= numberOfSharks; j++) {
                if (canEat(sharks[i], sharks[j], i, j)) {
                    sharkPredatorGraph[i].add(j);
                }
            }
        }

        preyMatch = new int[numberOfSharks + 1];
        visited = new boolean[numberOfSharks + 1];
        int matchCount = 0;

        for (int i = 1; i <= numberOfSharks; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(visited, false);
                if (findPrey(i)) {
                    matchCount++;
                }
            }
        }

        System.out.println(numberOfSharks - matchCount);
    }

    static boolean canEat(Shark predator, Shark prey, int predatorIndex, int preyIndex) {
        if (predator.size < prey.size || predator.speed < prey.speed || predator.intelligence < prey.intelligence) {
            return false;
        }
        if (predator.size == prey.size && predator.speed == prey.speed && predator.intelligence == prey.intelligence && predatorIndex > preyIndex) {
            return true;
        }
        return predator.size > prey.size || predator.speed > prey.speed || predator.intelligence > prey.intelligence;
    }

    static boolean findPrey(int predator) {
        for (int prey : sharkPredatorGraph[predator]) {
            if (visited[prey]) {
                continue;
            }
            visited[prey] = true;

            if (preyMatch[prey] == 0 || findPrey(preyMatch[prey])) {
                preyMatch[prey] = predator;
                return true;
            }
        }
        return false;
    }
}
