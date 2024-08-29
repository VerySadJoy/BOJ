//Question No: 16404
//Title: 주식회사 승범이네
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int totalNodes, currentIndex = 1;
    int[] binaryIndexedTree, nodeIndexMapping, rangeEndIndices;
    ArrayList<Integer>[] children;

    private int query(int index) {
        index = nodeIndexMapping[index];
        int sum = 0;
        while (index > 0) {
            sum += binaryIndexedTree[index];
            index -= index & -index;
        }
        return sum;
    }

    private void update(int index, int difference) {
        while (index <= totalNodes) {
            binaryIndexedTree[index] += difference;
            index += index & -index;
        }
    }

    private void rangeUpdate(int start, int end, int difference) {
        update(start, difference);
        update(end + 1, -difference);
    }

    private void rangeUpdate(int index, int difference) {
        int start = nodeIndexMapping[index];
        int end = rangeEndIndices[start];
        if (end == 0)
            return;
        rangeUpdate(start, end, difference);
    }

    private int initializeNodeMappingsAndRanges(int index) {
        int end = (nodeIndexMapping[index] = currentIndex++);
        if (children[index] == null)
            return rangeEndIndices[end] = end;

        for (int child : children[index]) {
            end = initializeNodeMappingsAndRanges(child);
        }
        rangeEndIndices[nodeIndexMapping[index]] = end;
        return end;
    }

    private void initialize(int totalNodes) {
        this.totalNodes = totalNodes;
        children = new ArrayList[totalNodes + 1];
        nodeIndexMapping = new int[totalNodes + 1];
        rangeEndIndices = new int[totalNodes + 1];
        binaryIndexedTree = new int[totalNodes + 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        Main mainInstance = new Main();
        mainInstance.initialize(Integer.parseInt(tokenizer.nextToken()));
        int totalOperations = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        tokenizer.nextToken();
        for (int i = 2; i <= mainInstance.totalNodes; i++) {
            int parentIndex = Integer.parseInt(tokenizer.nextToken());
            if (mainInstance.children[parentIndex] == null)
                mainInstance.children[parentIndex] = new ArrayList<>();
            mainInstance.children[parentIndex].add(i);
        }

        mainInstance.initializeNodeMappingsAndRanges(1);

        StringBuilder resultBuilder = new StringBuilder();
        while (totalOperations-- > 0) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            switch (tokenizer.nextToken().charAt(0)) {
                case '1':
                    mainInstance.rangeUpdate(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                    break;
                case '2':
                    resultBuilder.append(mainInstance.query(Integer.parseInt(tokenizer.nextToken()))).append('\n');
                    break;
            }
        }
        System.out.print(resultBuilder);
    }
}