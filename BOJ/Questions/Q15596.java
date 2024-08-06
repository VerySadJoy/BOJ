//Question No: 15596
//Title: 정수 N개의 합
//Tier: Bronze II
public class Test {
    long sum(int[] numbers) {
        long totalSum = 0;
        for (int number : numbers) {
            totalSum += number;
        }
        return totalSum;
    }
}