//Question No: 21874
//Title: 모자 게임
//Tier: Gold II
import java.util.List;

public class Main {
    static int totalNumbers;

    public static void init(int n) {
        totalNumbers = n;
    }

    public static int call(List<Integer> frontList, List<Integer> backList, int index) {
        if (index == totalNumbers - 1) {
            int result = 0;
            for (int value : frontList) {
                result ^= value;
            }
            return result;
        }

        int result = backList.get(totalNumbers - 1);
        for (int i = 0; i < index; i++) {
            result ^= frontList.get(i);
        }
        for (int i = index + 1; i < totalNumbers - 1; i++) {
            result ^= backList.get(i);
        }

        return result;
    }
}