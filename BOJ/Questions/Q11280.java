//Question No: 11280
//Title: 2-SAT - 3
//Tier: Platinum IV
import java.io.*;
import java.util.*;

public class Main {
	static int totalNodes, orderCount;
	static ArrayList<Integer>[] adjList;
	static int[] visitOrder;
	static boolean[] isVisited;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		totalNodes = Integer.parseInt(tokenizer.nextToken());
		int edges = Integer.parseInt(tokenizer.nextToken());

		adjList = new ArrayList[2 * totalNodes + 1];
		visitOrder = new int[2 * totalNodes + 1];
		isVisited = new boolean[2 * totalNodes + 1];
		stack = new Stack<>();

		for (int i = 0; i < 2 * totalNodes + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		while (edges-- > 0) {
			tokenizer = new StringTokenizer(reader.readLine());

			int from = Integer.parseInt(tokenizer.nextToken());
			int to = Integer.parseInt(tokenizer.nextToken());

			adjList[convertIndex(-from)].add(convertIndex(to));
			adjList[convertIndex(-to)].add(convertIndex(from));
		}

		boolean satisfiable = true;
		for (int i = 1; i < 2 * totalNodes + 1; i++) {
			if (!isVisited[i]) {
				if (findSCC(i) == -1) {
					satisfiable = false;
					break;
				}
			}
		}

		writer.write(satisfiable ? "1\n" : "0\n");
		writer.flush();
		writer.close();
		reader.close();
	}

	private static int convertIndex(int node) {
		if (node > 0 && node < totalNodes + 1)
			return node;
		return -node + totalNodes;
	}

	private static int findSCC(int node) {
		visitOrder[node] = ++orderCount;
		stack.add(node);
		int minOrder = visitOrder[node];

		for (int neighbor : adjList[node]) {
			if (visitOrder[neighbor] == 0)
				minOrder = Math.min(minOrder, findSCC(neighbor));
			else if (!isVisited[neighbor])
				minOrder = Math.min(minOrder, visitOrder[neighbor]);
		}

		if (minOrder == visitOrder[node]) {
			boolean[] visitedCheck = new boolean[totalNodes + 1];
			while (!stack.isEmpty()) {
				int currentNode = stack.pop();
				int absoluteIndex = convertIndex(currentNode);

				if (absoluteIndex < 0)
					absoluteIndex *= -1;
				if (visitedCheck[absoluteIndex])
					return -1;

				visitedCheck[absoluteIndex] = true;
				isVisited[currentNode] = true;

				if (currentNode == node)
					break;
			}
		}
		return minOrder;
	}
}
