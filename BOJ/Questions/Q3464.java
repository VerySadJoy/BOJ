//Question No: 3464
//Title: Decoding Morse sequences
//Tier: Platinum IV
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static final String[] codes = {
        ".-",   "-...", "-.-.", "-..",  ".",   "..-.", "--.",  "....", "..",
        ".---", "-.-",  ".-..", "--",   "-.",  "---",  ".--.", "--.-", ".-.",
        "...",  "-",    "..-",  "...-", ".--", "-..-", "-.--", "--..",
    };

    static class Trie {
        int[] children = new int[2];
        int terminal;

        Trie() {
            Arrays.fill(children, 0);
            terminal = 0;
        }
    }

    static int tcnt;
    static Trie[] tnodes = new Trie[10000 * 20 * 4 + 1];
    static int max_depth;
    static int seq_len;
    static char[] seq = new char[10001];
    static int[] dp = new int[10001];
    static char[] word = new char[21];

    static {
        for (int i = 0; i < tnodes.length; i++) {
            tnodes[i] = new Trie();
        }
    }

    static int talloc() {
        tnodes[tcnt] = new Trie();
        return tcnt++;
    }

    static void put() {
        int depth = 0;
        int t = 0;
        for (char wp : word) {
            if (wp == 0) break;
            for (char c : codes[wp - 'A'].toCharArray()) {
                ++depth;

                int nt = tnodes[t].children[c - '-'];
                if (nt == 0) {
                    nt = tnodes[t].children[c - '-'] = talloc();
                }
                t = nt;
            }
        }
        ++tnodes[t].terminal;

        if (depth > max_depth) {
            max_depth = depth;
        }
    }

    static int ambiguity(int i) {
        if (i >= seq_len) {
            return 1;
        }

        if (dp[i] >= 0) {
            return dp[i];
        }

        int cnt = 0;
        int t = 0;
        for (int len = 1; i + len <= seq_len && len <= max_depth; ++len) {
            t = tnodes[t].children[seq[i + len - 1] - '-'];
            if (t == 0) {
                break;
            }

            int match = tnodes[t].terminal;
            if (match > 0) {
                cnt += match * ambiguity(i + len);
            }
        }
        return dp[i] = cnt;
    }

    static void init() {
        tcnt = max_depth = 0;
        talloc();
        Arrays.fill(dp, -1);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int d = sc.nextInt();
            while (d-- > 0) {
                init();
                
                String seqStr = sc.next();
                seq = seqStr.toCharArray();
                seq_len = seqStr.length();
                
                int n = sc.nextInt();
                while (n-- > 0) {
                    String wordStr = sc.next();
                    word = wordStr.toCharArray();
                    put();
                }
                
                System.out.println(ambiguity(0));
            }
        }
    }
}