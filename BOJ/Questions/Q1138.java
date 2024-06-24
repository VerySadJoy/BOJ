//Question No: 1138
//Title: 한 줄로 서기
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int numPeople = Integer.parseInt(tokenizer.nextToken());
		int[] positions = new int[numPeople];
		boolean[] occupied = new boolean[numPeople];
		tokenizer = new StringTokenizer(reader.readLine());
		
		for (int i = 0; i < numPeople; i++) {
			int tallerCount = Integer.parseInt(tokenizer.nextToken());
			int count = 0;
			for (int j = 0; j < numPeople; j++) {
				if (!occupied[j]) {
					if (count == tallerCount) {
						occupied[j] = true;
						positions[j] = i + 1;
						break;
					}
					count++;
				}
			}
		}
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numPeople; i++) {
			result.append(positions[i]).append(" ");
		}
		System.out.println(result.toString().trim());
	}
}
