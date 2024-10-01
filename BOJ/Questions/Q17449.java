//Question No: 17449
//Title: 순위 계산
//Tier: Gold II
import java.io.*;
import java.util.*;

class RankInfo {
    int currentRank, winCount;
    boolean sameCountFlag;

    RankInfo(int currentRank, int winCount, boolean sameCountFlag) {
        this.currentRank = currentRank;
        this.winCount = winCount;
        this.sameCountFlag = sameCountFlag;
    }
}

class Range {
    int start, end;

    Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    static int totalGames;
    static RankInfo rankInfo;
    static Range rankRange;

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        rankInfo = new RankInfo(Integer.parseInt(inputReader.readLine()), 0, false);
        totalGames = Integer.parseInt(inputReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());

        for (int i = 0; i < totalGames; i++) {
            int nextRank = Integer.parseInt(tokenizer.nextToken());

            if (rankInfo.currentRank > nextRank) {
                rankInfo = new RankInfo(rankInfo.currentRank + 1, rankInfo.winCount, rankInfo.sameCountFlag);
                rankRange = new Range(rankInfo.currentRank + 1, rankInfo.currentRank + rankInfo.winCount);
            } else if (rankInfo.currentRank == nextRank) {
                rankInfo = new RankInfo(rankInfo.currentRank, rankInfo.winCount + 1, true);
                rankRange = new Range(rankInfo.currentRank + 1, rankInfo.currentRank + rankInfo.winCount);
            } else {
                if (rankInfo.sameCountFlag) {
                    if (nextRank >= rankRange.start && nextRank <= rankRange.end) {
                        rankInfo = new RankInfo(nextRank, rankInfo.winCount - (nextRank - rankInfo.currentRank) + 1, true);
                        rankRange = new Range(rankInfo.currentRank + 1, rankInfo.currentRank + rankInfo.winCount);
                    }
                }
            }
        }

        System.out.printf("%d %d", rankInfo.currentRank, rankInfo.currentRank + rankInfo.winCount);
    }
}