//Question No: 14572
//Title: 스터디 그룹
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
    int skillLevel;
    ArrayList<Integer> algorithmList;

    public Student(int skillLevel, ArrayList<Integer> algorithmList) {
        this.skillLevel = skillLevel;
        this.algorithmList = algorithmList;
    }

    @Override
    public int compareTo(Student other) {
        return this.skillLevel - other.skillLevel;
    }
}

public class Main {
    private static int calculateEfficiency(int[] algorithmCount, int startIdx, int endIdx) {
        int uniqueCount = 0;
        int fullyCoveredCount = 0;
        int studentRange = endIdx - startIdx + 1;
        for (int count : algorithmCount) {
            if (count != 0) uniqueCount++;
            if (count == studentRange) fullyCoveredCount++;
        }
        return (uniqueCount - fullyCoveredCount) * studentRange;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
        int totalStudents = Integer.parseInt(tokenizer.nextToken());
        int totalAlgorithms = Integer.parseInt(tokenizer.nextToken());
        int skillLimit = Integer.parseInt(tokenizer.nextToken());

        Student[] students = new Student[totalStudents];
        for (int i = 0; i < totalStudents; i++) {
            tokenizer = new StringTokenizer(inputReader.readLine());
            int algorithmCount = Integer.parseInt(tokenizer.nextToken());
            int skill = Integer.parseInt(tokenizer.nextToken());
            ArrayList<Integer> algorithms = new ArrayList<>(algorithmCount);
            tokenizer = new StringTokenizer(inputReader.readLine());
            while (algorithmCount-- > 0) {
                algorithms.add(Integer.valueOf(tokenizer.nextToken()));
            }
            students[i] = new Student(skill, algorithms);
        }

        Arrays.sort(students);

        int[] algorithmTracker = new int[totalAlgorithms + 1];
        int maxEfficiency = 0;
        int startIdx = 0;
        int endIdx = 0;
        for (int algorithm : students[0].algorithmList) {
            algorithmTracker[algorithm]++;
        }

        while (true) {
            int skillDifference = students[endIdx].skillLevel - students[startIdx].skillLevel;
            if (skillDifference <= skillLimit) {
                maxEfficiency = Math.max(maxEfficiency, calculateEfficiency(algorithmTracker, startIdx, endIdx));
                endIdx++;
                if (endIdx >= totalStudents) break;

                for (int algorithm : students[endIdx].algorithmList) {
                    algorithmTracker[algorithm]++;
                }
                continue;
            }
            for (int algorithm : students[startIdx].algorithmList) {
                algorithmTracker[algorithm]--;
            }
            startIdx++;
        }
        System.out.println(maxEfficiency);
    }
}