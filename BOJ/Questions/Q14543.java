//Question No: 14543
//Title: Linear Equation
//Tier: Silver I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(reader.readLine().trim());
        
        for (int i = 1; i <= P; i++) {
            String line = reader.readLine().trim();
            StringTokenizer st = new StringTokenizer(line, "x += ");
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            System.out.println("Equation " + i);
            
            if (a == 0) {
                if (b == c) {
                    System.out.println("More than one solution.");
                } else {
                    System.out.println("No solution.");
                }
            } else {
                double solution = (double) (c - b) / a;
                System.out.printf("x = %.6f%n", solution);
            }
            
            System.out.println();
        }
    }
}
