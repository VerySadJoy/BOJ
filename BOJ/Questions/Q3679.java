//Question No: 3679
//Title: 단순 다각형
//Tier: Platinum IV
import java.util.*;

class Node {
    int x, y, idx;

    Node(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}

public class Main {
    static Node p0;

    public static long ccw(Node a, Node b) {
        long left = (long)p0.x * a.y + (long)a.x * b.y + (long)b.x * p0.y;
        long right = (long)p0.y * a.x + (long)a.y * b.x + (long)b.y * p0.x;
        return left - right;
    }

    public static long dist(Node a) {
        long x = p0.x - a.x;
        long y = p0.y - a.y;
        return x * x + y * y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();
            List<Node> p = new ArrayList<>(n);
            p0 = new Node(10001, 10001, -1);

            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Node node = new Node(x, y, j);
                p.add(node);

                if (p0.y > node.y || (p0.y == node.y && p0.x > node.x)) {
                    p0 = node;
                }
            }

            Collections.sort(p, (a, b) -> {
                long cmp = ccw(a, b);
                if (cmp == 0) {
                    long dist1 = dist(a);
                    long dist2 = dist(b);
                    return Long.compare(dist1, dist2);
                } else {
                    return Long.compare(cmp, 0);
                }
            });

            int cnt = 0;
            for (int j = n - 1; j >= 1; j--) {
                Node tmpNode1 = p.get(j);
                Node tmpNode2 = p.get(j - 1);
                long tmpCcw = ccw(tmpNode1, tmpNode2);
                if (tmpCcw == 0) {
                    cnt++;
                }
                else {
                    break;
                }
            }

            if (cnt > 0) {
                p.subList(n - cnt - 1, n).sort((a, b) -> Long.compare(dist(b), dist(a)));
            }

            System.out.print(p.get(0).idx);
            for (int j = 1; j < n; j++) {
                System.out.print(" " + p.get(j).idx);
            }
            System.out.println();
        }

        sc.close();
    }
}
