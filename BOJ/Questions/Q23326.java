//Question No: 23326
//Title: 홍익 투어리스트
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int n = Integer.parseInt(tokenizer.nextToken());
        int q = Integer.parseInt(tokenizer.nextToken());
        
        TreeMap<Integer, Boolean> landmarks = new TreeMap<>();
        
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            boolean isLandmark = Integer.parseInt(tokenizer.nextToken()) == 1;
            if (isLandmark) {
                landmarks.put(i, true);
            }
        }
        
        int currentPosition = 0;
        
        for (int i = 0; i < q; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int queryType = Integer.parseInt(tokenizer.nextToken());
            
            if (queryType == 1) {
                int x = Integer.parseInt(tokenizer.nextToken());
                if (landmarks.containsKey(x - 1)) {
                    landmarks.remove(x - 1);
                } else {
                    landmarks.put(x - 1, true);
                }
            } else if (queryType == 2) {
                int x = Integer.parseInt(tokenizer.nextToken());
                currentPosition = (currentPosition + x) % n;
            } else if (queryType == 3) {
                if (landmarks.isEmpty()) {
                    System.out.println(-1);
                } else {
                    Map.Entry<Integer, Boolean> pos = landmarks.ceilingEntry(currentPosition);
                    if (pos == null) {
                        int steps = (n - currentPosition) + landmarks.firstKey();
                        System.out.println(steps);
                    } else {
                        System.out.println(pos.getKey() - currentPosition);
                    }
                }
            }
        }
    }
}
