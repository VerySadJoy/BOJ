//Question No: 31403
//Title: A + B - C
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next().trim();
        String B = sc.next().trim();
        String C = sc.next().trim();
        
        int A_num = Integer.parseInt(A);
        int B_num = Integer.parseInt(B);
        int C_num = Integer.parseInt(C);
        
        int resultNum = A_num + B_num - C_num;
        System.out.println(resultNum);
        
        String AB_str = A + B;
        int AB_num = Integer.parseInt(AB_str);
        int C_str_num = Integer.parseInt(C);
        int resultStr = AB_num - C_str_num;
        System.out.println(resultStr);
        
        sc.close();
    }
}
