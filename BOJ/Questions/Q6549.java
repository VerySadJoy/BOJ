//Question No: 6549
//Title: 히스토그램에서 가장 큰 직사각형
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] heights;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N;
		
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			
			if (N == 0) {
				break;
			}
			
			heights = new int[N];
			
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(getMaxArea(0, N - 1)).append('\n');
			heights = null;
		}
		
		System.out.println(sb);
	}
	
	public static long getMaxArea(int left, int right) {
		if (left == right) {
			return heights[left];
		}
		
		int mid = (left + right) / 2;
		long leftArea = getMaxArea(left, mid);
		long rightArea = getMaxArea(mid + 1, right);
		long maxArea = Math.max(leftArea, rightArea);
		maxArea = Math.max(maxArea, getCrossingArea(left, right, mid));
		
		return maxArea;
	}
	
	public static long getCrossingArea(int left, int right, int mid) {
		int toLeft = mid;
		int toRight = mid;
		long minHeight = heights[mid];
		long maxArea = minHeight;
		
		while (left < toLeft && toRight < right) {
			if (heights[toLeft - 1] < heights[toRight + 1]) {
				toRight++;
				minHeight = Math.min(minHeight, heights[toRight]);
			} else {
				toLeft--;
				minHeight = Math.min(minHeight, heights[toLeft]);
			}
			
			maxArea = Math.max(maxArea, minHeight * (toRight - toLeft + 1));
		}
		
		while (toRight < right) {
			toRight++;
			minHeight = Math.min(minHeight, heights[toRight]);
			maxArea = Math.max(maxArea, minHeight * (toRight - toLeft + 1));
		}
		
		while (left < toLeft) {
			toLeft--;
			minHeight = Math.min(minHeight, heights[toLeft]);
			maxArea = Math.max(maxArea, minHeight * (toRight - toLeft + 1));
		}
		
		return maxArea;
	}
}
