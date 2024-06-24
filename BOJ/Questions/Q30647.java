//Question No: 30647
//Title: 점수 관리
//Tier: Silver IV
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Participant {
    String name;
    int score;
    int isHidden;

    Participant(String name, int score, int isHidden) {
        this.name = name;
        this.score = score;
        this.isHidden = isHidden;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        List<Participant> participants = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String entry = scanner.nextLine().trim();
            entry = entry.substring(2, entry.length() - 2);
            String[] details = entry.split(",");
            String name = details[0].split(":")[1].trim().replaceAll("^\"|\"$", "");
            int score = Integer.parseInt(details[1].split(":")[1].trim());
            int isHidden = Integer.parseInt(details[2].split(":")[1].trim());
            participants.add(new Participant(name, score, isHidden));
        }

        Collections.sort(participants, new Comparator<Participant>() {
            @Override
            public int compare(Participant p1, Participant p2) {
                if (p1.score != p2.score) {
                    return Integer.compare(p2.score, p1.score);
                } else {
                    return p1.name.compareTo(p2.name);
                }
            }
        });

        List<String> ranking = new ArrayList<>();
        int currentRank = 1;

        for (int i = 0; i < participants.size(); i++) {
            if (i > 0 && participants.get(i).score < participants.get(i - 1).score) {
                currentRank = i + 1;
            }
            if (participants.get(i).isHidden == 0) {
                ranking.add(currentRank + " " + participants.get(i).name + " " + participants.get(i).score);
            }
        }

        for (String rank : ranking) {
            System.out.println(rank);
        }

        scanner.close();
    }
}
