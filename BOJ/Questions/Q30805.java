//Question No: 30805
//Title: 사전 순 최대 공통 부분 수열
//Tier: Gold IV
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        int sizeA = scanner.nextInt();
        ArrayList<Integer> listA = new ArrayList<>();
        for (int i = 0; i < sizeA; i++) {
            listA.add(scanner.nextInt());
        }
        int sizeB = scanner.nextInt();
        ArrayList<Integer> listB = new ArrayList<>();
        for (int i = 0; i < sizeB; i++) {
            listB.add(scanner.nextInt());
        }

        boolean continueLoop = true;
        ArrayList<Integer> commonSubsequence = new ArrayList<>();
        Integer maxA = null, maxB = null;
        int indexA = -1, indexB = -1;

        while (continueLoop) {
            while (true) {
                if (listA.isEmpty() || listB.isEmpty()) {
                    continueLoop = false;
                    break;
                }
                maxA = Collections.max(listA);
                indexA = listA.indexOf(maxA);
                maxB = Collections.max(listB);
                indexB = listB.indexOf(maxB);
                
                if (maxA.equals(maxB)) break;
                else if (maxA > maxB) listA.remove(indexA);
                else listB.remove(indexB);
            }
            if (!continueLoop) break;

            commonSubsequence.add(maxA);
            listA.subList(0, indexA + 1).clear();
            listB.subList(0, indexB + 1).clear();
        }

        if (!commonSubsequence.isEmpty()) {
            System.out.println(commonSubsequence.size());
            for (int value : commonSubsequence) {
                System.out.print(value + " ");
            }
        } else {
            System.out.print(0);
        }
    }
}

