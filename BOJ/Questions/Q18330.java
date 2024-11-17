//Question No: 18330
//Title: Petrol
//Tier: Bronze IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int plannedUsage = Integer.parseInt(reader.readLine());
        int remainingLiters = Integer.parseInt(reader.readLine());
        
        int totalAvailableLiters = 60 + remainingLiters;
        
        int cost = (plannedUsage <= totalAvailableLiters) ? plannedUsage * 1500 : totalAvailableLiters * 1500 + (plannedUsage - totalAvailableLiters) * 3000;
        
        System.out.println(cost);
    }
}