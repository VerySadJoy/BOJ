//Question No: 1014
//Title: 컨닝
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] matchLeft, matchRight;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	private static boolean bipartiteMatching(int left) {
		if (visited[left]) {
			return false;
		}
		visited[left] = true;
		for (int right : graph.get(left)) {
			if (matchRight[right] == -1 || bipartiteMatching(matchRight[right])) {
				matchLeft[left] = right;
				matchRight[right] = left;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str;
		StringTokenizer st;
		
		int t, n, m, i, j, k, brokenDesk, idx, matchingCount;
		char[] deskLeft, deskRight;
		
		t = Integer.parseInt(br.readLine());
		for (i = 0; i < t; i++) {
			
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			deskLeft = new char[n * (m + 1) / 2];
			deskRight = new char[n * m / 2];
			brokenDesk = 0;
			for (j = 0; j < n; j++) {
				str = br.readLine();
				for (k = 0; k < m; k++) {
					if (k % 2 == 0) {
						deskLeft[(k / 2) * n + j] = str.charAt(k);
					}
					else {
						deskRight[(k / 2) * n + j] = str.charAt(k);
					}
					if (str.charAt(k) == 'x') {
						brokenDesk++;
					}
				}
			}
			
			graph.clear();
			for (j = 0; j < n * (m + 1) / 2; j++) {
				graph.add(new ArrayList<>());
			}
			for (j = 0; j < n; j++) {
				for (k = 0; k < m; k += 2) {
					idx = (k / 2) * n + j;
					if (deskLeft[idx] == '.') {
						if (k - 1 >= 0) {
							if (j - 1 >= 0 && deskRight[idx - n - 1] == '.') {
								graph.get(idx).add(idx - n - 1);
							}
							if (deskRight[idx - n] == '.') {
								graph.get(idx).add(idx - n);
							}
							if (j + 1 < n && deskRight[idx - n + 1] == '.') {
								graph.get(idx).add(idx - n + 1);
							}
						}
						if (k + 1 < m) {
							if (j - 1 >= 0 && deskRight[idx - 1] == '.') {
								graph.get(idx).add(idx - 1);
							}
							if (deskRight[idx] == '.') {
								graph.get(idx).add(idx);
							}
							if (j + 1 < n && deskRight[idx + 1] == '.') {
								graph.get(idx).add(idx + 1);
							}
						}
					}
				}
			}
			
			matchLeft = new int[n * ((m + 1) / 2)];
			matchRight = new int[n * (m / 2)];
			visited = new boolean[n * ((m + 1) / 2)];
			Arrays.fill(matchLeft, -1);
			Arrays.fill(matchRight, -1);
			matchingCount = 0;
			for (j = 0; j < n * ((m + 1) / 2); j++) {
				Arrays.fill(visited, false);
				if (bipartiteMatching(j)) {
					matchingCount++;
				}
			}
			
			sb.append(n * m - brokenDesk - matchingCount).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
