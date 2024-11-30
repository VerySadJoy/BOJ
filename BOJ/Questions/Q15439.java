//Question No: 15439
//Title: 베라의 패션
//Tier: Bronze IV
import java.io.*;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfClothes = Integer.parseInt(reader.readLine());
        reader.close();

        int combinations = numberOfClothes * (numberOfClothes - 1);
        writer.write(combinations + "\n");

        writer.flush();
        writer.close();
    }
}