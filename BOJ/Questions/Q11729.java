//Question No: 11729
//Title: 하노이 탑 이동 순서
//Tier: Gold V
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static StringBuilder outputBuilder = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfDisks = Integer.parseInt(reader.readLine());
        int moveCount = solveHanoi(numberOfDisks, 1, 2, 3, 0, outputBuilder);

        writer.write(String.valueOf(moveCount) + "\n");
        writer.write(outputBuilder.toString());

        reader.close();
        writer.flush();
        writer.close();
    }

    public static int solveHanoi(int diskCount, int source, int auxiliary, int destination, int moveCount, StringBuilder outputBuilder) {
        moveCount++;

        if (diskCount == 1) {
            outputBuilder.append(source).append(" ").append(destination).append("\n");
            return moveCount;
        }

        moveCount = solveHanoi(diskCount - 1, source, destination, auxiliary, moveCount, outputBuilder);
        outputBuilder.append(source).append(" ").append(destination).append("\n");
        moveCount = solveHanoi(diskCount - 1, auxiliary, source, destination, moveCount, outputBuilder);

        return moveCount;
    }
}