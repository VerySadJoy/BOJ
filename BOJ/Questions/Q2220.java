//Question No: 2220
//Title: 힙 정렬
//Tier: Platinum IV
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int elementCount = scanner.nextInt();
        int[] heapArray = new int[elementCount + 1];
        for(int i = 1; i < elementCount; i++) {
            for(int j = i; j > 1; j /= 2)
                heapArray[j] = heapArray[j / 2];
            heapArray[1] = i + 1;
        }
        heapArray[elementCount] = 1;
        for(int i = 1; i <= elementCount; i++)
            System.out.print(heapArray[i] + " ");
    }
}