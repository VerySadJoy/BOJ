//Question No: 2357
//Title: 최솟값과 최댓값
//Tier: Gold I
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n, minQueryResult, maxQueryResult;
	static final int INITIAL_VALUE = 1_000_000_001;
	static int[] elements, minSegmentTree, maxSegmentTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		elements = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			elements[i] = Integer.parseInt(br.readLine());
		}
		int treeSize = calculateTreeSize();
		minSegmentTree = new int[treeSize];
		maxSegmentTree = new int[treeSize];
		initializeSegmentTree(0, minSegmentTree, 1, n, 1);
		initializeSegmentTree(1, maxSegmentTree, 1, n, 1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			minQueryResult = INITIAL_VALUE;
			maxQueryResult = -1;
			query(0, minSegmentTree, 1, n, 1, a, b);
			query(1, maxSegmentTree, 1, n, 1, a, b);
			sb.append(minQueryResult + " " + maxQueryResult + "\n");
		}
		System.out.println(sb.toString());
	}

	static int calculateTreeSize() {
		int height = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
		return (int) Math.pow(2, height);
	}

	static void initializeSegmentTree(int type, int[] tree, int start, int end, int node) {
		if (start == end) {
			tree[node] = elements[start];
		} else {
			int mid = (start + end) / 2;
			initializeSegmentTree(type, tree, start, mid, node * 2);
			initializeSegmentTree(type, tree, mid + 1, end, node * 2 + 1);

			if (type == 0) {
				tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
			} else {
				tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
			}
		}
	}

	static void query(int type, int[] tree, int start, int end, int node, int left, int right) {
		if (left > end || right < start)
			return;
		if (left <= start && end <= right) {
			if (type == 0) {
				minQueryResult = Math.min(minQueryResult, tree[node]);
			} else {
				maxQueryResult = Math.max(maxQueryResult, tree[node]);
			}
			return;
		}

		int mid = (start + end) / 2;
		query(type, tree, start, mid, node * 2, left, right);
		query(type, tree, mid + 1, end, node * 2 + 1, left, right);
	}
}
