//Question No: 14897
//Title: 서로 다른 수와 쿼리 1
//Tier: Platinum II
import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[] segmentTree;
    static int size;
    
    public static void main(String[] args) throws Exception {
        FastInput.initFI();
        int arraySize = FastInput.nextInt();
        size = 1 << (int) Math.ceil(Math.log(arraySize + 1) / Math.log(2));
        segmentTree = new int[2 * size];
        
        int[] nums = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            nums[i] = FastInput.nextInt();
        }

        Map<Integer, Integer> nextPositionMap = new HashMap<>();
        Map<Integer, List<Integer>> nextPositionListMap = new HashMap<>();

        for (int i = arraySize - 1; i >= 0; i--) {
            int nextPosition = nextPositionMap.getOrDefault(nums[i], arraySize);
            nextPositionListMap.putIfAbsent(nextPosition, new ArrayList<>());
            nextPositionListMap.get(nextPosition).add(i);
            nextPositionMap.put(nums[i], i);
        }

        int queryCount = FastInput.nextInt();
        int[] answers = new int[queryCount];
        List<int[]> queries = new ArrayList<>();

        for (int i = 0; i < queryCount; i++) {
            int left = FastInput.nextInt() - 1;
            int right = FastInput.nextInt() - 1;
            queries.add(new int[]{i, left, right});
        }

        queries.sort((a, b) -> b[2] - a[2]);
        int currentIndex = arraySize + 1;

        for (int[] query : queries) {
            int queryIndex = query[0];
            int left = query[1];
            int right = query[2];
            
            for (int j = right + 1; j < currentIndex; j++) {
                if (nextPositionListMap.containsKey(j)) {
                    for (int position : nextPositionListMap.get(j)) {
                        update(position, 1);
                    }
                }
            }
            currentIndex = right + 1;
            answers[queryIndex] = search(left, right);
        }

        StringBuilder output = new StringBuilder();
        for (int answer : answers) {
            output.append(answer).append('\n');
        }
        System.out.print(output);
    }

    static void update(int target, int value) {
        target += size;
        segmentTree[target] += value;
        while (target > 1) {
            target >>= 1;
            segmentTree[target] = segmentTree[target << 1] + segmentTree[target << 1 | 1];
        }
    }

    static int search(int left, int right) {
        int result = 0;
        left += size;
        right += size;
        while (left <= right) {
            if ((left & 1) == 1) result += segmentTree[left++];
            if ((right & 1) == 0) result += segmentTree[right--];
            left >>= 1;
            right >>= 1;
        }
        return result;
    }
}

class FastInput {
    private static final int BUFFER_SIZE = 1 << 16;
    private static DataInputStream dataInputStream;
    private static byte[] buffer;
    private static int bufferPointer, bytesRead;

    protected static void initFI() throws IOException {
        dataInputStream = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    protected static int nextInt() throws IOException {
        int value = 0;
        byte b = read();
        while (b <= ' ') b = read();
        do {
            value = value * 10 + b - '0';
        } while ((b = read()) >= '0' && b <= '9');
        return value;
    }

    private static byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            bytesRead = dataInputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
        return buffer[bufferPointer++];
    }
}