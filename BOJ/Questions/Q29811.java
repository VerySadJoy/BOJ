//Question No: 29811
//Title: 지각하기 싫어
//Tier: Gold IV
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int totalItems = scanner.nextInt();
        int additionalItems = scanner.nextInt();
        
        TreeSet<Pair> firstSet = new TreeSet<>();
        TreeSet<Pair> secondSet = new TreeSet<>();
        int[] values = new int[totalItems + additionalItems + 1];
        
        for (int i = 1; i <= totalItems + additionalItems; i++) {
            int value = scanner.nextInt();
            values[i] = value;
            if (i > totalItems) {
                secondSet.add(new Pair(value, i));
            } else {
                firstSet.add(new Pair(value, i));
            }
        }
        
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            char operation = scanner.next().charAt(0);
            if (operation == 'U') {
                int index = scanner.nextInt();
                int newValue = scanner.nextInt();
                
                TreeSet<Pair> currentSet = (index > totalItems) ? secondSet : firstSet;
                
                currentSet.remove(new Pair(values[index], index));
                values[index] = newValue;
                currentSet.add(new Pair(newValue, index));
            } else {
                System.out.println(firstSet.first().index + " " + secondSet.first().index);
            }
        }
        
        scanner.close();
    }
}
class Pair implements Comparable<Pair> {
    int value;
    int index;
    
    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
    
    @Override
    public int compareTo(Pair other) {
        if (this.value == other.value) {
            return Integer.compare(this.index, other.index);
        }
        return Integer.compare(this.value, other.value);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return value == pair.value && index == pair.index;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value, index);
    }
}