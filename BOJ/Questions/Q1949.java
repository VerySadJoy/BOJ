//Question No: 1949
//Title: 우수 마을
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {

    static int[] townPopulation;
    static List<Integer>[] adjacencyList;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = null;
        int villageCount = Integer.parseInt(reader.readLine());

        tokenizer = new StringTokenizer(reader.readLine());
        townPopulation = new int[villageCount + 1];
        dp = new int[villageCount + 1][2];
        for (int i = 0; i <= villageCount; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 1; i <= villageCount; i++) {
            townPopulation[i] = Integer.parseInt(tokenizer.nextToken());
        }

        adjacencyList = new ArrayList[villageCount + 1];
        for (int i = 0; i <= villageCount; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < villageCount - 1; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int villageA = Integer.parseInt(tokenizer.nextToken());
            int villageB = Integer.parseInt(tokenizer.nextToken());
            adjacencyList[villageA].add(villageB);
            adjacencyList[villageB].add(villageA);
        }

        System.out.println(Math.max(getMaxPopulation(1, -1, 1) + townPopulation[1], getMaxPopulation(1, -1, 0)));
    }

    static int getMaxPopulation(int currentVillage, int previousVillage, int isSpecial) {
        if (dp[currentVillage][isSpecial] != -1) return dp[currentVillage][isSpecial];

        dp[currentVillage][isSpecial] = 0;
        for (int nextVillage : adjacencyList[currentVillage]) {
            if (nextVillage != previousVillage) {
                if (isSpecial == 1) {
                    dp[currentVillage][isSpecial] += getMaxPopulation(nextVillage, currentVillage, 0);
                } else {
                    dp[currentVillage][isSpecial] += Math.max(
                        getMaxPopulation(nextVillage, currentVillage, 1) + townPopulation[nextVillage],
                        getMaxPopulation(nextVillage, currentVillage, 0)
                    );
                }
            }
        }
        return dp[currentVillage][isSpecial];
    }
}