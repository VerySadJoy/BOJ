//Question No: 8896
//Title: 가위 바위 보
//Tier: Silver IV
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(inputReader.readLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            LinkedList<Integer> remainingRobots = new LinkedList<>();
            int totalRobots = Integer.parseInt(inputReader.readLine());
            String[] robotMoves = new String[totalRobots];

            for (int i = 0; i < totalRobots; i++) {
                robotMoves[i] = inputReader.readLine();
                remainingRobots.add(i);
            }

            for (int round = 0; round < robotMoves[0].length(); round++) {
                HashMap<Integer, Character> currentRoundResults = new HashMap<>();
                for (int i = 0; i < remainingRobots.size(); i++) {
                    int robotIndex = remainingRobots.get(i);
                    char move = robotMoves[robotIndex].charAt(round);
                    currentRoundResults.put(robotIndex, move);
                }

                int distinctMoves = 0;
                char[] moveCounts = new char[3];
                for (int i = 0; i < remainingRobots.size(); i++) {
                    int robotIndex = remainingRobots.get(i);
                    char move = currentRoundResults.get(robotIndex);
                    if (move == 'S') moveCounts[0]++;
                    else if (move == 'R') moveCounts[1]++;
                    else if (move == 'P') moveCounts[2]++;
                }

                for (int i = 0; i < 3; i++) {
                    if (moveCounts[i] != 0) distinctMoves++;
                }

                if (distinctMoves == 3 || distinctMoves == 1) {
                    continue;
                } else if (distinctMoves == 2) {
                    if (moveCounts[2] == 0) {
                        for (int i = remainingRobots.size() - 1; i >= 0; i--) {
                            int robotIndex = remainingRobots.get(i);
                            if (currentRoundResults.get(robotIndex) == 'S') {
                                remainingRobots.remove(i);
                            }
                        }
                    } else if (moveCounts[0] == 0) {
                        for (int i = remainingRobots.size() - 1; i >= 0; i--) {
                            int robotIndex = remainingRobots.get(i);
                            if (currentRoundResults.get(robotIndex) == 'R') {
                                remainingRobots.remove(i);
                            }
                        }
                    } else if (moveCounts[1] == 0) {
                        for (int i = remainingRobots.size() - 1; i >= 0; i--) {
                            int robotIndex = remainingRobots.get(i);
                            if (currentRoundResults.get(robotIndex) == 'P') {
                                remainingRobots.remove(i);
                            }
                        }
                    }
                }

                if (remainingRobots.size() == 1) {
                    System.out.println(remainingRobots.get(0) + 1);
                    break;
                }
            }

            if (remainingRobots.size() > 1) {
                System.out.println(0);
            }
        }
    }
}