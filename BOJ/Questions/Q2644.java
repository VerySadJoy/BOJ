//Question No: 2644
//Title: 촌수계산
//Tier: Silver II
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] connections;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPeople = Integer.parseInt(reader.readLine());
        connections = new ArrayList[numberOfPeople + 1];
        visited = new boolean[numberOfPeople + 1];
        for (int i = 1; i <= numberOfPeople; i++) {
            connections[i] = new ArrayList<>();
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int personX = Integer.parseInt(tokenizer.nextToken());
        int personY = Integer.parseInt(tokenizer.nextToken());

        int numberOfRelations = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfRelations; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int personA = Integer.parseInt(tokenizer.nextToken());
            int personB = Integer.parseInt(tokenizer.nextToken());
            connections[personA].add(personB);
            connections[personB].add(personA);
        }

        findRelationDepth(personX, personY, 0);
        System.out.println(result);
    }

    static void findRelationDepth(int currentPerson, int targetPerson, int depth) {
        if (currentPerson == targetPerson) {
            result = depth;
            return;
        }

        visited[currentPerson] = true;
        for (int i = 0; i < connections[currentPerson].size(); i++) {
            int nextPerson = connections[currentPerson].get(i);
            if (!visited[nextPerson]) {
                findRelationDepth(nextPerson, targetPerson, depth + 1);
            }
        }
    }
}