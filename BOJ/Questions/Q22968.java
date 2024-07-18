//Question No: 22968
//Title: 균형
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        int[] ans = new int[num];
        
        int n1 = 4;
        int n2 = 2;
        int h = 3;
        
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n < 3) {
                ans[i] = n;
            } else {
                int temp = n1 + n2 + 1;
                while (temp <= n) {
                    n2 = n1;
                    n1 = temp;
                    h++;
                    temp = n1 + n2 + 1;
                }
                ans[i] = h;
                h = 3;
                n1 = 4;
                n2 = 2;
            }
        }
        
        for (int i = 0; i < num; i++) {
            System.out.println(ans[i]);
        }
    }
}
