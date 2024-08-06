//Question No: 4673
//Title: 셀프 넘버
//Tier: Silver V
public class Main {

    public static void main(String[] args) {

        boolean[] isSelfNumber = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int number = generateSelfNumber(i);
            if (number < 10001) {
                isSelfNumber[number] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        
        for (int i = 1; i < 10001; i++) {
            if (!isSelfNumber[i]) {
                result.append(i).append('\n');
            }
        }
        System.out.println(result);
    }

    public static int generateSelfNumber(int number) {
        int sum = number;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}