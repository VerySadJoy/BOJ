//Question No: 1007
//Title: 벡터 매칭
//Tier: Gold II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());
        List<Double> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int numCoords = Integer.parseInt(reader.readLine().trim());
            List<int[]> coordinates = new ArrayList<>();
            long xTotal = 0;
            long yTotal = 0;

            for (int i = 0; i < numCoords; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                xTotal += x;
                yTotal += y;
                coordinates.add(new int[]{x, y});
            }

            double minDistance = Double.MAX_VALUE;
            List<List<int[]>> combinations = generateCombinations(coordinates, numCoords / 2);
            int halfCombinationsSize = combinations.size() / 2;

            for (int i = 0; i < halfCombinationsSize; i++) {
                long x1Total = 0;
                long y1Total = 0;
                for (int[] coord : combinations.get(i)) {
                    x1Total += coord[0];
                    y1Total += coord[1];
                }
                long x2Total = xTotal - x1Total;
                long y2Total = yTotal - y1Total;

                double distance = Math.sqrt(Math.pow(x1Total - x2Total, 2) + Math.pow(y1Total - y2Total, 2));
                minDistance = Math.min(minDistance, distance);
            }

            results.add(minDistance);
        }

        for (double result : results) {
            System.out.printf("%.12f%n", result);
        }
    }

    private static List<List<int[]>> generateCombinations(List<int[]> coordinates, int size) {
        List<List<int[]>> combinations = new ArrayList<>();
        generateCombinationsHelper(coordinates, size, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(List<int[]> coordinates, int size, int startIndex, List<int[]> current, List<List<int[]>> combinations) {
        if (current.size() == size) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i <= coordinates.size() - (size - current.size()); i++) {
            current.add(coordinates.get(i));
            generateCombinationsHelper(coordinates, size, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }
}