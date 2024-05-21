//Question No: 23239
//Title: 당근 밭
//Tier: Platinum V
import java.util.Scanner;

public class Main {

    static long w, h, l, ans = 0;

    static long canEat(long r) {
        long carrot = 0;
        long j = r - 1;
        for (long i = 1; i < r; i++) {
            while (i * i + j * j > r * r) j--;
            carrot += j;
        }
        return carrot;
    }

    static long overlap() {
        long carrot = 0;
        long j = l - h - 1;
        for (long i = h + 1; i < l - w; i++) {
            while (((i - h) * (i - h) + j * j > (l - h) * (l - h)) || ((j - w) * (j - w) + i * i > (l - w) * (l - w)))
                j--;
            carrot += (j - w);
        }
        return carrot;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        w = scanner.nextLong();
        h = scanner.nextLong();
        l = scanner.nextLong();
        scanner.close();

        ans += (2 * l + 3 * canEat(l));
        if (l > h) ans += canEat(l - h) + l - h;
        if (l > w) ans += canEat(l - w) + l - w;
        if (l - h > w && l - w > h) ans -= overlap();
        System.out.println(ans);
    }
}
