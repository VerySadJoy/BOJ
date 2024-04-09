import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	static List<Integer> arrList;
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		parents = new int[n + 1];
		for(int i = 1; i < n + 1; i++) {
			parents[i] = i;
		}
		token = new StringTokenizer(reader.readLine());
		int en = Integer.parseInt(token.nextToken());
		arrList = new ArrayList<>();
		if(en == 0) {
			System.out.println(m);
			return;
		}
		else{
			for(int i = 0; i < en; i++) {
				arrList.add(Integer.parseInt(token.nextToken()));
			}
		}
		
		List<Integer>[] partyList = new ArrayList[m];
		for(int i = 0; i < m; i++) {
			partyList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			token = new StringTokenizer(reader.readLine());
			int pn = Integer.parseInt(token.nextToken());
			
			int x = Integer.parseInt(token.nextToken());
			partyList[i].add(x);
			for(int j = 1; j < pn; j++) {
				int y = Integer.parseInt(token.nextToken());
				union(x, y);
				partyList[i].add(y);
			}
		}
        
		int count = 0;
		for(int i = 0; i < m; i++) {
			boolean flag = true;
			for(int num : partyList[i]) {
				if(arrList.contains(find(parents[num]))) {
                    flag= false;
                    break;
    			}
            }
			if(flag) {
				count++;
			}
		}
		System.out.println(count);	
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return find(parents[x]);
	}
	
	static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if(arrList.contains(ry)) {
			int temp = rx;
			rx = ry;
			ry = temp;
		}
		parents[ry] = rx;
	}
}
