//Question No: 1300
//Title: K번째 수
//Tier: Gold I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int matrixSize = Integer.parseInt(reader.readLine());
        int targetIndex = Integer.parseInt(reader.readLine());
        
        long low = 1;
        long high = targetIndex;
        
        while (low < high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int row = 1; row <= matrixSize; row++) {
                count += Math.min(mid / row, matrixSize);
            }

            if (count >= targetIndex) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        System.out.println(low);
    }
}