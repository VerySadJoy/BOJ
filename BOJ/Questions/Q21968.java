//Question No: 21968
//Title: 선린의 터를
//Tier: Silver III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < testCases; i++) {
            solve(reader);
        }
    }
    
    private static void solve(BufferedReader reader) throws Exception {
        long number = Long.parseLong(reader.readLine());
        long result = 0;
        Deque<Long> binaryRepresentation = new LinkedList<>();
        
        while (number > 0) {
            result *= 3;
            if ((number & 1) == 1) {
                binaryRepresentation.addLast(1L);
            } else {
                binaryRepresentation.addLast(0L);
            }
            number >>= 1;
        }
        
        long powerOfThree = 1;
        while (!binaryRepresentation.isEmpty()) {
            result += binaryRepresentation.pollFirst() * powerOfThree;
            powerOfThree *= 3;
        }
        
        System.out.println(result);
    }
}
