//Question No: 13548
//Title: 수열과 쿼리 6
//Tier: Platinum I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Query implements Comparable<Query> {
    int start, end, index, factor;
    static int sqrtN;
    
    public static void setSqrtN(int n) { sqrtN = (int)Math.sqrt(n); }
    
    public Query(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.factor = this.start / sqrtN;
    }
    
    @Override
    public int compareTo(Query other) {
        if (this.factor == other.factor) {
            return this.end - other.end;
        }
        return this.factor - other.factor;
    }
}

public class Main {
    int[] count = new int[100010];
    int[] frequencyBucket = new int[100010];
    int maxFrequency = 0;
    
    private void addElement(int number) {
        frequencyBucket[count[number]]--;
        if (++frequencyBucket[++count[number]] == 1 && count[number] > maxFrequency) {
            maxFrequency = count[number];
        }
    }
    
    private void removeElement(int number) {
        if (--frequencyBucket[count[number]] == 0 && maxFrequency == count[number]) {
            maxFrequency--;
        }
        frequencyBucket[--count[number]]++;
    }
    
    private void solution() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Query.setSqrtN(n);
        int[] array = new int[n + 1];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(reader.readLine());
        Query[] queries = new Query[m];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            queries[i] = new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        
        Arrays.sort(queries);
        for (int i = queries[0].start; i <= queries[0].end; i++) {
            addElement(array[i]);
        }
        
        int[] results = new int[m];
        results[queries[0].index] = maxFrequency;
        int currentStart = queries[0].start;
        int currentEnd = queries[0].end;
        
        for (int i = 1; i < m; i++) {
            Query query = queries[i];
            
            for (int x = query.start; x < currentStart; x++) {
                addElement(array[x]);
            }
            for (int x = currentEnd + 1; x <= query.end; x++) {
                addElement(array[x]);
            }
            for (int x = currentStart; x < query.start; x++) {
                removeElement(array[x]);
            }
            for (int x = query.end + 1; x <= currentEnd; x++) {
                removeElement(array[x]);
            }
            
            currentStart = query.start;
            currentEnd = query.end;
            results[query.index] = maxFrequency;
        }
        
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < m; i++) {
            resultString.append(results[i]).append('\n');
        }
        System.out.print(resultString);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}