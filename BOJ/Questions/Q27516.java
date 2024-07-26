//Question No: 27516
//Title: 과녁 맞추기
//Tier: Gold III
import java.util.*;

public class Main {

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();

        List<long[]> vecMinus = new ArrayList<>();
        List<long[]> vecPlus = new ArrayList<>();

        int n = sc.nextInt();
        while (n-- > 0) {
            long tempX = sc.nextLong();
            long tempY = sc.nextLong();

            tempX -= x;
            tempY -= y;
            if (tempX == 0 || tempY >= 0) continue;

            if (tempX < 0) {
                tempX = Math.abs(tempX) * Math.abs(tempX);
                tempY = Math.abs(tempY);
                long gcd = gcd(tempX, tempY);
                tempX /= gcd;
                tempY /= gcd;
                vecMinus.add(new long[]{tempX, tempY});
            } else {
                tempX = Math.abs(tempX) * Math.abs(tempX);
                tempY = Math.abs(tempY);
                long gcd = gcd(tempX, tempY);
                tempX /= gcd;
                tempY /= gcd;
                vecPlus.add(new long[]{tempX, tempY});
            }
        }

        int ans = 0;
        if (!vecMinus.isEmpty()) {
            vecMinus.sort((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return Long.compare(o1[1], o2[1]);
                }
                return Long.compare(o1[0], o2[0]);
            });

            ans = Math.max(ans, 1);
            int count = 1;
            int size = vecMinus.size();
            for (int i = 1; i < size; i++) {
                if (vecMinus.get(i)[0] == vecMinus.get(i - 1)[0] && vecMinus.get(i)[1] == vecMinus.get(i - 1)[1]) {
                    count++;
                } else {
                    count = 1;
                }
                ans = Math.max(ans, count);
            }
        }

        if (!vecPlus.isEmpty()) {
            vecPlus.sort((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return Long.compare(o1[1], o2[1]);
                }
                return Long.compare(o1[0], o2[0]);
            });

            ans = Math.max(ans, 1);
            int count = 1;
            int size = vecPlus.size();
            for (int i = 1; i < size; i++) {
                if (vecPlus.get(i)[0] == vecPlus.get(i - 1)[0] && vecPlus.get(i)[1] == vecPlus.get(i - 1)[1]) {
                    count++;
                } else {
                    count = 1;
                }
                ans = Math.max(ans, count);
            }
        }

        System.out.println(ans);
    }
}