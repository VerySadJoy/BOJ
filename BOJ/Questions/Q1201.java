//Question No: 1201
//Title: NMK
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int totalNumbers = Integer.parseInt(tokenizer.nextToken());
        int groupCount = Integer.parseInt(tokenizer.nextToken());
        int maxGroupSize = Integer.parseInt(tokenizer.nextToken());
        
        int[] numbers = new int[totalNumbers];
        for(int i = 0; i < totalNumbers; i++){
            numbers[i] = i + 1;
        }
        
        if(totalNumbers < groupCount + maxGroupSize - 1 || groupCount * maxGroupSize < totalNumbers) {
            System.out.println(-1);
            return;
        }
        
        Deque<Integer> segmentEndpoints = new LinkedList<>();
        
        segmentEndpoints.offer(0);
        segmentEndpoints.offer(maxGroupSize);
        totalNumbers -= maxGroupSize;
        groupCount -= 1;
        
        int segmentSize = groupCount == 0 ? 0 : totalNumbers / groupCount;
        int remainder = groupCount == 0 ? 0 : totalNumbers % groupCount;
        
        for(int i = 0; i < groupCount; i++){
            segmentEndpoints.offer(segmentEndpoints.getLast() + segmentSize + (remainder > 0 ? 1 : 0));
            if(remainder > 0) remainder--;
        }
        
        StringBuilder result = new StringBuilder();
        
        int start = 0;
        int end = segmentEndpoints.pollFirst();
        while(!segmentEndpoints.isEmpty()){
            start = end;
            end = segmentEndpoints.pollFirst();
            
            for(int j = end - 1; j >= start; j--){
                result.append(numbers[j]).append(" ");
            }
        }
        
        System.out.println(result.toString().trim());
        reader.close();
    }
}