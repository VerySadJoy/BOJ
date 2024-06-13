//Question No: 28707
//Title: 배열 정렬
//Tier: Gold I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastIO io = new FastIO();
    static int arraySize;
    static Operation[] operations;
    static ArrayList<Integer> initialArray;
    static Set<String> visitedStates;

    static class State implements Comparable<State> {
        int cost;
        ArrayList<Integer> array;

        State(int cost, ArrayList<Integer> array) {
            this.array = new ArrayList<>(array);
            this.cost = cost;
        }

        @Override
        public int compareTo(State other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static class Operation {
        int leftIndex, rightIndex, operationCost;

        Operation(int leftIndex, int rightIndex, int operationCost) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.operationCost = operationCost;
        }
    }

    public static void main(String[] args) {
        arraySize = io.nextInt();
        initialArray = new ArrayList<>();
        visitedStates = new HashSet<>();

        for (int i = 0; i < arraySize; i++) {
            initialArray.add(io.nextInt());
        }

        PriorityQueue<State> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new State(0, initialArray));

        int numberOfOperations = io.nextInt();
        operations = new Operation[numberOfOperations];

        for (int i = 0; i < numberOfOperations; i++) {
            operations[i] = new Operation(io.nextInt() - 1, io.nextInt() - 1, io.nextInt());
        }

        while (!priorityQueue.isEmpty()) {
            State currentState = priorityQueue.poll();
            int currentCost = currentState.cost;
            ArrayList<Integer> currentArray = currentState.array;

            if (visitedStates.contains(arrayToString(currentArray))) {
                continue;
            }

            if (isSorted(currentArray)) {
                System.out.println(currentCost);
                return;
            }

            visitedStates.add(arrayToString(currentArray));

            for (Operation operation : operations) {
                Collections.swap(currentArray, operation.leftIndex, operation.rightIndex);
                priorityQueue.add(new State(currentCost + operation.operationCost, currentArray));
                Collections.swap(currentArray, operation.leftIndex, operation.rightIndex);
            }
        }

        System.out.println(-1);
    }

    static String arrayToString(ArrayList<Integer> array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString();
    }

    static boolean isSorted(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i - 1) > array.get(i)) {
                return false;
            }
        }
        return true;
    }
}

class FastIO {
    public BufferedReader br;
    public StringTokenizer st;

    FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}
