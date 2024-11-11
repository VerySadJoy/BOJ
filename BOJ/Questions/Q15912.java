//Question No: 15912
//Title: 우주선 만들기
//Tier: Gold III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int componentCount = Integer.parseInt(reader.readLine());
        StringTokenizer weightTokens = new StringTokenizer(reader.readLine(), " ");
        
        long[] weights = new long[componentCount + 1];
        long[] efficiencies = new long[componentCount + 1];
        
        for (int i = 1; i <= componentCount; i++) {
            weights[i] = Long.parseLong(weightTokens.nextToken());
        }
        
        StringTokenizer efficiencyTokens = new StringTokenizer(reader.readLine(), " ");
        for (int i = 1; i <= componentCount; i++) {
            efficiencies[i] = Long.parseLong(efficiencyTokens.nextToken());
        }
        
        long[] minCost = new long[componentCount + 1];
        
        for (int i = 1; i <= componentCount; i++) {
            minCost[i] = weights[i] * efficiencies[i] + minCost[i - 1];
            long maxWeight = weights[i];
            long maxEfficiency = efficiencies[i];
            
            for (int j = i - 1; j > 0; j--) {
                maxWeight = Math.max(maxWeight, weights[j]);
                maxEfficiency = Math.max(maxEfficiency, efficiencies[j]);
                minCost[i] = Math.min(minCost[i], maxWeight * maxEfficiency + minCost[j - 1]);
            }
        }
        
        writer.write(String.valueOf(minCost[componentCount]));
        writer.flush();
        writer.close();
        reader.close();
    }
}