//Question No: 21939
//Title: 문제 추천 시스템 Version 1
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static class Problem {
        int number;
        int difficulty;

        public Problem(int number, int difficulty) {
            this.number = number;
            this.difficulty = difficulty;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int problemCount = Integer.parseInt(reader.readLine());

        TreeSet<Problem> problemSet = new TreeSet<>((a, b) -> {
            if (a.difficulty == b.difficulty) {
                return a.number - b.number;
            }
            return a.difficulty - b.difficulty;
        });

        Map<Integer, Integer> problemMap = new HashMap<>();

        for (int i = 0; i < problemCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int number = Integer.parseInt(tokenizer.nextToken());
            int difficulty = Integer.parseInt(tokenizer.nextToken());
            Problem problem = new Problem(number, difficulty);
            problemSet.add(problem);
            problemMap.put(number, difficulty);
        }

        int queryCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < queryCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            switch (command) {
                case "add":
                    int number = Integer.parseInt(tokenizer.nextToken());
                    int difficulty = Integer.parseInt(tokenizer.nextToken());
                    Problem newProblem = new Problem(number, difficulty);
                    problemSet.add(newProblem);
                    problemMap.put(number, difficulty);
                    break;

                case "recommend":
                    int type = Integer.parseInt(tokenizer.nextToken());
                    if (type == 1) {
                        System.out.println(problemSet.last().number);
                    } else if (type == -1) {
                        System.out.println(problemSet.first().number);
                    }
                    break;

                case "solved":
                    int solvedNumber = Integer.parseInt(tokenizer.nextToken());
                    int solvedDifficulty = problemMap.get(solvedNumber);
                    problemSet.remove(new Problem(solvedNumber, solvedDifficulty));
                    break;

                default:
                    break;
            }
        }
    }
}