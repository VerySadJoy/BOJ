//Question No: 1086
//Title: 박성원
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String[] numbers;
	static int divisor, numCount;
	static int allVisited;
	static long[][] memo;
	static int[][] remainderCache;

	public static long calculateWays(int visited, int remainder) {
		if(memo[visited][remainder] != -1) {
			return memo[visited][remainder];
		}
		if(visited == allVisited) {
			return remainder == 0 ? 1 : 0;
		}
		long ways = 0;
		for(int i = 0; i < numCount; i++) {
			int current = 1 << i;
			if((visited & current) == 0) {
				ways += calculateWays(visited | current, getNewRemainder(i, remainder));
			}
		}
		return memo[visited][remainder] = ways;
	}
	
	public static int getNewRemainder(int idx, int remainder) {
		if(remainderCache[idx][remainder] != -1) return remainderCache[idx][remainder];
		int curr = remainder;
		int length = numbers[idx].length();
		for(int i = 0; i < length; i++) {
			curr *= 10;
			curr += (numbers[idx].charAt(i) - '0');
			curr %= divisor;
		}
		return remainderCache[idx][remainder] = curr;
	}
	
	public static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numCount = Integer.parseInt(br.readLine());
		numbers = new String[numCount];
		for(int i = 0; i < numCount; i++) {
			numbers[i] = br.readLine();
		}
		divisor = Integer.parseInt(br.readLine());
		allVisited = (1 << numCount) - 1;
		memo = new long[1 << numCount][divisor];
		remainderCache = new int[numCount][divisor];
		for(int j = 0; j < divisor; j++) {
			for(int i = 0; i < numCount; i++) {
				remainderCache[i][j] = -1;
			}
			for(int i = 0; i <= allVisited; i++) {
				memo[i][j] = -1;
			}
		}
		long answer = calculateWays(0, 0);
		if(answer == 0) {
			System.out.println("0/1");
		} else {
			long totalPermutations = 1;
			for(int i = 2; i <= numCount; i++) {
				totalPermutations *= i;
			}
			long gcdValue = gcd(totalPermutations, answer);
			System.out.println(answer / gcdValue + "/" + totalPermutations / gcdValue);
		}
		br.close();
	}
}
