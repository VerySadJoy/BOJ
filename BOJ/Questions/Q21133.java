//Question No: 21133
//Title: N-Queen 2
//Tier: Platinum II
import java.io.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder stringBuilder = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        int number = Integer.parseInt(bufferedReader.readLine());

        switch (number % 6) {
            case 2:
                for (int i = 2; i <= number; i += 2) {
                    stringBuilder.append(i).append('\n');
                }
                stringBuilder.append(3).append('\n');
                stringBuilder.append(1).append('\n');
                for (int i = 7; i <= number; i += 2) {
                    stringBuilder.append(i).append('\n');
                }
                stringBuilder.append(5).append('\n');
                break;

            case 3:
                for (int i = 4; i <= number; i += 2) {
                    stringBuilder.append(i).append('\n');
                }
                stringBuilder.append(2).append('\n');
                for (int i = 5; i <= number; i += 2) {
                    stringBuilder.append(i).append('\n');
                }
                stringBuilder.append(1).append('\n');
                stringBuilder.append(3).append('\n');
                break;

            default:
                for (int i = 2; i <= number; i += 2) {
                    stringBuilder.append(i).append('\n');
                }
                for (int i = 1; i <= number; i += 2) {
                    stringBuilder.append(i).append('\n');
                }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
    }
}