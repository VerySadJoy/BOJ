//Question No: 7578
//Title: 공장
//Tier: Platinum V
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int numElements;
        tokenizer = new StringTokenizer(reader.readLine());
        numElements = Integer.parseInt(tokenizer.nextToken());

        int[] arrayA = new int[numElements + 1];
        int maxId = 0;

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= numElements; i++) {
            arrayA[i] = Integer.parseInt(tokenizer.nextToken());
            maxId = Math.max(maxId, arrayA[i]);
        }

        int[] pairIndex = new int[maxId + 1];
        int machineId;

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= numElements; i++) {
            machineId = Integer.parseInt(tokenizer.nextToken());
            pairIndex[machineId] = i;
        }

        SegmentTree segmentTree = new SegmentTree(numElements);

        long inversionCount = 0;
        int queryLeft, queryRight;
        for (int i = 1; i <= numElements; i++) {
            queryLeft = pairIndex[arrayA[i]] + 1;
            queryRight = segmentTree.numOfLeaves;
            inversionCount += segmentTree.getPrefixSum(1, segmentTree.numOfLeaves, queryLeft, queryRight, 1);
            segmentTree.update(1, segmentTree.numOfLeaves, pairIndex[arrayA[i]], 1, 1);
        }

        System.out.println(inversionCount);

        reader.close();
    }
}

class SegmentTree {
    long[] tree;
    int numOfLeaves;

    public SegmentTree(int size) {
        numOfLeaves = 1;
        while (numOfLeaves < size)
            numOfLeaves *= 2;

        tree = new long[numOfLeaves * 2];
    }

    public long getPrefixSum(int left, int right, int queryLeft, int queryRight, int node) {
        if (right < queryLeft || left > queryRight)
            return 0;

        if (left >= queryLeft && right <= queryRight)
            return tree[node];

        int mid = (left + right) / 2;
        return getPrefixSum(left, mid, queryLeft, queryRight, node * 2) +
               getPrefixSum(mid + 1, right, queryLeft, queryRight, node * 2 + 1);
    }

    public void update(int left, int right, int target, long diff, int node) {
        if (right < target || left > target)
            return;

        tree[node] += diff;

        if (left != right) {
            int mid = (left + right) / 2;
            update(left, mid, target, diff, node * 2);
            update(mid + 1, right, target, diff, node * 2 + 1);
        }
    }
}
