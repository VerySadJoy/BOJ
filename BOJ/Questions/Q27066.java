//Question No: 27066
//Title: 나무 블럭 게임
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static double[] arr;

    public static void readInput(BufferedReader reader) throws IOException {
        n = Integer.parseInt(reader.readLine());
        arr = new double[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(tokenizer.nextToken());
        }
    }

    public static void computeResult(BufferedWriter writer) throws IOException {
        if (n == 1) {
            writer.write(String.format("%.6f", arr[0]));
            return;
        }

        Arrays.sort(arr);
        double sum = 0;
        for (double num : arr) {
            sum += num;
        }

        double result = Math.max(arr[n - 2], sum / n);
        writer.write(String.format("%.6f", result));
    }

    public static void process(BufferedReader reader, BufferedWriter writer) throws IOException {
        readInput(reader);
        computeResult(writer);
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        process(reader, writer);
        writer.flush();
        writer.close();
        reader.close();
    }
}