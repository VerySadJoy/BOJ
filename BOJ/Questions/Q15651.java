//Question No: 15651
//Title: N과 M (3)
//Tier: Silver III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int[] sequence;
    public static int totalNumbers, sequenceLength;
    public static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        totalNumbers = Integer.parseInt(tokenizer.nextToken());
        sequenceLength = Integer.parseInt(tokenizer.nextToken());

        sequence = new int[sequenceLength];
        generateSequence(0);
        System.out.println(output);
    }

    public static void generateSequence(int depth) {

        if (depth == sequenceLength) {
            for (int i = 0; i < sequenceLength; i++) {
                output.append(sequence[i]).append(' ');
            }
            output.append('\n');
            return;
        }

        for (int i = 1; i <= totalNumbers; i++) {
            sequence[depth] = i;
            generateSequence(depth + 1);
        }
    }
}