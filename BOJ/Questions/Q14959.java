//Question No: 14959
//Title: Slot Machines
//Tier: Platinum III
import java.util.*;

public class Main {
    static int size;
    static List<Integer> pattern;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        pattern = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            pattern.add(scanner.nextInt());
        }
        
        Collections.reverse(pattern);
        
        int optimalK = 0;
        int optimalP = 0;
        int minSum = Integer.MAX_VALUE;
        
        List<Integer> prefixArray = computePrefixArray(pattern);
        
        for (int i = 0; i < prefixArray.size(); i++) {
            int remainingPatternLength = prefixArray.size() - (i + 1);
            int patternPeriod = (i + 1) - prefixArray.get(i);
            
            if (remainingPatternLength + patternPeriod < minSum) {
                minSum = remainingPatternLength + patternPeriod;
                optimalK = remainingPatternLength;
                optimalP = patternPeriod;
            }
        }
        
        System.out.println(optimalK + " " + optimalP);
    }

    private static List<Integer> computePrefixArray(List<Integer> pattern) {
        List<Integer> prefixArray = new ArrayList<>(Collections.nCopies(pattern.size(), 0));
        int matchLength = 0;
        
        for (int i = 1; i < pattern.size(); i++) {
            while (matchLength > 0 && !pattern.get(i).equals(pattern.get(matchLength))) {
                matchLength = prefixArray.get(matchLength - 1);
            }
            
            if (pattern.get(i).equals(pattern.get(matchLength))) {
                matchLength++;
                prefixArray.set(i, matchLength);
            }
        }
        
        return prefixArray;
    }
}