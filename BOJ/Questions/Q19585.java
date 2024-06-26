//Question No: 19585
//Title: 전설
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    private int colorCount, nicknameCount;
    private final Trie colorTrie = new Trie('S', false);
    private final Set<String> nicknameSet = new HashSet<>();

    public static void main(String[] args) {
        new Main().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            this.colorCount = Integer.parseInt(input[0]);
            this.nicknameCount = Integer.parseInt(input[1]);
            this.loadColors(br);
            this.loadNicknames(br);
            System.out.print(this.processTeams(br));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadColors(BufferedReader br) throws IOException {
        for (int i = 0; i < colorCount; i++) {
            String color = br.readLine();
            this.addColorToTrie(color, this.colorTrie);
        }
    }

    private void loadNicknames(BufferedReader br) throws IOException {
        for (int i = 0; i < nicknameCount; i++) {
            String nickname = br.readLine();
            this.nicknameSet.add(nickname);
        }
    }

    private void addColorToTrie(String color, Trie trie) {
        for (int i = 0; i < color.length(); i++) {
            Trie newTrie = new Trie(color.charAt(i), i == color.length() - 1);
            trie.addNextTrie(newTrie);
            trie = trie.getNextTrie(color.charAt(i));
        }
    }

    private String processTeams(BufferedReader br) throws IOException {
        int teamCount = Integer.parseInt(br.readLine());
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < teamCount; i++) {
            String teamName = br.readLine();
            List<Integer> colorMatchedPoints = new ArrayList<>();
            this.markColorMatchPoints(teamName, this.colorTrie, colorMatchedPoints);
            resultBuilder.append(this.checkNicknameMatch(teamName, colorMatchedPoints)).append("\n");
        }
        return resultBuilder.toString();
    }

    private void markColorMatchPoints(String teamName, Trie trie, List<Integer> matchedPoints) {
        for (int i = 0; i < teamName.length(); i++) {
            trie = trie.getNextTrie(teamName.charAt(i));
            if (trie == null) return;
            if (trie.isEnd && teamName.length() - (i + 1) <= 1000) {
                matchedPoints.add(i);
            }
        }
    }

    private String checkNicknameMatch(String teamName, List<Integer> matchedPoints) {
        for (Integer matchPoint : matchedPoints) {
            if (this.nicknameSet.contains(teamName.substring(matchPoint + 1))) {
                return "Yes";
            }
        }
        return "No";
    }

    private static class Trie {
        char character;
        Trie[] nextNodes = new Trie['z' - 'a' + 1];
        boolean isEnd;

        public Trie(char character, boolean isEnd) {
            this.character = character;
            this.isEnd = isEnd;
        }

        public void addNextTrie(Trie trie) {
            int index = trie.character - 'a';
            if (nextNodes[index] == null) {
                nextNodes[index] = trie;
            }
            nextNodes[index].isEnd = nextNodes[index].isEnd || trie.isEnd;
        }

        public Trie getNextTrie(char character) {
            int index = character - 'a';
            return nextNodes[index];
        }
    }
}
