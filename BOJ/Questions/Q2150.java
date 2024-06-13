//Question No: 2150
//Title: Strongly Connected Component
//Tier: Platinum V
import java.io.*;
import java.util.*;

public class Main {
	
	static int index, sccCount=0;
	static int[] discoveryOrder, sccComponent;
	static List<Integer>[] adjacencyList;
	static Stack<Integer> stack;
	static List<Queue<Integer>> sccResult;
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		
		int vertices = Integer.parseInt(tokenizer.nextToken());
		int edges = Integer.parseInt(tokenizer.nextToken());
		
		adjacencyList = new ArrayList[vertices + 1];
		discoveryOrder = new int[vertices + 1];
		sccComponent = new int[vertices + 1];
		for(int i = 1; i < vertices + 1; i++) {
			adjacencyList[i] = new ArrayList<>();
			discoveryOrder[i] = -1;
			sccComponent[i] = -1;
		}
		
		for(int i = 0; i < edges; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			adjacencyList[a].add(b);
		}
		
		sccResult = new ArrayList<>();
		stack = new Stack<>();
		for(int i = 1; i < vertices + 1; i++) {
			if(discoveryOrder[i] == -1) {
				findStronglyConnectedComponents(i);	
			}
		}
		
		System.out.println(sccCount);
		Collections.sort(sccResult, (o1,o2) -> o1.peek()-o2.peek());
		StringBuilder output = new StringBuilder();
		for(Queue<Integer> q : sccResult ) {
			while(!q.isEmpty())	{
				output.append(q.poll()+" ");
			}
			output.append(-1+"\n");
		}
		System.out.println(output.toString());
	}
	
	static int findStronglyConnectedComponents(int current) {
		discoveryOrder[current] = index++;
		stack.push(current);
		
		int minimumDiscovery = discoveryOrder[current];
		for(int i = 0; i < adjacencyList[current].size(); i++) {
			int next = adjacencyList[current].get(i);
			if(discoveryOrder[next] == -1) {
				minimumDiscovery = Math.min(minimumDiscovery, findStronglyConnectedComponents(next));
			}
            else if(sccComponent[next] == -1) {
				minimumDiscovery = Math.min(minimumDiscovery, discoveryOrder[next]);
			}
		}
		
		if(minimumDiscovery == discoveryOrder[current]) {
			Queue<Integer> sccQueue = new PriorityQueue<>();
			while(true) {
				int temp = stack.pop();
				sccQueue.add(temp);
				sccComponent[temp] = sccCount;
				if(temp == current) break;
			}
			sccResult.add(sccQueue);
			sccCount++;
		}
		return minimumDiscovery;
	}
}
