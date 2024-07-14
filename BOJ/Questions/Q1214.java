//Question No: 1214
//Title: 쿨한 물건 구매
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private int d, p, q;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        readInput();
        calculateMinimumSum();
    }

    private void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
    }

    private void calculateMinimumSum() {
        int maxVal = Math.max(p, q);
        int minVal = Math.min(p, q);
        
        if (minVal == 1 || (minVal == 2 && d % 2 == 0) || d % maxVal == 0 || d % minVal == 0) {
            System.out.println(d);
            return;
        }

        int limit = d / maxVal + 1;
        int minRemainder = maxVal - 1;
        HashSet<Integer> remainders = new HashSet<>();
        
        for (int i = 0; i <= limit; i++) {
            int remaining = d - maxVal * i;
            if (remaining > 0 && remaining % minVal == 0) {
                System.out.println(d);
                return;
            }
            if (remaining < 0) {
                remaining += minVal;
            }
            int remainder = minVal - remaining % minVal;
            
            if (remainders.contains(remainder)) {
                break;
            }
            remainders.add(remainder);
            if (minRemainder > remainder) {
                minRemainder = remainder;
            }
        }
        System.out.println(d + minRemainder);
    }
}
