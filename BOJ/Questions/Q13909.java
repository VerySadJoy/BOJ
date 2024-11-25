//Question No: 13909
//Title: 창문 닫기
//Tier: Silver V
import java.io.*;

public class Main {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalWindows = Integer.parseInt(reader.readLine());
        int openWindowsCount = countOpenWindows(totalWindows);

        writer.write(openWindowsCount + "\n");

        reader.close();
        writer.flush();
        writer.close();
    }

    private static int countOpenWindows(int totalWindows) {
        int count = 0;
        for (int i = 1; i * i <= totalWindows; i++) {
            count++;
        }
        return count;
    }
}