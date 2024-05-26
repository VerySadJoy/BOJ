//Question No: 10775
//Title: 공항
//Tier: Gold II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int[] gates = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            gates[i] = i;
        }
        int count = 0;
        for (int i = 0; i < P; i++) {
            int plane = Integer.parseInt(br.readLine());
            int dockingGate = find(gates, plane);
            if (dockingGate == 0) {
                break;
            }
            union(gates, dockingGate, dockingGate - 1);
            count++;
        }
        System.out.println(count);
    }

    static int find(int[] gates, int x) {
        if (gates[x] == x) {
            return x;
        }
        return gates[x] = find(gates, gates[x]);
    }

    static void union(int[] gates, int x, int y) {
        x = find(gates, x);
        y = find(gates, y);
        gates[x] = y;
    }
}
