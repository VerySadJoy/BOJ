//Question No: 14501
//Title: 퇴사
//Tier: Silver III
import java.io.*;
import java.util.*;

public class Main {
	
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int caseCount = sc.nextInt();
		int[] durations = new int[caseCount];
		int[] payments = new int[caseCount];
		
		for(int i = 0; i < caseCount; i++) {
			durations[i] = sc.nextInt();	
			payments[i] = sc.nextInt();	
		}
		
		int[] dp = new int[caseCount + 1];
		
		for(int i = 0; i < caseCount; i++) {
			if(i + durations[i] <= caseCount) {	
				dp[i + durations[i]] = Math.max(dp[i + durations[i]], dp[i] + payments[i]);	
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		
		System.out.println(dp[caseCount]);	
	}
}