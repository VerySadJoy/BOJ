//Question No: 25048
//Title: 랜선 연결
//Tier: Gold II
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static class Node {
        long port;
        long cost;

        Node(long port, long cost) {
            this.port = port;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numberOfNodes = sc.nextInt();
        Node[] nodes = new Node[numberOfNodes];
        
        for (int i = 0; i < numberOfNodes; i++) {
            long port = sc.nextLong();
            long cost = sc.nextLong();
            nodes[i] = new Node(port, cost);
        }
        
        int target = sc.nextInt();
        
        if (target == 1) {
            System.out.println(0);
            return;
        }
        
        long[] dp = new long[target + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        
        for (Node node : nodes) {
            for (int j = target - (int)(node.port - 2); j >= 1; j--) {
                if (dp[j] == Long.MAX_VALUE) continue;
                dp[j + (int)(node.port - 2)] = Math.min(dp[j + (int)(node.port - 2)], dp[j] + node.cost);
            }
            if (node.port - 1 <= target) {
                dp[(int)(node.port - 1)] = Math.min(dp[(int)(node.port - 1)], node.cost);
            }
        }
        
        System.out.println(dp[target] == Long.MAX_VALUE ? -1 : dp[target]);
    }
}