//Question No: 21871
//Title: 화석 발굴 이벤트
//Tier: Gold I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        long gridSize = Long.parseLong(tokenizer.nextToken()) * 2 + 1;
        long offsetValue = Long.parseLong(tokenizer.nextToken());

        long subtractValue = 2 * (((gridSize - offsetValue) / 2) + 1) * ((gridSize - offsetValue) / 2);
        long totalArea = gridSize * gridSize;

        if (offsetValue < gridSize) {
            totalArea -= subtractValue + (offsetValue % 2 == 0 ? gridSize : 0);
        }

        System.out.println(totalArea);
    }
}