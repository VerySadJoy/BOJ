//Question No: 18234
//Title: 당근 훔쳐 먹기
//Tier: Gold III
import java.io.*;
import java.util.*;

public class Main {
    static class Carrot {
        long baseTaste;
        long nutrition;

        public Carrot(long baseTaste, long nutrition) {
            this.baseTaste = baseTaste;
            this.nutrition = nutrition;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int numCarrots = Integer.parseInt(st.nextToken());
        int totalDays = Integer.parseInt(st.nextToken());
        
        List<Carrot> carrots = new ArrayList<>();
        
        for (int i = 0; i < numCarrots; i++) {
            st = new StringTokenizer(br.readLine());
            long baseTaste = Long.parseLong(st.nextToken());
            long nutrition = Long.parseLong(st.nextToken());
            carrots.add(new Carrot(baseTaste, nutrition));
        }
        
        carrots.sort(Comparator.comparingLong(c -> c.nutrition));
        
        long totalTaste = 0;
        
        for (int i = 0; i < numCarrots; i++) {
            Carrot carrot = carrots.get(i);
            totalTaste += carrot.baseTaste + carrot.nutrition * (i + totalDays - numCarrots);
        }
        
        System.out.println(totalTaste);
    }
}
