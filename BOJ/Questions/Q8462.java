//Question No: 8462
//Title: 배열의 힘
//Tier: Platinum II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Query implements Comparable<Query> {
    int startIndex, endIndex, queryIndex, block;
    static int blockSize;

    public static void setBlockSize(int n) {
        blockSize = (int) Math.sqrt(n);
    }

    public Query(int startIndex, int endIndex, int queryIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.queryIndex = queryIndex;
        this.block = this.startIndex / blockSize;
    }

    @Override
    public int compareTo(Query other) {
        if (this.block == other.block) {
            return Integer.compare(this.endIndex, other.endIndex);
        }
        return Integer.compare(this.block, other.block);
    }
}

public class Main {
    private static final int MAX_SIZE = 1000001;
    private final int[] frequency = new int[MAX_SIZE];
    private long currentResult = 0;

    private void add(int value) {
        currentResult -= (long) value * frequency[value] * frequency[value];
        currentResult += (long) value * ++frequency[value] * frequency[value];
    }

    private void remove(int value) {
        currentResult -= (long) value * frequency[value] * frequency[value];
        currentResult += (long) value * --frequency[value] * frequency[value];
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 2 << 17)) {
            StringTokenizer tokenizer;
            
            tokenizer = new StringTokenizer(reader.readLine());
            int numElements = Integer.parseInt(tokenizer.nextToken());
            int numQueries = Integer.parseInt(tokenizer.nextToken());
            
            Query.setBlockSize(numElements);
            
            int[] array = new int[numElements + 1];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 1; i <= numElements; i++) {
                array[i] = Integer.parseInt(tokenizer.nextToken());
            }
            
            Query[] queries = new Query[numQueries];
            for (int i = 0; i < numQueries; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                queries[i] = new Query(
                        Integer.parseInt(tokenizer.nextToken()),
                        Integer.parseInt(tokenizer.nextToken()),
                        i
                );
            }
            
            Arrays.sort(queries);
            
            Main mainInstance = new Main();
            int currentStart = queries[0].startIndex;
            int currentEnd = queries[0].endIndex;
            
            for (int i = currentStart; i <= currentEnd; i++) {
                mainInstance.add(array[i]);
            }
            
            long[] results = new long[numQueries];
            results[queries[0].queryIndex] = mainInstance.currentResult;
            
            for (int i = 1; i < numQueries; i++) {
                Query query = queries[i];
                
                while (currentStart < query.startIndex) {
                    mainInstance.remove(array[currentStart++]);
                }
                while (currentStart > query.startIndex) {
                    mainInstance.add(array[--currentStart]);
                }
                while (currentEnd < query.endIndex) {
                    mainInstance.add(array[++currentEnd]);
                }
                while (currentEnd > query.endIndex) {
                    mainInstance.remove(array[currentEnd--]);
                }
                
                results[query.queryIndex] = mainInstance.currentResult;
            }
            
            StringBuilder output = new StringBuilder();
            for (long result : results) {
                output.append(result).append('\n');
            }
            System.out.print(output);
        }
    }
}