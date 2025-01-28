//Question No: 15704
//Title: 백준 마라톤 대회
//Tier: Platinum V
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long K;
    static List<List<Edge>> road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        road = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            road.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            long c = Long.parseLong(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            road.get(a).add(new Edge(b, c, t));
            road.get(b).add(new Edge(a, c, t));
        }

        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long start = 1, end = 100000, mid, person = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (dijkstra(mid) <= K) {
                person = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return person;
    }

    static long dijkstra(long P) {
        long[] cost = new long[N];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(s -> s.weight));
        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {
            State current = pq.poll();
            long weight = current.weight;
            int pos = current.position;

            if (weight > cost[pos]) continue;

            for (Edge edge : road.get(pos)) {
                long newCost = weight + edge.cost * Math.max(0, P - edge.time) * Math.max(0, P - edge.time);
                if (newCost > K) continue;
                if (newCost < cost[edge.to]) {
                    cost[edge.to] = newCost;
                    pq.offer(new State(edge.to, newCost));
                }
            }
        }

        return cost[N - 1];
    }

    static class Edge {
        int to;
        long cost, time;

        Edge(int to, long cost, long time) {
            this.to = to;
            this.cost = cost;
            this.time = time;
        }
    }

    static class State {
        int position;
        long weight;

        State(int position, long weight) {
            this.position = position;
            this.weight = weight;
        }
    }
}