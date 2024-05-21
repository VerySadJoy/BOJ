//Question No: 14003
//Title: 가장 긴 증가하는 부분 수열 5
//Tier: Platinum V
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        int[] indices = new int[n];
        int[] predecessors = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = 0;
        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(lis, 0, length, arr[i]);
            if (pos < 0) pos = -(pos + 1);

            lis[pos] = arr[i];
            indices[pos] = i;
            predecessors[i] = pos > 0 ? indices[pos - 1] : -1;

            if (pos == length) {
                length++;
            }
        }

        int[] result = new int[length];
        int k = indices[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = arr[k];
            k = predecessors[k];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(length).append("\n");
        for (int i = 0; i < length; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}

