//Question No: 3015
//Title: 오아시스 재결합
//Tier: Platinum V
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people_num = scanner.nextInt();

        Stack<Pair> st = new Stack<>();
        int now, cnt_same_height = 0;
        long cnt_pair = 0;

        for (int i = 0; i < people_num; ++i) {
            now = scanner.nextInt();

            cnt_same_height = 1;
            while (!st.empty() && st.peek().first < now) {
                cnt_pair += st.peek().second;
                st.pop();
            }

            if (!st.empty()) {
                if (st.peek().first == now) {
                    cnt_pair += st.peek().second;
                    cnt_same_height = st.peek().second + 1;
                    if (st.size() > 1)
                        ++cnt_pair;

                    st.pop();
                } else {
                    ++cnt_pair;
                }
            }

            st.push(new Pair(now, cnt_same_height));
        }

        System.out.println(cnt_pair);
        scanner.close();
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
