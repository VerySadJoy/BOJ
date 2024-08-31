//Question No: 10886
//Title: 0 = not cute / 1 = cute
//Tier: Bronze III
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int cuteCount = 0;
    int notCount = 0;
    for(int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 1) {
        cuteCount++;
      } else {
        notCount++;
      }
    }
    if (cuteCount > notCount) {
      System.out.print("Junhee is cute!");
    } else {
      System.out.print("Junhee is not cute!");
    }
  }
}