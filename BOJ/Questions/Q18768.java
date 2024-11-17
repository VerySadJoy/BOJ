//Question No: 18768
//Title: 팀 배정
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int playersCount, teamBalance;
    static int[][] skillLevels;
    
    static class PlayerInfo implements Comparable<PlayerInfo> {
        long skillDifference;
        
        PlayerInfo(int index, long skillDifference) {
            this.skillDifference = skillDifference;
        }
        @Override
        public int compareTo(PlayerInfo other) {
            return Long.compare(this.skillDifference, other.skillDifference);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder output = new StringBuilder();
        
        int testCases = Integer.parseInt(reader.readLine());
        
        while (testCases-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            playersCount = Integer.parseInt(tokenizer.nextToken());
            teamBalance = Integer.parseInt(tokenizer.nextToken());
            skillLevels = new int[2][playersCount];
            
            for (int i = 0; i < 2; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < playersCount; j++) {
                    skillLevels[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            output.append(calculateMinimumSkillSum()).append("\n");
        }
        System.out.print(output);
    }
    
    public static long calculateMinimumSkillSum() {
        long totalSkillSum = 0;
        PriorityQueue<PlayerInfo> teamOneQueue = new PriorityQueue<>();
        PriorityQueue<PlayerInfo> teamTwoQueue = new PriorityQueue<>();
        
        int skillDifference, teamOneSize = 0, teamTwoSize = 0;
        
        for (int i = 0; i < playersCount; i++) {
            skillDifference = Math.abs(skillLevels[0][i] - skillLevels[1][i]);
            
            if (skillLevels[0][i] > skillLevels[1][i]) {
                teamOneSize++;
                totalSkillSum += skillLevels[0][i];
                teamOneQueue.add(new PlayerInfo(i, skillDifference));
            } else {
                teamTwoSize++;
                totalSkillSum += skillLevels[1][i];
                teamTwoQueue.add(new PlayerInfo(i, skillDifference));
            }
        }
        
        while (Math.abs(teamOneSize - teamTwoSize) > teamBalance) {
            PlayerInfo current;
            if (teamOneSize > teamTwoSize) {
                current = teamOneQueue.poll();
                teamOneSize--;
                teamTwoSize++;
            } else {
                current = teamTwoQueue.poll();
                teamOneSize++;
                teamTwoSize--;
            }
            totalSkillSum -= current.skillDifference;
        }
        
        return totalSkillSum;
    }
}