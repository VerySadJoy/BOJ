//Question No: 2322
//Title: 아령
//Tier: Platinum I
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int numElements = readInt();
        Position[] positions = new Position[numElements];
        boolean[] visited = new boolean[numElements];
        int[] indices = new int[numElements];

        long globalMinValue = Long.MAX_VALUE;
        for (int i = 0; i < numElements; i++) {
            long value = readLong();
            globalMinValue = Math.min(value, globalMinValue);
            positions[i] = new Position(i, value);
        }
        Arrays.sort(positions);
        for (int i = 0; i < numElements; i++) {
            indices[positions[i].index] = i;
            if (positions[i].index == i) {
                indices[i] = -1;
            }
        }
        long result = 0;
        for (int i = 0; i < numElements; i++) {
            if (!visited[i] && indices[i] != -1) {
                int count = 1;
                int nextIndex = indices[i];
                long cycleSum = positions[nextIndex].value;
                long cycleMinValue = positions[nextIndex].value;
                visited[i] = true;
                while (!visited[nextIndex]) {
                    visited[nextIndex] = true;
                    count++;
                    nextIndex = indices[nextIndex];
                    cycleSum += positions[nextIndex].value;
                    cycleMinValue = Math.min(cycleMinValue, positions[nextIndex].value);
                }
                result += Math.min(cycleSum + (count - 2) * cycleMinValue, cycleMinValue + cycleSum + globalMinValue * (count + 1));
            }
        }
        System.out.println(result);
    }

    public static int readInt() throws Exception {
        int value = 0;
        int character = System.in.read();
        while (character <= ' ') {
            character = System.in.read();
        }
        boolean negative = (character == '-');
        if (negative) character = System.in.read();
        do {
            value = 10 * value + character - 48;
        } while ((character = System.in.read()) >= 48 && character <= 57);

        return negative ? -value : value;
    }

    public static long readLong() throws Exception {
        long value = 0;
        long character = System.in.read();
        while (character <= ' ') {
            character = System.in.read();
        }
        boolean negative = (character == '-');
        if (negative) character = System.in.read();
        do {
            value = 10 * value + character - 48;
        } while ((character = System.in.read()) >= 48 && character <= 57);

        return negative ? -value : value;
    }
}

class Position implements Comparable<Position> {
    int index;
    long value;

    public Position(int index, long value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Position other) {
        return Long.compare(this.value, other.value);
    }
}