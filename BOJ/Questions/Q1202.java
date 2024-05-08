//Question No: 1202
//Title: 보석 도둑
//Tier: Gold II
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Jewelry {
    int weight;
    int value;

    Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numJewelries = Integer.parseInt(st.nextToken());
        int numBags = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[numJewelries];
        for (int i = 0; i < numJewelries; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(weight, value);
        }
        Arrays.sort(jewelries, new Comparator<Jewelry>() {

            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.weight == o2.weight) {
                    return o2.value - o1.value;
                }
                return o1.weight - o2.weight;
            }

        });

        int[] bagWeights = new int[numBags];
        for (int i = 0; i < numBags; i++) {
            bagWeights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagWeights);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        for (int i = 0, j = 0; i < numBags; i++) {
            while (j < numJewelries && jewelries[j].weight <= bagWeights[i]) {
                pq.offer(jewelries[j++].value);
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}
