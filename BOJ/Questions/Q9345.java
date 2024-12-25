//Question No: 9345
//Title: 디지털 비디오 디스크(DVDs)
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static int first;
    static int[] minTree;
    static int[] maxTree;
    static int[] minArr;
    static int[] maxArr;
    static int logn;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int testCase = 0; testCase < testCases; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            size = Integer.parseInt(tokenizer.nextToken());
            int operations = Integer.parseInt(tokenizer.nextToken());

            logn = 0;
            while ((1 << logn) < size) logn++;

            minArr = new int[size + 1];
            maxArr = new int[size + 1];
            minArr[size] = Integer.MAX_VALUE;
            maxArr[size] = Integer.MIN_VALUE;

            minTree = new int[(1 << (logn + 1))];
            maxTree = new int[minTree.length];
            Arrays.fill(minTree, size);
            Arrays.fill(maxTree, size);
            first = minTree.length / 2;

            for (int i = 0; i < size; i++) {
                minArr[i] = i;
                maxArr[i] = i;
                minTree[first + i] = i;
                maxTree[first + i] = i;
            }

            initializeMinTree(1);
            initializeMaxTree(1);

            for (int op = 0; op < operations; op++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int choice = Integer.parseInt(tokenizer.nextToken());

                if (choice == 0) {
                    int index1 = Integer.parseInt(tokenizer.nextToken());
                    int index2 = Integer.parseInt(tokenizer.nextToken());
                    int temp = minArr[index1];
                    minArr[index1] = minArr[index2];
                    minArr[index2] = temp;
                    maxArr[index1] = minArr[index1];
                    maxArr[index2] = minArr[index2];
                    updateMinTree(first + index1);
                    updateMinTree(first + index2);
                    updateMaxTree(first + index1);
                    updateMaxTree(first + index2);
                } else {
                    int start = Integer.parseInt(tokenizer.nextToken());
                    int end = Integer.parseInt(tokenizer.nextToken());
                    int minResult = minArr[queryMinTree(first + start, first + end)];
                    int maxResult = maxArr[queryMaxTree(first + start, first + end)];
                    if (minResult == start && maxResult == end) {
                        resultBuilder.append("YES\n");
                    } else {
                        resultBuilder.append("NO\n");
                    }
                }
            }
        }
        System.out.print(resultBuilder);
    }

    static int queryMaxTree(int start, int end) {
        int result = maxTree[start];
        while (start <= end) {
            if (start % 2 == 1) {
                result = maxArr[result] < maxArr[maxTree[start]] ? maxTree[start] : result;
                start++;
            }
            if (end % 2 == 0) {
                result = maxArr[result] < maxArr[maxTree[end]] ? maxTree[end] : result;
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return result;
    }

    static int queryMinTree(int start, int end) {
        int result = minTree[start];
        while (start <= end) {
            if (start % 2 == 1) {
                result = minArr[result] > minArr[minTree[start]] ? minTree[start] : result;
                start++;
            }
            if (end % 2 == 0) {
                result = minArr[result] > minArr[minTree[end]] ? minTree[end] : result;
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return result;
    }

    static void updateMaxTree(int index) {
        while (index > 1) {
            index /= 2;
            maxTree[index] = maxArr[maxTree[index * 2]] >= maxArr[maxTree[index * 2 + 1]]
                ? maxTree[index * 2]
                : maxTree[index * 2 + 1];
        }
    }

    static void updateMinTree(int index) {
        while (index > 1) {
            index /= 2;
            minTree[index] = minArr[minTree[index * 2]] <= minArr[minTree[index * 2 + 1]]
                ? minTree[index * 2]
                : minTree[index * 2 + 1];
        }
    }

    static int initializeMinTree(int index) {
        if (index >= first / 2) {
            return minTree[index] = minArr[minTree[index * 2]] <= minArr[minTree[index * 2 + 1]]
                ? minTree[index * 2]
                : minTree[index * 2 + 1];
        }
        return minTree[index] = initializeMinTree(index * 2) <= initializeMinTree(index * 2 + 1)
            ? minTree[index * 2]
            : minTree[index * 2 + 1];
    }

    static int initializeMaxTree(int index) {
        if (index >= first / 2) {
            return maxTree[index] = maxArr[maxTree[index * 2]] >= maxArr[maxTree[index * 2 + 1]]
                ? maxTree[index * 2]
                : maxTree[index * 2 + 1];
        }
        return maxTree[index] = initializeMaxTree(index * 2) >= initializeMaxTree(index * 2 + 1)
            ? maxTree[index * 2]
            : maxTree[index * 2 + 1];
    }
}