//Question No: 1605
//Title: 반복 부분문자열
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    private static final int P = 29;
    private static final int MOD = 10007;
    private static int length;
    private static String str;
    private static int[] pexp = new int[200005];
    private static List<List<Integer>> hashTable = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        precomputePowers();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        str = br.readLine();
        System.out.println(findLongestDuplicateSubstringLength());
    }

    private static void precomputePowers() {
        pexp[0] = 1;
        for (int i = 1; i < pexp.length; i++) {
            pexp[i] = pexp[i - 1] * P % MOD;
        }
    }

    private static int findLongestDuplicateSubstringLength() {
        int left = 0, right = length;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (hasDuplicateSubstring(mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private static boolean hasDuplicateSubstring(int len) {
        initializeHashTable();
        int hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * P + str.charAt(i) - 'a') % MOD;
        }
        hashTable.get(hash).add(0);

        for (int i = len; i < length; i++) {
            hash = (hash - (str.charAt(i - len) - 'a') * pexp[len - 1] % MOD + MOD) % MOD;
            hash = (hash * P + str.charAt(i) - 'a') % MOD;

            if (!hashTable.get(hash).isEmpty()) {
                for (int idx : hashTable.get(hash)) {
                    if (realMatch(idx, i - len + 1, len)) return true;
                }
            }
            hashTable.get(hash).add(i - len + 1);
        }
        return false;
    }

    private static boolean realMatch(int s1, int s2, int len) {
        for (int i = 0; i < len; i++) {
            if (str.charAt(s1 + i) != str.charAt(s2 + i)) {
                return false;
            }
        }
        return true;
    }

    private static void initializeHashTable() {
        hashTable.clear();
        for (int i = 0; i < MOD; i++) {
            hashTable.add(new ArrayList<>());
        }
    }
}
